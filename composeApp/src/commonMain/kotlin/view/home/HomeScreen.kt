package view.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import network.CategoryResponse
import network.MealsSDK
import view.EmptyView
import view.LoadingView

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    mealsSDK: MealsSDK = MealsSDK(),
) {
    var categories by remember { mutableStateOf(listOf<CategoryResponse>()) }
    var isLoading by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isLoading = true
        val newData = withContext(Dispatchers.IO) {
            mealsSDK.getCategories()
        }
        categories = newData
        isLoading = false
    }

    if (isLoading) {
       LoadingView()
    } else if (categories.isNotEmpty()) {
        HomeContent(
            categories = categories,
            modifier = modifier
        )
    } else {
        EmptyView()
    }
}

@Composable
fun HomeContent(
    categories: List<CategoryResponse>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(categories) { data ->
            CategoryRow(
                data
            )
        }

    }
}