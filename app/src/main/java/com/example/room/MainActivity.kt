package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.room.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)


        val studentDatabase = StudentDatabase.getStudentDatabase(this)


        mainBinding.buttonSave.setOnClickListener {

            val name = mainBinding.editTextStudentName.text.toString()
            val grade = Integer.valueOf(mainBinding.editTextTextStudentGrade.text.toString())

            val student = Student(studentName = name, studentGrade = grade)
            studentDatabase?.studentDao()?.insert(student)

        }

        mainBinding.buttonAllStudent.setOnClickListener {

            var result = ""

            val students: ArrayList<Student> =
                studentDatabase?.studentDao()?.getAllStudent() as ArrayList<Student>

            students.forEach {

                result += it.studentName + "->" + it.studentGrade + "\n"
            }

            mainBinding.textViewResult.text = result
        }

    }
}