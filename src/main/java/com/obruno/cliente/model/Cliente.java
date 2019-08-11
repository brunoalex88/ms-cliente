package com.obruno.cliente.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2)
    private String nome;

    @NotEmpty
    @Size(min = 2)
    private String sobrenome;

    @NotEmpty
    @Size(min = 11, max = 11)
    private String cpf;

    @Min(18)
    private Integer idade;

    @Size(min = 8, max = 8)
    private String cep;

    @NotEmpty
    private String numero;

}
