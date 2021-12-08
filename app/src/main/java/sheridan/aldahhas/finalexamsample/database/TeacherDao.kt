package sheridan.aldahhas.finalexamsample.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TeacherDao {

    @Query("SELECT * FROM teachers")
    fun getAll(): LiveData<List<TeacherEntity>>

    @Insert
    suspend fun insert(teacher : TeacherEntity): Long
}