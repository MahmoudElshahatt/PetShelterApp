package org.shahtott.pet_shelter_app.ui.splash

import AccentColor
import ButtonTextColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.shahtott.pet_shelter_app.theme.rounded100
import petshelterapp.shared.generated.resources.Res
import petshelterapp.shared.generated.resources.ic_takee_app_icon
import petshelterapp.shared.generated.resources.splash_bg

@Composable
@Preview
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(Res.drawable.splash_bg),
            contentDescription = "background"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 38.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_takee_app_icon),
                    contentDescription = "logo"
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 28.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Happiness is closer than you think",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 36.sp,
                    color = Color.White
                )

                Spacer(Modifier.height(35.dp))

                Button(
                    modifier = Modifier.fillMaxWidth()
                        .height(58.dp)
                        .padding(horizontal = 16.dp),
                    contentPadding = PaddingValues(18.dp),
                    onClick = {},
                    shape = rounded100,
                    colors = ButtonDefaults.buttonColors(containerColor = AccentColor)
                ) {
                    Text(
                        "Let’s Go!",
                        style = TextStyle(
                            color = ButtonTextColor,
                            fontSize = 18.sp
                        )
                    )
                }
            }
        }
    }
}