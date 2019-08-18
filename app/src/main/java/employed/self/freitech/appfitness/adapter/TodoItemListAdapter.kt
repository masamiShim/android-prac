package employed.self.freitech.appfitness.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import employed.self.freitech.appfitness.R
import employed.self.freitech.appfitness.domain.TodoItem

class TodoItemListAdapter(
    private val activity: Activity,
    private val items: List<TodoItem>
) : BaseAdapter() {

    val layoutInflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    @SuppressLint("ResourceType")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = layoutInflater.inflate(R.layout.row_list_todo, parent, false)
        val item = getItem(position)
        view.findViewById<TextView>(R.id.done).setText(item.isDone().toString())
        view.findViewById<TextView>(R.id.content).setText(item.content)
        return view
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): TodoItem {
        return items[position]
    }

}