package com.felix.expenseapp.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felix.expenseapp.models.Expense
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ExpenseViewModel : ViewModel() {

    private val _expenses = MutableStateFlow<List<Expense>>(emptyList())
    val expenses: StateFlow<List<Expense>> = _expenses

    private var nextId = 1

    // Add new expense
    fun addExpense(title: String, amount: Double, category: String) {
        viewModelScope.launch {
            val newExpense = Expense(
                id = nextId++,
                title = title,
                amount = amount,
                category = category
            )
            _expenses.value = _expenses.value + newExpense
        }
    }

    // Edit existing expense
    fun editExpense(updated: Expense) {
        viewModelScope.launch {
            _expenses.value = _expenses.value.map {
                if (it.id == updated.id) updated else it
            }
        }
    }

    // Delete expense
    fun deleteExpense(id: Int) {
        viewModelScope.launch {
            _expenses.value = _expenses.value.filter { it.id != id }
        }
    }

    // Get total expenses
    fun getTotal(): Double {
        return _expenses.value.sumOf { it.amount }
    }

    // Filter by category
    fun getExpensesByCategory(category: String): List<Expense> {
        return _expenses.value.filter { it.category == category }
    }
}
