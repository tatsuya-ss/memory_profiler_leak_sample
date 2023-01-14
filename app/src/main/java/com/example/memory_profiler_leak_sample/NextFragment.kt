package com.example.memory_profiler_leak_sample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memory_profiler_leak_sample.databinding.FragmentNextBinding

class NextFragment : Fragment(), SelectionAdapter.Listener {

    private lateinit var binding: FragmentNextBinding

    private val adapter = SelectionAdapter(
        listOf("Android", "iOS", "その他"),
        this,
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentNextBinding>(
        inflater,
        R.layout.fragment_next,
        container,
        false
    ).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.setLayoutManager(linearLayoutManager)

        binding.recyclerView.adapter = adapter

        binding.backButton.setOnClickListener { requireActivity().finish() }
    }

    override fun onClickRow(selection: String) {
        Log.d("Tatsuya", "onClickRow: $selection")
        val intent = SelectionDetailActivity.createIntent(requireContext(), selection)
        startActivity(intent)
    }

    companion object {
        fun newInstance(): NextFragment {
            return NextFragment()
        }
    }
}