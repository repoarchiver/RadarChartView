package com.dzaitsev.radarchartview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import com.dzaitsev.widget.RadarChartView;

public class MainActivity extends AppCompatActivity {
  private int mOldProgress;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final RadarChartView chart = (RadarChartView) findViewById(R.id.radar_chart);
    final SeekBar parts = (SeekBar) findViewById(R.id.parts);
    parts.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        chart.setParts(progress);
      }
      @Override public void onStartTrackingTouch(SeekBar seekBar) {}
      @Override public void onStopTrackingTouch(SeekBar seekBar) {}
    });
    final SeekBar sectors = (SeekBar) findViewById(R.id.sectors);
    sectors.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        chart.clearSectors();
        for (int i = 0; i < progress; i++) {
          chart.addOrReplace("Sector " + i, i);
        }
      }
      @Override public void onStartTrackingTouch(SeekBar seekBar) {}
      @Override public void onStopTrackingTouch(SeekBar seekBar) {}
    });
  }
}
