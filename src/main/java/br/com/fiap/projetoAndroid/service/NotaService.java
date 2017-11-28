package br.com.fiap.projetoAndroid.service;

import br.com.fiap.projetoAndroid.model.Nota;
import br.com.fiap.projetoAndroid.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    NotaRepository notaRepository;

    public void salvar(Nota nota){
        Nota nota1 = notaRepository.findByTitulo(nota.getTitulo());
        if (nota1 != null){
            nota.setId(nota1.getId());
        }
        notaRepository.save(nota);
    }

    public List<Nota> buscarTodas(){
        return notaRepository.findAll();
    }
    public Nota buscar(String titulo){
        Nota nota = notaRepository.findByTitulo(titulo);

        if (nota == null){
            return new Nota();
        }else {
            return nota;
        }
    }
}
