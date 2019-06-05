package azotzot.margelet.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import azotzot.margelet.R
import azotzot.margelet.activities.MessagesActivity
import azotzot.margelet.entities.Chat
import kotlinx.android.synthetic.main.chat_item.view.*

class ChatListAdapter(var chats: MutableList<Chat>, context: Context): RecyclerView.Adapter<ChatListAdapter.ChatsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)




        return ChatsViewHolder(view)
    }

    override fun getItemCount() = chats.size

    override fun onBindViewHolder(holder: ChatsViewHolder, position: Int) {
        holder.chatname.text = chats[position].chatName
        holder.lastmessage.text = chats[0].messages[chats[0].messages.size-1].messageText

    }

    class ChatsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){ //, View.OnClickListener

        var chatname: TextView = itemView.chatname
        var lastmessage: TextView = itemView.lastMessage
        init {
            itemView.setOnClickListener {
                val pos = this.layoutPosition
                if (pos != RecyclerView.NO_POSITION) {
                    //пока ничего
                }
                Log.d("check", "click_on_item $pos")
                val intent = Intent(it.context, MessagesActivity::class.java)
                intent.putExtra("chat_position", pos.toString())
                it.context?.startActivity(intent)
            }
        }

    }



}
