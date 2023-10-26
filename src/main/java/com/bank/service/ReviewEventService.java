package com.bank.service;

import com.bank.exceptions.ResourceNotFoundException;
import com.bank.models.ReviewEvent;
import com.bank.repositories.ReviewEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewEventService {
    private final ReviewEventRepository reviewEventRepository;

    public ReviewEvent getById(Long id){
        return reviewEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ReviewLandmark wiht this id not found!"));
    }

    public List<ReviewEvent> getAll(){
        return reviewEventRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id){
        getById(id);
        reviewEventRepository.deleteById(id);
    }

    @Transactional
    public ReviewEvent save(ReviewEvent reviewEvent){
        reviewEvent.setLikes(0L);
        reviewEventRepository.save(reviewEvent);
        return reviewEvent;
    }

    @Transactional
    public ReviewEvent update(Long id, ReviewEvent reviewEvent){
        reviewEvent.setId(id);
        System.out.println(reviewEvent.getId());
        return reviewEventRepository.save(reviewEvent);
    }

    @Transactional
    public ReviewEvent putLikeForReview(Long reviewId){
        ReviewEvent reviewEvent = getById(reviewId);
        reviewEvent.setLikes(reviewEvent.getLikes()+1);
        reviewEventRepository.save(reviewEvent);
        return reviewEvent;
    }

}
