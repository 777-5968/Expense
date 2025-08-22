package com.felix.expenseapp.ui.theme.screens.budget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun ReminderScreen(
    reminders: List<String>,
    onAddReminder: (String) -> Unit,
    onDeleteReminder: (String) -> Unit
) {
    var newReminder by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Reminders") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = newReminder,
                onValueChange = { newReminder = it },
                label = { Text("New Reminder (e.g., 8:00 PM)") }
            )

            Button(
                onClick = {
                    if (newReminder.isNotEmpty()) {
                        onAddReminder(newReminder)
                        newReminder = ""
                    }
                }
            ) { Text("Add Reminder") }

            Divider()

            LazyColumn {
                items(reminders) { reminder ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(reminder)
                        IconButton(onClick = { onDeleteReminder(reminder) }) {
                            Icon(Icons.Default.Delete, contentDescription = "Delete Reminder")
                        }
                    }
                }
            }
        }
    }
}
@Preview
@Composable
fun ReminderScreenPreview() {
    ReminderScreen(rememberNavController()))
}
