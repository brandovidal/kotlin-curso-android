package com.brandovidal.cursoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer

class SecondFragment : Fragment(R.layout.fragment_second) {
    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val input = view.findViewById<TextView>(R.id.txt_output)
        viewModel.getUser().observe(viewLifecycleOwner, Observer { user ->
            input.text = "${user.name} ${user.age}"
        })
    }

}