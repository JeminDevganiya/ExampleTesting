package com.app.exampletesting.workers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.app.exampletesting.R
import com.app.exampletesting.adapters.AllTaskAdapter
import com.app.exampletesting.databinding.FragmentActiveBinding
import com.app.exampletesting.ui.main.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActiveFragment : Fragment() {

    private lateinit var binding: FragmentActiveBinding
    private lateinit var allTaskAdapter: AllTaskAdapter
    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentActiveBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        allTaskAdapter = AllTaskAdapter()
        binding.activeRC.adapter = allTaskAdapter

        viewModel.allUser.observe(viewLifecycleOwner, {
            allTaskAdapter.addTask(it)
        })
    }
}