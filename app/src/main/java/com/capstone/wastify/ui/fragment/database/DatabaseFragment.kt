package com.capstone.wastify.ui.fragment.database

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.capstone.wastify.R
import com.capstone.wastify.data.NewsLocal
import com.capstone.wastify.data.Sampah
import com.capstone.wastify.databinding.FragmentDatabaseBinding
import com.capstone.wastify.databinding.FragmentHomeBinding
import com.capstone.wastify.ui.adapter.SampahAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DatabaseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DatabaseFragment : Fragment() {

    private var _binding: FragmentDatabaseBinding? = null
    private val list = ArrayList<Sampah>()
    private val binding get() = _binding!!
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

        _binding = FragmentDatabaseBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // Inflate the layout for this fragment
        list.addAll(getListSampah())
        showRecyclerList()
        return root
    }

    private fun getListSampah(): ArrayList<Sampah> {
        val dataName = resources.getStringArray(R.array.data_sampah_name)
        val dataDescription = resources.getStringArray(R.array.data_sampah_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_sampah_photo)
        val listSampah = ArrayList<Sampah>()
        for (i in dataName.indices) {
            val sampah = Sampah(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listSampah.add(sampah)
        }
        return listSampah
    }

    private fun showRecyclerList() {
        binding.rvDatabase.layoutManager = GridLayoutManager(requireActivity(),2)
        val sampahAdapter = SampahAdapter(list)
        binding.rvDatabase.adapter = sampahAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DatabaseFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DatabaseFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}