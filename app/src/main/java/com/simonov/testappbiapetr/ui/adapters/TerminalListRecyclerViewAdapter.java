package com.simonov.testappbiapetr.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.simonov.testappbiapetr.R;
import com.simonov.testappbiapetr.api.TerminalResponse;
import com.simonov.testappbiapetr.ui.DestinationFragment.OnListFragmentInteractionListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TerminalListRecyclerViewAdapter extends RecyclerView.Adapter<TerminalListRecyclerViewAdapter.ViewHolder> {

    private final List<TerminalResponse> mTerminalList;
    private final OnListFragmentInteractionListener mListener;

    public TerminalListRecyclerViewAdapter(List<TerminalResponse> items, OnListFragmentInteractionListener listener) {
        mTerminalList = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.mTerminal = mTerminalList.get(position);
        holder.mName.setText(mTerminalList.get(position).getName());
        holder.mAddress.setText(mTerminalList.get(position).getAddress());

        Glide.with(holder.mMap.getContext())
                .load(mTerminalList.get(position).getMapUrl())
                .into(holder.mMap);

        holder.mContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mListener.onListFragmentInteraction(holder.mTerminal);
                holder.mRadioButton.setSelected(!holder.mRadioButton.isSelected());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTerminalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_item_container)
        View mContainer;
        @BindView(R.id.radio_button)
        TextView mRadioButton;
        @BindView(R.id.name_text_view)
        TextView mName;
        @BindView(R.id.address_text_view)
        TextView mAddress;
        @BindView(R.id.timetable_text_view)
        TextView mTimetable;
        @BindView(R.id.map_image_view)
        ImageView mMap;

        TerminalResponse mTerminal;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
//            view.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//            mRadioButton.setEnabled(!mRadioButton.isSelected());
//        }
    }
}
