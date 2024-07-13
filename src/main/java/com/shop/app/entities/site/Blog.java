package com.shop.app.entities.site;

import com.shop.app.enums.BlogStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String subTitle;
    private String description;
    private String image;
    private long visitCount;
    private Date publishDate;
    private BlogStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(long visitCount) {
        this.visitCount = visitCount;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public BlogStatus getStatus() {
        return status;
    }

    public void setStatus(BlogStatus status) {
        this.status = status;
    }
}
