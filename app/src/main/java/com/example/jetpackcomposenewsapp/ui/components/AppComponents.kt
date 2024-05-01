package com.example.jetpackcomposenewsapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.jetpackcomposenewsapp.R
import com.example.jetpackcomposenewsapp.data.entity.Article
import com.example.jetpackcomposenewsapp.data.entity.NewsResponse
import com.example.jetpackcomposenewsapp.ui.theme.Purple40

@Composable
fun Loader() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp), color = Purple40


        )
    }

}

@Composable
fun NewsList(response: NewsResponse) {
    LazyColumn {
        items(response.articles) { article ->
            NormalTextComponent(value = article.title ?: "Not Available")
        }
    }
}

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        style = TextStyle(
            fontSize = 18.sp, fontWeight = FontWeight.Normal, fontFamily = FontFamily.Monospace
        )
    )
}

@Composable
fun HeadingTextComponent(value: String, isCenterAligned: Boolean = false) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        style = TextStyle(
            fontSize = 24.sp, fontWeight = FontWeight.Medium
        ),
        textAlign = if (isCenterAligned) TextAlign.Center else TextAlign.Start
    )
}

@Composable
fun NewsRowComponent(page: Int, article: Article) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White),
    ) {

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            model = article.urlToImage, contentDescription = "",
            contentScale = ContentScale.Fit,
            placeholder = painterResource(id = R.drawable.placeholder),
            error = painterResource(id = R.drawable.placeholder)

        )
        Spacer(modifier = Modifier.size(20.dp))
        HeadingTextComponent(value = article.title ?: "")
        Spacer(modifier = Modifier.size(10.dp))
        NormalTextComponent(value = article.description ?: "")
        Spacer(modifier = Modifier.weight(1f))
        AuthorDetailsComponent(author = article.author, source = article.source?.name)
    }

}

@Composable
fun AuthorDetailsComponent(author: String?, source: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, bottom = 25.dp)
    ) {
        author?.also {
            Text(text = it)
        }
        Spacer(modifier = Modifier.weight(1f))
        source?.also {
            Text(text = it)
        }
    }
}

@Composable
fun EmptyStateComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.nodata), contentDescription = "")
        HeadingTextComponent(
            value = stringResource(R.string.no_news_available_for_now),
            isCenterAligned = true
        )
    }

}

@Composable
@Preview
fun EmptyStateComponentPreview() {
    EmptyStateComponent()
}

@Preview
@Composable
fun NewsRowComponentPreview() {
    val article =
        Article(author = "Asad", title = "Dummy News Title", null, null, null, null, null, null)
    NewsRowComponent(0, article)
}

