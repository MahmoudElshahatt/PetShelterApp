package org.shahtott.pet_shelter_app.ui.home.components

import TextPrimaryColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.shahtott.pet_shelter_app.theme.rounded16dp
import petshelterapp.shared.generated.resources.Res
import petshelterapp.shared.generated.resources.animal1
import petshelterapp.shared.generated.resources.ic_favorite
import petshelterapp.shared.generated.resources.ic_favourite_filled


@Composable
fun PetsSection() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(20) {
            PetItem()
        }
    }
}

@Composable
fun PetItem() {
    Card(
        shape = rounded16dp,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PetImage()
            PetInfo()
        }
    }
}

@Composable
fun PetImage() {
    Box {
        Image(
            painter = painterResource(Res.drawable.animal1),
            modifier = Modifier.height(116.dp).fillMaxWidth(),
            contentDescription = "animal",
            contentScale = ContentScale.Crop
        )

        FavoriteIcon(
            modifier = Modifier.align(Alignment.TopEnd)
        )
    }
}

@Composable
fun FavoriteIcon(modifier: Modifier = Modifier) {
    var favIcon by remember {
        mutableStateOf(Res.drawable.ic_favorite)
    }
    Icon(
        modifier = modifier
            .size(35.dp)
            .clip(CircleShape)
            .padding(top = 8.dp, end = 7.dp)
            .clickable {
                favIcon = if (favIcon == Res.drawable.ic_favorite)
                    Res.drawable.ic_favourite_filled else
                    Res.drawable.ic_favorite
            },
        painter = painterResource(favIcon),
        contentDescription = "fav",
        tint = Color.Unspecified
    )
}

@Composable
fun PetInfo() {
    Column(
        modifier = Modifier.padding(horizontal = 18.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Gary",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimaryColor
                )
            )
            Text(
                text = "3 Years",
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextPrimaryColor.copy(alpha = 0.70f)
                )
            )
        }
        Text(
            text = "Half-breed",
            style = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = TextPrimaryColor.copy(alpha = 0.70f)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPetsSection() {
    PetsSection()
}