package br.com.fiap.projetoAndroid.controller;

import br.com.fiap.projetoAndroid.model.Nota;
import br.com.fiap.projetoAndroid.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/nota")
public class NotaController {
    @Autowired
    NotaService notaService;

    @GetMapping
    List<Nota> buscarTodos(){
        return notaService.buscarTodas();
    }

    @GetMapping(value="titulo/{titulo}")
    Nota buscar(@PathVariable(value = "titulo") String titulo){
        return notaService.buscar(titulo);
    }
    @PostMapping
    public void salvar(@RequestBody Nota nota){
        notaService.salvar(nota);
    }
}
