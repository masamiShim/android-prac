package employed.self.freitech.appfitness.taskadd

import employed.self.freitech.appfitness.BasePresenter
import employed.self.freitech.appfitness.BaseView
import employed.self.freitech.appfitness.domain.TodoItem

interface CreateTaskContract {
    interface View: BaseView<CreateTaskPresenter> {
        fun addButtonClicked()
        fun isNotEmpty(): Boolean
        fun showErrorMessage()
        fun moveListView()
    }

    interface Presenter: BasePresenter {
        fun saveTodo(item: String)
    }
}