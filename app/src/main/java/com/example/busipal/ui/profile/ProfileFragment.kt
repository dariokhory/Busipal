package com.example.busipal.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.busipal.*
import com.example.busipal.databinding.FragmentHomeBinding
import com.example.busipal.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.activity_service.*

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel
    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnKartuNama = root.findViewById<ImageButton>(R.id.btnKartuNama)
        val btnUnduhLaporan = root.findViewById<ImageButton>(R.id.btnUnduhLaporan)
        val btnAnalisa = root.findViewById<ImageButton>(R.id.btnAnalisa)
        val btnSimulasiPajak = root.findViewById<ImageButton>(R.id.btnSimulasiPajak)
        val btnLogOut = root.findViewById<LinearLayout>(R.id.btnLogOut)

        btnKartuNama.setOnClickListener{
            startActivity(Intent(getActivity(), KartuNama::class.java))
        }

        btnUnduhLaporan.setOnClickListener{
            startActivity(Intent(getActivity(), UnduhLaporan::class.java))
        }

        btnAnalisa.setOnClickListener{
            startActivity(Intent(getActivity(), AnalisisKeuangan::class.java))
        }

        btnSimulasiPajak.setOnClickListener{
            startActivity(Intent(getActivity(), SimulasiPajak::class.java))
        }

        btnLogOut.setOnClickListener{
            stopMyService
            startActivity(Intent(getActivity(), MainActivity::class.java))
        }

        profileViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}