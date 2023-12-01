package br.com.ceub.rayone.sistematizacao.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.ceub.rayone.sistematizacao.domain.entities.User;
import br.com.ceub.rayone.sistematizacao.domain.repositories.IUserRepository;
import br.com.ceub.rayone.sistematizacao.services.interfaces.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public void save(User model) {

        User user = this.repository.findByDocument(model.getDocument());

        if (user == null) {

            this.repository.save(model);
            return;
        }

        if (user.getLogicalExclusion() != null) {

            model.setId(user.getId());

            this.repository.save(model);

        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Já existe um registro com os mesmos valores únicos.");
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = this.repository.findByLogicalExclusion(null);

        return users;
    }

    @Override
    public User findById(UUID id) {

        User user = this.repository.findUserByIdWhereLogicalExclusionEqualsNull(id);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Nenhum usuário encontrado com os critérios de pesquisa fornecidos.");
        }

        return user;
    }

    @Override
    public User findByDocument(String document) {
        return this.repository.findByDocument(document);
    }

    @Override
    public void deleteById(UUID id) {

        User user = this.findById(id);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Nenhum usuário encontrado com os critérios de pesquisa fornecidos.");
        }

        user.setLogicalExclusion(LocalDateTime.now());

        this.repository.save(user);
    }

    @Override
    public User update(User model) {

        User user = this.findById(model.getId());

        if (user == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Nenhum usuário encontrado com os critérios de pesquisa fornecidos.");

        return this.repository.save(model);
    }

}
