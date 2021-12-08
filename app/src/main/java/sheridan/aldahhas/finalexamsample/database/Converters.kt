package sheridan.aldahhas.finalexamsample.database

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun fromLongToDate(value: Long): Date {
        return Date(value)
    }
}