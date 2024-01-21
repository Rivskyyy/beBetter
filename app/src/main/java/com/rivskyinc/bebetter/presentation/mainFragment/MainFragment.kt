package com.rivskyinc.bebetter.presentation.mainFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.rivskyinc.bebetter.R
import com.rivskyinc.bebetter.databinding.FragmentMainBinding
import com.rivskyinc.bebetter.presentation.BlogApplication
import com.rivskyinc.bebetter.presentation.DetailFragment
import com.rivskyinc.bebetter.presentation.adapter.MyListAdapter
import com.rivskyinc.bebetter.presentation.mainFragment.viewModel.MainViewModel
import com.rivskyinc.bebetter.presentation.mainFragment.viewModel.MainViewModelFactory
import java.util.LinkedList
import javax.inject.Inject


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }
    private lateinit var myAdapter: MyListAdapter

    private val component by lazy {
        (this@MainFragment.activity?.application as BlogApplication).component
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        component.inject(this)
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loadData()

        binding.progressBar.visibility = View.GONE
    }

    private fun loadData() {

        viewModel.postsList.observe(viewLifecycleOwner) {
            if (it != null) {
                myAdapter.submitList(listOf(it))
            } else {
                binding.progressBar.visibility = View.VISIBLE
                Toast.makeText(this.context, "No Internet connection", Toast.LENGTH_LONG).show()
            }

        }
        viewModel.quote.observe(viewLifecycleOwner){
            if ( it!= null ){
                binding.textViewQuote.text = it.text
            }
        }
    }


    private fun launchDetailFragment(detailFragment: DetailFragment) {
        val fragmentManager = this.requireActivity().supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(
                R.id.main_container,
                detailFragment
            )
            .addToBackStack(null)
            .commit()

    }

    private fun setupRecyclerView() {
        binding.recyclerViewMain.apply {
            myAdapter = MyListAdapter { post, position ->
                val detailFragment = DetailFragment.newInstance(
                    post.title,
                    post.thumbnail,
                    post.text,
                    position,
                    LinkedList(myAdapter.currentList)
                )
                launchDetailFragment(detailFragment)
            }
            adapter = myAdapter
            layoutManager = GridLayoutManager(context, 3)
        }
    }
}




