package net.glm.goal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ORAN on 15/03/2018.
 */

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.LevelHolder> {

    private ArrayList<Level> levels;
    Context context;

    public LevelAdapter(ArrayList<Level> levels, Context context) {
        this.levels = levels;
        this.context = context;
    }

    @Override
    public LevelHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_levels, parent, false);
        LevelHolder levelHolder = new LevelHolder(view);

        return levelHolder;
    }

    @Override
    public void onBindViewHolder(LevelHolder holder, int position) {
    }


    @Override
    public int getItemCount() {
        return levels.size();
    }

    class LevelHolder extends RecyclerView.ViewHolder {
        public LevelHolder(View itemView) {
            super(itemView);
        }
    }
}
