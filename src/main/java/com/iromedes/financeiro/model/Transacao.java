package com.iromedes.financeiro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*; // Importante para as travas
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O tipo é obrigatório")
    private String tipo;

    @NotNull(message = "O valor é obrigatório")
    @Positive(message = "O valor deve ser positivo")
    private Double valor;

    private String descricao;

    @NotNull(message = "A data é obrigatória")
    private LocalDate data;
}