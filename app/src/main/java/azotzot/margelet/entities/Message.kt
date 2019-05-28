package azotzot.margelet.entities

import java.util.*


class Message(
    var messId: Int? = null,
    var meChatId: Int,
    var senderId: Int,
    var recipientId: Int,
    var date: Date? = null,
    var messageText: String
)
{

    override fun toString(): String {
        return "{messid: $messId \n" +
                "\t\t chatId: $meChatId \n" +
                "\t\t\t date: $date \n" +
                "\t\t\t\t recipientId: $recipientId \n" +
                "\t\t\t\t\t senderId: $senderId \n" +
                "\t\t\t\t\t\t message: $messageText \n}"
    }

}