package nishant.lab.notificationtestproject.domain.repository

import nishant.lab.notificationtestproject.data.remote.NotificationClick

interface NotificationRepository {
    suspend fun getNotification() : List<NotificationClick>
    suspend fun sendNotification() : List<NotificationClick>
}