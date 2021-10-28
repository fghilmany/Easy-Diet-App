package com.fghilmany.dietmealapp.ui.home.meal

data class Meal(
    val id: Int,
    val name: String,
    val totalCalories: Double,
    val totalCarbs: Double,
    val totalFat: Double,
    val totalProtein: Double
)

fun listMeal(): ArrayList<Meal>{
    val listMeal = arrayListOf<Meal>()
    listMeal.add(Meal(0, "Sangu Koneng", 450.0, 12.0, 24.0, 14.0))
    listMeal.add(Meal(0, "Nasi Uduk", 450.0, 12.0, 24.0, 14.0))
    listMeal.add(Meal(0, "Cilok", 450.0, 12.0, 24.0, 14.0))
    listMeal.add(Meal(0, "Kopi",450.0, 12.0, 24.0, 14.0))
    listMeal.add(Meal(0, "Pop Ice",  450.0, 12.0, 24.0, 14.0))
    listMeal.add(Meal(0, "Espresso",  450.0, 12.0, 24.0, 14.0))
    listMeal.add(Meal(0, "V60",  450.0, 12.0, 24.0, 14.0))
    listMeal.add(Meal(0, "Aeropresso",  450.0, 12.0, 24.0, 14.0))
    listMeal.add(Meal(0, "Toast",  450.0, 12.0, 24.0, 14.0))
    listMeal.add(Meal(0, "Kentang",  450.0, 12.0, 24.0, 14.0))
    listMeal.add(Meal(0, "Keju",  450.0, 12.0, 24.0, 14.0))
    return listMeal
}