class Admin (
    username: String,
    password:String,
     isAdmin:Boolean= true,
     contactDetails:String

):User(username,password,isAdmin,contactDetails)

{
   private fun deleteUser() {
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
    private fun deleteRoom() {
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

   private fun modifyRoomDetails() {
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

     private   fun modifyUserDetails() {
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



       override fun Menu() {
            println("Admin Menu Access:")
            println("Enter Admin Username:")
            val adminUserName = readln().trim()
           if (adminUserName.isBlank()) {
               println("Username cannot be empty")
               return
           }


            println("Enter Admin password:")
           val adminPassword = readln().trim()
           if (adminPassword.isBlank()) {
               println("Password cannot be empty")
               return
           }

            val admin = users.find { it.username == adminUserName && it.password == adminPassword }

            if (admin != null && admin.isAdmin) {
                println("Access granted. Welcome,Admin.${adminUserName}.")

                var exit = false

                while (!exit) {
                    println("Admin Menu:")
                    println("1. Modify room details")
                    println("2. Delete a room")
                    println("3. Modify user details")
                    println("4. Delete a user")
                    println("5. Exit")

                    when (readln().toIntOrNull()) {
                        1 -> modifyRoomDetails()
                        2 -> deleteRoom()
                        3 -> modifyUserDetails()
                        4 -> deleteUser()
                        5 -> {
                            println("Exiting admin menu.. Goodbye, Admin $adminUserName.")
                            exit = true

                        }

                        else -> println("Invalid option. Please try again.")
                    }
                    println("------------")
                }
            } else {
                println("Access denied. You are not authorized to access the admin menu.")
            }
        }
    }








