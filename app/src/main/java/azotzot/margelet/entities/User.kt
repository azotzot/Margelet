package azotzot.margelet.entities

class User(var userId: Int, var nickname: String, var chats: MutableList<Chat>) {

    override fun toString(): String {
        return "{userId: $userId \n" +
                "nickname: $nickname \n" +
                "first chat: ${chats[0]}}"
    }
}