package com.example.loginpage

sealed class Screen(var route:String){
    object Home:Screen(route="home_screen")
    object Detail:Screen(route="detail_screen")
}
