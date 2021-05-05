package com.emmanuel.cookey.addressbook.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.emmanuel.cookey.addressbook.R
import com.emmanuel.cookey.addressbook.data.model.Contact
import com.emmanuel.cookey.addressbook.viewmodel.AddViewModel
import com.emmanuel.cookey.addressbook.viewmodel.EditViewModel
import com.google.android.material.snackbar.Snackbar
import com.raywenderlich.wewatch.action
import com.raywenderlich.wewatch.snack
import kotlinx.android.synthetic.main.activity_add_contact.*
import kotlinx.android.synthetic.main.toolbar_view_custom_layout.*

class AddContactActivity : BaseActivity() {

    private val toolbar: Toolbar by lazy { toolbar_toolbar_view as Toolbar }


    private val viewModel: AddViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

    }



    override fun getToolbarInstance(): Toolbar? {
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