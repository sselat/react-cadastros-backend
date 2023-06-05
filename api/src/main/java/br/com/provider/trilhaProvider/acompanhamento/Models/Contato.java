/*

Modelagem			Banco de dados			JAVA				DTO
contato				tb_Contato				contato				contato
 

*/

package br.com.provider.trilhaProvider.acompanhamento.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "birthDate")
    private Date birthDate;

    @NotNull
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "cpf")
    private String cpf;

    @NotNull
    @Column(name = "gender")
    private String gender;

    @NotNull
    @Column(name = "cep")
    private String cep;

    @NotNull
    @Column(name = "logradouro")
    private String logradouro;

    @NotNull
    @Column(name = "houseNumber")
    private String houseNumber;

    @NotNull
    @Column(name = "bairro")
    private String bairro;

    @NotNull
    @Column(name = "complemento")
    private String complemento;

    @NotNull
    @Column(name = "cidade")
    private String cidade;

    @NotNull
    @Column(name = "uf")
    private String uf;

    @NotNull
    @Column(name = "createdBy")
    private String createdBy;
}