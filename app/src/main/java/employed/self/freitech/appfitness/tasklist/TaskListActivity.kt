package employed.self.freitech.appfitness.tasklist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import employed.self.freitech.appfitness.R
import employed.self.freitech.appfitness.repository.operator.TodoOperator

class TaskListActivity : AppCompatActivity() {


    private lateinit var taskListPresenter: TaskListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        // ほんとはTaskListViewなんていらないんではないか。。。
        taskListPresenter = TaskListPresenter(TodoOperator(this), TaskListView(this))
        taskListPresenter.start()
      }
}
