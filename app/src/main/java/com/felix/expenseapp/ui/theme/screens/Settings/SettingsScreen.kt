package com.felix.expenseapp.ui.theme.screens.Settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.felix.expenseapp.ui.theme.screens.splash.SplashScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onLogoutClick: () -> Unit,
    onProfileClick: () -> Unit,
    onCurrencyClick: () -> Unit,
    onThemeToggle: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Settings") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Account", style = MaterialTheme.typography.titleMedium)

            ListItem(
                headlineContent = { Text("Edit Profile") },
                supportingContent = { Text("Update your name, email, and password") },
                modifier = Modifier.clickable { onProfileClick() }
            )

            Divider()

            Text("Preferences", style = MaterialTheme.typography.titleMedium)

            ListItem(
                headlineContent = { Text("Currency") },
                supportingContent = { Text("Choose your default currency") },
                modifier = Modifier.clickable { onCurrencyClick() }
            )

            ListItem(
                headlineContent = { Text("Dark Mode") },
                supportingContent = { Text("Toggle light/dark theme") },
                modifier = Modifier.clickable { onThemeToggle() }
            )

            Divider()

            Button(
                onClick = onLogoutClick,
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Logout")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(
        onLogoutClick = {},
        onProfileClick = {},
        onCurrencyClick = {},
        onThemeToggle = {}
    )
}

