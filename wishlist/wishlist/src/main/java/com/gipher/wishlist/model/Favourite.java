package com.gipher.wishlist.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "favourites")
public class Favourite {

    @Id
    private String favId;
    private String username;
    private String emailId;
    private String title;
    private String imageURL;
    private int isSticker;

    public Favourite() {
        super();
    }

    public Favourite(String favId, String username, String emailId, String title, String imageURL, int isSticker) {
        super();
        this.favId = favId;
        this.username = username;
        this.emailId = emailId;
        this.title = title;
        this.imageURL = imageURL;
        this.isSticker = isSticker;
    }




}