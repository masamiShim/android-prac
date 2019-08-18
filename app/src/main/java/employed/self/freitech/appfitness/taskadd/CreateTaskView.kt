package employed.self.freitech.appfitness.taskadd

import android.content.Intent
import android.widget.Button
import android.widget.TextView
import employed.self.freitech.appfitness.R
import employed.self.freitech.appfitness.tasklist.TaskListActivity
import kotlinx.android.synthetic.main.activity_create_task.view.*
import org.w3c.dom.Text

class CreateTaskView(val activity: CreateTaskActivity): CreateTaskContract.View {

    private val mText: TextView
    private val mAddButton: Button

    init{
        mText = activity.findViewById(R.id.editText)
        mAddButton = activity.findViewById(R.id.addTask)
    }

    override fun isNotEmpty(): Boolean {
        return mText.text.toString().isNotEmpty()
    }

    override fun showErrorMessage() {
        mText.error = "タスクを入力してください。"
    }

    private lateinit var mPresent: CreateTaskContract.Presenter

    override fun addButtonClicked() {
        mAddButton.setOnClickListener {
            mPresent.saveTodo(mText.text.toString())
        }
    }

    override fun setPresenter(presenter: CreateTaskPresenter) {
        mPresent = presenter
    }

    override fun moveListView(){
        val intent = Intent(activity.applicationContext, TaskListActivity::class.java)
        activity.startActivity(intent)

    }
}