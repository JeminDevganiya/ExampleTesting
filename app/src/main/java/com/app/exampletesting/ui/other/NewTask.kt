package com.app.exampletesting.ui.other

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.app.exampletesting.data.local.TaskData
import com.app.exampletesting.databinding.NewTaskBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewTask : AppCompatActivity() {

    private lateinit var binding: NewTaskBinding
    private val viewModel: NewTaskViewModel by viewModels()

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
            val description = binding.enterTaskText.text.toString()
            when {
                title.isEmpty() -> {
                    Toast.makeText(this, "Enter title", Toast.LENGTH_LONG).show()
                }
                description.isEmpty() -> {
                    Toast.makeText(this, "Enter task", Toast.LENGTH_LONG).show()
                }
                else -> {
                    val task = TaskData(0,title,description, false)
                    viewModel.insertTaskData(task)
                }
            }
        }

        viewModel.insertFinish.observe(this, {
            finish()
        })
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
