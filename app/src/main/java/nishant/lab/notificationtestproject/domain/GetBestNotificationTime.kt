package nishant.lab.notificationtestproject.domain

import android.os.Build
import androidx.annotation.RequiresApi
import nishant.lab.notificationtestproject.data.remote.NotificationClick
import nishant.lab.notificationtestproject.domain.repository.NotificationRepository
import java.time.LocalTime
import javax.inject.Inject

class GetBestNotificationTime @Inject constructor(private val repository: NotificationRepository) {
    @RequiresApi(Build.VERSION_CODES.O)
    suspend operator fun invoke() : LocalTime? {
        val notificationClick = repository.getNotification()
        return calculateBestTimeInterval(notificationClick)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun calculateBestTimeInterval(clicks : List<NotificationClick>) : LocalTime? {
        val quadrantSize = 24/4
        val clickCount = IntArray(4)
        for(click in clicks){
            val quadrant = click.time.hour/quadrantSize
            clickCount[quadrant]++

        }
        val bestQuadrant = clickCount.indices.maxByOrNull { clickCount[it] }
        return bestQuadrant?.let { LocalTime.of(it*quadrantSize,0) }
    }
}