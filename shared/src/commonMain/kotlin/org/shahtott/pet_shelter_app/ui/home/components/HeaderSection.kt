package org.shahtott.pet_shelter_app.ui.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import petshelterapp.shared.generated.resources.Res
import petshelterapp.shared.generated.resources.ic_notification_bill
import petshelterapp.shared.generated.resources.ic_takee_app_icon

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .statusBarsPadding()
            .padding(top = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_takee_app_icon),
            contentDescription = "logo"
        )
        Icon(
            painter = painterResource(Res.drawable.ic_notification_bill),
            contentDescription = "logo",
            tint = Color.Unspecified
        )
    }
}