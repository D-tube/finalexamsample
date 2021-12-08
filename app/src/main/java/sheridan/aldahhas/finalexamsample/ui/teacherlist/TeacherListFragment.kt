package sheridan.aldahhas.finalexamsample.ui.teacherlist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import sheridan.aldahhas.finalexamsample.databinding.TeacherListFragmentBinding
import sheridan.aldahhas.finalexamsample.domain.Teacher
import sheridan.aldahhas.finalexamsample.domain.TeacherStatus


class TeacherListFragment : Fragment() {

    companion object {
        private const val TAG = "TeacherListFragment"
        private const val CONFIRM_CLEAR_ALL = "confirmClearAll"
        private const val CONFIRM_DELETE_ITEM = "confirmDelete"
    }

    private val teacherListViewModel: TeacherListViewModel by viewModels()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = TeacherListFragmentBinding.inflate(inflater, container, false)
        navController = findNavController()

        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.recyclerView.addItemDecoration(divider)
        val adapter = TeacherListAdapter()
        binding.recyclerView.adapter = adapter

        binding.viewModel = teacherListViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        if(teacherListViewModel.instanceState == TeacherListViewModel.State.INITIALIZING){
            teacherListViewModel.insertTeacher(Teacher("3","Shareef","Aldahhan", TeacherStatus.FULL_TIME,true))
            teacherListViewModel.insertTeacher(Teacher("2","Dtube","Ross", TeacherStatus.FULL_TIME,true))
            teacherListViewModel.insertTeacher(Teacher("1","Baraa","Istaty", TeacherStatus.SEASONAL,true))
            teacherListViewModel.instanceState = TeacherListViewModel.State.DONE
        }

        return binding.root
    }
}