package org.example.heritagebackend.service;

import org.example.heritagebackend.Entity.reviews;
import org.example.heritagebackend.pojo.Reviews_pojo;

import java.util.List;
import java.util.Optional;

public interface reviews_service {
    List<reviews> getReviews();
    Optional<reviews> getReviewsById(Long Id);
    reviews addReviews(Reviews_pojo ReviewsPojo);
    reviews updateReviews(Reviews_pojo ReviewsPojo, Long id);
    void deleteReviews(Long id);
}
