package com.example.knowwhatyoueat.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.knowwhatyoueat.MainActivity
import com.example.knowwhatyoueat.ProductView
import com.example.knowwhatyoueat.R
import com.example.knowwhatyoueat.databinding.FragmentHomeBinding

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
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(layoutInflater)
        val root: View = binding.root
/*
        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })


 */
        val textView = binding.tvTest
        binding.buTest.setOnClickListener {
            // Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(requireActivity().getApplicationContext())
            val url = "https://world.openfoodfacts.org/api/v0/product/737628064502"

            // Request a string response from the provided URL.
            val stringRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                Response.Listener { response ->
                    val productViewActivity = Intent(getActivity(), ProductView::class.java)
                    productViewActivity.putExtra("response", response.toString())
                    startActivity(productViewActivity)
                    //textView.text = "${response.toString().substring(0, 500)}"
                },
                Response.ErrorListener { textView.text = "Dat hat nich geklappt :("})

            // Add the request to the RequestQueue.
            queue.add(stringRequest)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}