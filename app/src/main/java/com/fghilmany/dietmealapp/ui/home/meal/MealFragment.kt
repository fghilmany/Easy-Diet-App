package com.fghilmany.dietmealapp.ui.home.meal

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fghilmany.dietmealapp.databinding.FragmentMealBinding
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView


class MealFragment : Fragment() {

    private lateinit var mealViewModel: MealViewModel
    private var _binding: FragmentMealBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mealViewModel =
            ViewModelProvider(this).get(MealViewModel::class.java)

        _binding = FragmentMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){

            val mealAdapter = MealAdapter()
            with(rvMeal){
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
                adapter = mealAdapter
                addItemDecoration(
                    DividerItemDecoration(
                        context,
                        DividerItemDecoration.VERTICAL
                    )
                )
            }

            rvMeal.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy > 0 && fabAddMenu.isShown)
                        fabAddMenu.hide()
                    else
                        fabAddMenu.show()
                }

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE)
                        fabAddMenu.isShown

                    super.onScrollStateChanged(recyclerView, newState)
                }
            })

            etSearch.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    mealAdapter.filter.filter(p0)
                }

                override fun afterTextChanged(p0: Editable?) {

                }

            })

            fabAddMenu.setOnClickListener {
                val toAddMeal = MealFragmentDirections.actionNavigationMealToAddMealFragment()
                findNavController().navigate(toAddMeal)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}