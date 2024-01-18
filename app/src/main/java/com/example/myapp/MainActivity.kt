package com.example.visitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.R
import com.example.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VisitCard()
                }
            }
        }
    }
}

@Composable
fun PictureIntro(name: String, description: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    val borderWidth = 16.dp
    val colorGradient = listOf(Color.Magenta, Color.Cyan)
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = "logo android",
            modifier = modifier
                .size(150.dp)
                .border(
                    BorderStroke(5.dp, Color.Cyan),
                    RoundedCornerShape(borderWidth)
                )
                .clip(RoundedCornerShape(borderWidth))
                .background(Color.Black)
        )
        Text(
            text = name,
            fontSize = 25.sp
        )
        Text(
            text = description,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = colorGradient
                )
            )
        )
    }
}

@Composable
fun ProjectsScrollBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Black)
            .horizontalScroll(rememberScrollState())
            .padding(20.dp)
            .height(150.dp)
    ) {
        Row {
            Column {
                Text(
                    text = "My App",
                    color = Color.White,
                    modifier = modifier
                        .padding(bottom = 2.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.visistcardscreen),
                    contentDescription = null,
                    modifier = modifier
                        .padding(end = 20.dp),
                    contentScale = ContentScale.FillHeight
                )
            }
            Column {
                Text(
                    text = "Tetris",
                    color = Color.White
                )
                Image(
                    painter = painterResource(id = R.drawable.tetrisscreen),
                    contentDescription = null,
                    modifier = modifier
                        .padding(end = 20.dp),
                    contentScale = ContentScale.FillHeight
                )
            }
            Column {
                Text(
                    text = "Tourism Viewer",
                    color = Color.White
                )
                Image(
                    painter = painterResource(id = R.drawable.tourismvscreen),
                    contentDescription = null,
                    modifier = modifier
                        .padding(end = 20.dp),
                    contentScale = ContentScale.FillHeight
                )
            }
            Column {
                Text(
                    text = "Gazoduc",
                    color = Color.White
                )
                Image(
                    painter = painterResource(id = R.drawable.gazoducscreen),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight
                )
            }
        }
    }
}

@Composable
fun Projects(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Projects and Collaborations",
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(8.dp)
        )
        ProjectsScrollBar()
    }
}

@Composable
fun Coordinate(phone: String, email: String, github: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Rounded.Phone,
                contentDescription = "phone number"
            )
            Text(
                text = phone,
                modifier = modifier
                    .padding(6.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Rounded.Email,
                contentDescription = "email address"
            )
            Text(
                text = email,
                modifier = modifier
                    .padding(6.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.github_icon),
                contentDescription = "GitHub link",
                Modifier.size(24.dp)
            )
            Text(
                text = github,
                modifier = modifier
                    .padding(6.dp)
            )
        }
    }
}

@Composable
fun VisitCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFbbd1f4)),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        PictureIntro(
            name = stringResource(R.string.name),
            description = stringResource(R.string.profilDescription)
        )
        Projects()
        Coordinate(
            phone = stringResource(R.string.phoneNumber),
            email = stringResource(R.string.emailAdress),
            github = stringResource(R.string.GitHubLink)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyAppPreview() {
    MyAppTheme {
        VisitCard()
    }
}