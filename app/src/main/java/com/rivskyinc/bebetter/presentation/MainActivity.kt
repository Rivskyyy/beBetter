package com.rivskyinc.bebetter.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.rivskyinc.bebetter.R
import com.rivskyinc.bebetter.databinding.ActivityMainBinding
import com.rivskyinc.bebetter.presentation.adapter.MyListAdapter
import com.rivskyinc.bebetter.presentation.mainFragment.viewModel.MainViewModel
import com.rivskyinc.bebetter.presentation.mainFragment.viewModel.MainViewModelFactory
import java.util.LinkedList
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = getColor(R.color.black)
    }
}