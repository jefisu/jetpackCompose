package com.jefisu.examplebottomnavigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun InitialScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Initial Screen",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SecondScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Second Screen",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ThirdScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Third Screen",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    }
}