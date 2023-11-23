package screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.ScreenAComponent
import navigation.ScreenAEvent

@Composable
fun ScreenA(component: ScreenAComponent) {
    val text by component.text.subscribeAsState()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Screen A")
        OutlinedTextField(
            value = text,
            onValueChange = { component.onEvent(ScreenAEvent.UpdateText(it)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Button(onClick = {
            component.onEvent(ScreenAEvent.ClickButtonA)
        }) {
            Text("Go to Screen B")
        }
    }
}