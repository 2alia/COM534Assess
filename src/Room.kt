data class Room (val roomNumber: String, var osType:String, val computers: Int)

val rooms = mutableListOf(
    Room("JM606","Windows",20),
    Room("JM607","Linux", 15)
)

fun modifyRoomDetails(){
    println("Enter room number to modify:")
    val roomNumber= readln()

    val room = rooms.find {it.roomNumber== roomNumber}

    if (room != null) {
        println("Enter new computer type(Windows, Mac, Linux):")

        val newOsType = readln()
        room.osType = newOsType
        println("Room $roomNumber has been updated to use $newOsType computers.")
    }else{
        println("Room not found")
    }
}

fun deleteRoom(){
    println("Enter room number to delete:")
    val roomNumber = readln()

    val room = rooms.find { it.roomNumber == roomNumber }

    if (room !=null){
        rooms.remove(room)
        println("Room $roomNumber has been deleted.")
    }else {
        println("Room not found.")
    }
}

fun modifyUserDetails(){
    println("Enter the username of the user to modify:")
    val username = readln()

    val user = users.find { it.username == username }
    if (user != null) {
        println("Enter new contact details:")
        val newContactDetails = readln()
        user.contactDetails = newContactDetails
        println("User $username's contact details have been updated to $newContactDetails")
    }else{
        println("User not found")
    }
}

fun deleteUser(){
    println("Enter the username of the user to delete : ")
    val username = readln()

    val user = users.find { it.username == username }

    if (user !=null) {
        users.remove(user)
        println("User $username has been deleted.")
    }else{
        println("User not found.")
    }
}
fun adminMenu(){
    println("Admin Menu:")
    println("1. Modify room details")
    println("2. Delete a room")
    println("3. Modify user details")
    println("4. Delete a user")
    println("5. Exit")

    when (readln().toIntOrNull()){
        1 -> modifyRoomDetails()
        2 -> deleteRoom()
        3 -> modifyUserDetails()
        4 -> deleteUser()
        5 -> println("Exiting admin menu...")
        else -> println("Invalid option, try again.")
    }
}