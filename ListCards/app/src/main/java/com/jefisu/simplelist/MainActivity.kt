package com.jefisu.simplelist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jefisu.simplelist.ui.theme.SimpleListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleListTheme {
                ShowList(context = this, services = SampleData.serviceList)
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
}

@Composable
fun ShowList(context: Context,services: List<ServiceModel>) {
    LazyColumn {
        items(services) {
            MyCard(context = context,serv = it)
        }
    }
}

@Composable
fun MyCard(context: Context, serv: ServiceModel) {
    Card(
        shape = RoundedCornerShape(size = 15.dp),
        backgroundColor = MaterialTheme.colors.background,
        elevation = 5.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 4.dp, end = 4.dp, top = 8.dp)
            .clickable {
                Toast
                    .makeText(context, "Welcome ${serv.name}", Toast.LENGTH_SHORT)
                    .show()
            }
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_person),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = Color.White),
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )

                Text(
                    text = serv.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 8.dp)
        ) {
            Text(text = serv.kindService, fontSize = 14.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.width(4.dp))

            Text(text = "-", fontSize = 18.sp)

            Spacer(modifier = Modifier.width(4.dp))

            Text(text = serv.category, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
    }
}
