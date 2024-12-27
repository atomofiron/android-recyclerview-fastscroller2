package lib.atomofiron.recyclerview.fastscroller2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

private const val COUNT = 1024
private val items = Array(COUNT) { "Demo Item $it" }.toList()
private val checked = BooleanArray(COUNT)

class ItemAdapter : ListAdapter<String, ItemViewHolder>(ItemCallback) {

    init {
        setHasStableIds(true)
        submitList(items)
    }

    override fun getItemId(position: Int): Long = position.toLong()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val holder = ItemViewHolder(itemView)
        holder.checkbox.setOnCheckedChangeListener { _, isChecked ->
            if (holder.bindingAdapterPosition in checked.indices) {
                checked[holder.bindingAdapterPosition] = isChecked
            }
        }
        return holder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.title.text = getItem(position)
        holder.checkbox.isChecked = checked[position]
    }
}

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.title)
    val checkbox: CheckBox = itemView.findViewById(R.id.checkbox)
}

private object ItemCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem
    override fun areContentsTheSame(oldItem: String, newItem: String) = true
}