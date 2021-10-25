package com.fghilmany.dietmealapp.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.fghilmany.dietmealapp.R
import com.fghilmany.dietmealapp.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.liveData.observe(viewLifecycleOwner){
            when(it){
                is SplashState.InitSplash ->{
                    val splashAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.anim_splash)
                    binding.ivSplash.startAnimation(splashAnimation)
                }
                is SplashState.MainActivity -> {
                    findNavController().navigate(R.id.action_splashFragment_to_identityFragment)
                }
            }
        }
    }


}