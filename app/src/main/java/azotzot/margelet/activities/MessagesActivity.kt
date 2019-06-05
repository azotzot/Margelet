package azotzot.margelet.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import azotzot.margelet.CompositeJob
import azotzot.margelet.GlobalVariables.Companion.socket
import azotzot.margelet.GlobalVariables.Companion.user
import azotzot.margelet.R
import azotzot.margelet.adapters.MessageAdapter
import azotzot.margelet.entities.Message
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.messages_activity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.coroutines.CoroutineContext

class MessagesActivity : AppCompatActivity(), CoroutineScope {
    private val job: CompositeJob = CompositeJob()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main //To change initializer of created properties use File | Settings | File Templates.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.messages_activity)

        messageList?.layoutManager = LinearLayoutManager(this).apply {
            this.reverseLayout = true
        }

        var pos = intent.getStringExtra("chat_position").toInt()
        messageList?.adapter = MessageAdapter(user!!.chats[pos].messages, this)
//        val forJoke = Toast.makeText(this, "ПРИХОД СОВЕРШЕН", Toast.LENGTH_SHORT)//"(づ｡◕‿‿◕｡)づ WAIT", Toast.LENGTH_LONG)

    }



    fun sendMessage(view: View) {
        Toast.makeText(this, "(づ｡◕‿‿◕｡)づ", Toast.LENGTH_SHORT).show()
        val pos = intent.getStringExtra("chat_position").toInt()
        var messTextEditor = newMessageField
        if (messTextEditor.text.toString() != "") {

            Toast.makeText(this, "(づ｡◕‿‿◕｡)づ", Toast.LENGTH_SHORT).show()
            val chatOfNewMess = user!!.chats[pos]
            var newMess = Message(
                chatId = chatOfNewMess.chatId,
                senderId = user!!.userId,
                date = Date(),
                messId = UUID.randomUUID(),
                messageText = messTextEditor.text.toString()
            )
            chatOfNewMess.messages.add(newMess)
            messTextEditor.text.clear()
            Log.d("check", newMess.toString())

            job.add(launch {
                val t = mutableListOf<Int>()
                chatOfNewMess.members.forEach { t.add(it.userId)}
                socket?.emit("sendMessage", t, GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(newMess) )
                Log.d("check",  newMess.toString())
            })

        }


    }

    override fun onDestroy() {
        super.onDestroy()

        job.cancel()
    }


}




