package employed.self.freitech.appfitness.domain

class TodoItem(var id: Int, var done: Boolean, var content: String) {
    fun doneTask(){
        this.done = true
    }

    fun unDone(){
        this.done = false
    }
    fun isDone(): Boolean {
        return this.done == true
    }
}