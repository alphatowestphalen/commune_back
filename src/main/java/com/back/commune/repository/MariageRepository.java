package com.back.commune.repository;


import com.back.commune.model.mariage.Mariage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MariageRepository extends JpaRepository<Mariage, Long> {

	@Query(value = "SELECT * FROM mariage m ORDER BY m.created_date DESC LIMIT 1 ", nativeQuery = true)
	Mariage chercherMariage();

	Mariage findByIdMariage(String idMariage);

	Page<Mariage> findAll( Pageable pageable);

	@Query(value = "SELECT count(m.id_mariage) FROM mariage m", nativeQuery = true)
	long countByIdMariage();

}
