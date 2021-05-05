package com.emmanuel.cookey.addressbook.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_table")
data class Contact (

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String? = null,
    var phoneNumber: String? = null,
    var emailAddress: String? = null
){

    fun emailInLowerCase(): String? {
        return emailAddress?.toLowerCase()
    }

    fun nameCapitalized(): String? {
        return name?.capitalize()
    }
}