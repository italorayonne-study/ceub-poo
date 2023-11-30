package br.com.ceub.rayone.sistematizacao.domain.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ceub.rayone.sistematizacao.domain.entities.Pack;

public interface IPackRepository extends JpaRepository<Pack, UUID> {

    Optional<Package> findPackageById(UUID id);
}
