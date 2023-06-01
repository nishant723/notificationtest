package nishant.lab.notificationtestproject.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import nishant.lab.notificationtestproject.domain.GetBestNotificationTime
import java.time.LocalTime
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(private val getBestNotificationTime : GetBestNotificationTime) : ViewModel() {
  private val _bestTimeInterval : MutableStateFlow<LocalTime?> = MutableStateFlow(null)
    val bestTimeInterval : StateFlow<LocalTime?> = _bestTimeInterval

    @RequiresApi(Build.VERSION_CODES.O)
    fun calculatesBestTimeInterval(){
        viewModelScope.launch {
            val bestTimeInterval = getBestNotificationTime()
            _bestTimeInterval.value = bestTimeInterval
        }
    }
}