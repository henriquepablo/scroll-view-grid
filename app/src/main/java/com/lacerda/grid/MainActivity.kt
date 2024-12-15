package com.lacerda.grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lacerda.grid.data.DataSource
import com.lacerda.grid.model.Topic
import com.lacerda.grid.ui.theme.GridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GridTheme {
                Surface(modifier =
                    Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    List()
                }
            }
        }
    }
}

@Composable
fun List(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
    ) {
        items(DataSource.topics) { topic ->
            Card(topic)
        }
    }
}

@Composable
fun Card(topic: Topic, modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .statusBarsPadding()
    ) {
        Box(
            modifier = Modifier
                .background(color = colorResource(R.color.background))
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
        ) {
            Row() {
                Image(
                    painter = painterResource(id = topic.imageRes),
                    contentDescription = "Image",
                    Modifier
                        .height(68.dp)
                        .width(68.dp)
                )
                Column() {
                    Text(
                        text = stringResource(id = topic.name),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 16.dp, bottom = 8.dp, top = 16.dp, end = 16.dp)
                    )
                    Row() {
                        Text(
                            text = "Image",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(start = 16.dp, end = 8.dp)
                        )
                        Text(
                            text = topic.availableCourses.toString(),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    //Card();
}