package com.garden.menagarden.ui.landing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.garden.menagarden.ui.menu.BackgroundDark
import com.garden.menagarden.ui.menu.PrimaryColor
import com.garden.menagarden.ui.menu.TextColor
import com.garden.menagarden.ui.menu.TextColorSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OurHistoryScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Nuestra Historia", color = TextColor) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = TextColor
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundDark.copy(alpha = 0.8f)
                )
            )
        },
        containerColor = BackgroundDark
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Mena Garden: Historia y Tradición en el Corazón de Nerja",
                color = PrimaryColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Mena Garden no es solo un restaurante, es un lugar con una profunda historia arraigada en la tradición de Nerja.",
                color = TextColor,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Nuestro establecimiento se levanta sobre las bases del legendario Hostal Mena (o Pensión Mena), un referente turístico que fue pionero en la comarca con más de 50 años de actividad. El hostal ocupó un edificio que data del siglo XVIII (1700), una joya arquitectónica de esencia andaluza.",
                color = TextColorSecondary,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "El elemento más distintivo, que hoy da nombre a nuestro local, era su extraordinario entorno: más de 1.000 m² de exóticos jardines que se asomaban al acantilado, ofreciendo un oasis de paz en el centro del pueblo.",
                color = TextColorSecondary,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Hoy, hemos transformado esta rica herencia en un espacio moderno, conservando la autenticidad y el espíritu andaluz, y manteniendo vivo ese jardín tranquilo.",
                color = TextColorSecondary,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Al visitarnos, no solo disfrutarás de la mejor gastronomía en la Calle El Barrio, sino que te conectarás con una parte esencial y con solera de la historia turística de Nerja.",
                color = TextColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Justify
            )
        }
    }
}
