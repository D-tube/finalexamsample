package sheridan.aldahhas.finalexamsample.ui.about

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import sheridan.aldahhas.finalexamsample.R

class AboutFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder
            .setTitle(R.string.app_name)
            .setMessage(R.string.auther)
            .setPositiveButton(android.R.string.ok, null)
        return builder.create()
    }
}