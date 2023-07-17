package com.example.motivationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.motivationapp.model.motivations
import com.example.motivationapp.ui.theme.MotivationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MotivationAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        MotivationApp()
                }
            }
        }
    }
}

@Composable
fun MotivationApp(modifier: Modifier = Modifier){
    LazyColumn(
        modifier = modifier.padding(16.dp)
    ){
        items(motivations){
            it -> Cards(
                    day = it.day,
                    title = it.title,
                    imageRes = it.imageRes,
                    description = it.description,
                    modifier = modifier.padding(bottom=12.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MotivationPreview() {
    MotivationAppTheme {
        MotivationApp()
    }
}