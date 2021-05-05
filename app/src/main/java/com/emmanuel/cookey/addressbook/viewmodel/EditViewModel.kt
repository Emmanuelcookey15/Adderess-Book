package com.emmanuel.cookey.addressbook.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.emmanuel.cookey.addressbook.data.ContactRepository
import com.emmanuel.cookey.addressbook.data.ContactRepositoryImpl
import com.emmanuel.cookey.addressbook.data.model.Contact
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(private val repository: ContactRepository): ViewModel()  {
    //1
    fun saveMovie(contact: Contact) {
        repository.update(contact)
    }


    //2
    fun getContacts(id: Int): LiveData<Contact> {
        val specificContact = repository.selectedContact(id)
        return specificContact

    }
}