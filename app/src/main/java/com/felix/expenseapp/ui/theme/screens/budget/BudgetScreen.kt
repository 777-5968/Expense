package com.felix.expenseapp.ui.theme.screens.budget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BudgetScreen(
    currentSpent: Double,
    budgetLimit:Double,
    onSetBudget: (Double) -> Unit
) {
    var newBudget by remember { mutableStateOf("") }
    val progress = if (budgetLimit > 0) (currentSpent / budgetLimit).coerceIn(0f, 1f) else 0f

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Budget") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Current Budget: KES $budgetLimit")
            Text("Spent: KES $currentSpent")

            LinearProgressIndicator(
                progress = progress.toFloat(),
                modifier = Modifier.fillMaxWidth()
            )

            if (budgetLimit > 0) {
                Text("Remaining: KES ${budgetLimit - currentSpent}")
            }

            OutlinedTextField(
                value = newBudget,
                onValueChange = { newBudget = it },
                label = { Text("Set New Budget") }
            )

            Button(
                onClick = {
                    if (newBudget.isNotEmpty()) {
                        onSetBudget(newBudget.toDouble())
                        newBudget = ""
                    }
                }
            ) { Text("Save Budget") }
        }
    }
}
@Preview
@Composable
fun BudgetScreenPreview(){
     BudgetScreen (rememberNavController()))
}

