package org.iuc.mobileteam.iucnewsappbackend.repositories;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import jakarta.annotation.PostConstruct;
import org.bson.BsonDocument;
import org.bson.types.ObjectId;
import org.iuc.mobileteam.iucnewsappbackend.models.AnnouncementsEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoDBAnnouncementsRepository implements AnnouncementsRepository {
    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();

    private final MongoClient client;
    private MongoCollection<AnnouncementsEntity> announcementsCollection;

    public MongoDBAnnouncementsRepository(MongoClient client) {
        this.client = client;
    }

    @PostConstruct
    void init() {
        announcementsCollection = client.getDatabase("iuc-news-app").getCollection("announcements", AnnouncementsEntity.class);
    }

    @Override
    public AnnouncementsEntity save(AnnouncementsEntity announcement) {
        announcementsCollection.insertOne(announcement);
        return announcement;
    }

    @Override
    public List<AnnouncementsEntity> saveAll(List<AnnouncementsEntity> announcements) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> {
                announcements.forEach(a -> a.setId(new ObjectId()));
                announcementsCollection.insertMany(clientSession, announcements);
                return announcements;
            }, txnOptions);
        }
    }

    @Override
    public AnnouncementsEntity findById(String id) {
        return announcementsCollection.find(new org.bson.Document("_id", new ObjectId(id))).first();
    }

    @Override
    public List<AnnouncementsEntity> findAll() {
        return announcementsCollection.find().into(List.of());
    }

    @Override
    public long deleteAll() {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(
                    () -> announcementsCollection.deleteMany(clientSession, new BsonDocument()).getDeletedCount(), txnOptions);
        }
    }

    @Override
    public long deleteById(String id) {
        return announcementsCollection.deleteOne(new org.bson.Document("_id", new ObjectId(id))).getDeletedCount();
    }

    @Override
    public AnnouncementsEntity update(AnnouncementsEntity announcement) {
        return announcementsCollection.findOneAndReplace(new org.bson.Document("_id", announcement.getId()), announcement);
    }
}
