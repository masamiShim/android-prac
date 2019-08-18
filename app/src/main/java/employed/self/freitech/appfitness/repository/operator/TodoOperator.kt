package employed.self.freitech.appfitness.repository.operator

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import employed.self.freitech.appfitness.domain.TodoItem
import employed.self.freitech.appfitness.repository.TodoRepository

class TodoOperator(mContext: Context) {
    private val db: SQLiteDatabase
    private val todoRepository: TodoRepository = TodoRepository(mContext)

    init {
        db = todoRepository.writableDatabase
    }

    fun exists(id: Int): Boolean {
        // プレースホルダー
        val selectSql: String = "SELECT count(*) as cnt from ${TodoRepository.TABLE_NAME} where id = ?"
        val cursor: Cursor = db.rawQuery(selectSql, arrayOf(id.toString()))

        // cursor操作
        cursor.use { c ->
            c.moveToFirst()
            val count = cursor.getInt(cursor.getColumnIndex("cnt"))
            return count > 0

        }
    }

    fun findAll(): List<TodoItem> {
        // プレースホルダー
        val selectSql: String = "SELECT *  from ${TodoRepository.TABLE_NAME}"
        val cursor: Cursor = db.rawQuery(selectSql, null)

        // cursor操作
        // use使うとclosableなものはcloseしてくれるらしい
        cursor.use { c ->
            c.moveToFirst()
            // 全件取得
            return IntRange(0, cursor.count - 1).map { toItem(cursor, it) }.toList()
        }
    }

    private fun toItem(cursor: Cursor, pos: Int): TodoItem {
        cursor.moveToPosition(pos)
        val id = cursor.getInt(cursor.getColumnIndex("id"))
        val done = cursor.getInt(cursor.getColumnIndex("done")) != 0
        val context = cursor.getString(cursor.getColumnIndex("content"))
        return TodoItem(id, done, context)
    }

    fun save(content: String) {
        val values = ContentValues()
        values.put("content", content)
        // まじめにやるならdoneもenumで作るか
        values.put("done", false)

        db.insertOrThrow(TodoRepository.TABLE_NAME, null, values)
    }
}