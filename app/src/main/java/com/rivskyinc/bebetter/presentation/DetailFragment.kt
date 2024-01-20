package com.rivskyinc.bebetter.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rivskyinc.bebetter.R
import com.rivskyinc.bebetter.domain.entities.Blog
import java.util.LinkedList

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DetailFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

        private const val IMAGE = "image"
        private const val TITLE = "title"
        private const val TEXT = "text"
        private const val POSTS_LIST = "photo_list"
        private const val POSITION = "position"

        @JvmStatic
        fun newInstance(title: String, image : String,  text: String, position : Int,
                        postsList: LinkedList<Blog>
        ) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(TITLE, title)
                    putString(IMAGE, image)
                    putString(TEXT, text)
                    putInt(POSITION,position )
                    putSerializable(POSTS_LIST, postsList)
                }
            }
    }
}