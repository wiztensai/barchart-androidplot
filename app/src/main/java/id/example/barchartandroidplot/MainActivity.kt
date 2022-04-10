package id.example.barchartandroidplot

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.androidplot.util.SeriesUtils
import com.androidplot.xy.*
import id.example.barchartandroidplot.databinding.ActivityMainBinding

lateinit var bind: ActivityMainBinding

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        setChart()
    }

    private fun setChart() {
        val seriesNumber = mutableListOf<Number>()
        for (i in 0..10) {
            val random = (0..10).random()
            seriesNumber.add(random)
        }

        val series = SimpleXYSeries(seriesNumber, SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Repetition")
        bind.plot.setDomainBoundaries(-1, series.size(), BoundaryMode.FIXED)
        bind.plot.setDomainStep(StepMode.INCREMENT_BY_VAL, 1.0)
        bind.plot.setRangeUpperBoundary(SeriesUtils.minMax(series).getMaxY().toDouble() + 1, BoundaryMode.FIXED)
        bind.plot.getGraph().setDomainGridLinePaint(null)

        val seriesFormat = MyBarFormatter(Color.argb(255,0,0,100), Color.LTGRAY)
        bind.plot.addSeries(series, seriesFormat)

        val renderer = MyBarRenderer(bind.plot)
        renderer.setBarGroupWidth(BarRenderer.BarGroupWidthMode.FIXED_GAP, 1f)
//        renderer.setBarWidth(20); <- why i dont have setBarWidth method in renderer?

        bind.plot.redraw()
    }
}