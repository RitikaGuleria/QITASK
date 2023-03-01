package com.example.qitask.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.example.Articles
import com.example.qitask.ui.theme.QITASKTheme

@Composable
fun HomeScreen() {
    val viewModel: NewsViewModel = viewModel() //view holds reference of viewModel

    //hoisting up the coroutines
    val news = viewModel.newsState.value

    Scaffold(topBar = { AppBar( icon = Icons.Filled.Search,title = "Search in feed") })
    {

        LazyColumn(contentPadding = PaddingValues(16.dp))
        {
            items(news){ ans->
                print(ans.title)
                CardContent(news = ans)

            }
        }
    }
}


@Composable
fun AppBar(title:String, icon: ImageVector)
{
    TopAppBar(navigationIcon = { icon}, title = { Text(text = title) })
}


@Composable
fun CardContent(news: Articles)
{
    Card(modifier= Modifier
        .padding(18.dp)
        .wrapContentHeight()
        .shadow(4.dp))
    {
        Row(modifier = Modifier.wrapContentSize())
        {
            Column(modifier=Modifier.padding(18.dp)) {
                news.publishedAt?.let { Text(text = "2 hours ago BBC News",color= Color.Gray,modifier=Modifier.padding(4.dp)) }
                news.title?.let { Text(text = it, fontWeight= FontWeight.Bold,modifier=Modifier.padding(4.dp)) }
                news.description?.let { Text(text = it, fontSize = 12.sp,modifier=Modifier.padding(4.dp)) }
            }
            Image(painter = painterResource(id = com.example.qitask.R.drawable.ic_baseline_image_24) , contentDescription = "")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    QITASKTheme {
        HomeScreen()
    }
}
