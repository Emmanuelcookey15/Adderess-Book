package com.emmanuel.cookey.addressbook.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.emmanuel.cookey.addressbook.data.model.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase: RoomDatabase() {


    abstract fun contactDao(): ContactDao

    companion object {
        private val lock = Any()
        private const val DB_NAME = "ContactDatabase"
        private var INSTANCE: ContactDatabase? = null

        fun getInstance(application: Application): ContactDatabase {
            synchronized(ContactDatabase.lock) {
                if (ContactDatabase.INSTANCE == null) {
                    ContactDatabase.INSTANCE =
                        Room.databaseBuilder(application, ContactDatabase::class.java, ContactDatabase.DB_NAME)
                            .build()
                }
            }
            return INSTANCE!!
        }
    }


}