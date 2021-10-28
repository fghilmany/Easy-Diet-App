package com.fghilmany.dietmealapp.ui.home.meal.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.fghilmany.dietmealapp.R
import com.fghilmany.dietmealapp.databinding.FragmentDetailMealBinding

class DetailMealFragment : Fragment() {

    private var _binding: FragmentDetailMealBinding? = null
    private val binding get() = _binding!!

    companion object{
        val TAG: String = this::class.java.simpleName
        fun newInstance(): DetailMealFragment {
            val args = Bundle()
            val fragment = DetailMealFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            Glide.with(requireContext())
                .load("https://majalah.ottencoffee.co.id/wp-content/uploads/2016/10/espresso_830x550.jpg")
                .into(ivMeal)
        }

    }

}