package com.example.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCheckedTask : (WellnessTask,Boolean)->Unit,
    onClosed: (WellnessTask)->Unit
) {
    LazyColumn(modifier = modifier) {
        items(list , key = {task->task.id}) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onClose = {onClosed(task)},
                onCheckedChange = { newValue-> onCheckedTask(task,newValue) },
                modifier = modifier)
        }
    }
}




