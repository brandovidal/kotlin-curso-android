package com.brandovidal.cursoandroid

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class SecondFragment : Fragment(R.layout.fragment_second) {

    private var name: String? =""
    private var age: Int? = 0
    private val args: SecondFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use Args
        name = args.name
        age = args.age
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val input = view.findViewById<TextView>(R.id.txt_output)
        input.text = "$name $age"

        val button = view.findViewById<TextView>(R.id.btn_send_data)

        button.setOnClickListener {
            val result = "Resultado"
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(Uri.parse("cursoandroid://card"))
        }
    }

    companion object {
        private const val MY_NAME = "name"
        private const val MY_AGE = "age"

        fun newInstance(name: String, age: Int) = SecondFragment().apply {
            arguments = bundleOf(MY_NAME to name, MY_AGE to age)
        }
    }
}