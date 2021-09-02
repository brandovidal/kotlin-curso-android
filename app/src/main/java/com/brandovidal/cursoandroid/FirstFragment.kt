package com.brandovidal.cursoandroid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment(R.layout.fragment_first) {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.btn_navigate)

        button.setOnClickListener {
            viewModel.setUser(User("Brando", 32))
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }


        viewModel.getUser().observe(viewLifecycleOwner, Observer { user ->
            Log.d("user >>", "getUser: ${user.name} ${user.age}")
        })

        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<User>("user")?.observe(viewLifecycleOwner) {
            result -> Log.d("user >>", "onViewCreated: ${result.name} ${result.age}")
        }
    }
}