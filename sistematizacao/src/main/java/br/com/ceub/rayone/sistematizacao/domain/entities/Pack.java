package br.com.ceub.rayone.sistematizacao.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.ceub.rayone.sistematizacao.domain.enums.PackStatusType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@Check(constraints = "status IN ('SENT', 'DELIVERED', 'LATE', 'CANCELED', 'PENDENT')")
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, length = 13, nullable = false)
    private String tracking;

    @Column
    private UUID userId;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a")
    @Column(nullable = false)
    private LocalDateTime receiptDate; // Quando o pacote chega na empresa

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a", shape = Shape.STRING)
    @Column(nullable = true)
    private LocalDateTime deliveryDate; // Quando o cliente recebe o pacote

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PackStatusType status;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a", shape = Shape.STRING)
    @CreationTimestamp
    private LocalDateTime createdAt; // Quando o pacote é registrado no banco

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a", shape = Shape.STRING)
    @Column
    private LocalDateTime logicalExclusion;
}
