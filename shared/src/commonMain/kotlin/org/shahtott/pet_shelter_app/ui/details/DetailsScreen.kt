package org.shahtott.pet_shelter_app.ui.details

import BodyTextColor
import ButtonStartColor
import ButtonTextColor
import CardPinkTopColor
import ChipCreamColor
import ChipCreamTextColor
import ChipLavenderColor
import ChipLavenderTextColor
import ChipPinkColor
import ChipPinkTextColor
import GlassColor
import MutedTextColor
import ScreenColor
import TitleColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.shahtott.pet_shelter_app.ui.details.components.PageIndicator
import org.shahtott.pet_shelter_app.ui.home.components.FavoriteIcon
import petshelterapp.shared.generated.resources.Res
import petshelterapp.shared.generated.resources.animal1
import petshelterapp.shared.generated.resources.ic_back
import petshelterapp.shared.generated.resources.ic_cat

data class Pet(
    val name: String,
    val tags: List<PetTag>,
    val description: String,
    val updateDate: String,
    val photo: DrawableResource,
    val thumbnail: DrawableResource,
    val thumbnailLabel: String,
)

data class PetTag(
    val text: String,
    val background: Color,
    val foreground: Color,
)

@Composable
fun PetCardScreen(
    pet: Pet,
    modifier: Modifier = Modifier,
    isFavorite: Boolean = true,
    onBackClick: () -> Unit = {},
    onFavoriteClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(ScreenColor)
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        Spacer(Modifier.height(8.dp))

        PetPhotoCard(
            photo = pet.photo,
            thumbnail = pet.thumbnail,
            thumbnailLabel = pet.thumbnailLabel,
            isFavorite = isFavorite,
            onBackClick = onBackClick,
            onFavoriteClick = onFavoriteClick,
        )

        Text(
            text = pet.name,
            color = TitleColor,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
        )

        TagsRow(tags = pet.tags)

        Text(
            text = pet.description,
            color = BodyTextColor,
            fontSize = 20.sp,
            lineHeight = 28.sp,
        )

        Text(
            text = "Update date: ${pet.updateDate}",
            color = MutedTextColor,
            fontSize = 14.sp,
        )

        Spacer(Modifier.height(4.dp))

        SignUpButton(onClick = onSignUpClick)

        Spacer(Modifier.height(16.dp))
    }
}

@Composable
private fun PetPhotoCard(
    photo: DrawableResource,
    thumbnail: DrawableResource,
    thumbnailLabel: String,
    isFavorite: Boolean,
    onBackClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(0.86f)
            .clip(RoundedCornerShape(32.dp))
            .background(CardPinkTopColor),
    ) {
        Image(
            painter = painterResource(photo),
            contentDescription = "Pet photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_back),
                contentDescription = "Back",
                modifier = Modifier.size(35.dp),
            )

            FavoriteIcon()
        }

        ThumbnailLabel(
            thumbnail = thumbnail,
            label = thumbnailLabel,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp),
        )

        PageIndicator(
            count = 3,
            selectedIndex = 0,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp),
        )
    }
}

@Composable
private fun ThumbnailLabel(
    thumbnail: DrawableResource,
    label: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(GlassColor)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Image(
            painter = painterResource(thumbnail),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(45.dp)
                .clip(RoundedCornerShape(12.dp)),
        )
        Text(
            text = label,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 22.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(end = 8.dp),
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun TagsRow(
    tags: List<PetTag>,
    modifier: Modifier = Modifier,
) {
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        tags.forEach { TagChip(it) }
    }
}

@Composable
private fun TagChip(tag: PetTag) {
    Surface(
        shape = RoundedCornerShape(percent = 50),
        color = tag.background,
        contentColor = tag.foreground,
    ) {
        Text(
            text = tag.text,
            fontSize = 17.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 18.dp, vertical = 12.dp),
        )
    }
}

@Composable
private fun SignUpButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp),
        shape = RoundedCornerShape(32.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(ButtonStartColor),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "Sign up for an acquaintance",
                style = TextStyle(
                    color = ButtonTextColor,
                    fontSize = 18.sp
                )
            )
        }
    }
}

@Preview
@Composable
private fun PetCardScreenPreview() {
    PetCardScreen(
        pet = Pet(
            name = "Lucky",
            tags = listOf(
                PetTag("Cat", ChipPinkColor, ChipPinkTextColor),
                PetTag("Male", ChipLavenderColor, ChipLavenderTextColor),
                PetTag("2 years", ChipCreamColor, ChipCreamTextColor),
            ),
            description = "Lucky is a playful and affectionate cat looking for a " +
                    "warm home. He loves naps in the sun and gets along well with kids.",
            updateDate = "12 May 2026",
            photo = Res.drawable.animal1,
            thumbnail = Res.drawable.ic_cat,
            thumbnailLabel = "Meet Lucky in person",
        ),
    )
}
