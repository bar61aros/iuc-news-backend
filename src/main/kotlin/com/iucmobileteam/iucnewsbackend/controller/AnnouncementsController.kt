package com.iucmobileteam.iucnewsbackend.controller

import com.iucmobileteam.iucnewsbackend.entity.AnnouncementsEntity
import com.iucmobileteam.iucnewsbackend.service.AnnouncementsService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("announcements")
class AnnouncementsController (private val announcementsService: AnnouncementsService) {
    @GetMapping
    fun getAnnouncements() = announcementsService.getAnnouncements()

    @GetMapping("{id}")
    fun getAnnouncementById(id: Long) = announcementsService.getAnnouncementById(id)

    @PostMapping("create")
    fun createAnnouncement(@RequestBody announcement: AnnouncementsEntity): AnnouncementsEntity = announcementsService.createAnnouncement(announcement)

    @PutMapping("update")
    fun updateAnnouncement(announcement: AnnouncementsEntity): AnnouncementsEntity = announcementsService.updateAnnouncement(announcement)

    @DeleteMapping("delete")
    fun deleteAnnouncement(id: Long) = announcementsService.deleteAnnouncement(id)
}