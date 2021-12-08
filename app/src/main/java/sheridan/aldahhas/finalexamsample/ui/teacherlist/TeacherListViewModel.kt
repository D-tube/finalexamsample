package sheridan.aldahhas.finalexamsample.ui.teacherlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sheridan.aldahhas.finalexamsample.domain.Teacher
import sheridan.aldahhas.finalexamsample.repositories.TeacherRepository
import javax.inject.Inject

@HiltViewModel
class TeacherListViewModel @Inject constructor(
    private val repository: TeacherRepository
) : ViewModel() {

    companion object{
        private const val TAG = "TeacherListViewModel"
    }

    init{
        Log.d(TAG, "init: the TeacherListViewModel object is created")
    }

    enum class State{INITIALIZING, DONE}
    var instanceState: State = State.INITIALIZING

    var teacherList: LiveData<List<Teacher>> = repository.getAll()

    fun insertTeacher(teacher: Teacher)=
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(teacher)
        }

}