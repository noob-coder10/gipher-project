package com.gipher.wishlist.repository;

import java.util.List;

import com.gipher.wishlist.model.Favourite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepository extends MongoRepository<Favourite, String> {

    public List<Favourite> findByEmailId(String emailId);
}