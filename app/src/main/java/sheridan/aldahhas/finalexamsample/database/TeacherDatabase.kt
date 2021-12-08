package sheridan.aldahhas.finalexamsample.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [TeacherEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class TeacherDatabase : RoomDatabase(){

    abstract fun teacherDao(): TeacherDao
}