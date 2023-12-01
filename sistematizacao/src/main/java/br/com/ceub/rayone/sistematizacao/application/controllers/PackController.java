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

import br.com.ceub.rayone.sistematizacao.domain.entities.Pack;
import br.com.ceub.rayone.sistematizacao.services.PackService;

@RestController
@RequestMapping("api/v1/pack")
public class PackController {
    @Autowired
    private PackService packService;

    @PostMapping()
    public ResponseEntity<Pack> create(@RequestBody Pack request) {

        this.packService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping()
    public ResponseEntity<List<Pack>> findAll() {

        List<Pack> packs = this.packService.findAll();

        return ResponseEntity.status(HttpStatus.FOUND).body(packs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pack> findById(@PathVariable UUID id) {

        Pack pack = this.packService.findById(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(pack);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updata(@PathVariable UUID id, @RequestBody Pack request) {

        request.setId(id);

        this.packService.update(request);

        return ResponseEntity.status(HttpStatus.OK).body("Registro atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {

        this.packService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Registro excluído com sucesso");
    }
}
