package com.emmanuel.cookey.addressbook.di

import com.emmanuel.cookey.addressbook.data.ContactRepositoryImpl
import com.emmanuel.cookey.addressbook.data.ContactRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


//Repositories will live same as the activity that requires them
@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesChannelRepository(impl: ContactRepositoryImpl): ContactRepository

}


