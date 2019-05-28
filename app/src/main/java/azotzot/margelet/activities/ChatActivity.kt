package azotzot.margelet.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import azotzot.margelet.GlobalVariables
import azotzot.margelet.GlobalVariables.Companion.user
import azotzot.margelet.R
import azotzot.margelet.adapters.MessageAdapter
import azotzot.margelet.entities.Message
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.messages_activity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ChatActivity : AppCompatActivity(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main //To change initializer of created properties use File | Settings | File Templates.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.messages_activity)

        messageList?.layoutManager = LinearLayoutManager(this)

        var pos = intent.getStringExtra("chat_position").toInt()
        messageList?.adapter = MessageAdapter(user!!.chats[pos].messages, this)

    }


    fun sendMessage(view: View) {
        Toast.makeText(this, "(づ｡◕‿‿◕｡)づ", Toast.LENGTH_SHORT).show()
        val pos = intent.getStringExtra("chat_position").toInt()
        var messTextEditor = newMessageField
        if (messTextEditor.text.toString() != "") {

            Toast.makeText(this, "(づ｡◕‿‿◕｡)づ", Toast.LENGTH_SHORT).show()

            var newMess = Message(
                meChatId = user!!.chats[pos].chatId,
                senderId = user!!.userId,
                recipientId = user!!.chats[pos].recipientId,
                messageText = messTextEditor.text.toString()
            )
            messTextEditor.text.clear()
            Log.d("check", newMess.toString())
            launch(coroutineContext) {
                GlobalVariables.socket?.emit("newMessage", GsonBuilder().serializeNulls().create().toJson(newMess))
                Log.d("check", newMess.toString())
                Log.d("check", "launch active")
                cancel(cause = null)
                Log.d("check", "still active???")
            }

        }


    }


}




