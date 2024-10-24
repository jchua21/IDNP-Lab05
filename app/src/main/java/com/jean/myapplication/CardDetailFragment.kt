package com.jean.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class CardDetailFragment : Fragment() {
    private var title: String? = null
    private var description: String? = null
    private var src: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(TITLE_BUNDLE)
            description = it.getString(DESCRIPTION_BUNDLE)
            src = it.getInt(SRC_BUNDLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleTextView: TextView = view.findViewById(R.id.card_detail_title)
        val descriptionTextView: TextView = view.findViewById(R.id.carad_detail_description)
        val imageView: ImageView = view.findViewById(R.id.card_detail_img)

        titleTextView.text = title
        descriptionTextView.text = description
        imageView.setImageResource(src!!)
    }

    companion object {
        const val TITLE_BUNDLE = "title_bundle"
        const val DESCRIPTION_BUNDLE = "description_bundle"
        const val SRC_BUNDLE = "src_bundle"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CardDetailFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }
}