package com.app.exampletesting.ui.other

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.provider.ContactsContract
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.exampletesting.databinding.NewTaskBinding
import com.app.exampletesting.data.local.AppDatabase
import com.app.exampletesting.data.local.TaskData

class NewTask : AppCompatActivity() {

    private lateinit var binding: NewTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "New Task"
        }

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "database")
            .allowMainThreadQueries()
            .build()
        val userDao = db.userDao()

        binding.checkButton.setOnClickListener {
            val title = binding.enterTitleText.text.toString()
            val task = binding.enterTaskText.text.toString()
            when {
                title.isEmpty() -> {
                    Toast.makeText(this, "Enter title", Toast.LENGTH_LONG).show()
                }
                task.isEmpty() -> {
                    Toast.makeText(this, "Enter task", Toast.LENGTH_LONG).show()
                }
                else -> {
                    val task = TaskData(0,title)
                    userDao.insert(task)
                }
            }
            val intent = Intent(this,AddTask::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            android.R.id.home -> {
                finish()

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}