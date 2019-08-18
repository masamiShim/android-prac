package employed.self.freitech.appfitness.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class TodoRepository(var context: Context) : SQLiteOpenHelper(context, "sample_db", null, 1) {
    companion object{
        val TABLE_NAME = "Todo"
    }

    /** テーブル作成 */
    override fun onCreate(db: SQLiteDatabase?) {
        val todoTableCreateSQL: StringBuilder = StringBuilder()
        todoTableCreateSQL.append("")
            .append("CREATE TABLE $TABLE_NAME (")
            .append(" id INTEGER PRIMARY KEY AUTOINCREMENT").append(",")
            .append(" content TEXT").append(",")
            .append(" done BIT")
            .append(");")

        db?.execSQL(todoTableCreateSQL.toString())
        Log.i(TABLE_NAME,"テーブルが作成されました");
    }

    /** テーブルDROP & CREATE */
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME;")
        onCreate(db)
    }
}