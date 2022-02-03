package com.nire.studyproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nire.studyproject.ui.theme.StudyProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyProjectTheme {
                Surface(color = MaterialTheme.colors.background) {
                    var scrollState = ScrollState(0)
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .verticalScroll(scrollState)
                    ) {
                        HumanCard()
                        Spacer(modifier = Modifier.height(10.dp))
                        HumanCard()
                        Spacer(modifier = Modifier.height(10.dp))
                        HumanCard()
                        Spacer(modifier = Modifier.height(10.dp))
                        HumanCard()
                    }
                }
            }
        }
    }
}

@Composable
fun HumanCard() {
    Card(
        backgroundColor = Color.Magenta,
        elevation = 15.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column() {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = ""
            )
            val visible = remember {
                mutableStateOf(true)
            }
            if (visible.value) {
                HumanInfo()
            }
            HumanButton(visible)
        }
    }
}

@Composable
fun HumanInfo() {
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {

        HumanInfoItem("First name", "Ivan")
        HumanInfoItem("Last name", "Petrov")

    }
}

@Composable
fun HumanInfoItem(name: String, value: String) {
    Row() {
        Text(text = "$name: ", fontSize = 20.sp, color = Color.White)
        Text(text = value, fontSize = 20.sp, color = Color.White)
    }
}

@Composable
fun HumanButton(visible: MutableState<Boolean>) {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Button(onClick = {
            visible.value = !visible.value
        }) {
            Icon(
                painter = painterResource(id = R.drawable.human_icon),
                contentDescription = ""
            )
            if (visible.value) {
                Text("Hide info")
            } else {
                Text("Show info")
            }
        }
    }
}