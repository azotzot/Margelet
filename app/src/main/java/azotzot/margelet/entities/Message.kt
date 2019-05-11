package azotzot.margelet.entities

class Message(var messid: Int,var senderId: Int, var message: String) {

    override fun toString(): String {
        return "{messid: $messid \n" +
                "\t\t\t\t senderId: $senderId \n" +
                "\t\t\t\t message: $message}"
    }

}