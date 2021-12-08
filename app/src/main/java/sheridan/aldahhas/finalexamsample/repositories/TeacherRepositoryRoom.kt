package sheridan.aldahhas.finalexamsample.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import sheridan.aldahhas.finalexamsample.database.TeacherDao
import sheridan.aldahhas.finalexamsample.database.TeacherEntity
import sheridan.aldahhas.finalexamsample.domain.Teacher

import javax.inject.Inject

class TeacherRepositoryRoom @Inject constructor(private val teacherDao : TeacherDao)
    : TeacherRepository {

    companion object {
        private const val TAG = "TeacherRepositoryRoom"
    }

    init {
        Log.d(TAG, "init: the TeacherRepositoryRoom object is created")
    }

    override fun getAll(): LiveData<List<Teacher>> {
        return teacherDao.getAll().map { list -> list.map { it.asTeacher()} }
    }

    override suspend fun insert(teacher: Teacher): Long {
        return teacherDao.insert(teacher.asEntity())
    }
}
fun TeacherEntity.asTeacher(): Teacher {
    return Teacher(
        id = id.toString(),
        firstName = firstName,
        lastName = lastName,
        teacherStatus = teacherStatus,
        certification = certified,
    )
}

fun Teacher.asEntity(): TeacherEntity {
    return TeacherEntity(
        id = id?.toLong() ?: 0L,
        firstName = firstName,
        lastName = lastName,
        teacherStatus = teacherStatus,
        certified = certification,
    )
}