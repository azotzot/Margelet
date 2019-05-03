package azotzot.margelet.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import azotzot.margelet.GlobalVariables.Companion.socket
import azotzot.margelet.R
import com.github.nkzawa.socketio.client.IO
import java.net.URISyntaxException


class MainActivity : AppCompatActivity() {

//    private var socket = globVar.socket
    private val connectUrl = "http://10.0.2.2:3000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        try{
//            socket = IO.socket(connectUrl)
//            Log.i("check", "connect success")
//        } catch (e: URISyntaxException) {
//            Log.e("check", "connect error")
//        }
    }

    fun testDate(view: View) {
        socket!!.emit("test", "test mess")
        Log.i("check", "try to send")
    }

    fun testConnect(view: View) {
//        socket!!.connect()
        try{
            socket = IO.socket(connectUrl)
            Log.i("check", "connect success")
        } catch (e: URISyntaxException) {
            Log.e("check", "connect error")
        }
        if (socket != null) {
            Log.i("check", "connect success")
            Log.i("check", socket.toString())
            Log.i("check", socket.toString()+" || globVar")
        }
    }

    fun testDisconnect(view: View) {
        socket!!.disconnect()
        Log.i("check", "disconnect success")
    }
}
