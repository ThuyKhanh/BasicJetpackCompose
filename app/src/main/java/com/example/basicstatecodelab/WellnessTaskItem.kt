package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.ui.theme.BasicStateCodeLabTheme

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onClose: () -> Unit,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = taskName, modifier = Modifier
                .weight(1.0f)
                .padding(16.dp)
        )
        Checkbox(checked = checked, onCheckedChange = {newValue-> onCheckedChange(newValue)})
        IconButton(onClick = onClose) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = null)

        }
    }
}

@Preview
@Composable
fun WellnessTaskItemPreview() {
    BasicStateCodeLabTheme {
        WellnessTaskItem("My task", false, onClose = {}, onCheckedChange = {})
    }
}