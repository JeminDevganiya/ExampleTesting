package com.app.exampletesting.workers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.app.exampletesting.R
import com.app.exampletesting.adapters.AllTaskAdapter
import com.app.exampletesting.databinding.FragmentAllBinding
import com.app.exampletesting.ui.main.TaskViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AllFragment : Fragment() {
    private lateinit var binding: FragmentAllBinding
    private lateinit var allTaskAdapter: AllTaskAdapter
    private val viewModel: TaskViewModel by viewModels()

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

        viewModel.allUser.observe(viewLifecycleOwner, {
            allTaskAdapter.addTask(it)
            if (it.isNotEmpty()){
                binding.leafImageView.visibility = View.GONE
                binding.textView.visibility = View.GONE
            }
        })
        allTaskAdapter.click = {
            viewModel.setCompleted(it)
        }
        viewModel.snackBarText.observe(viewLifecycleOwner,{
                Snackbar.make(binding.view2, it, Snackbar.LENGTH_SHORT).show()
        })
    }
}
