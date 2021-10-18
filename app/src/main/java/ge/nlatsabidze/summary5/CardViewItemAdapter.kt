package ge.nlatsabidze.summary5

import android.text.InputType
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import ge.nlatsabidze.summary5.databinding.CardviewitemLayoutBinding
import ge.nlatsabidze.summary5.databinding.DropDownBinding

class CardViewItemAdapter(private val viewModel: DataViewModel, val data: UserData.DataSubList): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val firstView = 1
        const val secondView = 2
    }

    inner class ViewHolder(private val binding: CardviewitemLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: UserData.DataSubListItem) {
            binding.etInputInfo.hint = currentItem.hint

            binding.etInputInfo.inputType = (InputType.TYPE_CLASS_TEXT);

            if (currentItem.hint == "Birthday") {
                binding.etInputInfo.inputType = (InputType.TYPE_CLASS_NUMBER);
            }

            viewModel.mapOfItems.value?.put(absoluteAdapterPosition,binding.etInputInfo.text.toString())

            binding.etInputInfo.doAfterTextChanged {
                currentItem.value = it.toString()
            }
            binding.etInputInfo.setText(currentItem.value)
        }
    }

    inner class SecondViewHolder(private val binding: DropDownBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindSecond(currentItem: UserData.DataSubListItem) {
            binding.etItem.hint = currentItem.hint

//            val items = listOf("Option 1", "Option 2", "Option 3", "Option 4")
//            val adapter = ArrayAdapter(binding.root.context, R.layout.drop_down, items)
//            (binding.etItem as? AutoCompleteTextView)?.setAdapter(adapter)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1) {
            ViewHolder(CardviewitemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        } else {
            SecondViewHolder(DropDownBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = data[position]
        if (holder is ViewHolder) {
            holder.bind(currentItem)
        } else if (holder is SecondViewHolder) {
            holder.bindSecond(currentItem)
        }
    }

    override fun getItemCount() = data.size

    override fun getItemViewType(position: Int): Int {
        val currentItem = data[position]
        if (currentItem.fieldType == DefineTypeEnum.INPUT.type) {
            return firstView
        }
        return secondView
    }
}