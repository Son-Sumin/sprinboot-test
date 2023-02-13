package com.bitacademy.cocktail.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.bitacademy.cocktail.domain.ReviewSignature;
import com.bitacademy.cocktail.domain.Signature;
import com.bitacademy.cocktail.repository.ReviewSignatureRepository;
import com.bitacademy.cocktail.repository.SignatureRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewSignatureService {
	
	private final ReviewSignatureRepository reviewSignatureRepository;

	/* 해당 시그니처 게시글 댓글 리스트 */
	public List<ReviewSignature> listReviewSignature(@PathVariable("no") Long no) {
		return reviewSignatureRepository.findBySignatureNo(no);
	}
	
	/* 시그니처 댓글 작성 */
	public void add(ReviewSignature form) {		
		
		ReviewSignature reviewSignature = new ReviewSignature();
		
		reviewSignature.setNickname(form.getNickname());
		reviewSignature.setContents(form.getContents());
		reviewSignature.setSignature(form.getSignature());
		
		reviewSignatureRepository.save(reviewSignature);
		
		System.out.println(reviewSignature + "######################");
	}

	/* 시그니처 게시글 댓글 삭제 */
	public void delete(Long no) {
		reviewSignatureRepository.deleteByNo(no);
	}
}
