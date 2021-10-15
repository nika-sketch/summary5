package ge.nlatsabidze.summary5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import ge.nlatsabidze.summary5.databinding.CardviewitemLayoutBinding

class CardViewItemAdapter(private val data: UserData.DataSubList): RecyclerView.Adapter<CardViewItemAdapter.ViewHolder>() {

    companion object {
        const val firstView = 1
        const val secondView = 2
    }

    inner class ViewHolder(private val binding: CardviewitemLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: UserData.DataSubListItem) {
            binding.etInputInfo.hint = currentItem.hint

            binding.etInputInfo.doAfterTextChanged {
                currentItem.value = it.toString()
            }
            binding.etInputInfo.setText(currentItem.value)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewItemAdapter.ViewHolder {
        if (viewType == 1) {
            return ViewHolder(CardviewitemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
        return ViewHolder(CardviewitemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = data[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = data.size

    override fun getItemViewType(position: Int): Int {
        if (position == 5 || position == 6) {
            return 2
        }
        return 1
    }
}