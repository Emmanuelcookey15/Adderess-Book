package com.emmanuel.cookey.addressbook.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import android.text.TextUtils.split

@Parcelize
@Entity(tableName = "contact_table")
data class Contact (

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String? = null,
    var phoneNumber: String? = null,
    var emailAddress: String? = null
) : Parcelable {

    fun emailInLowerCase(): String? {
        return emailAddress?.toLowerCase()
    }

    fun nameCapitalized(): String? {
        return name?.split(" ")?.map { it?.capitalize() }?.joinToString(" ")
    }


}