package com.example.codepathmail

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) :
    RecyclerView.Adapter<EmailAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val senderTextView: TextView
        val titleTextView: TextView
        val summaryTextView: TextView
        val imageView: ImageView


        init {

            senderTextView = itemView.findViewById(R.id.senderTv)
            titleTextView = itemView.findViewById(R.id.titleTv)
            summaryTextView = itemView.findViewById(R.id.summaryTv)
            imageView = itemView.findViewById(R.id.photo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val email = emails[position]
        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary
        holder.imageView.setImageResource(email.image)

        if (email.read) {
            holder.senderTextView.setTypeface(null, Typeface.NORMAL)
        } else {
            holder.senderTextView.setTypeface(null, Typeface.BOLD)
        }

        holder.itemView.setOnClickListener {
            email.read = true
            holder.senderTextView.setTypeface(null, Typeface.NORMAL)
        }
    }



    override fun getItemCount(): Int {
        return emails.size
    }


}
