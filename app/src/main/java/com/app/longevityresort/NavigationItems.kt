package com.app.longevityresort

sealed class NavigationItems(var route: String, var icon: Int, var title: String) {
    object Home: NavigationItems("home", R.drawable.ic_tab_home,"Home")
    object Roadmap: NavigationItems("roadmap", R.drawable.ic_roadmap,"roadmap")
    object Locations: NavigationItems("locations", R.drawable.ic_marker,"Locations")
    object More: NavigationItems("more", R.drawable.ic_more,"More")
}
