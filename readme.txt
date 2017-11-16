可滑动标签控件说明
    此控件以来ViewPager控件设计，监听ViewPager的行为，当ViewPager滚动时标签会滚动到相应位置。
    基本用法：
    1、layout中声明控件：
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <cn.richinfo.widget.pagerslidingtabstrip.PagerSlidingTabStrip
            android:id="@+id/ps"
            android:layout_width="match_parent"
            android:layout_height="50dp"
            app:pstsIndicatorColor="#FF0000"
            app:pstsIndicatorHeight="2dp" />
        <android.support.v4.view.ViewPager
            android:id="@+id/vp"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_below="@id/ps"/>
    </RelativeLayout>

    2、代码中获取，初始化数据，直接将ViewPager设置到控件中即可：
    ps = (PagerSlidingTabStrip)findViewById(R.id.ps);
    vp = (ViewPager)findViewById(R.id.vp);
    initData();
    MyAdapter adapter = new MyAdapter(this, mData);
    vp.setAdapter(adapter);
    ps.setViewPager(vp);

    3、如果你的自定义PagerAdapter实现了IconTabProvider接口，则标题栏的标签可以是一张图片，而非文字
    public interface IconTabProvider {
        int getPageIconResId(int position);//获取图片id的接口
    }