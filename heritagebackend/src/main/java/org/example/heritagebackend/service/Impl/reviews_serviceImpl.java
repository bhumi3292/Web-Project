package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.reviews;
import org.example.heritagebackend.pojo.Reviews_pojo;
import org.example.heritagebackend.repository.Reviews_repo;
import org.example.heritagebackend.service.reviews_service;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class reviews_serviceImpl implements reviews_service {

    private final Reviews_repo reviews_repo;

    @Override
    public List<reviews> getReviews() {
        return reviews_repo.findAll();
    }

    @Override
    public Optional<reviews> getReviewsById(Long Id) {
        return reviews_repo.findById(Id);
    }

    @Override
    public reviews addReviews(Reviews_pojo ReviewsPojo) {
        reviews review = new reviews();
        review.setRating(ReviewsPojo.getRating());
        review.setComment(ReviewsPojo.getComment());
        review.setReviewDate(new Date());
        review.setProduct(ReviewsPojo.getProduct());
        review.setCustomer(ReviewsPojo.getCustomer());

        return reviews_repo.save(review);
    }

    @Override
    public reviews updateReviews(Reviews_pojo ReviewsPojo, Long id) {
        Optional<reviews> reviewsOptional = reviews_repo.findById(id);
        if (reviewsOptional.isPresent()) {
            reviews review = reviewsOptional.get();
            review.setRating(ReviewsPojo.getRating());
            review.setComment(ReviewsPojo.getComment());
            review.setReviewDate(new Date());
            review.setProduct(ReviewsPojo.getProduct());
            review.setCustomer(ReviewsPojo.getCustomer());
            return reviews_repo.save(review);
        }
        return null;
    }

    @Override
    public void deleteReviews(Long id) {
        reviews_repo.deleteById(id);
    }
}
