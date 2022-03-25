package com.example.demo;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class charts {

    public void piechart(Map<String, Long> map, String title, int top) {


        PieChart chart = new PieChartBuilder().width(1000).height(800).title(title).build();
        final int[] cnt = {map.size()};
        for (String key : map.keySet()) {
            cnt[0] -= 1;
            if (cnt[0] <= top) {
                chart.addSeries(key, map.get(key));
            }

        }

        new SwingWrapper(chart).displayChart();


    }

    public void barchart(Map<String, Integer> map,String title,String x, int top) {
        CategoryChart chart = new CategoryChartBuilder().width(1000).height(800).title(title).xAxisTitle(x).yAxisTitle("Count").build();
        List<String> s = new ArrayList<>();
        List<Integer> n = new ArrayList<>();
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        final int[] cnt = {map.size()};
        map.entrySet().forEach(entry -> {
            cnt[0] -= 1;
            if (cnt[0] <= top) {
                s.add(entry.getKey());
                n.add(Math.toIntExact(entry.getValue()));
            }
        });
        chart.addSeries("Number of jobs", s.stream().collect(Collectors.toList()), n.stream().limit(10).collect(Collectors.toList()));
        new SwingWrapper<CategoryChart>(chart).displayChart();

    }
}
