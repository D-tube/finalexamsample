package sheridan.aldahhas.finalexamsample.ui.teacherlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sheridan.aldahhas.finalexamsample.databinding.TeacherListItemBinding
import sheridan.aldahhas.finalexamsample.domain.Teacher


class TeacherListAdapter():
ListAdapter<Teacher, TeacherListAdapter.ViewHolder>(TeacherDiffCallback()) {

    inner class ViewHolder(
        private val binding: TeacherListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(teacher: Teacher) {
            binding.teacher = teacher
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TeacherListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TeacherDiffCallback : DiffUtil.ItemCallback<Teacher>() {
        override fun areItemsTheSame(oldItem: Teacher, newItem: Teacher): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Teacher, newItem: Teacher): Boolean {
            return oldItem == newItem
        }
    }
}