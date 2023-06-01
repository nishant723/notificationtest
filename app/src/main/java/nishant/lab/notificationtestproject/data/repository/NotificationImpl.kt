package nishant.lab.notificationtestproject.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import nishant.lab.notificationtestproject.data.remote.NotificationClick
import nishant.lab.notificationtestproject.domain.repository.NotificationRepository
import java.time.LocalTime

class NotificationImpl : NotificationRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getNotification(): List<NotificationClick> {
        return listOf(
            NotificationClick(LocalTime.of(8, 15)),
            NotificationClick(LocalTime.of(7, 20)),
            NotificationClick(LocalTime.of(5, 30)),
            NotificationClick(LocalTime.of(17, 30)),
            NotificationClick(LocalTime.of(18, 30)),
            NotificationClick(LocalTime.of(2, 30)),
            NotificationClick(LocalTime.of(4, 30)),
            NotificationClick(LocalTime.of(19, 0)),
            NotificationClick(LocalTime.of(20, 15)),
            NotificationClick(LocalTime.of(17, 0))
        )

    }

    override suspend fun sendNotification(): List<NotificationClick> {
        TODO("Not yet implemented")
    }
}