package com.example.scroll_viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FrameLayout02 extends ScBaseFragment {
    ListView list_view02;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmment02, null);
        list_view02 =view.findViewById(R.id.list_view02);

        return view;
    }

    @Override
    public View getScrollableView() {
        return list_view02;
    }
}
