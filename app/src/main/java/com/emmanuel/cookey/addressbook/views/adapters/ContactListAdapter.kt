/*
 * Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.emmanuel.cookey.addressbook.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.emmanuel.cookey.addressbook.R
import com.emmanuel.cookey.addressbook.data.model.Contact
import kotlinx.android.synthetic.main.item_contact_main.view.*
import java.util.*

class ContactListAdapter(private val contacts: MutableList<Contact>,
                         private var listener: (Contact) -> Unit): RecyclerView.Adapter<ContactListAdapter.ContctsHolder>() {


  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContctsHolder {
    val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.item_contact_main, parent, false)
    return ContctsHolder(view)
  }

  override fun getItemCount(): Int = contacts.size ?: 0

  override fun onBindViewHolder(holder: ContctsHolder, position: Int) {
    holder.bind(contacts[position], position)
  }

  fun setMovies(contactList: List<Contact>) {
    this.contacts.clear()
    this.contacts.addAll(contactList)
    notifyDataSetChanged()
  }

  inner class ContctsHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(contact: Contact, position: Int) = with(view) {
      text_view_name.text = contact.nameCapitalized()
      text_view_email.text = contact.emailInLowerCase()
      text_view_phone.text = contact.phoneNumber
      view.setOnClickListener { listener(contacts?.get(position)) }

    }
  }
}