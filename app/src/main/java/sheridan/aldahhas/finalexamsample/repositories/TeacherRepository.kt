package sheridan.aldahhas.finalexamsample.repositories

import androidx.lifecycle.LiveData
import sheridan.aldahhas.finalexamsample.domain.Teacher


interface TeacherRepository {
    fun getAll(): LiveData<List<Teacher>>
    suspend fun insert(teacher: Teacher): Long
}