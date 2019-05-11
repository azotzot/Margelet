package azotzot.margelet.activities



import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import azotzot.margelet.GlobalVariables.Companion.user
import azotzot.margelet.R
import azotzot.margelet.adapters.ChatsAdapter
import kotlinx.android.synthetic.main.activity_chat_list.*


class ChatListActivity : AppCompatActivity() {

//    private var chatListView: RecyclerView? = chatList
//    private lateinit var linearLayoutManager: LinearLayoutManager
//    private lateinit var adapter: ChatsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_list)

        chatList?.layoutManager = LinearLayoutManager(this)

//        socket!!.emit("getData").on("sendData") { args ->
//            user = Klaxon().parse<User>(args[0].toString())
//            Log.i("load_check2", user.toString())
//        }
//        loadData()

//        Log.i("load_check", user.toString())
        chatList?.adapter = ChatsAdapter(user!!.chats, this)

    }

//    private fun loadData(){
//        socket!!.emit("getData").on("sendData") { args ->
//            user = Klaxon().parse<User>(args[0].toString())
//            Log.i("load_check2", user.toString())
//        }
//    }

//    override fun onStart() {
//        super.onStart()
////        if (user!!.chats.size == 0) {
////            //проверка на пустоту чатов
////        }
//    }


}
