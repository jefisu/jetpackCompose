package com.jefisu.roomcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jefisu.roomcompose.data.dto.Person
import com.jefisu.roomcompose.data.repository.PersonRepository
import com.jefisu.roomcompose.ui.theme.AppTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTestTheme {
                Screen()
            }
        }
    }
}

@Composable
fun Screen(
) {
    val context = LocalContext.current
    val mRepository = PersonRepository(context)

    var name by remember {
        mutableStateOf("")
    }

    var list by remember {
        mutableStateOf(listOf<Person>())
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
    ) {

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Name") },
            shape = RoundedCornerShape(15.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextButton(
            modifier = Modifier.align(Alignment.End),
            onClick = {
                val movie = Person(title = name)
                mRepository.save(movie)
                list = mRepository.load()
                name = ""
            }
        ) {
            Text(
                text = "Save",
                modifier = Modifier.padding(end = 50.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {
            list = mRepository.load()
            items(list) {
                ItemList(item = it)
            }
        }
    }
}


@Composable
fun ItemList(
    item: Person
) {
    Card(
        backgroundColor = MaterialTheme.colors.secondary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 0.dp
    ) {
        Row(modifier = Modifier.padding(vertical = 10.dp, horizontal = 12.dp)) {
            Text(
                text = "${item.id} - ${item.title}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

