package com.jefisu.roomcompose.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jefisu.roomcompose.data.dto.Person

@Database(entities = [Person::class], version = 1)
abstract class PersonDatabase : RoomDatabase() {

    abstract fun dao(): PersonDao

    companion object {

        private lateinit var INSTANCE: PersonDatabase

        fun getInstance(context: Context): PersonDatabase {
            if (!::INSTANCE.isInitialized) {
                synchronized(PersonDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context, PersonDatabase::class.java, "movieDb")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }


}