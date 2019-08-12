package employed.self.freitech.appfitness

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ListView
import employed.self.freitech.appfitness.adapter.TodoItemListAdapter
import employed.self.freitech.appfitness.domain.TodoItem

class TaskListActivity : AppCompatActivity() {

    companion object {
        const val ADD_TASK_ITEM: String = "employed.self.freitech.appfitness.ADD_TASK_ITEM"
        var TaskList: ArrayList<TodoItem> = ArrayList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        val task: String? = intent.getStringExtra(ADD_TASK_ITEM)
        task.let {
            if(!it.isNullOrBlank()) {
                TaskList.add(TodoItem(false, it!!))
            }
        }

        val todoListView = findViewById<ListView>(R.id.todoList)
        todoListView.adapter = TodoItemListAdapter(this,  TaskList)


        // 「追加する」ボタン
        findViewById<Button>(R.id.addTask).setOnClickListener {
            val intent = Intent(this@TaskListActivity, employed.self.freitech.appfitness.CreateTaskActivity::class.java)
            startActivity(intent)
        }
    }

}
