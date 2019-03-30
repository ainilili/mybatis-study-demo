package org.smallnico.mybatis.domain;

public class Blog {

    private String id;
    
    private String title;
    
    private String content;
    
    private Integer length;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", length=" + length + "]";
    }
    
}
