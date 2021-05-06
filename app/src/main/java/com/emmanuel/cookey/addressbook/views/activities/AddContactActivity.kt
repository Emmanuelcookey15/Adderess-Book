package com.emmanuel.cookey.addressbook.views.activities

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import com.emmanuel.cookey.addressbook.R
import com.emmanuel.cookey.addressbook.data.model.Contact
import com.emmanuel.cookey.addressbook.viewmodel.AddViewModel
import com.google.android.material.snackbar.Snackbar
import com.emmanuel.cookey.addressbook.action
import com.emmanuel.cookey.addressbook.snack
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_add_contact.*
import kotlinx.android.synthetic.main.toolbar_view_custom_layout.*


@AndroidEntryPoint
class AddContactActivity : BaseActivity() {

    private val toolbar: Toolbar by lazy { toolbar_toolbar_view as Toolbar }


    private val viewModel: AddViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

    }



    override fun getToolbarInstance(): Toolbar? {
        toolbar.title = "Add Contact"
        return toolbar
    }

    fun addContactClicked(view: View) {
        if (nameEditText.text.toString().isNotBlank()) {
            viewModel.saveMovie(
                Contact(
                name = nameEditText.text.toString(),
                phoneNumber = phone_num_edit_text.text.toString(),
                emailAddress = emailEditText.text.toString()
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