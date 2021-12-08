package sheridan.aldahhas.finalexamsample.ui.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import sheridan.aldahhas.finalexamsample.R
import sheridan.aldahhas.finalexamsample.domain.TeacherStatus

@BindingAdapter("employmentStatus")
fun bindEmploymentStatus(textView: TextView, status: TeacherStatus?){
    if(status is TeacherStatus){
        val status = textView.resources.getStringArray(R.array.status_text)
        textView.text = status[1]
    }
}