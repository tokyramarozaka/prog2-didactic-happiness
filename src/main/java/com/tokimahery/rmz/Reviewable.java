package com.tokimahery.rmz;

import java.util.List;

public interface Reviewable {
    void addReview(Review toAdd);
    List<Review> getReviews();
}
