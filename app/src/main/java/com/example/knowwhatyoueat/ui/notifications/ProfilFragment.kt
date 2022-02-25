package com.example.knowwhatyoueat.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.knowwhatyoueat.databinding.FragmentProfilBinding

class ProfilFragment : Fragment() {

    private lateinit var profilViewModel: ProfilViewModel
    private var _binding: FragmentProfilBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profilViewModel =
            ViewModelProvider(this).get(ProfilViewModel::class.java)

        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        val root: View = binding.root
/*
        val textView: TextView = binding.textNotifications
        profilViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

 */
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}