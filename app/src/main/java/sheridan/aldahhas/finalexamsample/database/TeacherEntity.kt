package sheridan.aldahhas.finalexamsample.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import sheridan.aldahhas.finalexamsample.domain.TeacherStatus

@Entity(tableName = "teachers")
data class TeacherEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val firstName: String,

    val lastName: String,
    val teacherStatus: TeacherStatus,
    val certified: Boolean
)