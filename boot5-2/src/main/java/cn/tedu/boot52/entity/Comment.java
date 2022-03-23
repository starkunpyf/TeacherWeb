package cn.tedu.boot52.entity;

public class Comment {
    private Integer id;
    private String content;
    private String nick;
    private Integer weiboId;
    /*
   create table comment(id int primary key auto_increment,
   content varchar(255),nick varchar(50),weibo_id int)charset=utf8;
    **/

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", nick='" + nick + '\'' +
                ", weiboId=" + weiboId +
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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(Integer weiboId) {
        this.weiboId = weiboId;
    }
}
