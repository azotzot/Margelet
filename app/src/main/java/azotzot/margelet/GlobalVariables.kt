package azotzot.margelet

import android.app.Application
import com.github.nkzawa.socketio.client.Socket

class GlobalVariables: Application() {
    companion object {
        var socket: Socket? = null
    }

}