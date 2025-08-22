package com.felix.expenseapp.models

data class User(
    val id: String = "",            // could be Firebase UID or UUID
    val name: String = "",
    val email: String = "",
    val currency: String = "USD",
    val darkMode: Boolean = false
)
