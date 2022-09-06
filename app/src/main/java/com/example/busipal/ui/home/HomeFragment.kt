package com.example.busipal.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.busipal.*
import com.example.busipal.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the layout
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnCatatanTransaksi = root.findViewById<ImageButton>(R.id.btnCatatanTransaksi)
        val btnCatatanHutang = root.findViewById<ImageButton>(R.id.btnCatatanHutang)
        val btnStokBarang = root.findViewById<ImageButton>(R.id.btnStokBarang)
        val btnDetails = root.findViewById<TextView>(R.id.textView13)

        btnCatatanTransaksi.setOnClickListener{
            startActivity(Intent(getActivity(), CatatanTransaki::class.java))
        }

        btnCatatanHutang.setOnClickListener{
            startActivity(Intent(getActivity(), CatatanHutang::class.java))
        }

        btnStokBarang.setOnClickListener{
            startActivity(Intent(getActivity(), StokBarang::class.java))
        }

        btnDetails.setOnClickListener{
            startActivity(Intent(getActivity(), AnalisisKeuangan::class.java))
        }

        val btnPilih = root.findViewById<Button>(R.id.btnPilih)
        val btnAll = root.findViewById<Button>(R.id.btnAll)
        val btnMonth = root.findViewById<Button>(R.id.btnMonth)
        val btnWeek = root.findViewById<Button>(R.id.btnWeek)
        val btnDay = root.findViewById<Button>(R.id.btnDay)

        btnFilter(btnPilih,btnAll,btnMonth, btnWeek, btnDay)

        homeViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root

    }

    private fun btnFilter(btnPilih: Button, btnAll: Button, btnMonth: Button, btnWeek: Button, btnDay: Button) {
        btnPilih.setOnClickListener {
            btnPilih.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter_active))
            btnAll.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
            btnMonth.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
            btnWeek.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
            btnDay.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
        }
        btnAll.setOnClickListener {
            btnPilih.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
            btnAll.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter_active))
            btnMonth.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
            btnWeek.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
            btnDay.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
        }
        btnMonth.setOnClickListener {
            btnPilih.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
            btnAll.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
            btnMonth.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter_active))
            btnWeek.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
            btnDay.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
        }
        btnWeek.setOnClickListener {
            btnPilih.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
            btnAll.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
            btnMonth.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
            btnWeek.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter_active))
            btnDay.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
        }
        btnDay.setOnClickListener {
            btnPilih.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
            btnAll.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
            btnMonth.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
            btnWeek.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter))
            btnDay.setBackground(getActivity()?.getDrawable(R.drawable.btn_filter_active))
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}