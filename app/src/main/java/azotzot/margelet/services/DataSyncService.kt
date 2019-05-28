package azotzot.margelet.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import azotzot.margelet.GlobalVariables.Companion.socket
import azotzot.margelet.GlobalVariables.Companion.user
import azotzot.margelet.entities.Message
import azotzot.margelet.entities.User
import com.google.gson.GsonBuilder
import kotlin.concurrent.thread


class DataSyncService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate() {
        super.onCreate()
        var myThread = thread {
            socket!!.on("updateData") { args ->
                Log.i("SocketThread", args[0].toString())
                user = GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().fromJson(args[0].toString(), User::class.java)
//                     = gson.fromJson(args[0].toString(), User::class.java)
                Log.i("SocketThread", user.toString())
            }

            socket!!.on("syncNewMessage") {args ->
                Log.i("SocketThread", "new mess sync")
                val newMess = GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().fromJson(args[0].toString(), Message::class.java)
                Log.i("SocketThread", "new mess = $newMess")

                user?.getChatById(newMess.meChatId).run {
                    if (this == null) {
                        ////////////////////// cделать обработку ошибок
                    }
                    else {
                        this.messages.add(newMess)
                    }
                }
            }
                ///FOR TEST HEROKU
//            socket!!.on("loginResponse") {args ->
//                user = GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().fromJson(args[0].toString(), User::class.java)
//            }


        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show()
        Log.d("check", "ServiceStart")
        return super.onStartCommand(intent, flags, startId)
    }


}
