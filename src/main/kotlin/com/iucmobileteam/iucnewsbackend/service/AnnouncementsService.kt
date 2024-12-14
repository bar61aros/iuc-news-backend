package com.iucmobileteam.iucnewsbackend.service

import com.iucmobileteam.iucnewsbackend.entity.AnnouncementsEntity
import com.iucmobileteam.iucnewsbackend.repository.AnnouncementsRepository
import org.springframework.stereotype.Service

@Service
class AnnouncementsService(private val announcementsRepository: AnnouncementsRepository) {
    fun getAnnouncements() = announcementsRepository.findAll()

    fun getAnnouncementById(id: Long) = announcementsRepository.findById(id)

    fun createAnnouncement(announcement: AnnouncementsEntity) = announcementsRepository.save(announcement)

    fun updateAnnouncements(annoucements: List<AnnouncementsEntity>) = announcementsRepository.saveAll(annoucements)

    fun deleteAllAnnouncements() = announcementsRepository.deleteAll()
}