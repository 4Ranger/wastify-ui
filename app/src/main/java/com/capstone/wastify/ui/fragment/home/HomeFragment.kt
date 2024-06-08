package com.capstone.wastify.ui.fragment.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstone.wastify.R
import com.capstone.wastify.data.Location
import com.capstone.wastify.data.NewsLocal
import com.capstone.wastify.databinding.FragmentHomeBinding
import com.capstone.wastify.ui.activity.PersonActivity
import com.capstone.wastify.ui.adapter.NewsAdapter

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val list = ArrayList<NewsLocal>()


    private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    val root: View = binding.root

      binding.ivPerson.setOnClickListener {
          val intentPerson = Intent(requireActivity(), PersonActivity::class.java)
          startActivity(intentPerson)
      }

      binding.rvNews.setHasFixedSize(true)

      list.addAll(getListNews())
      showRecyclerList()

    return root
  }

    private fun getListNews(): ArrayList<NewsLocal> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPublisher = resources.getStringArray(R.array.data_publisher)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listNews = ArrayList<NewsLocal>()
        for (i in dataName.indices) {
            val news = NewsLocal(dataName[i], dataPublisher[i], dataPhoto.getResourceId(i,-1))
            listNews.add(news)
        }
        return listNews
    }

    private fun showRecyclerList() {
        binding.rvNews.layoutManager = LinearLayoutManager(requireActivity())
        val listNewsAdapter = NewsAdapter(list)
        binding.rvNews.adapter = listNewsAdapter
    }



override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}