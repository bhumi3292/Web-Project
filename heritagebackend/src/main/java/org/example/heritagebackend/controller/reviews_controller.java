//
//package org.example.heritagebackend.controller;
//
//import org.example.heritagebackend.Entity.reviews;
//import org.example.heritagebackend.pojo.Reviews_pojo;
//import org.example.heritagebackend.service.reviews_service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/reviews")
//public class reviews_controller {
//
//    @Autowired
//    private reviews_service reviewsService;
//
//    @GetMapping
//    public List<reviews> getAllReviews() {
//        return reviewsService.getReviews();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<reviews> getReviewById(@PathVariable Long id) {
//        Optional<reviews> review = reviewsService.getReviewsById(id);
//        return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<reviews> addReview(@RequestBody Reviews_pojo reviewsPojo) {
//        reviews newReview = reviewsService.addReviews(reviewsPojo);
//        return ResponseEntity.ok(newReview);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<reviews> updateReview(@RequestBody Reviews_pojo reviewsPojo, @PathVariable Long id) {
//        reviews updatedReview = reviewsService.updateReviews(reviewsPojo, id);
//        return ResponseEntity.ok(updatedReview);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
//        reviewsService.deleteReviews(id);
//        return ResponseEntity.noContent().build();
//
//    }
//}
