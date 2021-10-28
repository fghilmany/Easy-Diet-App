package com.fghilmany.dietmealapp.ui.home.meal

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.fghilmany.dietmealapp.R
import com.fghilmany.dietmealapp.databinding.ItemMealsBinding
import com.fghilmany.dietmealapp.ui.home.profile.Profile
import java.util.*
import kotlin.collections.ArrayList

class MealAdapter: RecyclerView.Adapter<MealAdapter.ViewHolder>(), Filterable {

    private val listImmutableMeal = ArrayList<Meal>()
    private var listMeal = ArrayList<Meal>()

    init {
        listImmutableMeal.addAll(listMeal())
        listMeal = listImmutableMeal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meals, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = listImmutableMeal[position]
        holder.bind(result)
    }

    override fun getItemCount(): Int = listImmutableMeal.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemMealsBinding.bind(view)
        @SuppressLint("SetTextI18n")
        fun bind(result: Meal) {
            with(binding){
                result.apply {
                    tvMeal.text = name
                    tvMealCalories.text = totalCalories.toString() + " " + itemView.context.resources.getString(R.string.kcal)
                }
            }

            itemView.setOnClickListener {
                val toDetailMeal = MealFragmentDirections.actionNavigationMealToDetailMealFragment()
                it.findNavController().navigate(toDetailMeal)
            }
        }

    }

    override fun getFilter(): Filter =
        object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                listMeal = if (charSearch.isEmpty()){
                    listImmutableMeal
                } else {
                    val result = ArrayList<Meal>()
                    for (i in listImmutableMeal){
                        if (i.name.lowercase(Locale.ROOT).contains(
                                charSearch.lowercase(
                                    Locale.ROOT
                                )
                            )
                        ){
                            result.add(i)
                        }
                    }
                    result
                }
                val filterResult = FilterResults()
                filterResult.values = listMeal
                return filterResult
            }

            override fun publishResults(constraint: CharSequence?, result: FilterResults?) {
                @Suppress("UNCHECKED_CAST")
                listMeal = result?.values as ArrayList<Meal>
                notifyDataSetChanged()
            }
        }
}