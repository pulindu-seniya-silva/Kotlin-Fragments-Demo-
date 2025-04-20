package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SettingsFragment : Fragment() {

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
        val rootView = inflater.inflate(R.layout.fragment_settings, container, false)

        val spinner: Spinner = rootView.findViewById(R.id.spinner)
        val saveButton:Button = rootView.findViewById(R.id.buttonSave)

        val viewModel = ViewModelProvider(requireActivity())[FragmentViewModel::class.java]

        saveButton.setOnClickListener {
            when(spinner.selectedItem) {
                "blank" -> {}
                "Background1" -> {viewModel.setBackgroundColor(R.color.background1)}
                "Background2" -> {viewModel.setBackgroundColor(R.color.background2)}
                "Background3" -> {viewModel.setBackgroundColor(R.color.background3)}
                "Background4" -> {viewModel.setBackgroundColor(R.color.background4)}
                "Background5" -> {viewModel.setBackgroundColor(R.color.background5)}
            }
        }

        return  rootView

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}