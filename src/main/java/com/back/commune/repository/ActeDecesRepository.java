package com.back.commune.repository;

import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.model.ActeDeces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActeDecesRepository extends JpaRepository<ActeDeces, String>{

	ActeDeces findByIdActeDeces(String idActeDeces);

	@Query(value = "SELECT * FROM acte_deces a ORDER BY a.created_date DESC LIMIT 1 ", nativeQuery = true)
	ActeDeces chercherActeDeces();

	@Query(value = "SELECT count(a.id_acte_deces) FROM acte_deces a", nativeQuery = true)
	long countByIdDeces();

    @Query("SELECT new com.back.commune.DTO.resulSet.CountByUser(a.createdBy, count(a.idActeDeces)) FROM ActeDeces a GROUP BY a.createdBy")
    List<CountByUser> countByUser();
}
