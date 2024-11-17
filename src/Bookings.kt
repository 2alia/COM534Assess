data class Bookings (val bookingId:String,val bookingDay:String,val bookingTimeSlot:String,val room:String,var osType:String, val computer: Int,)

/// REMEMBER THE TIME SLOTS ARE FROM 09:00-11:00, 11:00-13:00, 13:00-15:00, 15:00-17:00


val bookingsDummyData= mutableListOf<Bookings>(
    Bookings(bookingId = "1", bookingDay = "Monday", bookingTimeSlot = "09:00am",  room ="JM606", osType = "Ios", computer = 4 ),
    Bookings(bookingId = "2", bookingDay = "Monday", bookingTimeSlot = "11:00am",  room ="JM606", osType = "Windows", computer = 10 ),
    Bookings(bookingId = "3", bookingDay = "Monday", bookingTimeSlot = "13:00am",  room ="JM606", osType = "Linux", computer = 11 ),
    Bookings(bookingId = "4", bookingDay = "Monday", bookingTimeSlot = "15:00am",  room ="JM606", osType = "Windows", computer = 12 )
)