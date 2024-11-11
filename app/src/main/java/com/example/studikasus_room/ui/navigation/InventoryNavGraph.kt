package com.example.studikasus_room.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.studikasus_room.ui.item.ItemDetailsDestination
import com.example.studikasus_room.ui.item.ItemDetailsScreen
import com.example.studikasus_room.ui.item.ItemEditDestination
import com.example.studikasus_room.ui.item.ItemEditScreen
import com.example.studikasus_room.ui.item.ItemEntryDestination
import com.example.studikasus_room.ui.item.ItemEntryScreen
import com.example.studikasus_room.ui.home.HomeDestination
import com.example.studikasus_room.ui.home.HomeScreen

/*
 InventoryNavGraph khususnya pada fungsi InventoryNavHost berfungsi untuk mendefinisikan navigasi
 untuk seluruh tampilan halaman yang ada pada aplikasi ini. Fungsi InventoryNavHost menggunakan NavHost
 untuk mengatur alur navigasi aplikasi dengan berbagai rute yang mengarah pada seluruh halaman aplikasi
 seperti HomeScreen, ItemEntryScreen, ItemDetailsScreen, dan ItemEditScreen
 */

@Composable
fun InventoryNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(ItemEntryDestination.route) },
                navigateToItemUpdate = {
                    navController.navigate("${ItemDetailsDestination.route}/${it}")
                }
            )
        }
        composable(route = ItemEntryDestination.route) {
            ItemEntryScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = ItemDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemDetailsDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemDetailsScreen(
                navigateToEditItem = { navController.navigate("${ItemEditDestination.route}/$it") },
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(
            route = ItemEditDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemEditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemEditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}