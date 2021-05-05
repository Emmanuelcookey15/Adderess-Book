package com.emmanuel.cookey.addressbook.data

import androidx.lifecycle.LiveData
import com.emmanuel.cookey.addressbook.data.db.ContactDao
import com.emmanuel.cookey.addressbook.data.model.Contact
import com.emmanuel.cookey.addressbook.db
import kotlin.concurrent.thread

class ContactRepositoryImpl : ContactRepository {
    //1
    private val contactDao: ContactDao = db.contactDao()
    private val allContacts: LiveData<List<Contact>>

    //2
    init {
        allContacts = contactDao.getAll()
    }
    
    //3
    override fun deleteContact(contact: Contact) {
        thread {
            db.contactDao().delete(contact.id)
        }
    }

    override fun selectedContact(id: Int): LiveData<Contact> {
        val contact = contactDao.getContact(id)
        return contact
    }

    //4
    override fun getSavedContact() = allContacts

    //5
    override fun saveContact(movie: Contact) {
        thread {
            contactDao.insert(movie)
        }
    }


}