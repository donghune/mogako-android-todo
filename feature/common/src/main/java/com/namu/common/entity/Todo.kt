package com.namu.common.entity

import android.os.Parcel
import android.os.Parcelable
import java.text.SimpleDateFormat
import java.util.*

data class Todo(
    var id: Int,
    var content: String,
    var date: Date,
    var isUseReminder: Boolean,
    var isComplete: Boolean
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        Date(parcel.readLong()),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(content)
        parcel.writeByte(if (isUseReminder) 1 else 0)
        parcel.writeByte(if (isComplete) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun calculateLeftDate(): String {
        val today = Calendar.getInstance()
        val todoDate = (today.clone() as Calendar).apply { time = date }

        return when (val dayDiff =
            todoDate.get(Calendar.DAY_OF_MONTH) - today.get(Calendar.DAY_OF_MONTH)) {
            0 -> "today"
            1 -> "tomorrow"
            else -> {
                if (dayDiff < 0) {
                    "overdue"
                } else {
                    SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(todoDate.time)
                }
            }
        }
    }

    companion object CREATOR : Parcelable.Creator<Todo> {
        override fun createFromParcel(parcel: Parcel): Todo {
            return Todo(parcel)
        }

        override fun newArray(size: Int): Array<Todo?> {
            return arrayOfNulls(size)
        }
    }

}