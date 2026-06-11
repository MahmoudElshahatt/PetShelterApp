package org.shahtott.pet_shelter_app.ui.home.components

import AccentColor
import TextPrimaryColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.shahtott.pet_shelter_app.theme.rounded100
import petshelterapp.shared.generated.resources.Res
import petshelterapp.shared.generated.resources.ic_all

@Composable
fun CategoriesSection() {
    val categories = remember {
        mutableStateListOf("All", "Cat", "Dog")
    }
    var selectedIndex by remember { mutableStateOf(0) }

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        itemsIndexed(categories) { index, item ->
            CategoryItem(
                item,
                isSelected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                }
            )
        }
    }
}

@Composable
fun CategoryItem(item: String, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor by animateColorAsState(
        if (isSelected) AccentColor else Color.White
    )
    val borderColor by animateColorAsState(
        if (isSelected) AccentColor else Color.Black.copy(alpha = 0.08f)
    )
    val textColor by animateColorAsState(
        if (isSelected) Color.White else TextPrimaryColor
    )
    Row(
        modifier = Modifier.height(52.dp)
            .background(
                color = backgroundColor,
                shape = rounded100
            )
            .border(1.dp, color = borderColor, shape = rounded100)
            .clip(rounded100)
            .padding(horizontal = 10.dp)
            .padding(end = 14.dp)
            .clickable {
                onClick()
            },
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.clip(CircleShape)
                .size(34.dp),
            painter = painterResource(Res.drawable.ic_all),
            contentDescription = "all"
        )

        Text(
            text = item,
            style = TextStyle(fontSize = 16.sp, color = textColor)
        )
    }
}

@Preview
@Composable
fun PreviewCategoriesSection() {
    CategoriesSection()
}