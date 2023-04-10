package com.example.overtestdemo01.Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;
/*自定义高度可自动计算的ExpandableListView*/
public class MyExpandableListView extends ExpandableListView {
    public MyExpandableListView(Context context) {
        super(context);
    }

    public MyExpandableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyExpandableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyExpandableListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {

        super(context, attrs, defStyleAttr, defStyleRes);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
