// -------------------------------GROUP AUTHORS DAFE EDESIRI OTUDJE,ADAM ALI AND DANIEL ADEYEMI --------------------------------------
// we created a simulation of a database where we keep all the data relating to the System
    val rooms = mutableListOf<Room>()
    val bookings = mutableListOf<Booking>()
    // NOTE: these data present here is for testing purposes
    val users = mutableListOf<User>(
        User("John", "Doe",contactDetails= "1", isAdmin = false),
        Admin("Nick", "admin1",contactDetails= "2")
    )

