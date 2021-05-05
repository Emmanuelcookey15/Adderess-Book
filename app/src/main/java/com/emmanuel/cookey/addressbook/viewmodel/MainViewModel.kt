package com.emmanuel.cookey.addressbook.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.emmanuel.cookey.addressbook.data.model.Contact
import com.emmanuel.cookey.addressbook.data.ContactRepository
import com.emmanuel.cookey.addressbook.data.ContactRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ContactRepository = ContactRepositoryImpl()) : ViewModel() {

    //1
    private val allContacts = MediatorLiveData<List<Contact>>()
    //2
    init {
        getAllContacts()
    }
    //3
    fun getSavedContacts() = allContacts
    //4
    private fun getAllContacts() {
        allContacts.addSource(repository.getSavedContact()) { contacts ->
            allContacts.postValue(contacts)
        }
    }
    //5
    fun deleteSavedMovies(contact: Contact) {
        repository.deleteContact(contact)
    }
}
