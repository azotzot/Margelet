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
import azotzot.margelet.activities.ChatActivity
import azotzot.margelet.entities.Chat
import kotlinx.android.synthetic.main.chat_item.view.*

class ChatListAdapter(var chats: MutableList<Chat>, context: Context): RecyclerView.Adapter<ChatListAdapter.ChatsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)

        return ChatsViewHolder(view)
    }

    override fun getItemCount() = chats.size

    override fun onBindViewHolder(holder: ChatsViewHolder, position: Int) {
        holder.chatname.text = chats[position].chatName

    }

    class ChatsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{ //, View.OnClickListener

        var chatname: TextView = itemView.chatname
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            var pos = layoutPosition
            Log.d("check", "click_on_item $pos")
            var intent = Intent(v?.context, ChatActivity::class.java)
            intent.putExtra("chat_position", pos.toString())
            v?.context?.startActivity(intent)

        }

    }



}
