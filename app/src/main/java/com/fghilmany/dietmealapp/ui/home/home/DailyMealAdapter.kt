package com.fghilmany.dietmealapp.ui.home.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fghilmany.dietmealapp.R
import com.fghilmany.dietmealapp.databinding.ItemDailyMealsBinding

class DailyMealAdapter: RecyclerView.Adapter<DailyMealAdapter.ViewHolder>() {

    private val listDailyMeal = ArrayList<DailyMeal>()

    init {
        listDailyMeal.addAll(dailyMeal())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_daily_meals, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = listDailyMeal[position]
        holder.bind(result)
    }

    override fun getItemCount(): Int = listDailyMeal.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemDailyMealsBinding.bind(view)
        @SuppressLint("SetTextI18n")
        fun bind(result: DailyMeal) {
            with(binding){
                result.apply {
                    tvNameMealSchedule.text = name
                    tvTime.text = "($time)"
                    tvTotalCalories.text = totalCalories.toString()
                    tvTotalCarbs.text = totalCarbs.toString()
                    tvTotalFat.text = totalFat.toString()
                    tvTotalProtein.text = totalProtein.toString()
                }
            }
        }

    }
}