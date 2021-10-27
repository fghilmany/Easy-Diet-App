package com.fghilmany.dietmealapp.ui.identity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.fghilmany.dietmealapp.R
import com.fghilmany.dietmealapp.databinding.FragmentIdentityBinding

class IdentityFragment : Fragment() {

    private var _binding : FragmentIdentityBinding? = null
    private val binding get() = _binding!!

    private var genderPosition: Int? = null


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

            rgGender.setOnCheckedChangeListener { _, position ->
                genderPosition = position
            }

            btNext.setOnClickListener {

                if (etName.text.isNullOrBlank()){
                    etName.error = resources.getString(R.string.dont_be_empty)
                    etName.requestFocus()
                    return@setOnClickListener
                }

                if (etHeight.text.isNullOrBlank()){
                    etHeight.error = resources.getString(R.string.dont_be_empty)
                    etHeight.requestFocus()
                    return@setOnClickListener
                }

                if (etWeight.text.isNullOrBlank()){
                    etWeight.error = resources.getString(R.string.dont_be_empty)
                    etWeight.requestFocus()
                    return@setOnClickListener
                }

                if (genderPosition == null){
                    rgGender.requestFocus()
                    Toast.makeText(requireContext(), resources.getString(R.string.you_havent_chosen), Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val toDailyActivity = IdentityFragmentDirections.actionIdentityFragmentToDailyActivityFragment()
                view.findNavController().navigate(toDailyActivity)
            }

        }
    }


}