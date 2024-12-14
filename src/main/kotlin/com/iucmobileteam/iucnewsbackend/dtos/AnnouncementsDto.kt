package com.iucmobileteam.iucnewsbackend.dtos

import com.iucmobileteam.iucnewsbackend.entity.AnnouncementsEntity
import java.util.Date

data class AnnouncementsDto (
    val id: Long? = null,
    val title: String? = null,
    val content: String? = null,
    val readCount: Int? = null,
    val publishDate: Date? = null,
    val originURL: String? = null
) {
    constructor(announcement: AnnouncementsEntity): this(
        id = announcement.id,
        title = announcement.title,
        content = announcement.content,
        readCount = announcement.readCount,
        publishDate = announcement.publishDate,
        originURL = announcement.originURL
    )

    fun toAnnouncementsEntity(): AnnouncementsEntity {
        return AnnouncementsEntity(
            id = this.id,
            title = this.title,
            content = this.content,
            readCount = this.readCount,
            publishDate = this.publishDate,
            originURL = this.originURL
        )
    }
}