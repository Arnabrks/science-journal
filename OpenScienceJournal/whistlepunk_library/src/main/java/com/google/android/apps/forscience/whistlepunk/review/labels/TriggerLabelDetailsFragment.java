/*
 *  Copyright 2017 Google Inc. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.google.android.apps.forscience.whistlepunk.review.labels;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.apps.forscience.whistlepunk.R;
import com.google.android.apps.forscience.whistlepunk.filemetadata.Label;

/**
 * Details view controller for a TriggerLabel.
 */
public class TriggerLabelDetailsFragment extends LabelDetailsFragment {

    public static TriggerLabelDetailsFragment newInstance(String experimentId,
            String trialId, Label originalLabel) {
        TriggerLabelDetailsFragment result = new TriggerLabelDetailsFragment();
        Bundle args = new Bundle();
        args.putString(LabelDetailsActivity.ARG_EXPERIMENT_ID, experimentId);
        args.putString(LabelDetailsActivity.ARG_TRIAL_ID, trialId);
        args.putParcelable(LabelDetailsActivity.ARG_LABEL, originalLabel);
        result.setArguments(args);
        return result;
    }

    public TriggerLabelDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            final Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.sensor_readings_label_details_fragment, container,
                false);

        // TODO: Populate the list with trigger values.

        setupCaption(rootView);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_sensor_item_label_details, menu);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle(getActivity().getResources().getString(
                R.string.trigger_label_details_title));

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_delete);
        item.getIcon().mutate().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        super.onPrepareOptionsMenu(menu);
    }
}
