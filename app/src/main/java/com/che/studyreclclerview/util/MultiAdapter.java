package com.che.studyreclclerview.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：余天然 on 16/7/14 下午2:32
 */
public abstract class MultiAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<T> items = new ArrayList<>();

    public MultiAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public Context getContext() {
        return context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(getLayoutId(viewType), parent, false));
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        bindData(holder, items.get(position), getItemViewType(position));
    }

    @Override
    public int getItemViewType(int position) {
        return setViewType(items.get(position));
    }


    public abstract int setViewType(T t);

    public abstract int getLayoutId(int viewType);

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected abstract void bindData(ViewHolder holder, T item, int viewType);


    public void setData(List<T> list) {
        this.items = list;
        notifyDataSetChanged();
    }

}