package com.iucmobileteam.iucnewsbackend.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "announcements")
data class AnnouncementsEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val title: String? = null,

    @Column(nullable = false)
    val content: String? = null,

    @Column(nullable = false)
    val readCount: Int? = null,

    @Column(nullable = false)
    val createdAt: Date? = null,

    @Column(nullable = false)
    val originURL: String? = null
)