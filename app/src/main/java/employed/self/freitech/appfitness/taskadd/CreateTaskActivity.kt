package employed.self.freitech.appfitness.taskadd

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import employed.self.freitech.appfitness.R
import employed.self.freitech.appfitness.repository.operator.TodoOperator
import employed.self.freitech.appfitness.tasklist.TaskListActivity

class CreateTaskActivity : AppCompatActivity() {

    lateinit private var todoDB: TodoOperator

    private lateinit var mCreateTaskPresenter: CreateTaskContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

        // DB呼び出し(このタイミングでデータなければ呼び出してる？)
        mCreateTaskPresenter = CreateTaskPresenter(TodoOperator(this), CreateTaskView(this))
        mCreateTaskPresenter.start()

        // 追加ボタン(追加できたら一覧へ戻る)
        findViewById<Button>(R.id.addTask).setOnClickListener {
            val inputText = findViewById<TextView>(R.id.editText)
            if (inputText.text.isNotEmpty()) {
                // データ追加
                todoDB.save(inputText.text.toString())
                //intent.putExtra(TaskListActivity.ADD_TASK_ITEM, inputText.text.toString())
                val intent = Intent(applicationContext, TaskListActivity::class.java)
                startActivity(intent)
            } else {
                inputText.error = "タスクを入力してください。"
            }
        }

    }

}
