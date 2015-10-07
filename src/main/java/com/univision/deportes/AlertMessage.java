package com.univision.deportes;

/**
 * Created by jbjohn on 10/7/15.
 */
public class AlertMessage {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
