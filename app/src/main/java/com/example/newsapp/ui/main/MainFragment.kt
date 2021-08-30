package com.example.newsapp.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.newsapp.data.model.state.DataState
import com.example.newsapp.databinding.MainFragmentBinding
import com.example.newsapp.ui.adapter.NewsAdapter

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: NewsAdapter
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        observeHomeDataList()
    }

    private fun observeHomeDataList(){

        viewModel.getTopHeadlines().observe(viewLifecycleOwner){
            when (it.getStatus()) {

                DataState.DataStatus.LOADING -> {

                }

                DataState.DataStatus.SUCCESS -> {

                }

                DataState.DataStatus.ERROR -> {

                }

                DataState.DataStatus.NO_INTERNET -> {

                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = NewsAdapter()
        binding.rvNews.adapter = adapter
        binding.loadingLayout.pbProgressbar.isVisible = false
        binding.loadingLayout.tvError.isVisible = false
    }

}