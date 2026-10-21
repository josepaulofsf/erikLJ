package com.eriklj.lavajato.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.*;

@Entity 
@Data
@Table(name = "tb_lavagem")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter 
@Setter
public class Lavagem {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne 
    @JoinColumn(name = "id_cliente")
    private Usuario cliente;

    @Column(name = "tipo", nullable = false)
    @JsonProperty("tipoLavagem")
    @Enumerated(EnumType.STRING)
    private TipoLavagem tipoLavagem;

    @Column(name = "data", nullable = false)
    @JsonProperty("data")
    private LocalDate data;

    @Column(name = "hora", nullable = false)
    @JsonProperty("hora")
    private LocalTime hora;
}
