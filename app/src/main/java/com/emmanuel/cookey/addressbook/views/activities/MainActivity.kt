package com.emmanuel.cookey.addressbook.views.activities

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.emmanuel.cookey.addressbook.R
import com.emmanuel.cookey.addressbook.data.model.Contact
import com.emmanuel.cookey.addressbook.viewmodel.MainViewModel
import com.emmanuel.cookey.addressbook.views.adapters.ContactListAdapter
import com.emmanuel.cookey.addressbook.action
import com.emmanuel.cookey.addressbook.snack
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_view_custom_layout.*
import org.jetbrains.anko.toast

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val toolbar: Toolbar by lazy { toolbar_toolbar_view as Toolbar }
    private val adapter = ContactListAdapter(mutableListOf()) { contact -> editContactDetails(contact) }



    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contactsRecyclerView.adapter = adapter
        viewModel.getSavedContacts().observe(this, Observer { contacts ->
            contacts?.let {
                adapter.setMovies(contacts)
            }
        })

    }


    override fun getToolbarInstance(): Toolbar? {
        return toolbar
    }


    fun goToAddActivity(view: View){
        val intent = Intent(this@MainActivity, AddContactActivity::class.java)
        startActivity(intent)
    }


    private fun editContactDetails(contact: Contact) {
        mainLayout.snack("You want to edit ${contact.name}?", Snackbar.LENGTH_LONG) {
            action(getString(R.string.ok)) {
                val intent = Intent(this@MainActivity, EditContactActivity::class.java)
                intent.putExtra("contact_id", contact.id)
                startActivity(intent)
            }
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> true
            else -> toast(getString(R.string.error))
        }
        return super.onOptionsItemSelected(item)

    }



}