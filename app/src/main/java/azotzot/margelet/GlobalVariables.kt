package azotzot.margelet

import android.app.Application
import com.github.nkzawa.socketio.client.Socket
import ru.donstu.margelet.entity.User

class GlobalVariables: Application() {
    companion object {
        var socket: Socket? = null
        var user: User? = null
    }

}