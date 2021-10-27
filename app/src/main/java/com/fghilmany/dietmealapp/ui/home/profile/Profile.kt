package com.fghilmany.dietmealapp.ui.home.profile


data class Profile(
    val id: Int,
    val name: String,
    val gender: String,
    val weight: Int,
    val height: Int
)

fun listProfile(): ArrayList<Profile>{
    val listProfile = arrayListOf<Profile>()
    listProfile.add(Profile(0, "Faris", "male", 55, 168 ))
    listProfile.add(Profile(0, "aris", "female", 58, 152 ))
    listProfile.add(Profile(0, "Ghilmany", "male", 63, 180 ))
    listProfile.add(Profile(0, "Hilman", "female", 51, 170 ))
    listProfile.add(Profile(0, "Faris", "male", 55, 168 ))
    listProfile.add(Profile(0, "aris", "female", 58, 152 ))
    listProfile.add(Profile(0, "Ghilmany", "male", 63, 180 ))
    listProfile.add(Profile(0, "Hilman", "female", 51, 170 ))
    listProfile.add(Profile(0, "Faris", "male", 55, 168 ))
    listProfile.add(Profile(0, "aris", "female", 58, 152 ))
    listProfile.add(Profile(0, "Ghilmany", "male", 63, 180 ))
    listProfile.add(Profile(0, "Hilman", "female", 51, 170 ))
    return listProfile
}