package azotzot.margelet.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import azotzot.margelet.CompositeJob
import azotzot.margelet.GlobalVariables.Companion.socket
import azotzot.margelet.GlobalVariables.Companion.user
import azotzot.margelet.R
import azotzot.margelet.entities.User
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private val job: CompositeJob = CompositeJob()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (!socket?.connected()!!) {
            socket!!.connect()
            Log.d("check", "connect success")
            Log.d("check", socket.toString())
        }


        val notFoundUserToast = Toast.makeText(this, "(づ｡◕‿‿◕｡)づ WAIT", Toast.LENGTH_LONG)
        val intent = Intent(this, ChatListActivity::class.java)
//        Log.d("check", "toast was create $notFoundUserToast")
        Log.d("check", "intent was create $intent")

        val nickNameField = enterNickname
        val passwordField = enterPassword
        socket?.on("loginResponse") {args ->
            Log.d("check", "loginResponse args = $args[0]")
//
                    if (args[0] != null) {
                        notFoundUserToast.show()
                        user = GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().fromJson(args[0].toString(), User::class.java)
                        startActivity(intent)

                    } else {
                        runOnUiThread {
                            nickNameField.error = "Пользователь не существует"
                            passwordField.text.clear()
                            nickNameField.requestFocus()
                        }
                    }
                }
        }


//
//    fun testConnect(view: View) {
//        socket!!.connect()
//        if (socket!!.connected()) {
//            Log.i("check", "connect success")
//            Log.i("check", socket.toString())
//        }
//    }
//
//    fun startService(view: View) {
//        startService(Intent(this, DataSyncService::class.java))
//    }


//    fun testDisconnect(view: View) {
//        socket!!.disconnect()
//        Log.i("check", "disconnect success")
//    }

//    fun change(view: View) {
//
//        var intent = Intent(this, ChatListActivity::class.java)
////        inten.putExtra(, socket)
//        startActivity(intent)
//
//    }

    fun login(view: View) {
        val nickNameField = enterNickname
        val passwordField = enterPassword
        socket?.emit("login", nickNameField.text.toString(), passwordField.text.toString())
        Log.i("check", "emit success")
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
        socket?.off("loginResponse")
    }
}
