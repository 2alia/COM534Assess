
//--------INDIVIDUAL AUTHOR DANIEL ADEYEMI---------------------
class Booking (
    private val userId: String,
    private val globalComputerId: String,
    private val day: String,
    private val timeslot: String,
    private val room:String
) {
    fun getUserId() = userId
    fun getGlobalComputers() =globalComputerId
    fun getDay() = day
    fun getTimeslot() = timeslot
    fun getRoom()=room

    override fun toString(): String {
        return "Booking(userId= '$userId', globalComputerId='$globalComputerId', day'$day',timeslot'$timeslot')"
    }

}