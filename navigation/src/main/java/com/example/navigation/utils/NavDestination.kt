package com.example.navigation.utils

import androidx.navigation.NavBackStackEntry

interface NavDestination<Arg> {
    fun destination(arg: Arg): String
    fun objectParser(entry: NavBackStackEntry): Arg
}

typealias DestinationRoute = String
