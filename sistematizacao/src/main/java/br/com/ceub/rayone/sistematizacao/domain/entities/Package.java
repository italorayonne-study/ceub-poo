package br.com.ceub.rayone.sistematizacao.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "package")
@Table(name = "package")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String tracking;
    private LocalDateTime receiptDate;
    private LocalDateTime deliveryDate;
    private String status;
}
