package com.example.retweet;

public class Tweet {
    String username;
    String tweet_content;

    public Tweet(String username, String tweet_content){
        this.username=username;
        this.tweet_content=tweet_content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTweet_content() {
        return tweet_content;
    }

    public void setTweet_content(String tweet_content) {
        this.tweet_content = tweet_content;
    }
}
