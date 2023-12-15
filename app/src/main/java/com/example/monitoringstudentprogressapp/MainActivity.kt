package com.example.monitoringstudentprogressapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.monitoringstudentprogressapp.Adapters.Student
import com.example.monitoringstudentprogressapp.Adapters.StudentAdapter
import com.example.monitoringstudentprogressapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityMain must not be null")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentList = mutableListOf<Student>(
            Student(1,2,0,1),
            Student(0,2,2,1)
        )

        val rvStudents: RecyclerView = binding.rvStudents
        rvStudents.layoutManager =  LinearLayoutManager(this)
        rvStudents.adapter = StudentAdapter(studentList, this)
    }
}