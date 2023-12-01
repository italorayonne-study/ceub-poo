package br.com.ceub.rayone.sistematizacao.services.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.ceub.rayone.sistematizacao.domain.entities.Pack;

public interface IPackService {
    void save(Pack model);

    List<Pack> findAll();

    Pack findById(UUID id);

    Pack findByTracking(String tracking);

    Pack update(Pack model);

    void deleteById(UUID id);

}
