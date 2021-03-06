package com.ulan.timetable.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ulan.timetable.Adapters.Week2Adapter;
import com.ulan.timetable.Adapters.WeekAdapter;
import com.ulan.timetable.R;
import com.ulan.timetable.Utils.DbHelper;
import com.ulan.timetable.Utils.FragmentHelper;

import org.lucasr.twowayview.TwoWayView;


public class FridayWeekFragment extends Fragment {

    public static final String KEY_FRIDAY_FRAGMENT = "Friday";
    private DbHelper db;
    private ListView listView;
    private Week2Adapter adapter;
    private TwoWayView listItem;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_week_friday, container, false);
        setupAdapter(view);

        //setupListViewMultiSelect();
        return view;
    }

    private void setupAdapter(View view) {
        db = new DbHelper(getActivity());
        listItem = view.findViewById(R.id.fridayweeklist);
        adapter = new Week2Adapter(getActivity(), listItem, R.layout.listview_week_adapter2, db.getWeek(KEY_FRIDAY_FRAGMENT));
        listItem.setAdapter(adapter);
        //listView = view.findViewById(R.id.fridayweeklist);
        //adapter = new Week2Adapter(getActivity(), listView, R.layout.listview_week_adapter2, db.getWeek(KEY_FRIDAY_FRAGMENT));
        //listView.setAdapter(adapter);
    }

    private void setupListViewMultiSelect() {
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        //listView.setMultiChoiceModeListener(FragmentHelper.setupListViewMultiSelect(getActivity(), listView, adapter, db));
    }
}
