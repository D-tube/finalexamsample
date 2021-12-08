package sheridan.aldahhas.finalexamsample.ui.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import sheridan.aldahhas.finalexamsample.R

@BindingAdapter("certification")
fun bindCertification(textView: TextView, isCertified: Boolean?) {
    if (isCertified  is Boolean) {
        val context = textView.context
        textView.text =
            if (isCertified) {
                context.getString(R.string.certified)
            } else {
                context.getString(R.string.not_certified)
            }
    }
}