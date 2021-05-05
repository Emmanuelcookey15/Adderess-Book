package com.emmanuel.cookey.addressbook.data

import androidx.lifecycle.LiveData
import com.emmanuel.cookey.addressbook.data.db.ContactDao
import com.emmanuel.cookey.addressbook.data.model.Contact
import com.emmanuel.cookey.addressbook.db
import javax.inject.Inject
import kotlin.concurrent.thread

class ContactRepositoryImpl @Inject constructor() : ContactRepository {
    //1
    private val contactDao: ContactDao = db.contactDao()
    private val allContacts: LiveData<List<Contact>>

    //2
    init {
        allContacts = contactDao.getAll()
    }


    override fun selectedContact(id: Int): LiveData<Contact> {
        val contact = contactDao.getContact(id)
        return contact
    }

    //4
    override fun getSavedContact() = allContacts

    //5
    override fun saveContact(contact: Contact) {
        thread {
            contactDao.insert(contact)
        }
    }

    override fun update(contact: Contact) {
        thread {
            contactDao.updateContact(contact)
        }
    }


}