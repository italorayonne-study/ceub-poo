package br.com.ceub.rayone.sistematizacao.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.com.ceub.rayone.sistematizacao.domain.enums.PackStatusType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "pack")
@Table(name = "pack")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String tracking;

    @Column
    private LocalDateTime receiptDate;

    @Column
    private LocalDateTime deliveryDate;

    @Column(columnDefinition = "VARCHAR(75) CHECK (status IN ('SENT','DELIVERED', 'LATE', 'CANCELED'))")
    private PackStatusType status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime logicalExclusion;
}
