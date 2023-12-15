package com.example.monitoringstudentprogressapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        val studentList = mutableListOf<Student>(Student(1,2,0,1), Student(0,2,2,1))


        val rvStudents: RecyclerView = binding.rvStudents
        rvStudents.layoutManager =  LinearLayoutManager(this)
        val adapter = StudentAdapter(studentList, this)
        rvStudents.adapter = adapter

        val bthAdd = binding.bthAdd
        val llAddStudentPonel = binding.llAddStudentPonel
        val bthCloseAddStudentPonel = binding.bthCloseAddStudentPonel
        bthAdd.setOnClickListener{
            if (llAddStudentPonel.visibility != View.VISIBLE) {
                llAddStudentPonel.visibility = View.VISIBLE
                return@setOnClickListener
            }
            val SinnKS1 = binding.SinnKS1.selectedItem.toString().toInt()
            val SinnKS2 = binding.SinnKS2.selectedItem.toString().toInt()
            val SinnKS3 = binding.SinnKS3.selectedItem.toString().toInt()
            val SinnKS4 = binding.SinnKS4.selectedItem.toString().toInt()
            adapter.addStudent(Student(SinnKS1,SinnKS2,SinnKS3,SinnKS4))
            //rvStudents.notifySubtreeAccessibilityStateChanged()
                //addStudent(Student(SinnKS1,SinnKS2,SinnKS3,SinnKS4))
            //rvStudents.adapter.addStudent()
        }
        bthCloseAddStudentPonel.setOnClickListener{
            llAddStudentPonel.visibility = View.GONE
        }
    }
}