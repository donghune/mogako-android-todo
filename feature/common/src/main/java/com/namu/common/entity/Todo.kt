package com.namu.common.entity

import android.os.Parcel
import android.os.Parcelable
import org.joda.time.LocalDate
import org.joda.time.LocalDateTime
import java.util.*

data class Todo(
    var id: Int,
    var content: String,
    var date: LocalDateTime,
    var isUseReminder: Boolean,
    var isComplete: Boolean
) : Parcelable {

    constructor(
        id: Int,
        content: String,
        date: Date,
        isUseReminder: Boolean,
        isComplete: Boolean
    ) : this(
        id,
        content,
        LocalDateTime.fromDateFields(date),
        isUseReminder,
        isComplete
    )

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        LocalDateTime(parcel.readLong()),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(content)
        parcel.writeLong(date.toDate().time)
        parcel.writeByte(if (isUseReminder) 1 else 0)
        parcel.writeByte(if (isComplete) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun calculateLeftDate(): String {

        if (date.toLocalDate().isBefore(LocalDate.now())) {
            return "overdue"
        }

        if (date.toLocalDate().isEqual(LocalDate.now())) {
            return "today"
        }

        if (date.toLocalDate().plusDays(-1).isEqual(LocalDate.now())) {
            return "tomorrow"
        }

        return date.toLocalDate().toString("yyyy-MM-dd")
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