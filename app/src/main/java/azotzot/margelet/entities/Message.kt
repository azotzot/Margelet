package azotzot.margelet.entities

import java.util.*


class Message(
    var messId: UUID,
    var chatId: UUID,
    var senderId: Int,
    var date: Date? = null,
    var messageText: String
)
{


    override fun toString(): String {
        return "{messid: $messId \n" +
                "\t\t chatId: $chatId \n" +
                "\t\t\t date: $date \n" +
                "\t\t\t\t senderId: $senderId \n" +
                "\t\t\t\t\t message: $messageText \n}"
    }

}