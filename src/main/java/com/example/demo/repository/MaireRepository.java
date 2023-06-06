package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Maire;
@Repository
public interface MaireRepository extends JpaRepository<Maire, Long> {

	@Modifying
    @Query(value ="UPDATE maire SET deleted = false WHERE id_maire = :idMaire", nativeQuery = true)
    void restoreMaire(@Param("idMaire") Long idMaire);
	
	
	@Query(value="DELETE FROM maire WHERE deleted = true AND id_maire=:idMaire", nativeQuery=true)
	void supprdefinitive(@Param("idMaire") Long idMaire);
}
