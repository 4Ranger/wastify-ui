package com.capstone.wastify.ui.fragment.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.wastify.R
import com.capstone.wastify.data.Location
import com.capstone.wastify.data.NewsLocal
import com.capstone.wastify.databinding.FragmentHomeBinding
import com.capstone.wastify.databinding.FragmentLocationBinding
import com.capstone.wastify.ui.adapter.LocationAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LocationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LocationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentLocationBinding? = null
    private val list = ArrayList<Location>()

    private val binding get() = _binding!!

    private lateinit var rvLocation: Location
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

        _binding = FragmentLocationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.rvLocation.setHasFixedSize(true)

        list.addAll(getListLocation())
        showRecyclerList()

        return root
    }

    private fun getListLocation(): ArrayList<Location> {
        val dataName = resources.getStringArray(R.array.data_location)
        val dataDescription = resources.getStringArray(R.array.data_location_description)
        val listLocation = ArrayList<Location>()
        for (i in dataName.indices) {
            val location = Location(dataName[i], dataDescription[i])
            listLocation.add(location)
        }

        return listLocation
    }

    private fun showRecyclerList() {
        binding.rvLocation.layoutManager = LinearLayoutManager(requireActivity())
        val listLocationAdapter = LocationAdapter(list)
        binding.rvLocation.adapter = listLocationAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LocationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LocationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}