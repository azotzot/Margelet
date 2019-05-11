package azotzot.margelet.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import azotzot.margelet.GlobalVariables.Companion.user
import azotzot.margelet.R
import azotzot.margelet.adapters.MessageAdapter
import kotlinx.android.synthetic.main.chat_activity.*

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_activity)

        messageList?.layoutManager = LinearLayoutManager(this)

        var pos = intent.getStringExtra("chat_position").toInt()
        messageList?.adapter = MessageAdapter(user!!.chats[pos].messages, this)

    }
}
