package com.emmanuel.cookey.addressbook.viewmodel


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.emmanuel.cookey.addressbook.data.ContactRepository
import com.emmanuel.cookey.addressbook.data.ContactRepositoryImpl
import com.emmanuel.cookey.addressbook.data.model.Contact
import javax.inject.Inject


class EditViewModel @ViewModelInject constructor(private val repository: ContactRepository): ViewModel()  {
    //1
    fun saveMovie(contact: Contact) {
        repository.update(contact)
    }

}