package com.example.qitask.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.qitask.ui.theme.QITASKTheme

@Composable
fun TopAppBar(navHostController: NavHostController?)
{
    Column(modifier= Modifier.wrapContentHeight())
    {
        Card(shape= RoundedCornerShape(45.dp), backgroundColor = Color.Red,modifier= Modifier.fillMaxWidth())
        {
            Column() {
                Text(text = "Social X",color= Color.White, fontWeight = FontWeight.Bold, fontSize = 30.sp,modifier= Modifier
                    .padding(16.dp)
                    .align(Alignment.Start))
                Box(Modifier.background(color= Color.White)){
                    Row()
                    {
                        Text(text = "LOG IN",color= Color.Gray,modifier= Modifier
                            .padding(28.dp)
                            .clickable { navHostController?.navigate("login") }, fontSize = 20.sp)
                        Spacer(modifier = Modifier.width(36.dp))
                        Card(backgroundColor = Color.Red, shape = RoundedCornerShape(bottomStart =  65.dp)) {
                            Text(text = "SIGN UP",color= Color.White,modifier= Modifier
                                .padding(28.dp)
                                .clickable { navHostController?.navigate("register") }, textAlign = TextAlign.Center, fontSize = 20.sp)
                        }

                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview3() {
    QITASKTheme() {
        TopAppBar(null)
    }
}
