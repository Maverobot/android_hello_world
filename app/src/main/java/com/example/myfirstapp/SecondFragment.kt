package com.example.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_compute.setOnClickListener { result.setText( (input_lhs.text.toString().toDouble() +
                input_rhs.text.toString().toDouble()).toString() ) }

        val updateResult = { _: View, hasFocus: Boolean ->
            if (!hasFocus) {
                var lhsText: String = input_lhs.text.toString()
                var rhsText: String = input_rhs.text.toString()
                var lhsHint: String = input_lhs.hint.toString()
                var rhsHint: String = input_rhs.hint.toString()

                var lhs: Double = if (lhsText.isEmpty()) lhsHint.toDouble() else lhsText.toDouble()
                var rhs: Double = if (rhsText.isEmpty()) rhsHint.toDouble() else rhsText.toDouble()
                var sum: Double = lhs + rhs
                result.setText(sum.toString())
            }
        }

        input_lhs.setOnFocusChangeListener(updateResult)
        input_rhs.setOnFocusChangeListener(updateResult)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}
