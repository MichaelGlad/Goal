package net.glm.goal;

import android.content.Context;
import android.content.Intent;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alonz on 14/03/2018.
 */



public class ChallengesAdapter extends RecyclerView.Adapter<ChallengesAdapter.MyViewHolder> {


    private changeBackground listener;
private ArrayList<Challenge> challenges;

public static class MyViewHolder extends RecyclerView.ViewHolder{
    //UI Members
    TextView goalsTV;
    TextView leaderboardsTV;
    TextView tryoutsTV;
    TextView caloriesTV;
    ProgressBar progressBar;
    ConstraintLayout btnMapActivity;
    ConstraintLayout mainView;

    private final Context context;
    public MyViewHolder(View itemView){
        super(itemView);
        context = itemView.getContext();
        goalsTV = itemView.findViewById(R.id.goals_tv);
        leaderboardsTV= itemView.findViewById(R.id.leaderboards_tv);
        tryoutsTV = itemView.findViewById(R.id.tryouts_tv);
        caloriesTV = itemView.findViewById(R.id.calories_tv);
        progressBar = itemView.findViewById(R.id.progressBar2);
        btnMapActivity = itemView.findViewById(R.id.challenge_view);
        mainView = itemView.findViewById(R.id.mainView);

    }
}

    public ChallengesAdapter(ArrayList<Challenge> challenges, changeBackground listener) {
        this.listener=listener;
        this.challenges = challenges;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.challenges_recycler_view, parent ,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.goalsTV.setText("58%");
        holder.leaderboardsTV.setText("39th");
        holder.tryoutsTV.setText("5 times");
        holder.caloriesTV.setText("786 cal");
        holder.progressBar.setProgress(58);
        if (position == 3) {
            listener.changeBackground(position);
        }

        holder.btnMapActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.context, MapsActivity.class);
                holder.context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return challenges.size();
    }

}
