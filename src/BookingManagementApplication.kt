// -------------------------------GROUP AUTHORS DAFE EDESIRI OTUDJE,ADAM ALI AND DANIEL ADEYEMI --------------------------------------
// WE changed the handling process of Menu by the Admin class and User Class to "BookingManagementApplication" handling it
// This is the class where the core Integration was done
//
class BookingManagementApplication {
    //--------INDIVIDUAL AUTHOR DAFE EDESIRI OTUDJE----------------------
    // I changed Login from a class to a function in "BookingManagementApplication"
    fun login(): User?{
        println("Please Login to Have Access to your Account")
        val userName: String = promptForInput("Enter your username:")
        val passWord: String = promptForInput("Enter your password:")

        val user = users.find { it.username == userName && it.password == passWord }
        if (user != null ) {
            println("Login successful!!")
        } else {
            println("Incorrect password or Username.")
        }
        return user

    }

    //--------INDIVIDUAL AUTHOR ADAM ALI----------------------
    // I changed signUp from a class to a function in "BookingManagementApplication"
    fun signUp():User{
        var username: String
        var password:String
        var choice:String
        var contactDetails: String


        do {
            println("1 SignUp as Admin:")
            println("2 SignUp as Regular User:")
            choice = readLine().orEmpty()
        } while (choice.isBlank()|| (choice != "1" && choice != "2"))

        do {
            println("Enter your username:")
            username = readLine().orEmpty()
            if (users.any{it.username == username}) {
                println("Username already exists.Please choose a different username.")
                username = ""
            }
        } while (username.isBlank())

        do {
            println("Enter your password:")
            password = readLine().orEmpty()
        } while (password.isBlank())
        do {
            println("Enter your contact details:")
            contactDetails = readLine().orEmpty()
        } while (contactDetails.isBlank())


        val newUser: User = if (choice =="1"){
            Admin(username, password,contactDetails= contactDetails)
        }else{
            User(username, password, isAdmin = false, contactDetails= contactDetails)
        }


       users.add(newUser)
        println("User $username has successfully signed up!")
        return newUser

    }
    //--------INDIVIDUAL AUTHOR DANIEL ADEYEMI---------------------
    fun searchRooms(user: User) {
        println("Enter Building Name to Search: ")
        val building = readln()
        println("Enter Operating System to Search (Windows, Linux, Mac): ")
        val osType = readln()
        val rooms = user.searchRooms(building, osType)
        if (rooms.isNotEmpty()) {
            println("Available Rooms: $rooms")
        } else {
            println("No rooms found matching the criteria.")
        }
    }
    //--------INDIVIDUAL AUTHOR DANIEL ADEYEMI---------------------
    fun bookComputer(user: User) {
        println("Enter Your User ID: ")
        val userId = readln()
        println("Enter Room Number: ")
        val roomNumber = readln()
        println("Enter Day (e.g., Monday): ")
        val day = readln()
        println("Enter Timeslot (e.g., 10:00-12:00): ")
        val timeslot = readln()
        val bookingResult = user.bookComputer(userId, roomNumber, day, timeslot)
        if (bookingResult != null) {
            println("Booking successful! Allocated Computer ID: $bookingResult")
        } else {
            println("No available computers for the given timeslot.")
        }
    }
    //--------INDIVIDUAL AUTHOR DANIEL ADEYEMI---------------------
    fun viewBookings(user: User) {
        println("Enter Your User ID: ")
        val userId = readln()
        val bookings = user.viewUserBookings(userId)
        if (bookings.isNotEmpty()) {
            println("Your Bookings: $bookings")
        } else {
            println("You have no bookings.")
        }

    }
    //--------INDIVIDUAL AUTHOR DANIEL ADEYEMI---------------------
    fun cancelBooking(user: User) {
        println("Enter Your User ID: ")
        val userId = readln()
        println("Enter Global Computer ID to Cancel (e.g., JM606-1): ")
        val globalComputerId = readln()
        println("Enter Day of Booking to Cancel (e.g., Monday): ")
        val day = readln()
        println("Enter Timeslot of Booking to Cancel (e.g., 10:00-12:00): ")
        val timeslot = readln()
        val cancelResult = user.cancelBooking(userId, globalComputerId, day, timeslot)
        if (cancelResult) {
            println("Booking successfully cancelled.")
        } else {
            println("No matching booking found to cancel.")
        }
    }

    //--------INDIVIDUAL AUTHOR ADAM ALI---------------------
    fun Usermenu(user: User){
        var running=true
        while(running){
            println(
                """
             Welcome,${user.username}       
            ------------------------------
            Please choose an option:
            1. Search for Rooms
            2. Book a Computer
            3. View Your Bookings
            4. Cancel a Booking
            5. Log out
            ------------------------------
        """.trimIndent()
            )
            when(readln().toInt()){
                    1->searchRooms(user)
                    2->bookComputer(user)
                    3->viewBookings(user)
                    4->cancelBooking(user)
                5-> running=false
                else -> println("Invalid choice.")
            }

        }

    }

    //--------INDIVIDUAL AUTHOR DAFE EDESIRI OTUDJE----------------------
    // created a function to handle Admin menu outside the Admin class to make the Admin class more reusable
    // I also removed the encapsulation I implemented on the Admin Class methods previously in my individual parts
    fun AdminMenu(user: Admin) {

        println("Access granted. Welcome,Admin ${user.username}.")

        var running = true

        while (running) {
            println("Admin Menu:")
            println("1. Modify room details")
            println("2. Delete a room")
            println("3. Modify user details")
            println("4. Delete a user")
            println("5. Search Bookings by room and day")
            println("6. Add Room")
            println("7. Exit")

            when (readln().toIntOrNull()) {
                1 -> user.modifyRoomDetails()
                2 -> user.deleteRoom()
                3 -> user.modifyUserDetails()
                4 -> user.deleteUser()
                5-> {
                    val fetchedBookings=user.getBookingsByRoomandDay()
                    if(fetchedBookings.isNotEmpty()){
                        fetchedBookings.forEach { println(it) }
                    }else{
                        println("No Booking for This Room")
                    }
                }
                6-> user.addNewRoom()
                7 -> {
                    println("Exiting admin menu.. Goodbye, Admin ${user.username}.")
                    running = false
                }
                else -> println("Invalid option. Please try again.")
            }
            println("------------")
        }
    }

    private fun promptForInput(message: String): String {
        var input: String
        do {
            println(message)
            input = readln().trim()
        } while (input.isBlank())
        return input
    }

    // -------------------------------GROUP AUTHORS DAFE EDESIRI OTUDJE,ADAM ALI AND DANIEL ADEYEMI --------------------------------------
    fun run(){
        println("Welcome to the Computer Reservation System!")

        println("If you have an account, login or signup to create one.")
        println("1. Login")
        println("2. SignUp")
        val option= readln().toInt()
        val user : User?= when(option){
            1->login()
            2->signUp()
           else -> {
               println("Invalid option! Please select 1 or 2.")
               return
           }
       }
        if(user != null){
            // This is where the logic to make the system aware of the type of user is
            // Using the isAdmin value in the user class
            // isAdmin was Added because we are now handling the Menu outside of The User and Admin Class so we had to think of a way to make the system aware of the type of user.
            if(user.isAdmin){
                AdminMenu(user as Admin)
            }else{
                Usermenu(user)
            }
        }


        println("Existing the program...")


    }



}