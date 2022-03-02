package com.jefisu.animateitemposition

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalFoundationApi
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var items by remember {
                mutableStateOf((1..10).toList())
            }
            LazyColumn(modifier = Modifier.padding(8.dp)) {
                items(
                    items = items,
                    key = { it }
                ) {
                    ListItem(
                        text = {
                            Text(
                                text = "Item $it",
                                style = MaterialTheme.typography.h5
                            )
                        },
                        modifier = Modifier.animateItemPlacement(
                            animationSpec = spring()
                        )
                    )
                }
                item {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { items = items.shuffled() }
                    ) {
                        Text(text = "Sort randomly")
                    }
                }
            }
        }
    }
}