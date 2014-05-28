package com.gargleblaster.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import static android.widget.LinearLayout.LayoutParams;


public class MainActivity extends Activity {

    private static class DataRow {
        String name;
        int resId;

        public DataRow(String name, int resId) {
            this.name = name;
            this.resId = resId;
        }
    }

    private static DataRow [] LEFT_DATA =
            new DataRow[] {
                    new DataRow("Zone Dead Time (ms)", R.array.some_ints),
                    new DataRow("CM Heart Beat Interval", R.array.some_mins),
                    new DataRow("Auto Mode Change Over Multiplier", R.array.some_temps),
                    new DataRow("Rebalance Hold Time", R.array.some_mins),
                    new DataRow("Min Cooling Airflow Temp", R.array.some_ints),
                    new DataRow("Min Heating Airflow Temp", R.array.some_mins)
            };

    private static DataRow [] RIGHT_DATA =
            new DataRow[] {
                    new DataRow("Building To Zone Differential (F)", R.array.some_temps),
                    new DataRow("Heart Beats to Skip", R.array.some_ints),
                    new DataRow("Auto Away Time (mins)", R.array.some_mins)
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillData((LinearLayout) findViewById(R.id.left), LEFT_DATA);
        fillData((LinearLayout)findViewById(R.id.right), RIGHT_DATA);
    }

    private void fillData(LinearLayout layout, DataRow [] data) {
        for (DataRow s : data) {
            DataRowView rowView = new DataRowView(MainActivity.this);
            rowView.setData(s.name, s.resId);
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layout.addView(rowView, params);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
