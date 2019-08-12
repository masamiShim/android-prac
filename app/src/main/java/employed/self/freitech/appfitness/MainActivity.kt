package employed.self.freitech.appfitness

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var chart: BarChart = bar_chart
        // チャートのデータを設定
        chart.data = BarData(getBarData())
        chart = applyAxisLeft(chart)
        chart = applyAxisRight(chart)
        chart = applyXAxis(chart)

        chart.apply {
            setDrawValueAboveBar(true)
            description.isEnabled = false
            isClickable = false
            legend.isEnabled = false
            setScaleEnabled(false)
            animateY(1200, Easing.EasingOption.Linear)
        }

        findViewById<Button>(R.id.move_todo).setOnClickListener {
            val intent = Intent(this@MainActivity, employed.self.freitech.appfitness.TaskListActivity::class.java)
            startActivity(intent)
        }

        //
    }

    private fun applyAxisLeft(chart: BarChart): BarChart {
        chart.axisLeft.apply {
            axisMinimum = 0f
            axisMaximum = 100f
            labelCount = 5
            setDrawTopYLabelEntry(true)
            setValueFormatter{ value, axis -> "" + value.toInt() }
        }
        return chart
    }

    private fun applyAxisRight(chart: BarChart): BarChart {
        chart.axisRight.apply {
            setDrawLabels(false)
            setDrawGridLines(false)
            setDrawZeroLine(false)
            setDrawTopYLabelEntry(true)
        }
        return chart
    }

    private fun applyXAxis(chart: BarChart) :BarChart {
        val labels = arrayOf("","国語", "数学", "英語")
        chart.xAxis.apply {
            valueFormatter = IndexAxisValueFormatter(labels)
            labelCount = 3
            position = XAxis.XAxisPosition.BOTTOM
            setDrawLabels(true)
            setDrawGridLines(false)
            setDrawAxisLine(true)
        }
        return chart
    }
    private fun getBarData(): ArrayList<IBarDataSet> {

        val entries = ArrayList<BarEntry>().apply {
            add(BarEntry(1f, 60f))
            add(BarEntry(2f, 80f))
            add(BarEntry(3f, 70f))
        }

        val dataSet = BarDataSet(entries, "bar").apply {
            valueFormatter = IValueFormatter{ value, _, _, _ -> "" + value.toInt() }
            isHighlightEnabled = false
            setColors(intArrayOf(R.color.material_blue, R.color.material_green, R.color.material_yellow), this@MainActivity)
        }
        val bars = ArrayList<IBarDataSet>()
        bars.add(dataSet)
        return bars
    }
}
