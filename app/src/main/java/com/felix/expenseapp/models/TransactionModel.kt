package com.felix.expenseapp.models

data class Transaction(
    val title: String,
    val amount: Double,
    val category: String,
    val date: String
)