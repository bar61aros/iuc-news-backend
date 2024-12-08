package org.iuc.mobileteam.iucnewsappbackend.services;

import org.iuc.mobileteam.iucnewsappbackend.dtos.AnnouncementsDto;
import org.iuc.mobileteam.iucnewsappbackend.repositories.AnnouncementsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementsServiceImpl implements AnnouncementsService{
    private final AnnouncementsRepository announcementsRepository;

    public AnnouncementsServiceImpl(AnnouncementsRepository announcementsRepository) {
        this.announcementsRepository = announcementsRepository;
    }

    @Override
    public List<AnnouncementsDto> getAll() {
        return announcementsRepository.findAll().stream().map(AnnouncementsDto::new).toList();
    }

    @Override
    public AnnouncementsDto getById(String id) {
        return new AnnouncementsDto(announcementsRepository.findById(id));
    }

    @Override
    public AnnouncementsDto create(AnnouncementsDto announcement) {
        return new AnnouncementsDto(announcementsRepository.save(announcement.toAnnouncementsEntity()));
    }

    @Override
    public AnnouncementsDto update(String id, AnnouncementsDto announcement) {
        return new AnnouncementsDto(announcementsRepository.update(announcement.toAnnouncementsEntity()));
    }

    @Override
    public long deleteAll() {
        return announcementsRepository.deleteAll();
    }

    @Override
    public List<AnnouncementsDto> saveAll(List<AnnouncementsDto> announcements) {
        return announcementsRepository.saveAll(announcements.stream().map(AnnouncementsDto::toAnnouncementsEntity).toList())
                                      .stream()
                                      .map(AnnouncementsDto::new)
                                      .toList();
    }
}
