package com.obruno.cliente.enums;

public enum SexoEnum {

    M("Masculino"),
    F("Feminino");

    SexoEnum(String sexo) {
        this.sexo = sexo;
    }

    private String sexo;

}
