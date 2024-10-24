package com.jean.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.card.MaterialCardView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CardItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CardItemFragment : Fragment() {
    // TODO: Rename and change types of parameters
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardCatedral = view.findViewById<MaterialCardView>(R.id.card_catedral)
        val cardClaustro = view.findViewById<MaterialCardView>(R.id.card_claustro)

        cardCatedral.setOnClickListener(){
            val bundle = Bundle().apply {
                putString(CardDetailFragment.TITLE_BUNDLE, "Catedral de Arequipa")
                putString(CardDetailFragment.DESCRIPTION_BUNDLE, "La Catedral de Arequipa, un majestuoso ícono de la ciudad, se erige en la Plaza de Armas como un ejemplo destacado de la arquitectura barroca. Construida en sillar blanco, un tipo de piedra volcánica, la catedral presenta una impresionante fachada con elaborados detalles escultóricos y dos imponentes torres que dominan el paisaje urbano.")
                putInt(CardDetailFragment.SRC_BUNDLE, R.drawable.catedral)
            }
            // Navigate to another fragment
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<CardDetailFragment>(R.id.fragment_container, args = bundle)
                addToBackStack("replacement")
            }
        }

        cardClaustro.setOnClickListener(){
            //Navigate to another fragment
            Log.d("FRAGMENT", "navigating ")
            val bundle = Bundle().apply {
                putString(CardDetailFragment.TITLE_BUNDLE, "Claustro de Arequipa")
                putString(CardDetailFragment.DESCRIPTION_BUNDLE, "El Claustro de la Catedral de Arequipa es un espacio de gran importancia histórica y arquitectónica que complementa la magnificencia de la catedral. Este claustro, con sus elegantes arcos y columnas de sillar.")
                putInt(CardDetailFragment.SRC_BUNDLE, R.drawable.claustro)
            }
            // Navigate to another fragment
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<CardDetailFragment>(R.id.fragment_container, args = bundle)
                addToBackStack("replacement")
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CardItemFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CardItemFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}