package employed.self.freitech.appfitness

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.TextView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IValueFormatter
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import kotlinx.android.synthetic.main.activity_main.*

class CreateTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

        // 追加ボタン(追加できたら一覧へ戻る)
        findViewById<Button>(R.id.addTask).setOnClickListener {
            val inputText = findViewById<TextView>(R.id.editText)
            if (inputText.text.isNotEmpty()) {
                val intent = Intent(applicationContext, employed.self.freitech.appfitness.TaskListActivity::class.java)
                intent.putExtra(TaskListActivity.ADD_TASK_ITEM, inputText.text.toString())
                startActivity(intent)
            } else {
                inputText.error = "タスクを入力してください。"
            }
        }

    }

}
