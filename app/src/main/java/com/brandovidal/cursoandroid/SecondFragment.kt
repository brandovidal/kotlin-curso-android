package com.brandovidal.cursoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf


class SecondFragment : Fragment(R.layout.fragment_second) {

    private var name: String? =""
    private var age: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        name = requireArguments().getString(MY_NAME)
        age = requireArguments().getInt(MY_AGE)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val input = view.findViewById<TextView>(R.id.txt_output)
        input.text = "$name $age"
    }

    companion object {
        private const val MY_NAME = "nombre"
        private const val MY_AGE = "25"

        fun newInstance(name: String, age: Int) = SecondFragment().apply {
            arguments = bundleOf(MY_NAME to name, MY_AGE to age)
        }
    }
}