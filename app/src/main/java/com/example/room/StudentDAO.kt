package com.example.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {

    @Insert
    fun insert(student: Student)

    @Delete
    fun delete(student: Student)

    @Query("SELECT*FROM student")
    fun getAllStudent(): List<Student>
}