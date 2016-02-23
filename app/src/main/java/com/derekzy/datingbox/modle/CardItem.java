package com.derekzy.datingbox.modle;

import java.io.Serializable;

/**
 * Created by derekzy on 2016/2/20.
 */
public class CardItem implements Serializable {
    private int id;
    private String content;
    private String tag;
    private Integer level;
    private Boolean fav;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getTag() {
        return tag;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    public Integer getLevel() {
        return level;
    }

    public void setFav(Boolean isFav) {
        this.fav = isFav;
    }
    public Boolean getFav() {
        return fav;
    }
}
