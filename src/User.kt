//--------INDIVIDUAL AUTHOR DANIEL ADEYEMI---------------------
open class User(val username:String,
                val password:String,
                var contactDetails: String,var isAdmin:Boolean){



   open fun bookComputer(userId: String, roomNumber: String, day: String, timeslot: String): String?{
        val room = rooms.find{ it.roomNumber == roomNumber}
        room?.let {
            val availableComputer = it.computers.find { computerId ->
               bookings.none {booking ->
                    booking.getGlobalComputers() == "${roomNumber}-${computerId}" &&
                            booking.getDay() == day &&
                            booking.getTimeslot() == timeslot
                }
            }
            if (availableComputer != null) {
                val globalComputerId = "${roomNumber}-${availableComputer}"
               bookings.add(Booking(userId, globalComputerId, day, timeslot,room.roomNumber))
                return globalComputerId
            }
        }
        return null
    }

   open fun viewUserBookings(userId: String): List<Booking> {
        return bookings.filter { it.getUserId() == userId }
    }


    open fun cancelBooking(userId: String, globalComputerId: String, day: String, timeslot: String): Boolean {
        val booking = bookings.find {
            it.getUserId() == userId &&
                    it.getGlobalComputers() == globalComputerId &&
                    it.getDay() == day &&
                    it.getTimeslot() == timeslot
        }
        return if (booking != null) {
            bookings.remove(booking)
            true
        }else {
            false
        }
    }


    open fun searchRooms(building: String, osType: String): List<Room>{
        return rooms.filter{it.building== building && it.osType == osType}
    }


}

