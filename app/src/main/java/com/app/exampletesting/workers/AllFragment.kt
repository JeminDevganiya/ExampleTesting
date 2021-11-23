package com.app.exampletesting.workers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.app.exampletesting.adapters.AllTaskAdapter
import com.app.exampletesting.databinding.FragmentAllBinding
import com.app.exampletesting.ui.main.TaskViewModel

class AllFragment : Fragment() {
    private lateinit var binding: FragmentAllBinding
    private lateinit var allTaskAdapter: AllTaskAdapter
    private lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: TaskViewModel by viewModels{
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        allTaskAdapter = AllTaskAdapter()
        binding.allRC.adapter = allTaskAdapter

        viewModel.getTaskData()

        viewModel.allUser.observe(viewLifecycleOwner,{
            allTaskAdapter.getTask(it)
        })
    }
}
