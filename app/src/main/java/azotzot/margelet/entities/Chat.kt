package azotzot.margelet.entities

import java.util.*

data class Member(var userId: Int,
                  var nickname: String) {
}

class Chat(var chatId: UUID,
           var chatName: String,
           var type: String,
           var members: MutableList<Member>,
           var messages: MutableList<Message>) {

    override fun toString(): String {
        return "{chatId: $chatId \n" +
                "\t type: $type \n "+
                "\t\t chatName: $chatName \n" +
                "\t\t\t first message: ${messages[0]} \n}"
    }

}