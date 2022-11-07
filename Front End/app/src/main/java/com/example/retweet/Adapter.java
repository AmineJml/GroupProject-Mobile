package com.example.retweet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.alltweets>{

        Context context;
        List<Tweet> listTweets;

    public Adapter(Context context, List<Tweet> listTweets){
        this.context = context;
        this.listTweets = listTweets;
    }

    @NonNull
    @Override
    public alltweets onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tweet, parent, false);
        alltweets alltweets = new alltweets(view);
        return alltweets;
    }

    @Override
    public void onBindViewHolder(@NonNull alltweets holder, int position) {
        Tweet tweet = listTweets.get(position);
        holder.username.setText(tweet.getUsername());
        holder.tweet_content.setText(tweet.getTweet_content());
    }

    @Override
    public int getItemCount() {
        return listTweets.size();
    }

    public class alltweets extends RecyclerView.ViewHolder {
        TextView username, tweet_content;
        public alltweets(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.showUsername);
            tweet_content = itemView.findViewById(R.id.showTweet);
        }
    }
}
