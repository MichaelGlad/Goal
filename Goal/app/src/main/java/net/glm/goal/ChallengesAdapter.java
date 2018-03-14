package net.glm.goal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by alonz on 14/03/2018.
 */

public class ChallengesAdapter extends RecyclerView.Adapter<ChallengesAdapter.MyViewHolder> {

private ArrayList<Challenge> challenges;

public static class MyViewHolder extends RecyclerView.ViewHolder{

    public MyViewHolder(View itemView){
        super(itemView);

    }
}

    public ChallengesAdapter(ArrayList<Challenge> challenges) {
        this.challenges = challenges;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.challenges_recycler_view, parent ,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return  myViewHolder;
    }




    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return challenges.size();
    }
}
