package com.fghilmany.dietmealapp.ui.home.home

data class DailyMeal(
    val id: Int,
    val name: String,
    val time: String,
    val totalCalories: Double,
    val totalCarbs: Double,
    val totalFat: Double,
    val totalProtein: Double
)

fun dailyMeal(): ArrayList<DailyMeal>{
    val listDailyMeal = arrayListOf<DailyMeal>()
    listDailyMeal.add(DailyMeal(0, "Breakfast", "07.00", 450.0, 12.0, 24.0, 14.0))
    listDailyMeal.add(DailyMeal(0, "Lunch", "12.00", 450.0, 12.0, 24.0, 14.0))
    listDailyMeal.add(DailyMeal(0, "Dinner", "19.00", 450.0, 12.0, 24.0, 14.0))
    listDailyMeal.add(DailyMeal(0, "Morning Snack", "10.00", 450.0, 12.0, 24.0, 14.0))
    listDailyMeal.add(DailyMeal(0, "Afternoon Snack", "16.00", 450.0, 12.0, 24.0, 14.0))
    return listDailyMeal
}