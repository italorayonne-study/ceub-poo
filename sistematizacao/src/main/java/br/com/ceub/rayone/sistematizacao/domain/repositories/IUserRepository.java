package br.com.ceub.rayone.sistematizacao.domain.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ceub.rayone.sistematizacao.domain.entities.User;

public interface IUserRepository extends JpaRepository<User, UUID> {

    User findByDocument(String document);

    List<User> findByLogicalExclusion(LocalDateTime logicalExclusion);

    @Query(value = "SELECT * FROM users WHERE ID = ?1 AND logical_exclusion IS NULL", nativeQuery = true)

    User findUserByIdWhereLogicalExclusionEqualsNull(UUID id);

}
