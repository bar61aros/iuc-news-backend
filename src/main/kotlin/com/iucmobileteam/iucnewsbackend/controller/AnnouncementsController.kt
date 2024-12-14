package com.iucmobileteam.iucnewsbackend.controller

import com.iucmobileteam.iucnewsbackend.dtos.AnnouncementsDto
import com.iucmobileteam.iucnewsbackend.entity.AnnouncementsEntity
import com.iucmobileteam.iucnewsbackend.service.AnnouncementsService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("announcements")
class AnnouncementsController (private val announcementsService: AnnouncementsService) {
    @GetMapping
    fun getAnnouncements(): MutableList<AnnouncementsEntity> = announcementsService.getAnnouncements()

    @GetMapping("{id}")
    fun getAnnouncementById(@PathVariable id: Long): Optional<AnnouncementsEntity> = announcementsService.getAnnouncementById(id)

    @PostMapping()
    fun createAnnouncement(@RequestBody announcement: AnnouncementsDto): AnnouncementsEntity = announcementsService.createAnnouncement(announcement.toAnnouncementsEntity())

    @PostMapping("bulk")
    fun updateAnnouncements(@RequestBody announcements: List<AnnouncementsDto>): MutableList<AnnouncementsEntity> = announcementsService.updateAnnouncements(announcements.map { it.toAnnouncementsEntity() })

    @DeleteMapping()
    fun deleteAllAnnouncements() = announcementsService.deleteAllAnnouncements()
}