package com.fghilmany.dietmealapp.ui.home.meal.add_meal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.fghilmany.dietmealapp.R
import com.fghilmany.dietmealapp.databinding.FragmentAddMealBinding


class AddMealFragment : Fragment() {

    private var _binding: FragmentAddMealBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddMealBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){

            with(wvAddMeal){
                with(settings){
                    setSupportZoom(true)
                    builtInZoomControls = true
                    displayZoomControls = false
                }
                scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
                webViewClient = WebViewClient()
                loadUrl("https://fghilmany.com")
            }

        }
    }


}