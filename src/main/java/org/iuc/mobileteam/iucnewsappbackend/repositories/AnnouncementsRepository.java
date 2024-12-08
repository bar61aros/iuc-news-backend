package org.iuc.mobileteam.iucnewsappbackend.repositories;

import org.iuc.mobileteam.iucnewsappbackend.models.AnnouncementsEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementsRepository {
    AnnouncementsEntity save(AnnouncementsEntity announcement);
    AnnouncementsEntity findById(String id);
    List<AnnouncementsEntity> findAll();
    long deleteAll();
    long deleteById(String id);
    List<AnnouncementsEntity> saveAll(List<AnnouncementsEntity> announcements);
    AnnouncementsEntity update(AnnouncementsEntity announcement);
}
