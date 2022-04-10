package id.example.barchartandroidplot;

import com.androidplot.xy.BarRenderer;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

public class MyBarRenderer extends BarRenderer<MyBarFormatter> {

    public MyBarRenderer(XYPlot plot) {
        super(plot);
    }

     public MyBarFormatter getFormatter(int index, XYSeries series) {
        return getFormatter(series);
    }
}