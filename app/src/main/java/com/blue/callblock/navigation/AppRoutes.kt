package com.blue.callblock.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings

object AppRoutes {
    object Home : Route(name = "route_home", Icons.Filled.Home)
    object Manage : Route(name = "route_manage", Icons.Filled.List)
    object NumberDetails : Route(name = "route_number_details", Icons.Filled.Home)
    object Settings : Route(name = "route_settings", Icons.Filled.Settings)
    object AllowList : Route(name = "route_allow", Icons.Filled.Settings)
    object BlockList : Route(name = "route_block", Icons.Filled.Settings)
    object NeighborList : Route(name = "route_neighbor", Icons.Filled.Settings)
    object AreaCodeList : Route(name = "route_areacode", Icons.Filled.Settings)

    fun asList(): Array<Route> {
        return arrayOf(Home, Settings, Manage, NumberDetails)
    }

    fun asListForTab(): Array<Route> {
        return arrayOf(Home, Manage, Settings)
    }
}