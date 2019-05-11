package azotzot.margelet.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import azotzot.margelet.R
import azotzot.margelet.entities.Message
import kotlinx.android.synthetic.main.message_item.view.*

class MessageAdapter(var messages: MutableList<Message>, var context: Context): RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(LayoutInflater.from(context).inflate(R.layout.message_item, parent, false))
    }

    override fun getItemCount() = messages.size

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {

        Log.d("check", messages[position].toString())
        holder.senderId.text = messages[position].senderId.toString()
        holder.messageText.text = messages[position].message
    }

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { //, View.OnClickListener

        var senderId: TextView = itemView.senderId
        var messageText: TextView = itemView.messageText

        init{
            senderId = itemView.senderId
            messageText = itemView.messageText

        }

    }

}