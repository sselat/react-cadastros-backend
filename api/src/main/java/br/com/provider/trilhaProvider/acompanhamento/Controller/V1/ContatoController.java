package br.com.provider.trilhaProvider.acompanhamento.Controller.V1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.provider.trilhaProvider.acompanhamento.DTO.ContatoDto;
import br.com.provider.trilhaProvider.acompanhamento.service.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<ContatoDto> findById(@PathVariable("id") Long id) {

        try {
            ContatoDto contato = contatoService.GetGestorID(id);
            if (contato == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(contato, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping("/teste")
    public String testeProcesso() {
        return "teste de controller 05";
        // return new GestorDto();
    }

    @CrossOrigin
    @PostMapping("")
    public ResponseEntity<ContatoDto> createGestor(@RequestBody ContatoDto contato) {
        try {
            ContatoDto _tutorial = contatoService.save(contato);
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ContatoDto updateGestorById(@RequestBody ContatoDto contato, @PathVariable("id") Long id) {
        return contatoService.updateById(contato, id);
    }

    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<List<ContatoDto>> getAllGestor() {
        try {
            List<ContatoDto> contatos = contatoService.GetAll();
            if (contatos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(contatos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public Boolean deleteById(@PathVariable("id") long id) {
        return contatoService.deleteById(id);
    }

    // @CrossOrigin
    // @GetMapping("findByNome/{nomeGestor}")
    // public ResponseEntity<List<ContatoDto>> getAllGestorByNome(@PathVariable
    // String nomeGestor) {
    // try {
    // List<ContatoDto> contatos = contatoService.getByNomeGestor(nomeGestor);
    // return new ResponseEntity<>(contatos, HttpStatus.OK);

    // } catch (Exception e) {
    // return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    // }

    // }
}
