package com.jefisu.navigation

sealed class Screen (val route: String) {
    object MainScreen : Screen(route = "main")
    object SecondScreen: Screen(route = "second")

    fun withArgs (vararg args: String) : String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
