package sheridan.aldahhas.finalexamsample.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import sheridan.aldahhas.finalexamsample.domain.Teacher
import sheridan.aldahhas.finalexamsample.ui.teacherlist.TeacherListAdapter

@BindingAdapter("teacherList")
fun bindTeacherList(recyclerView: RecyclerView, list: List<Teacher>?){
        val adapter = recyclerView.adapter as TeacherListAdapter
        adapter.submitList(list)
    }

