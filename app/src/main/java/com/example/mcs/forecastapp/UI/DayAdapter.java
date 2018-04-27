package com.example.mcs.forecastapp.UI;

import android.arch.lifecycle.LiveData;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mcs.forecastapp.Model.DayModel;
import com.example.mcs.forecastapp.R;
import com.example.mcs.forecastapp.databinding.DayCardviewBinding;

import java.util.List;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.DayViewHolder>{

    private List<DayModel> dayList;


    public DayAdapter(List<DayModel> dayList){
        this.dayList=dayList;
    }

    //sets the days and updays the recyclerview
    public void setDayList(List<DayModel> dayList){
        this.dayList=dayList;
        notifyDataSetChanged();
    }

    /***
     * creates a new binding util for each cardview in recycler
     * @return the DayViewHolder with that new binding util
     ***/
    @Override
    public DayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DayCardviewBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.day_cardview,
                        parent, false);

        return new DayViewHolder(binding);
    }

    /***
     *binds the given day in the list to its appropiate cardview laylout
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(DayViewHolder holder, int position) {
        holder.binding.setDay(dayList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return dayList == null ? 0 : dayList.size();
    }

    //Creates the DayViewHolder for the recyclerview and sets the auto generated Binding Util
    static class DayViewHolder extends RecyclerView.ViewHolder {

        final DayCardviewBinding binding;

        DayViewHolder(DayCardviewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
