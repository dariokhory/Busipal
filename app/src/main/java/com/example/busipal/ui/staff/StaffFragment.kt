package com.example.busipal.ui.staff

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
import com.example.busipal.databinding.FragmentStaffBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StaffFragment : Fragment() {

    private lateinit var staffViewModel: StaffViewModel
    private var _binding: FragmentStaffBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        staffViewModel =
            ViewModelProvider(this).get(StaffViewModel::class.java)

        _binding = FragmentStaffBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnStaffList = root.findViewById<Button>(R.id.btnStaffList)
        val btnStaffNew = root.findViewById<FloatingActionButton>(R.id.btnStaffNew)

        btnStaffList.setOnClickListener{
            startActivity(Intent(getActivity(), StaffManagementList::class.java))
        }
        btnStaffNew.setOnClickListener{
            startActivity(Intent(getActivity(), StaffManagementNew::class.java))
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}