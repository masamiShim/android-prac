package employed.self.freitech.appfitness.taskadd

import employed.self.freitech.appfitness.repository.operator.TodoOperator

class CreateTaskPresenter(private val todoRepository: TodoOperator, private val view: CreateTaskContract.View) :
    CreateTaskContract.Presenter {

    override fun saveTodo(content: String) {
        if (view.isNotEmpty()) {
            todoRepository.save(content)
            view.moveListView()
        } else {
            view.showErrorMessage()
        }
    }

    override fun start() {
        view.addButtonClicked()
    }
}