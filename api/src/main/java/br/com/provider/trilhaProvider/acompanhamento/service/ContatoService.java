
package br.com.provider.trilhaProvider.acompanhamento.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.provider.trilhaProvider.acompanhamento.DTO.ContatoDto;
import br.com.provider.trilhaProvider.acompanhamento.Models.Contato;
import br.com.provider.trilhaProvider.acompanhamento.Repository.ContatoRepository;

@Service
public class ContatoService {

    /**     
     */
    @Autowired
    ContatoRepository contatoRepository;

    /**
     * @param id
     * @return
     */
    public ContatoDto GetGestorID(Long id) {
        Optional<Contato> optional = contatoRepository.findById(id);
        if (optional.isPresent()) {
            return ConvertContatoDTO(optional.get());
        }
        return null;
    }

    public void setContatoRepository(ContatoRepository gestorRepository) {
        this.contatoRepository = gestorRepository;
    }

    public ContatoDto save(ContatoDto gestorDto) {
        Contato contato = ConvertGestor(gestorDto);
        return ConvertContatoDTO(contatoRepository.save(contato));
    }

    public List<ContatoDto> GetAll() {
        // comentario vazio
        return convertListToDto(contatoRepository.findAll());
    }

    private Contato ConvertGestor(ContatoDto gestorDto) {
        Contato retorno = new Contato();
        retorno.setId(gestorDto.getId());
        retorno.setName(gestorDto.getName());
        retorno.setBirthDate(gestorDto.getBirthDate());
        retorno.setPhone(gestorDto.getPhone());
        retorno.setCpf(gestorDto.getCpf());
        retorno.setGender(gestorDto.getGender());
        retorno.setCep(gestorDto.getCep());
        retorno.setLogradouro(gestorDto.getLogradouro());
        retorno.setHouseNumber(gestorDto.getHouseNumber());
        retorno.setBairro(gestorDto.getBairro());
        retorno.setComplemento(gestorDto.getComplemento());
        retorno.setCidade(gestorDto.getCidade());
        retorno.setUf(gestorDto.getUf());
        return retorno;
    }

    private ContatoDto ConvertContatoDTO(Contato contato) {
        ContatoDto retorno = new ContatoDto();
        retorno.setId(contato.getId());
        retorno.setName(contato.getName());
        retorno.setBirthDate(contato.getBirthDate());
        retorno.setPhone(contato.getPhone());
        retorno.setCpf(contato.getCpf());
        retorno.setGender(contato.getGender());
        retorno.setCep(contato.getCep());
        retorno.setLogradouro(contato.getLogradouro());
        retorno.setHouseNumber(contato.getHouseNumber());
        retorno.setBairro(contato.getBairro());
        retorno.setComplemento(contato.getComplemento());
        retorno.setCidade(contato.getCidade());
        retorno.setUf(contato.getUf());
        return retorno;
    }

    private List<ContatoDto> convertListToDto(List<Contato> contatos) {
        return contatos.stream().map(t -> ConvertContatoDTO(t)).collect(Collectors.toList());
    }

    public ContatoDto updateById(ContatoDto contato, Long id) {
        Optional<Contato> op = contatoRepository.findById(id);
        if (op.isPresent()) {
            Contato obj = op.get();
            if (contato.getName() != null) {
                obj.setName(contato.getName());
            }
            if (contato.getBirthDate() != null) {
                obj.setBirthDate(contato.getBirthDate());
            }
            if (contato.getPhone() != null) {
                obj.setPhone(contato.getPhone());
            }
            if (contato.getCpf() != null) {
                obj.setCpf(contato.getCpf());
            }
            if (contato.getGender() != null) {
                obj.setGender(contato.getGender());
            }
            if (contato.getCep() != null) {
                obj.setCep(contato.getCep());
            }
            if (contato.getLogradouro() != null) {
                obj.setLogradouro(contato.getLogradouro());
            }
            if (contato.getHouseNumber() != null) {
                obj.setHouseNumber(contato.getHouseNumber());
            }
            if (contato.getBairro() != null) {
                obj.setBairro(contato.getBairro());
            }
            if (contato.getComplemento() != null) {
                obj.setComplemento(contato.getComplemento());
            }
            if (contato.getCidade() != null) {
                obj.setCidade(contato.getCidade());
            }
            if (contato.getUf() != null) {
                obj.setUf(contato.getUf());
            }

            contatoRepository.save(obj);
            return ConvertContatoDTO(obj);
        }
        return null;
    }

    public Boolean deleteById(Long id) {
        Optional<Contato> op = contatoRepository.findById(id);
        if (op.isPresent()) {
            contatoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // TODO: precisa de revisão não esta bem feito
    // public List<ContatoDto> getByNomeGestor(String nomeGestor) throws Exception {

    // List<ContatoDto> contatos = convertListToDto(
    // contatoRepository.findByNomeContato(nomeGestor));
    // if (contatos.size() == 0) {
    // throw new Exception("NOT FOUND");
    // }
    // return contatos;
    // }
}