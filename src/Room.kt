//--------INDIVIDUAL AUTHOR DAFE EDESIRI OTUDJE----------------------
class Room (
    val roomNumber: String,
    val building: String,
    var osType: String,
    // During Integration, I changed the computers from an Int to a MutableList of Int to align with Group member A booking logic
    // The Admin can Still Specify the number of computers in a room but now the number inputed by the admin becomes the computer MutableList Limit
    val computers: MutableList<Int>,
    val timeSlots:MutableList<String>
) {

    override fun toString(): String {
        return "Room(roomNumber='$roomNumber', buildings= '$building', osType= '$osType', computers= $computers)"
    }
}