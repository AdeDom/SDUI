package com.adedom.ui_component.ui.component.dialog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun AppErrorDialogComponent(
    onClickOk: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onClickOk,
        confirmButton = {},
        title = {
            Text(text = "Error")
        },
        text = {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Button(
                    onClick = onClickOk,
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {
                    Text(text = stringResource(id = android.R.string.ok))
                }
            }
        },
        shape = MaterialTheme.shapes.large,
        containerColor = MaterialTheme.colorScheme.onBackground
    )
}