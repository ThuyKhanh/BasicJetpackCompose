package com.example.basicstatecodelab

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basicstatecodelab.ui.theme.BasicStateCodeLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicStateCodeLabTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    var counter by rememberSaveable {
//                        mutableStateOf(0)
//                    }
//                    Column {
//                        //WatterCounter(counter, { counter++ }, { counter = 0 })
//                        val list = remember {
//                            getWellnessTasks().toMutableStateList()
//                        }
//                        WellnessTaskList(list = list, onClosed = { task -> list.remove(task) })
//                    }
//                }
                WellnessScreen()
            }
        }
    }
}

@Preview
@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Surface {
        WellnessTaskList(
            list = wellnessViewModel.tasks,
            onCheckedTask = {task,newValue-> wellnessViewModel.changeTaskChecked(task,newValue)},
            onClosed = { task -> wellnessViewModel.remove(task) })
    }
}

//@Composable
//fun WatterCounter(
//    counter: Int,
//    onIncrement: () -> Unit,
//    onClear: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    Surface {
//
//        var counter by rememberSaveable {
//            mutableStateOf(0)
//        }
//        Column {
//            WatterCounter(counter, { counter++ }, { counter = 0 })
//            val list = remember {
//                getWellnessTasks().toMutableStateList()
//            }
//            WellnessTaskList(list = list, onClosed = { task -> list.remove(task) })
//        }
//    }
//}

//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Composable
//fun GreetingPreview() {
//    BasicStateCodeLabTheme {
//        WatterCounter(counter = 0, onIncrement = {  }, onClear = {  })
//    }
//}
//
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun GreetingPreviewDard() {
//    BasicStateCodeLabTheme {
//        var counter by rememberSaveable {
//            mutableStateOf(0)
//        }
//        WatterCounter(counter, { counter++ }, { counter = 0 })
//    }
//}