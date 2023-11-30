package br.com.ceub.rayone.sistematizacao.application.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ceub.rayone.sistematizacao.domain.entities.User;
import br.com.ceub.rayone.sistematizacao.services.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<User> create(@RequestBody User model) {

        this.userService.save(model);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);

    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {

        List<User> users = this.userService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id) {

        User user = this.userService.findById(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable UUID id, @RequestBody User request) {

        request.setId(id);

        this.userService.update(request);

        return ResponseEntity.status(HttpStatus.OK).body("Registro atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {

        this.userService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Registro excluído com sucesso");
    }
}
