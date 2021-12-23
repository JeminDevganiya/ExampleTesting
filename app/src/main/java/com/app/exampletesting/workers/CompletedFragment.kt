package com.app.exampletesting.workers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.app.exampletesting.adapters.AllTaskAdapter
import com.app.exampletesting.databinding.FragmentCompletedBinding
import com.app.exampletesting.ui.main.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompletedFragment : Fragment() {
    private lateinit var binding: FragmentCompletedBinding
    private lateinit var allTaskAdapter: AllTaskAdapter
    private val viewModel : CompletedTaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompletedBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allTaskAdapter = AllTaskAdapter()
        binding.completeRC.adapter = allTaskAdapter

        viewModel.completeTask.observe(viewLifecycleOwner,{
            allTaskAdapter.addTask(it)
            if (it.isNotEmpty()){
                binding.noTaskText.visibility = View.GONE
            }
        })
        viewModel.getCompleteTask()
    }
}