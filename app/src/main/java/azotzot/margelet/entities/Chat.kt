package azotzot.margelet.entities

class Chat(var chatId: Int, var chatName: String, var recipient: Int, var messages: MutableList<Message>) {

    override fun toString(): String {
        return "{chatId: $chatId \n" +
                "\t\t chatName: $chatName \n" +
                "\t\t first message: ${messages[0]}}"
    }

}