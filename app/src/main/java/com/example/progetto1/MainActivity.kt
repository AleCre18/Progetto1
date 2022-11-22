package com.example.progetto1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.progetto1.ui.theme.Progetto1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Progetto1Theme {
                val moneyCounter = remember {
                    mutableStateOf(0)
                }
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = Color.Green) {
                    //Greeting("Android")
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {
                        Text(text = "${moneyCounter.value}$", fontSize = 35.sp, fontWeight = FontWeight.ExtraBold)
                        Spacer(modifier = Modifier.padding(30.dp))
                        CreateCircle(moneyCounter.value){
                            moneyCounter.value += 1
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CreateCircle(moneyCounter: Int = 0, addMoney: (Int) -> Unit ){
    //var moneyCounter by remember {
    //    mutableStateOf(0)
    //}

    Card(modifier = Modifier
        .padding(3.dp)
        .size(100.dp)
        .clickable {
            addMoney(moneyCounter)
            Log.d("Money", "createCircle: My balance: $moneyCounter dollars.")
        },
    shape = CircleShape, elevation = 5.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Tap", modifier = Modifier)
        }
    }
}