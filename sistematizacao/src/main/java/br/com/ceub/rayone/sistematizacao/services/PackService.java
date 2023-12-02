package br.com.ceub.rayone.sistematizacao.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.ceub.rayone.sistematizacao.domain.entities.Pack;
import br.com.ceub.rayone.sistematizacao.domain.helpers.GeneratePackTrackingCode;
import br.com.ceub.rayone.sistematizacao.domain.repositories.IPackRepository;
import br.com.ceub.rayone.sistematizacao.domain.utils.Utils;
import br.com.ceub.rayone.sistematizacao.services.interfaces.IPackService;

@Service
public class PackService implements IPackService {

    @Autowired
    private IPackRepository packRepository;

    @Override
    public void save(Pack model) {
        Pack pack = this.packRepository.findByTracking(model.getTracking());

        GeneratePackTrackingCode trackingCode = new GeneratePackTrackingCode();

        if (pack != null) {

            if (pack.getLogicalExclusion() != null)
                throw new ResponseStatusException(HttpStatus.CONFLICT,
                        "Já existe um registro com os mesmos valores únicos.");

            model.setId(pack.getId());
            model.setTracking(trackingCode.generate());

            this.packRepository.save(model);

        } else {

            model.setTracking(trackingCode.generate());
            this.packRepository.save(model);
        }
    }

    @Override
    public List<Pack> findAll() {
        List<Pack> packes = this.packRepository.findByLogicalExclusion(null);

        return packes;
    }

    @Override
    public Pack findById(UUID id) {

        Pack pack = this.packRepository.findByIdWhereLogicalExclusionEqualsNull(id);

        if (pack == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Nenhum pacote encontrado com os critérios de pesquisa fornecidos");
        }

        return pack;
    }

    @Override
    public Pack findByTracking(String tracking) {
        return this.packRepository.findByTracking(tracking);
    }

    @Override
    public Pack update(Pack model) {

        Pack pack = this.findById(model.getId());

        if (pack == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Nenhum pacote encontrado com os critérios de pesquisa fornecidos");
        }

        // Utils.copyNonNullProperties(model, pack);

        return this.packRepository.save(model);
    }

    @Override
    public void deleteById(UUID id) {
        Pack pack = this.findById(id);

        if (pack == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Nenhum pacote encontrado com os critérios de pesquisa fornecidos");
        }

        pack.setLogicalExclusion(LocalDateTime.now());

        this.packRepository.save(pack);
    }
}
