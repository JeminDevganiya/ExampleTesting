package com.app.exampletesting.ui.other

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.exampletesting.databinding.NewTaskBinding

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
        binding.checkButton.setOnClickListener {
            val title = binding.enterTitleText.text.toString()
            val task = binding.enterTaskText.text.toString()
            when {
                title.isEmpty() ->{
                    Toast.makeText(this,"Enter title", Toast.LENGTH_LONG).show()
                }
                task.isEmpty() ->{
                    Toast.makeText(this,"Enter task",Toast.LENGTH_LONG).show()
                }
                else -> {
                    val intent = Intent(this,AddTask::class.java)
                    startActivity(intent)

                }
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){

            android.R.id.home -> {
                finish()

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}