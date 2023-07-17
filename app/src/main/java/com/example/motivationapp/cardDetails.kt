package com.example.motivationapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cards(
    day: Int,
    title: Int,
    imageRes: Int,
    description: Int,
    modifier: Modifier = Modifier
){
    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        onClick = { expanded = !expanded },
        modifier = modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessHigh
                )
            )
    ) {
        Column(
            modifier = modifier.padding(12.dp)
        ) {
            Text(text =  "Day $day", modifier.padding(bottom=6.dp), fontWeight = FontWeight.Bold )
            Text(text = stringResource(id = title), modifier.padding(bottom = 12.dp), fontWeight = FontWeight.Bold, fontSize = 22.sp )
            Image( painterResource(id = imageRes), contentDescription = null)

            AnimatedVisibility(visible = expanded) {
                Text(text = stringResource(id = description), modifier.padding(top=16.dp), fontSize = 18.sp)
            }

        }
    }
}

@Preview(showBackground = false)
@Composable
fun CardPreview(){
    Cards(1,R.string.title1, R.drawable.pic1, R.string.description1)
}