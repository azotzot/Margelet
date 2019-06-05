package azotzot.margelet

import android.app.Application
import android.content.Intent
import android.util.Log
import azotzot.margelet.entities.User
import azotzot.margelet.services.DataSyncService
import com.github.nkzawa.socketio.client.IO
import com.github.nkzawa.socketio.client.Socket
import java.net.URISyntaxException


class GlobalVariables: Application() {
    companion object {
        var socket: Socket? = null
        var user: User? = null
    }

    private val connectUrl = "http://10.0.2.2:3000" //"https://margeletserver.herokuapp.com/"

    override fun onCreate() {
        super.onCreate()

        try{
            socket = IO.socket(connectUrl)
            Log.d("check", "socket get success")
        } catch (e: URISyntaxException) {
            Log.e("check", "connect error")
        }

        startService(Intent(this, DataSyncService::class.java))
    }

    override fun onTerminate() {
        super.onTerminate()

        socket!!.disconnect()
    }


}