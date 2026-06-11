package org.shahtott.pet_shelter_app.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.shahtott.pet_shelter_app.ui.home.components.CategoriesSection
import org.shahtott.pet_shelter_app.ui.home.components.HeaderSection
import org.shahtott.pet_shelter_app.ui.home.components.PetsSection

@Composable
fun HomeScreen(

) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .statusBarsPadding()
            .padding(horizontal = 16.dp)
    ) {
        HeaderSection()
        Spacer(Modifier.height(16.dp))
        CategoriesSection()
        Spacer(Modifier.height(16.dp))
        PetsSection()
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}



