package employed.self.freitech.appfitness.tasklist

import android.content.Context
import android.content.Intent
import employed.self.freitech.appfitness.BasePresenter
import employed.self.freitech.appfitness.BaseView
import employed.self.freitech.appfitness.domain.TodoItem

interface TaskListContract {

    /**
     * Viewに実装されている機能の一覧
     */
    interface View : BaseView<Presenter>{

        fun showTaskList()
        fun moveAddTaskView()
    }

    /**
     * DBとのやり取りだけでいいのか？
     */
    interface Presenter: BasePresenter {
        fun fetchTaskAll(): List<TodoItem>
    }
}