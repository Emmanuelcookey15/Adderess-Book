package com.emmanuel.cookey.addressbook.data.model

import org.junit.Assert.*
import org.junit.Assert.assertEquals
import org.junit.Test

class ContactTest{

    @Test
    fun testGetContactNameAsCapitalized() {
        //1
        val contact = Contact(name = "EMANUEL COOKEY", phoneNumber = "010020200", emailAddress = "Emmanuelcookey@gmail.com")
        assertEquals("Emmanuel Cookey", contact.nameCapitalized())
    }


    @Test
    fun testGetContactNameEdgeCaseEmpty() {
        //3
        val contact = Contact(name = "", phoneNumber = "010020200", emailAddress = "emmanuelcookey22@gmail.com")
        assertEquals("", contact.emailInLowerCase())
    }

    @Test
    fun testGetContactNameEdgeCaseNull() {
        //4
        val contact = Contact(phoneNumber = "010020200", emailAddress = "emmanuelcookey22@gmail.com")
        assertEquals(null, contact.emailInLowerCase())
    }




    @Test
    fun testGetContactEmailInLowerCase() {
        //2
        val contact = Contact(name = "EMANUEL COOKEY", phoneNumber = "010020200", emailAddress = "EmmanuelCookey22@gmail.com")
        assertEquals("emmanuelcookey22@gmail.com", contact.emailInLowerCase())
    }

    @Test
    fun testGetContactEmailEdgeCaseEmpty() {
        //3
        val contact = Contact(name = "EMANUEL COOKEY", phoneNumber = "010020200", emailAddress = "")
        assertEquals("", contact.emailInLowerCase())
    }

    @Test
    fun testGetContactEmailCaseNull() {
        //4
        val contact = Contact(name = "EMANUEL COOKEY", phoneNumber = "010020200")
        assertEquals("", contact.emailInLowerCase())
    }

}