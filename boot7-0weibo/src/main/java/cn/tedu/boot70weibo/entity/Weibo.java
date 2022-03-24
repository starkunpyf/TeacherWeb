package cn.tedu.boot70weibo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Weibo {
    private Integer id;
    private String content;
    private String urls;
    private String nick;
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss", timezone = "GMT+8")
    private Date created;//发布时间 导包 java.util
    private Integer userId;  //user_id

    @Override
    public String toString() {
        return "Weibo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", urls='" + urls + '\'' +
                ", nick='" + nick + '\'' +
                ", created=" + created +
                ", userId=" + userId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
