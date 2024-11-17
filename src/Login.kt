class Login() {

    fun login() {

        var username: String
        var password: String
        // Asking the user for their username until they provide one
        do {
            println("Enter your username:")
            username = readln().trim()
        } while (username.isEmpty())

        // Asking the user for their password until they provide one
        do {
            println("Enter your password:")
            password = readln().trim()
        } while (password.isEmpty())

        // Searching for the user by their username using lambda(WEEK 6) and find collection method
        // "users"  is a mutableList of SignedUp  users gotten from User.kt
        val user = users.find { it.username == username }

        // Check if the user exists and the password matches
        if (user != null) {
            if (user.password == password) {
                println("Welcome, $username! You've successfully logged in.")
            } else {
                println("The password you entered is incorrect.")
            }
        } else {
            println("The username '$username' does not exist.")
        }
    }
}



//class Login() {
//
//    fun login() {
//        val userName: String = promptForInput("Enter your username:")
//        val passWord: String = promptForInput("Enter your password:")
//
//        val user = users.find { it.username == userName }
//
//        if (user != null && user.password == passWord) {
//            println("User $userName has logged in!")
//        } else {
//            if (user == null) {
//                println("Username does not exist.")
//            } else {
//                println("Incorrect password.")
//            }
//        }
//    }
//
//    private fun promptForInput(message: String): String {
//        var input: String
//        do {
//            println(message)
//            input = readln().trim()
//        } while (input.isBlank())
//        return input
//    }
//}
