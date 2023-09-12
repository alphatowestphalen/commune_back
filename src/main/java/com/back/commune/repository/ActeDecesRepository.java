package com.back.commune.repository;

import com.back.commune.model.ActeDeces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActeDecesRepository extends JpaRepository<ActeDeces, Long>{

	ActeDeces findByIdActeDeces(String idActeDeces);

	@Query(value = "SELECT * FROM acte_deces a ORDER BY a.created_date DESC LIMIT 1 ", nativeQuery = true)
	ActeDeces chercherActeDeces();


	@Query(value = "SELECT count(a.id_acte_deces) FROM acte_deces a", nativeQuery = true)
	long countByIdDeces();
}
