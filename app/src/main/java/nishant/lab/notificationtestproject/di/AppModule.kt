package nishant.lab.notificationtestproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nishant.lab.notificationtestproject.data.repository.NotificationImpl
import nishant.lab.notificationtestproject.domain.GetBestNotificationTime
import nishant.lab.notificationtestproject.domain.repository.NotificationRepository
import nishant.lab.notificationtestproject.presentation.NotificationViewModel
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)


object AppModule {
    @Provides
    @Singleton
    fun providerRepository(): NotificationRepository {
        return NotificationImpl()
    }

    @Provides
    fun providerNotification(getBestNotificationTimeInterval : GetBestNotificationTime) : NotificationViewModel {
        return NotificationViewModel(getBestNotificationTimeInterval)
    }


}