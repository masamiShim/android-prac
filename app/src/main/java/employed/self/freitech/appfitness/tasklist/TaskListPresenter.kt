package employed.self.freitech.appfitness.tasklist

import employed.self.freitech.appfitness.domain.TodoItem
import employed.self.freitech.appfitness.repository.operator.TodoOperator

class TaskListPresenter(private val todoRepository: TodoOperator, private val view : TaskListContract.View): TaskListContract.Presenter {

    init {
        view.setPresenter(this)
    }
    override fun fetchTaskAll(): List<TodoItem> {
        return todoRepository.findAll()
    }

    override fun start() {
        // View操ってよいのか？
        view.moveAddTaskView()
        view.showTaskList()
    }

}