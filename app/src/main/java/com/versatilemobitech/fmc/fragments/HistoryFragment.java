package com.versatilemobitech.fmc.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.versatilemobitech.fmc.R;
import com.versatilemobitech.fmc.activities.DashboardActivity;
import com.versatilemobitech.fmc.utility.Utility;

/**
 * Created by Shankar Pilli on 11/06/2016
 */
public class HistoryFragment extends Fragment {

    public static final String TAG = "HistoryFragment";
    private DashboardActivity mParent;
    private View rootView;

    private LinearLayout ll_history;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mParent = (DashboardActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mParent.txt_fmc.setText(Utility.getResourcesString(getActivity(), R.string.history));
        mParent.txt_fmc.setTypeface(Utility.setTypeFaceRobotoRegular(getActivity()));
        rootView = inflater.inflate(R.layout.fragment_history, container, false);
        initUI();
        return rootView;

    }

    private void initUI() {
        ll_history = (LinearLayout) rootView.findViewById(R.id.ll_history);

        for (int i = 0; i < 10; i++) {
            LinearLayout layout_list_header = (LinearLayout) getActivity().getLayoutInflater().inflate(R.layout.
                    history_item, null);
            TextView txt_header = (TextView) layout_list_header.findViewById(R.id.txt_header);
            TextView txt_description = (TextView) layout_list_header.findViewById(R.id.txt_description);
            txt_description.setTypeface(Utility.setTypeFaceRobotoRegular(getActivity()));
            txt_header.setTypeface(Utility.setTypeFaceRobotoRegular(getActivity()));
            ll_history.addView(layout_list_header);
        }
    }
}
