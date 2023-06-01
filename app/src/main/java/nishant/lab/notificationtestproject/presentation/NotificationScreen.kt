package nishant.lab.notificationtestproject.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotificationScreen(viewModel: NotificationViewModel = hiltViewModel()){
    val bestTimeInterval by viewModel.bestTimeInterval.collectAsState()

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Best Time Interval for Sending Notifications",
        style = TextStyle(fontSize = 18.sp , fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (bestTimeInterval != null) {
            Text(
                text = "Best Time: ${bestTimeInterval!!.format(DateTimeFormatter.ofPattern("HH:mm"))}",
                style = TextStyle(fontSize = 24.sp)
            )
            Text(
                text = "24 hour  format",
                style = TextStyle(fontSize = 14.sp)
            )
        } else {
            Text(text = "Calculating best time...")
        }
    }

    LaunchedEffect(Unit) {
        viewModel.calculatesBestTimeInterval()
    }

    }

