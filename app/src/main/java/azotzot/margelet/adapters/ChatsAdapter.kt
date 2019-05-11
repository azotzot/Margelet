package azotzot.margelet.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import azotzot.margelet.R
import kotlinx.android.synthetic.main.chat_item.view.*
import ru.donstu.margelet.entity.Chat

class ChatsAdapter(var chats: MutableList<Chat>, var context: Context): RecyclerView.Adapter<ChatsAdapter.ChatsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder {
        return ChatsViewHolder(LayoutInflater.from(context).inflate(R.layout.chat_item, parent, false))
    }

    override fun getItemCount() = chats.size

    override fun onBindViewHolder(holder: ChatsViewHolder, position: Int) {

//        holder.bind(chats[position])
        holder.chatname?.text = chats[position].chatName
    }

    class ChatsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener { //, View.OnClickListener

        //        private var view = itemView
        //        private var chat: Chat? = null
        var chatname = itemView.chatname

        init{
            itemView.setOnClickListener(this)
            chatname = itemView.chatname
        }

        override fun onClick(v: View?) {
            Log.d("check", "click_on_item")
        }

//        fun bind(chat: Chat) {
//            chatname.text = chat.chatName
//        }
    }

}