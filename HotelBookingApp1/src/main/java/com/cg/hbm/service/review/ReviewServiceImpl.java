package com.cg.hbm.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.entites.Review;
import com.cg.hbm.exceptions.review.InvalidInputDataException;
import com.cg.hbm.repository.review.ReviewRepository;


@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Override
	public List<Review> getAllReviews() {
		
		return reviewRepository.findAll();	
	}

	@Override
	public Review addReview(Review review) {
	
		return reviewRepository.save(review);
	
	}

	@Override
	public List<Review> getReviewByStarRating(int starRating) {
		return reviewRepository.getReviewByStarRating(starRating);
	}
	
	@Override
	public List<Review> getReviewByHotelId(int hotelId) {
		
		
		return reviewRepository.getReviewByHotelId(hotelId);
		
		
	}
	
	@Override
	public List<Review> getReviewByRoomId(int roomId) {
		
			return reviewRepository.getReviewByRoomId(roomId);
			}
			
	
}



