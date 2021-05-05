package com.emmanuel.cookey.addressbook.viewmodel

import androidx.lifecycle.ViewModel
import com.emmanuel.cookey.addressbook.data.model.Contact
import com.emmanuel.cookey.addressbook.data.ContactRepository
import com.emmanuel.cookey.addressbook.data.ContactRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(private val repository: ContactRepository = ContactRepositoryImpl()): ViewModel()  {
    //2
    fun saveMovie(contact: Contact) {
        repository.saveContact(contact)
    }
}