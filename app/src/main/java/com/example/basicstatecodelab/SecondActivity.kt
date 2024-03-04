package com.example.basicstatecodelab

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.rememberAsyncImagePainter
import com.example.basicstatecodelab.ui.theme.BasicStateCodeLabTheme


class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenView(Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun ScreenView(modifier: Modifier = Modifier) {
    BasicStateCodeLabTheme {
        Surface {
            ActivityResultView(modifier = modifier)            
        }

    }
}

@Composable
fun ActivityResultView(modifier: Modifier) {
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent(), onResult = {
        imageUri = it
    })
    Column(modifier = modifier,horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {launcher.launch("image/*")}) {
            Text(text = "Select image")
        }
        Image(painter = rememberAsyncImagePainter(imageUri), contentDescription = null)
    }
}
