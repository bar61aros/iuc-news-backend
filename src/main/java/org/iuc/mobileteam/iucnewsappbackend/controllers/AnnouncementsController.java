package org.iuc.mobileteam.iucnewsappbackend.controllers;

import org.iuc.mobileteam.iucnewsappbackend.dtos.AnnouncementsDto;
import org.iuc.mobileteam.iucnewsappbackend.services.AnnouncementsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcements")
public class AnnouncementsController {
    private final static Logger LOGGER = LoggerFactory.getLogger(AnnouncementsController.class);
    private final AnnouncementsService announcementsService;

    public AnnouncementsController(AnnouncementsService announcementsService) {
        this.announcementsService = announcementsService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public List<AnnouncementsDto> postAnnouncements(@RequestBody List<AnnouncementsDto> announcements) {
        LOGGER.info("Received POST request to create announcements");
        return announcementsService.saveAll(announcements);
    }

    @GetMapping()
    public List<AnnouncementsDto> getAnnouncements() {
        LOGGER.info("Received GET request to fetch announcements");
        return announcementsService.getAll();
    }

    @GetMapping("/{id}")
    public AnnouncementsDto getAnnouncementById(@PathVariable String id) {
        LOGGER.info("Received GET request to fetch announcement with id: {}", id);
        return announcementsService.getById(id);
    }
    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public long deleteAnnouncements() {
        LOGGER.info("Received DELETE request to delete all announcements");
        return announcementsService.deleteAll();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final Exception handleAllExceptions(RuntimeException e) {
        LOGGER.error("Internal server error.", e);
        return e;
    }
}
