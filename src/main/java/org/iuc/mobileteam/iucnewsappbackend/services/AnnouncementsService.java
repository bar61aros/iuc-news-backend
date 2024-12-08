package org.iuc.mobileteam.iucnewsappbackend.services;

import org.iuc.mobileteam.iucnewsappbackend.dtos.AnnouncementsDto;

import java.util.List;

public interface AnnouncementsService {
    List<AnnouncementsDto> getAll();
    AnnouncementsDto getById(String id);
    AnnouncementsDto create(AnnouncementsDto announcement);
    AnnouncementsDto update(String id, AnnouncementsDto announcement);
    long deleteAll();
    List<AnnouncementsDto> saveAll(List<AnnouncementsDto> announcements);
}
