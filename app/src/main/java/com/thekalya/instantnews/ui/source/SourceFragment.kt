package com.thekalya.instantnews.ui.source

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.thekalya.instantnews.R
import com.thekalya.instantnews.adapter.SourceAdapter
import com.thekalya.instantnews.databinding.FragmentSourceBinding

class SourceFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentSourceBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_source, container, false
        )

        val viewModelFactory = SourceViewModelFactory()
        val viewModel = ViewModelProvider(this, viewModelFactory).get(SourceViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.categoryList.observe(this, Observer {
            binding.recyclerView.adapter = SourceAdapter(this.context!!, it)
        })
        return binding.root
    }
}
