package com.garden.menagarden.ui.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.garden.menagarden.ui.theme.MenaGardenTheme

val primaryColor = Color(0xFF38e07b)
val backgroundDark = Color(0xFF122017)

@Composable
fun LandingScreen(navController: NavController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = rememberAsyncImagePainter("https://lh3.googleusercontent.com/aida-public/AB6AXuCCAMw6KvNZjiKvjFnMiwTHCX0mFQ8L6myijWpyhlZufrd2dNJl6c8ZE-fH0S_Q_uoRAS31Egl5HArvRI4jov9UEA6RXY3Ms6BFbhk0pfwu5pA8jupYJPt7O1AxgHGpvGgnxXDdTYXL1w0pwA_yTL7F_VxFqQ59dWe26Oe_GKimY6LfPQfymZBbBtBhc0GpeIuKHo_SSuyJkToHhQqzXwq5Eo7y5Hdnnh6lHX1PpmZ6NxbZJDZ4-WEH1op17wWMjvfiIZUFKrxD9JM"),
            contentDescription = "A beautiful and lush garden patio at Mena Garden Nerja, with elegant seating and warm lighting.",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.8f
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter("https://lh3.googleusercontent.com/aida-public/AB6AXuBzCGrySAe-qQMtd38ezCH-yS1YvPJmzFxqWikhoyovox6l1blGnO_Ix61cEZMQhnPOc9_1yJGZNK6Uy4vMVYyeRxrgUU-3zXXbshot386xd2wz3ebTaQBKm0xJBRu05k5r-s4l1kSBCv0TwY-NsT14A066K3En4RVyOYqoJaFBWjKUD6_69RT-yXPZUyXnl3dA6KyFv-j5Wz46ZasjtKgl5mO9wfQ7OCZVln1YOFbTN9L6xoyKZDMHnQVBnZPuvxbv8LtD_7emeIA"),
                contentDescription = "Mena Garden Nerja Logo",
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Bienvenido a",
                color = Color.White,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Mena Garden Nerja",
                color = Color.White,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Nuestra Historia",
                    color = backgroundDark,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("menu") },
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Carta de Comidas",
                    color = backgroundDark,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Carta de Bebidas",
                    color = backgroundDark,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Contacto y Localización",
                    color = backgroundDark,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LandingScreenPreview() {
    MenaGardenTheme {
        LandingScreen(navController = rememberNavController())
    }
}
