package com.emmanuel.cookey.addressbook.viewmodel

import androidx.lifecycle.ViewModel
import com.emmanuel.cookey.addressbook.data.model.Contact
import com.emmanuel.cookey.addressbook.data.ContactRepository
import com.emmanuel.cookey.addressbook.data.ContactRepositoryImpl
import javax.inject.Inject
import androidx.hilt.lifecycle.ViewModelInject


class AddViewModel @ViewModelInject constructor(private val repository: ContactRepository): ViewModel()  {
    //2
    fun saveMovie(contact: Contact) {
        repository.saveContact(contact)
    }
}