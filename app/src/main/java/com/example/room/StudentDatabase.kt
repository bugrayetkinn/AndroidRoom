package com.example.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDAO

    companion object {
        private var instance: StudentDatabase? = null

        fun getStudentDatabase(context: Context): StudentDatabase? {

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    StudentDatabase::class.java,
                    "student.db"
                ).allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}