package com.brandovidal.cursoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val input = view.findViewById<TextView>(R.id.txt_result)
        val button = view.findViewById<Button>(R.id.btn_navigate)

        setFragmentResultListener("requestKey") { key, bundle ->
            val result = bundle.getString("bundleKey")
            input.text = result
        }

        button.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment("Brando Vidal", 25)
            findNavController().navigate(action)
        }
    }
}