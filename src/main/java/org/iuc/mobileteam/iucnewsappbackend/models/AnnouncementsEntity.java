package org.iuc.mobileteam.iucnewsappbackend.models;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.Objects;

public class AnnouncementsEntity {
    private ObjectId id;
    private String title;
    private String content;
    private int readCount;
    private Date createdAt;
    private String originURL;

    public AnnouncementsEntity() {
    }

    public AnnouncementsEntity(ObjectId id, String title, String content, int readCount, Date createdAt, String originURL) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.readCount = readCount;
        this.createdAt = createdAt;
        this.originURL = originURL;
    }

    public ObjectId getId() {
        return id;
    }

    public AnnouncementsEntity setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AnnouncementsEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public AnnouncementsEntity setContent(String content) {
        this.content = content;
        return this;
    }

    public int getReadCount() {
        return readCount;
    }

    public AnnouncementsEntity setReadCount(int readCount) {
        this.readCount = readCount;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public AnnouncementsEntity setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getOriginURL() {
        return originURL;
    }

    public AnnouncementsEntity setOriginURL(String originURL) {
        this.originURL = originURL;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnnouncementsEntity that = (AnnouncementsEntity) o;

        if (readCount != that.readCount) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(content, that.content)) return false;
        if (!Objects.equals(createdAt, that.createdAt)) return false;
        return Objects.equals(originURL, that.originURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, readCount, createdAt, originURL);
    }
}
