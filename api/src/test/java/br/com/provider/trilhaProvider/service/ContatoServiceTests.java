package br.com.provider.trilhaProvider.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.provider.trilhaProvider.acompanhamento.DTO.ContatoDto;
import br.com.provider.trilhaProvider.acompanhamento.Models.Contato;
import br.com.provider.trilhaProvider.acompanhamento.Repository.ContatoRepository;
import br.com.provider.trilhaProvider.acompanhamento.service.ContatoService;

public class ContatoServiceTests {

        private ContatoService gestorService;

        @Mock
        private ContatoRepository gestorRepository;

        @Before
        public void setupMock() {

                MockitoAnnotations.initMocks(this);
                gestorService = new ContatoService();
                gestorService.setContatoRepository(gestorRepository);
        }

        private Contato criarGestorGet(Long id) {
                Contato contato = new Contato();

                contato.setId(id);
                contato.setName("Nome");
                contato.setBirthDate(new Date());

                return contato;
        }

        private ContatoDto criarDto(Contato contato) {

                ContatoDto retorno = new ContatoDto();

                retorno.setId(contato.getId());
                retorno.setName(contato.getName());
                retorno.setBirthDate(contato.getBirthDate());

                return retorno;
        }

        @Test
        public void testGetContatoDTO() throws Exception {

                ContatoDto contato = new ContatoDto();

                contato.setId(1);

                contato.setName("igor");

                contato.setPhone("(11)987047186");

                contato.setCpf("9123812388");

                contato.setGender("Masculino");

                contato.setCep("832182383218");

                contato.setLogradouro("casa do chapeu");

                contato.setBairro(" burguesia ");

                contato.setUf("SP");

                contato.setHouseNumber("666");

                contato.setCidade("Disney");

                contato.setComplemento("Casa do mickey ");

                contato.setBirthDate(java.sql.Date.valueOf(LocalDate.now()));

                ///
                when(gestorService.GetGestorID(1L)).thenReturn(contato);
                mockMvc.perform(get("/contatos/1")) /// mock é uma simulação de uma classe que vc queira testar
                                .andExpect(status().isOk()) /// ele tem um retorno, ele ta esperando o retorno do status
                                                            /// OK
                                /// .andExpect(jsonPath("$.Id_Contato").value(contato.getId_Contato()))
                                .andExpect(jsonPath("$.nome").value(contato.getNome()))
                                .andExpect(jsonPath("$.dataNiver", is(LocalDate.now().toString())))
                                .andExpect(jsonPath("$.telefone").value(contato.getTelefone()))
                                .andExpect(jsonPath("$.cpf").value(contato.getCpf()))
                                .andExpect(jsonPath("$.genero").value(contato.getGenero()))
                                .andExpect(jsonPath("$.cep").value(contato.getCep()))
                                .andExpect(jsonPath("$.logradouro").value(contato.getLogradouro()))
                                .andExpect(jsonPath("$.bairro").value(contato.getBairro()))
                                .andExpect(jsonPath("$.uf").value(contato.getUf()))
                                .andExpect(jsonPath("$.number").value(contato.getNumber()))
                                .andExpect(jsonPath("$.localidade").value(contato.getLocalidade()))
                                .andExpect(jsonPath("$.complemento").value(contato.getComplemento()))
                                .andDo(print());
                /// e faça isso para finalizar
        }

}
