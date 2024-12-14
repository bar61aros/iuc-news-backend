package com.iucmobileteam.iucnewsbackend.repository

import com.iucmobileteam.iucnewsbackend.entity.AnnouncementsEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AnnouncementsRepository: JpaRepository<AnnouncementsEntity, Long>