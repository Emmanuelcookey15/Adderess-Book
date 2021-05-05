package com.emmanuel.cookey.addressbook.views.activities

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.emmanuel.cookey.addressbook.R
import com.emmanuel.cookey.addressbook.data.model.Contact
import com.emmanuel.cookey.addressbook.viewmodel.EditViewModel
import com.google.android.material.snackbar.Snackbar
import com.emmanuel.cookey.addressbook.action
import com.emmanuel.cookey.addressbook.snack
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_add_contact.*
import kotlinx.android.synthetic.main.activity_edit_contact.*
import kotlinx.android.synthetic.main.toolbar_view_custom_layout.*

@AndroidEntryPoint
class EditContactActivity : BaseActivity() {


    private val toolbar: Toolbar by lazy { toolbar_toolbar_view as Toolbar }

    var contactId = 0
    var contactName: String = ""
    var contactPhone = ""
    var contactEmail = ""


    private val viewModel: EditViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_contact)

        val intentFromMainActivity = intent
        initializeEditText(intentFromMainActivity.getIntExtra("contact_id", 0))


    }

    override fun getToolbarInstance(): Toolbar? {
        return toolbar
    }

    fun initializeEditText (id: Int) {
        if (id != 0) {
            viewModel.getContacts(id).observe(this, Observer {
                contactId = it.id!!
                contactName = it.name.toString()
                contactPhone = it.phoneNumber.toString()
                contactEmail = it.emailAddress.toString()

                nameEdit.setText(contactName)
                phone_num_edit.setText(contactPhone)
                emailEdit.setText(contactEmail)
            })
        }
    }


    fun editContactClicked(view: View) {

        if (nameEditText.text.toString().isNotBlank()) {
            viewModel.saveMovie(
                Contact(
                    id = contactId,
                    name = nameEdit.text.toString(),
                    phoneNumber = phone_num_edit.text.toString(),
                    emailAddress = emailEdit.text.toString()
                )
            )
            finish()
        } else {
            showMessage(getString(R.string.enter_name))
        }
    }

    private fun showMessage(msg: String) {
        addLayout.snack((msg), Snackbar.LENGTH_LONG) {
            action(getString(R.string.ok)) {
            }
        }
    }


}