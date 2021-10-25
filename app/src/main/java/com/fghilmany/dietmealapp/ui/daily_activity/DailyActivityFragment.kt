package com.fghilmany.dietmealapp.ui.daily_activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.fghilmany.dietmealapp.R
import com.fghilmany.dietmealapp.databinding.FragmentDailyActivityBinding

class DailyActivityFragment : Fragment() {

    private var _binding: FragmentDailyActivityBinding? = null
    private val binding get() = _binding!!

    private var identityPosition: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDailyActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){

            rgActivity.setOnCheckedChangeListener { _, position ->
                identityPosition = position
            }

            btFinish.setOnClickListener {

                if (identityPosition == null){
                    Toast.makeText(requireContext(), "Kamu belum memilih", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val toIdentity = DailyActivityFragmentDirections.actionDailyActivityFragmentToHomeActivity()
                view.findNavController().navigate(R.id.action_dailyActivityFragment_to_homeActivity)
            }
        }
    }


}