package azotzot.margelet.activities



import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import azotzot.margelet.GlobalVariables.Companion.user
import azotzot.margelet.R
import azotzot.margelet.adapters.ChatListAdapter
import kotlinx.android.synthetic.main.chats_activity.*


class ChatListActivity : AppCompatActivity() {

//    private var chatListView: RecyclerView? = chatList
//    private lateinit var linearLayoutManager: LinearLayoutManager
//    private lateinit var adapter: ChatListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chats_activity)

        chatList?.layoutManager = LinearLayoutManager(this)
        chatList?.adapter = ChatListAdapter(user!!.chats, this)

    }

    override fun onStart() {
        super.onStart()

        val forJoke = Toast.makeText(this, "ПРИХОД СОВЕРШЕН", Toast.LENGTH_SHORT)//"(づ｡◕‿‿◕｡)づ WAIT", Toast.LENGTH_LONG)
        forJoke.show()

    }

}
