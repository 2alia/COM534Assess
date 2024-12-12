// -------------------------------GROUP AUTHORS DAFE EDESIRI OTUDJE AND ADAM ALI --------------------------------------

// HAD TO  MAKE ALL THE FUNCTIONS THAT WERE PRIVATE PUBLIC
// THIS WAS BECAUSE BOOKINGMANAGEMENTAPPLICATION CLASS WAS HANDLING THE MENU AND APP FLOW
// SO IT NEEDED ACCESS TO ADMIN METHODS
class Admin (
    username: String,
    password:String,
    contactDetails:String

):User(username,password,contactDetails, isAdmin=true)

{
    //--------INDIVIDUAL AUTHOR ADAM ALI----------------------
    fun deleteUser() {
        println("Enter the username of the user to delete : ")
        val username = readln()

        val user = users.find { it.username.equals(username, ignoreCase = true)}

        if (user != null) {
            users.remove(user)
            println("User ${user.username} has been deleted.")
        } else {
            println("User $username not found. It might have been deleted.")
        }
    }
    //--------INDIVIDUAL AUTHOR ADAM ALI----------------------
    fun deleteRoom() {
        println("Enter room number to delete:")
        val roomNumber = readln()

        val room = rooms.find { it.roomNumber.equals(roomNumber, ignoreCase = true) }


        if (room != null) {
            rooms.remove(room)
            println("Room ${room.roomNumber} has been permanently deleted.")
        } else {
            println("Room $roomNumber not found. It might have been deleted.")
        }
    }
    //--------INDIVIDUAL AUTHOR ADAM ALI----------------------
    fun modifyRoomDetails() {
        println("Enter room number to modify:")
        val roomNumber = readln()

        val room = rooms.find { it.roomNumber == roomNumber }
        if (room != null) {
            println("Enter new computer type(Windows, Mac, Linux):")

            val newOsType = readln()
            room.osType = newOsType
            println("Room $roomNumber has been updated to use $newOsType computers.")
        } else {
            println("Room not found")
        }
   }
    //--------INDIVIDUAL AUTHOR ADAM ALI----------------------
     fun modifyUserDetails() {
            println("Enter the username of the user to modify:")
            val username = readln()

            val user = users.find { it.username == username }
            if (user != null) {
                println("Enter new contact details:")
                val newContactDetails = readln()
                user.contactDetails = newContactDetails
                println("User $username's contact details have been updated to $newContactDetails.")
            } else {
                println("User not found.")
            }
        }

    //--------INDIVIDUAL AUTHOR DAFE EDESIRI OTUDJE ----------------------
     fun addNewRoom(){
        println("Enter Building Name: ")
        val building = readln()
        println("Enter room name: ")
        val roomName = readln()
        println("Enter number of computers: ")
        val numberOfComputers = readln().toInt()
        println("Enter Computer OS Type: ")
        val osType = readln()
        val timeSlots= mutableListOf<String>()
        val newRoom=Room(roomName,building,osType,MutableList<Int>(numberOfComputers){-1},timeSlots)
        println("Room $roomName added with $numberOfComputers computers.")
        rooms.add(newRoom)

    }

    //--------INDIVIDUAL AUTHOR DAFE EDESIRI OTUDJE ----------------------
    fun getBookingsByRoomandDay():List<Booking>{
        println("Enter room name: ")
        val room = readln()
        println("Enter day: ")
        val day = readln()
        val roomBookings = bookings.filter { it.getRoom() == room && it.getDay() == day }
        if(roomBookings==null){
            println("No Data found")
        }
        return roomBookings


    }




}