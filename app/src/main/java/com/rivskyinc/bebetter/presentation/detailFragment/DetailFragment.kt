package com.rivskyinc.bebetter.presentation.detailFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.rivskyinc.bebetter.databinding.FragmentDetailBinding
import com.rivskyinc.bebetter.domain.entities.Blog
import com.rivskyinc.bebetter.presentation.BlogApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.LinkedList
import javax.inject.Inject

class DetailFragment : Fragment() {

    private var currentPosition: Int = 0

    private lateinit var binding: FragmentDetailBinding
    private var getPostImage: String? = null
    private var getPostTitle: String? = null
    private var getPostText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            getPostImage = it.getString(IMAGE)
            getPostTitle = it.getString(TITLE)
            getPostText = it.getString(TEXT)
            currentPosition = it.getInt(POSITION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.onBackButton.setOnClickListener {
//            activity?.onBackPressed()
//        }
        setData()
        binding.progressBar.visibility = View.GONE
    }

    private fun setData() {
        setImage()
        setTitle()
        setText()

    }

    private fun setTitle() {
        binding.tvTitleDetail.text = getPostTitle.toString()
    }

    private fun setText() {
        binding.tvPost.text = getPostText.toString()
    }

    private fun setImage() {
        activity?.let { fragmentActivity ->
            Glide.with(fragmentActivity.applicationContext)
                .load(getPostImage)
                .into(binding.imageViewFragmentDetail)
        }

    }


    companion object {

        private const val IMAGE = "image"
        private const val TITLE = "title"
        private const val TEXT = "text"
        private const val POSITION = "position"

        @JvmStatic
        fun newInstance(
            title: String?, image: String?, text: String?, position: Int
            ) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(TITLE, title)
                    putString(IMAGE, image)
                    putString(TEXT, text)
                    putInt(POSITION, position)
                }
            }
    }
}