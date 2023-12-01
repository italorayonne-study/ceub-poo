package br.com.ceub.rayone.sistematizacao.domain.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ceub.rayone.sistematizacao.domain.entities.Pack;
import java.time.LocalDateTime;

public interface IPackRepository extends JpaRepository<Pack, UUID> {

    Pack findByTracking(String tracking);

    List<Pack> findByLogicalExclusion(LocalDateTime logicalExclusion);

    @Query(value = "SELECT * FROM pack WHERE ID = ?1 AND logical_exclusion IS NULL", nativeQuery = true)
    Pack findByIdWhereLogicalExclusionEqualsNull(UUID id);
}
