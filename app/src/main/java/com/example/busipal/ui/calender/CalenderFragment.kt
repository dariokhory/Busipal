package com.example.busipal.ui.calender

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.busipal.*
import com.example.busipal.databinding.FragmentCalenderBinding
import com.example.busipal.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_calender.*

class CalenderFragment : Fragment() {

    private lateinit var calenderViewModel: CalenderViewModel
    private var _binding: FragmentCalenderBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        calenderViewModel =
            ViewModelProvider(this).get(CalenderViewModel::class.java)

        _binding = FragmentCalenderBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnPlus = root.findViewById<ImageButton>(R.id.btnPlus)
        val btnJatuhTempo = root.findViewById<ImageButton>(R.id.btnJatuhTempo)

        btnPlus.setOnClickListener {
            startActivity(Intent(getActivity(),CalenderNew::class.java))
        }

        btnJatuhTempo.setOnClickListener {
            startActivity(Intent(getActivity(),CalenderJatuhTempo::class.java))
        }



        calenderViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}