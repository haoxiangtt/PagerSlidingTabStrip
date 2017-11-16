package cn.richinfo.widget.demo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.richinfo.widget.pagerslidingtabstrip.PagerSlidingTabStrip;

public class MainActivity extends AppCompatActivity {

    private PagerSlidingTabStrip ps;
    private ViewPager vp;
    private ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ps = (PagerSlidingTabStrip)findViewById(R.id.ps);
        vp = (ViewPager)findViewById(R.id.vp);
        initData();
        MyAdapter adapter = new MyAdapter(this, mData);
        vp.setAdapter(adapter);
        ps.setViewPager(vp);
    }

    private void initData() {
        mData = new ArrayList<String>();
        mData.add("第1章");
        mData.add("第2章");
        mData.add("第3章");
        mData.add("第4章");
        mData.add("第5章");
        mData.add("第6章");
        mData.add("第7章");
        mData.add("第8章");
        mData.add("第9章");
    }

    static class MyAdapter extends PagerAdapter{

        List<String> mDataList;
        private android.content.Context mContext;

        public MyAdapter(Context context, List<String> dataList){
            super();
            mContext = context;
            mDataList = dataList;
        }

        @Override
        public int getCount() {
            return mDataList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(mContext);
            tv.setText(mDataList.get(position));
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            tv.setGravity(Gravity.CENTER);
            tv.setLayoutParams(lp);
            container.addView(tv);
            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mDataList.get(position);
        }
    }
}
