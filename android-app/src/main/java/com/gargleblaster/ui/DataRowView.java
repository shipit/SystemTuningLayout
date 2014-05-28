package com.gargleblaster.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

/**
 * Created by sumeet on 5/28/14.
 */

public class DataRowView extends LinearLayout {

    private TextView mDataRowNameView;
    private Spinner mDataListView;

    public DataRowView(Context context) {
        super(context);
        init();
    }

    public DataRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DataRowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    protected void init() {
        View.inflate(getContext(), R.layout.data_row, this);
        mDataRowNameView = (TextView) findViewById(R.id.data_row_name);
        mDataListView = (Spinner) findViewById(R.id.data_row_list);
    }

    public void setData(String name, int arrayResId) {
        mDataRowNameView.setText(name);

        SpinnerAdapter adapter = ArrayAdapter.createFromResource(getContext(), arrayResId, android.R.layout.simple_spinner_item);
        mDataListView.setAdapter(adapter);
    }

}
