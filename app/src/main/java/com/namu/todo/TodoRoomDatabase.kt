package com.namu.todo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoRoomDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: TodoRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): TodoRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoRoomDatabase::class.java,
                    "todo_database"
                )
                .addCallback(TodoDatabaseCallback(scope))
                .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
    class TodoDatabaseCallback(private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
                INSTANCE.let { database ->
                    scope.launch {
                        if (database != null) {
                            populateDatabase(database.todoDao())
                        }
                    }
                }
        }

        private suspend fun populateDatabase(todoDao: TodoDao) {
            // Delete all content here.
//        todoDao.deleteAll()

            // Add sample words.
            var word = Todo(1,"Hello")
            todoDao.insert(word)
            word = Todo(2,"World!")
            todoDao.insert(word)
        }
    }
}