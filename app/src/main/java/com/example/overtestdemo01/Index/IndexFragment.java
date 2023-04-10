package com.example.overtestdemo01.Index;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.overtestdemo01.Bean.ChapterBean;
import com.example.overtestdemo01.R;
import com.example.overtestdemo01.Utils.CircleProgressView;
import com.example.overtestdemo01.Utils.MyCircleProgress;
import com.example.overtestdemo01.Utils.PixChangeDp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class IndexFragment extends Fragment {


    private View v;
    private CircleProgressView mCircleBar;
    private static final String TAG = "Test1Activity";

    private boolean _threadFlag = false;

    private TextView all_topic;

    private ExpandableListView ep_lv;
    private Map<ChapterBean, List<ChapterBean>> topicMap;
    private List<ChapterBean> parentTitle;
    private MyCircleProgress myCircleProgress;


    @Override
    public void onDestroy() {
        _threadFlag = true;
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_index, container, false);

        initWidget();

        InitCircleProgress();


        /*下拉标题*/
        initTopicData();        /*初始化标题数据*/
        initExpandableList();

        return v;
    }

    /*方法*/
    /*圆形进度条*/
    public void InitCircleProgress() {


        Thread thread = new Thread(() -> {
//            int chose_num_all = 0;        //选择的总共题数
//            int topic_num_all = 0;        //总共有的题数
//
//            all_topic.setText(topic_num_all + "\n" + "总题数");    //总题数


//            getActivity().runOnUiThread(() -> myCircleProgress.SetCurrent(0));
            myCircleProgress.SetCurrent(10);
        });
        thread.start();


    }


    /*可拓展ListView*/
    public void initExpandableList(){
        ep_lv.setAdapter(new myEpListView());
        ep_lv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(getActivity(), "你点击了" + groupPosition, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        ep_lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getActivity(), "你点击了" + groupPosition+"的"+childPosition, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    /*初始化组件*/
    public void initWidget() {
        all_topic = (TextView) v.findViewById(R.id.all_topic);
        ep_lv = (ExpandableListView) v.findViewById(R.id.ep_lv);
        myCircleProgress = v.findViewById(R.id.simple);
    }

    /*初始化标题数据*/
    public void initTopicData() {
        //存储一级标题和二级标题
        topicMap = new HashMap<>();
        //存储二级标题
        parentTitle = new ArrayList<>();

        //parentTitle = new String[]{"计算机组成与结构","程序语言","操作系统"};
        List<ChapterBean> childrenTitle1 = new ArrayList<>();
        List<ChapterBean> childrenTitle2 = new ArrayList<>();
        List<ChapterBean> childrenTitle3 = new ArrayList<>();

        parentTitle.add(new ChapterBean("计算机组成与结构", 198, 141));
        parentTitle.add(new ChapterBean("程序语言", 132, 0));
        parentTitle.add(new ChapterBean("操作系统", 136, 15));

        childrenTitle1.add(new ChapterBean("计算机基本工作原理", 198, 141));
        childrenTitle1.add(new ChapterBean("存储系统", 198, 141));
        childrenTitle1.add(new ChapterBean("总线系统", 198, 141));
        childrenTitle1.add(new ChapterBean("输入输出系统", 198, 141));
        childrenTitle1.add(new ChapterBean("指令系统和计算机体系结构", 198, 141));
        childrenTitle1.add(new ChapterBean("系统性能评测和可靠性基础", 198, 141));
        childrenTitle1.add(new ChapterBean("信息安全和病毒防护", 198, 141));

        childrenTitle2.add(new ChapterBean("信息安全和病毒防护", 198, 141));
        childrenTitle2.add(new ChapterBean("信息安全和病毒防护", 198, 141));
        childrenTitle2.add(new ChapterBean("信息安全和病毒防护", 198, 141));
        childrenTitle2.add(new ChapterBean("信息安全和病毒防护", 198, 141));
        childrenTitle2.add(new ChapterBean("信息安全和病毒防护", 198, 141));


        childrenTitle3.add(new ChapterBean("信息安全和病毒防护", 198, 141));
        childrenTitle3.add(new ChapterBean("信息安全和病毒防护", 198, 141));
        childrenTitle3.add(new ChapterBean("信息安全和病毒防护", 198, 141));
        childrenTitle3.add(new ChapterBean("信息安全和病毒防护", 198, 141));


        topicMap.put(parentTitle.get(0), childrenTitle1);
        topicMap.put(parentTitle.get(1), childrenTitle2);
        topicMap.put(parentTitle.get(2), childrenTitle3);
    }




    /*继承的类*/
    public class myEpListView extends BaseExpandableListAdapter {
        //  获得父项的数量
        @Override
        public int getGroupCount() {
            return topicMap.size();
        }

        //  获得某个父项的子项数目
        @Override
        public int getChildrenCount(int groupPosition) {
            return topicMap.get(parentTitle.get(groupPosition)).size();
        }

        //  获得某个父项
        @Override
        public Object getGroup(int groupPosition) {
            return null;
        }

        //  获得某个父项的某个子项
        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return null;
        }

        //  获得某个父项的id
        @Override
        public long getGroupId(int groupPosition) {
            return 0;
        }

        //  获得某个父项的某个子项的id
        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return 0;
        }

        //  按函数的名字来理解应该是是否具有稳定的id，这个方法目前一直都是返回false，没有去改动过
        @Override
        public boolean hasStableIds() {
            return false;
        }

        //  获得父项显示的view
        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            View v = LayoutInflater.from(getActivity()).inflate(R.layout.lo_primary_itle, null);
            RelativeLayout rl_item = (RelativeLayout) v.findViewById(R.id.rl_item);
            ImageView level_one_drop_down = (ImageView) v.findViewById(R.id.level_one_drop_down);
            ImageView enter_topic = (ImageView) v.findViewById(R.id.enter_topic);
            TextView level_one_title = (TextView) v.findViewById(R.id.level_one_title);
            TextView topic_rate = (TextView) v.findViewById(R.id.topic_rate);
            ProgressBar progress_bar = (ProgressBar) v.findViewById(R.id.progress_bar);

//            level_one_drop_down.setImageResource(R.drawable.user_head);
            level_one_title.setText(parentTitle.get(groupPosition).getTitle());
            topic_rate.setText(parentTitle.get(groupPosition).getNum() + "");
            progress_bar.setProgress(parentTitle.get(groupPosition).getChose_num() * 100 / parentTitle.get(groupPosition).getNum());
            return v;
        }

        //  获得子项显示的view
        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            View v = LayoutInflater.from(getActivity()).inflate(R.layout.lo_list_view_item, null);
            RelativeLayout rl_item = (RelativeLayout) v.findViewById(R.id.rl_item);
            ImageView level_two_drop_down = (ImageView) v.findViewById(R.id.level_two_drop_down);
            ImageView enter_topic = (ImageView) v.findViewById(R.id.enter_topic);
            TextView level_two_title = (TextView) v.findViewById(R.id.level_two_title);
            TextView topic_rate = (TextView) v.findViewById(R.id.topic_rate);
            ProgressBar progress_bar = (ProgressBar) v.findViewById(R.id.progress_bar);

            level_two_drop_down.setImageResource(R.drawable.arrow_right);
            level_two_title.setText(topicMap.get(parentTitle.get(groupPosition)).get(childPosition).getTitle() + "");
            topic_rate.setText(topicMap.get(parentTitle.get(groupPosition)).get(childPosition).getNum() + "");
            progress_bar.setProgress(topicMap.get(parentTitle.get(groupPosition)).get(childPosition).getChose_num() * 100 / topicMap.get(parentTitle.get(groupPosition)).get(childPosition).getNum());
            return v;
        }

        //  子项是否可选中，如果需要设置子项的点击事件，需要返回true
        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}



/*圆形进度条*/
//    private void initViews() {
//
//        mCircleBar = (CircleProgressView) v.findViewById(R.id.circleProgressbar);
//
//        mCircleBar.setProgress(50);
//
//    }


