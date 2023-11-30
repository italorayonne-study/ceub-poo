package br.com.ceub.rayone.sistematizacao.services.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.ceub.rayone.sistematizacao.domain.entities.User;

public interface IUserService {
    void save(User model);

    List<User> findAll();

    User findById(UUID id);

    User findByDocument(String document);

    User update(User model);

    void deleteById(UUID id);
}
