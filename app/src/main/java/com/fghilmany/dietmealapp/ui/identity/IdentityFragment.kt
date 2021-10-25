package com.fghilmany.dietmealapp.ui.identity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.fghilmany.dietmealapp.R
import com.fghilmany.dietmealapp.databinding.FragmentIdentityBinding

class IdentityFragment : Fragment() {

    private var _binding : FragmentIdentityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentIdentityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){

            btNext.setOnClickListener {
                val toDailyActivity = IdentityFragmentDirections.actionIdentityFragmentToDailyActivityFragment()
                view.findNavController().navigate(R.id.action_identityFragment_to_dailyActivityFragment)
            }

        }
    }


}