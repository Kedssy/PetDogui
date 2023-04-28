
package br.unipar.pet.dogui.service;

import br.unipar.pet.dogui.model.Pet;
import br.unipar.pet.dogui.service.repository.PetRepository;
import java.util.ArrayList;

public class PetService {
    private PetRepository repository = new PetRepository();

    public Pet insert(Pet pet) throws Exception {
        
        validaPet(pet);
        
        return repository.insert(pet);
        
    }

    private void validaPet(Pet pet) throws Exception {
        PessoaService pessoaService = new PessoaService();
        
        if (pet.getNome() == null || 
            pet.getNome().isEmpty()) {
            throw new Exception("Nome do pet não informado");
        }
        if(pessoaService.findById(pet.getDono().getId()).getId() == 0){
            throw new Exception("Dono não enconrado");
        }
        
        if(pet.getPeso() <= 0){
            throw new Exception("Peso inválido");
        }
        
        
       if(pet.getGenero() == null) {
            throw new Exception("Genero não informado");
        }
       
       if(pet.getPorte()== null) {
            throw new Exception("Porte não informado");
        }
        
        
    }

    public Pet update(Pet pet) throws Exception {
        validaPet(pet);
        return repository.update(pet);
    }

    public void delete(int id) throws Exception {
    
        repository.delete(id);
    
    }

    public Pet findById(int id)  throws Exception {
    
        return repository.findById(id);
        
    }
    
    public ArrayList<Pet> findByAll()  throws Exception {
    
        return repository.findAll();
        
    }
    
    public ArrayList<Pet> findWithParameteres(String nmPet)  throws Exception {
    
        return repository.findWithParameters(nmPet);
        
    }
}
