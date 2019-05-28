package azotzot.margelet.entities

class Chat(var chatId: Int,
           var chatName: String,
           var chUserId: Int,
           var recipientId: Int,
           var recipientName: String,
           var messages: MutableList<Message>) {

    override fun toString(): String {
        return "{chatId: $chatId \n" +
                "\t userId: $chUserId \n" +
                "\t\t chatName: $chatName \n" +
                "\t\t\t recipientId: $recipientId \n" +
                "\t\t\t\t recipientName: $recipientName \n" +
                "\t\t\t\t\t first message: ${messages[0]} \n}"
    }

}