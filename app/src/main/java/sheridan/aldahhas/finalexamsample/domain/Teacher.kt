package sheridan.aldahhas.finalexamsample.domain

import com.google.firebase.database.IgnoreExtraProperties
@IgnoreExtraProperties

data class Teacher (
    var id: String?,
    var firstName: String,
    var lastName: String,
    var teacherStatus: TeacherStatus,
    var certification: Boolean
)