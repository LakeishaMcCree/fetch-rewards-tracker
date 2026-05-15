package com.lakeisha.fetchrewardstracker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [RewardItem::class],
    version = 1
)
abstract class RewardDatabase : RoomDatabase() {

    abstract fun rewardDao(): RewardDao

    companion object {
        @Volatile
        private var INSTANCE: RewardDatabase? = null

        fun getDatabase(context: Context): RewardDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RewardDatabase::class.java,
                    "reward_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }

}