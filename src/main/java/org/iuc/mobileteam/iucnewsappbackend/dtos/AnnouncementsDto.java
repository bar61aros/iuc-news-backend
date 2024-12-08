package org.iuc.mobileteam.iucnewsappbackend.dtos;

import org.bson.types.ObjectId;
import org.iuc.mobileteam.iucnewsappbackend.models.AnnouncementsEntity;

import java.util.Date;

public record AnnouncementsDto (
        String id,
        String title,
        String content,
        int readCount,
        Date createdAt,
        String originURL
) {
   public AnnouncementsDto(AnnouncementsEntity a){
       this(a.getId().toHexString(), a.getTitle(), a.getContent(), a.getReadCount(), a.getCreatedAt(), a.getOriginURL());
   }
   public AnnouncementsEntity toAnnouncementsEntity(){
       ObjectId _id = id == null ? new ObjectId() : new ObjectId(id);
         return new AnnouncementsEntity(_id, title, content, readCount, createdAt, originURL);
   }
}
