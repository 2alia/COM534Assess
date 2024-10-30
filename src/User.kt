open class User(val username:String, var password:String, var isAdmin:Boolean = false, var contactDetails: String = ""){

     open fun Menu() {
        println("hello")
     }
 }

val users = mutableListOf<User>()

fun signUp():User{
    var username: String
    var password:String
    var choice:String
    var contactDetails: String

    do {
        println("1 SignUp as Admin:")
        println("2 SignUp as Regular User:")
        choice = readLine().orEmpty()
    } while (choice.isBlank())

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

    val newUser:User
    if (choice.toInt()==1){

        newUser = Admin(username, password, isAdmin = true, contactDetails= contactDetails)
    }else{
        newUser = User(username, password, isAdmin = false, contactDetails= contactDetails)
    }


    users.add(newUser)
    println("User $username has successfully signed up!")
    return newUser

}

