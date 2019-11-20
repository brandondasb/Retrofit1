package com.example.retrofit1;

public class CatFact {
    private String _id;
    private String text;
    private String type;
    private User user;
    private int upvotes;

    public String get_Id() {
        return _id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public User getUser() {
        return user;
    }

    public int getUpvotes() {
        return upvotes;
    }
}
