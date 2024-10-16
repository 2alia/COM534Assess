data class User(val username:String, var password:String, var isAdmin:Boolean = false, var contactDetails: String = "")

val users = mutableListOf<User>()

fun signUp(){
    var username: String
    var password:String
    var contactDetails: String

    do {
        println("Enter your username:")
        username = readLine().orEmpty()
    } while (username.isBlank())

    do {
        println("Enter your password:")
        password = readLine().orEmpty()
    } while (password.isBlank())
    do {
        println("Enter your contact details:")
        contactDetails = readLine().orEmpty()
    } while (contactDetails.isBlank())

    val newUser = User(username, password, isAdmin = false, contactDetails= contactDetails)
    users.add(newUser)
    println("User $username has successfully signed up!")

}

