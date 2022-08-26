package com.sweb.freshnews;

public class NewsModel {

    public String heading;
    public String desc;
    public String imageUrl;
    public String dateTime;
    public String author;

    public NewsModel(String heading, String desc, String imageUrl, String dateTime, String author) {
        this.heading = heading;
        this.desc = desc;
        this.imageUrl=imageUrl;
        this.dateTime=dateTime;
        this.author=author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
