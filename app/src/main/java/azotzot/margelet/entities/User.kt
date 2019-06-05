package azotzot.margelet.entities

import java.util.*

class User(var userId: Int,
           var nickname: String,
    //var password: String,
           var chats: MutableList<Chat>) {


    fun getChatById(chatId: UUID): Chat?{
        for(ch in chats){
            if (ch.chatId == chatId) {
                return ch
            }
        }
        return null
    }

    override fun toString(): String {
        return "{userId: $userId \n" +
                "nickname: $nickname \n" +
                "first chat: ${chats[0]}}"
    }
}