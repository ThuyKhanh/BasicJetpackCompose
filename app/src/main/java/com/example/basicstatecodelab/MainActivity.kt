package com.example.basicstatecodelab

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.ui.theme.BasicStateCodeLabTheme

class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicStateCodeLabTheme {
                DerivedStateOfScreen(
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp), viewModel.resident)
            }
        }
    }

    @Composable
    private fun DerivedStateOfScreen(modifier: Modifier = Modifier, list: List<Person>) {
        Column(modifier = modifier) {
            Row (modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Absolute.SpaceEvenly){
                Button(onClick = { viewModel.removeFistItem() }) {
                    Text(text = "Remove the first")
                }
                Button(onClick = { viewModel.addToLast() }) {
                    Text(text = "Add to the last")
                }
            }
            LazyColumn( modifier = Modifier.fillMaxWidth()) {
                items(list,key = {it.name}) { person ->
                    PersonItemView(modifier = modifier,person = person)
                }
            }
        }
    }

    @Composable
    private fun PersonItemView(modifier: Modifier = Modifier, person: Person) {
        Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = person.name)
            Column {
                repeat(person.addressCollection.addresses.size){
                    Text(text = person.addressCollection.addresses[it])
                }
            }
        }
    }
    @Preview(widthDp = 480, heightDp = 800)
    @Composable
    fun DerivedStateOfScreenPreview() {
        BasicStateCodeLabTheme {
            Surface {
                val list = List(50) { index -> Person(name = "Person $index",
                    addressCollection = AddressCollection(MutableList(5){"Address $it"}),
                    properties = Properties(house = List(2){ House(60.0f,2,2) }, car = List(1){Car(branch = "Hyundai", seat = 4)})
                ) }
                DerivedStateOfScreen(modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp), list = list)
            }
        }
    }
    companion object {
        var TAG: String = "THUY_DEBUG"
    }
}