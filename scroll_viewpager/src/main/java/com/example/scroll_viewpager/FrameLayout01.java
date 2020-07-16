package com.example.scroll_viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FrameLayout01 extends ScBaseFragment {
    ListView list_view01;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01, null);
        list_view01 =view.findViewById(R.id.list_view01);
        return view;
    }

    @Override
    public View getScrollableView() {
        return list_view01;
    }
}
