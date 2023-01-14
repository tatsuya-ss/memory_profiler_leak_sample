package com.example.memory_profiler_leak_sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.memory_profiler_leak_sample.databinding.RowSelectionBinding

class SelectionAdapter(
    private val selectionList: List<String>,
    private val listener: Listener,
) : RecyclerView.Adapter<SelectionAdapter.SelectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectionViewHolder {
        return SelectionViewHolder(
            LayoutInflater.from(parent.context),
            parent,
        )
    }

    override fun onBindViewHolder(holder: SelectionViewHolder, position: Int) {
        holder.set(selectionList[position])
    }

    override fun getItemCount(): Int {
        return selectionList.size
    }

    inner class SelectionViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        private val binding: RowSelectionBinding = RowSelectionBinding.inflate(
            inflater,
            parent,
            false,
        )
    ) : RecyclerView.ViewHolder(binding.root) {
        fun set(selection: String) {
            binding.tvSelectName.text = selection

            binding.clSearchSelectListRow.setOnClickListener {
                listener.onClickRow(selection)
            }
        }
    }

    interface Listener {
        fun onClickRow(selection: String)
    }
}