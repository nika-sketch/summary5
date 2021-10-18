package ge.nlatsabidze.summary5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ge.nlatsabidze.summary5.databinding.CardviewLayoutBinding

class CardViewAdapter(private val viewModel: DataViewModel, private val data: UserData): RecyclerView.Adapter<CardViewAdapter.EditTextFolder>() {

    inner class EditTextFolder(private val binding: CardviewLayoutBinding):RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: UserData.DataSubList) {
            binding.rv.layoutManager = LinearLayoutManager(binding.root.context)
            binding.rv.adapter = CardViewItemAdapter(viewModel, item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditTextFolder {
        val binding = CardviewLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EditTextFolder(binding)
    }

    override fun onBindViewHolder(holder: EditTextFolder, position: Int) {
        val item = data[position]
        holder.onBind(item)
    }

    override fun getItemCount() = data.size

}