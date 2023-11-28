package br.com.ceub.rayone.sistematizacao.domain.repositorys;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ceub.rayone.sistematizacao.domain.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByDocument(String document);

    Optional<User> findUserById(UUID id);

}