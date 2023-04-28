/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.pet.dogui.service;
import java.sql.SQLException;
import java.util.ArrayList;
import br.unipar.pet.dogui.model.Pessoa;
import br.unipar.pet.dogui.service.repository.PessoaRepository;

/**
 *
 * @author k.luan
 */
public class PessoaService {
    private final PessoaRepository repository = new PessoaRepository();

    public Pessoa insert(Pessoa pessoa) throws Exception {
        validaPessoa(pessoa);

        return repository.insert(pessoa);
    }

    private void validaPessoa(Pessoa pessoa) throws Exception {
     if (pessoa.getNome()== null ||
            pessoa.getNome().isEmpty()) {
            throw new Exception("Nome da pessoa não informada");
        }
    }

    public Pessoa update(Pessoa pessoa) throws Exception {

        return repository.update(pessoa);
    }

    public void delete(int id) throws SQLException {
        repository.delete(id);
    }

    public Pessoa findById(int id) throws Exception {

        return repository.findById(id);
    }

    public ArrayList<Pessoa> findAll() throws Exception {

        return repository.findAll();

    }

    public ArrayList<Pessoa> findWithParameteres(String nome) throws Exception {

        return repository.findWithParameters(nome);

    }
}
