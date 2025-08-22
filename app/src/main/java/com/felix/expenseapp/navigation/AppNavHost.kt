package com.felix.expenseapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.felix.expenseapp.ui.theme.screens.Settings.SettingsScreen
import com.felix.expenseapp.ui.theme.screens.budget.BudgetScreen
import com.felix.expenseapp.ui.theme.screens.expenses.AddExpenseScreen
import com.felix.expenseapp.ui.theme.screens.home.HomeScreen
import com.felix.expenseapp.ui.theme.screens.login.LoginScreen
import com.felix.expenseapp.ui.theme.screens.register.RegisterScreen
import com.felix.expenseapp.ui.theme.screens.splash.SplashScreen

@Composable
fun  AppNavHost(
    modifier: Modifier=Modifier,
    navController: NavHostController = rememberNavController(),

    startDestination:String=ROUTE_REGISTER
){
   NavHost(
       navController = navController,
       modifier=modifier,
       startDestination = startDestination
   )
   {
       composable(ROUTE_REGISTER){
           RegisterScreen(navController=navController)
       }
       composable(ROUTE_LOGIN){
           LoginScreen(navController=navController)
       }
       composable(ROUTE_HOME){
           HomeScreen(navController=navController)
       }
       composable(ROUTE_SPLASH){
           SplashScreen(navController=navController)
       }
       composable(ROUTE_SETTINGS){
           SettingsScreen(navController=navController)
       }
       composable(ROUTE_BUDGET){
           BudgetScreen(navController=navController)
       }
       composable(ROUTE_EXPENSES){
           AddExpenseScreen(navController=navController)
       }
   }
}

