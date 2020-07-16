package com.example.scroll_viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /**
     * ScrollableLayout  +viewpager
     * 固定标签栏在顶部
     * @param savedInstanceState
     */

    ScrollableLayout slRoot;
    ViewPager vpScroll;
    RelativeLayout ly_page1,ly_page2;
    private final List<ScBaseFragment> fragmentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initClick();

    }
    private void initView() {
        slRoot =findViewById(R.id.sl_root);
        vpScroll =findViewById(R.id.vp_scroll);
        ly_page1 =findViewById(R.id.ly_page1);
        ly_page2 =findViewById(R.id.ly_page2);
        //viewpager 添加fragment
        FrameLayout01 layout01 = new FrameLayout01();
        FrameLayout02 layout02 = new FrameLayout02();
        fragmentList.add(layout01);
        fragmentList.add(layout02);
        CommonFragementPagerAdapter commonFragementPagerAdapter = new CommonFragementPagerAdapter(getSupportFragmentManager());
        vpScroll.setAdapter(commonFragementPagerAdapter);
        //重要1：
        slRoot.getHelper().setCurrentScrollableContainer(fragmentList.get(0));

        vpScroll.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                //重要2：
                slRoot.getHelper().setCurrentScrollableContainer(fragmentList.get(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public void initClick(){
        ly_page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpScroll.setCurrentItem(0);
            }
        });

        ly_page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpScroll.setCurrentItem(1);
            }
        });
    }

    public class CommonFragementPagerAdapter extends FragmentPagerAdapter {

        public CommonFragementPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return getCount() > position ? fragmentList.get(position) : null;
        }

        @Override
        public int getCount() {
            return fragmentList == null ? 0 : fragmentList.size();
        }
    }


}
