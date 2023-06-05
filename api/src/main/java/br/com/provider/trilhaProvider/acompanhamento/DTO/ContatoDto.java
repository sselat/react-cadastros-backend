package br.com.provider.trilhaProvider.acompanhamento.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class ContatoDto {
    private long id;
    private String name;
    private Date birthDate;
    private String phone;
    private String cpf;
    private String gender;
    private String cep;
    private String logradouro;
    private String houseNumber;
    private String bairro;
    private String complemento;
    private String cidade;
    private String uf;
    private String createdBy;
}
