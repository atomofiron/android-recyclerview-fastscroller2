package lib.atomofiron.recyclerview.fastscroller2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LabelAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long = -1

    override fun getItemCount() = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_labels, parent, false)
        return object : RecyclerView.ViewHolder(itemView) { }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = Unit
}
