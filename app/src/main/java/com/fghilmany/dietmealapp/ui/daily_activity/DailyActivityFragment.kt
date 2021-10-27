package com.fghilmany.dietmealapp.ui.daily_activity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.fghilmany.dietmealapp.R
import com.fghilmany.dietmealapp.databinding.FragmentDailyActivityBinding
import com.fghilmany.dietmealapp.ui.home.HomeActivity

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
                    Toast.makeText(requireContext(), resources.getString(R.string.you_havent_chosen), Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val i = Intent(requireActivity(), HomeActivity::class.java)
                startActivity(i)
                requireActivity().finish()
            }
        }
    }


}