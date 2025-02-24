package com.trabajoFinal.GameVerseBackEnd.repositories;

import com.trabajoFinal.GameVerseBackEnd.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
