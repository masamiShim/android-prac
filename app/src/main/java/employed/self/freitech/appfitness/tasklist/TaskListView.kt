package employed.self.freitech.appfitness.tasklist

import android.content.Intent
import android.support.annotation.NonNull
import android.widget.Button
import android.widget.ListView
import employed.self.freitech.appfitness.R
import employed.self.freitech.appfitness.adapter.TodoItemListAdapter
import employed.self.freitech.appfitness.taskadd.CreateTaskActivity

class TaskListView(val activity: TaskListActivity) : TaskListContract.View {

    private lateinit var mPresenter: TaskListContract.Presenter

    // 追加するボタン
    private val mAddButton: Button = activity.findViewById(R.id.addTask)

    // タスクの一覧
    private val mTaskList: ListView = activity.findViewById(R.id.todoList)

    override fun setPresenter(@NonNull presenter: TaskListContract.Presenter) {
        mPresenter = presenter
    }

    override fun showTaskList() {
        val taskList = mPresenter.fetchTaskAll()
        mTaskList.adapter = TodoItemListAdapter(activity, taskList)
    }

    override fun moveAddTaskView() {
        // 「追加する」ボタン
        mAddButton.setOnClickListener {
            val intent = Intent(activity.baseContext, CreateTaskActivity::class.java)
            activity.startActivity(intent)
        }
    }
}