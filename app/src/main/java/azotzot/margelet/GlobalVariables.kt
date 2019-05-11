package azotzot.margelet

import android.app.Application
import azotzot.margelet.entities.User
import com.github.nkzawa.socketio.client.Socket


class GlobalVariables: Application() {
    companion object {
        var socket: Socket? = null
        var user: User? = null
    }

}