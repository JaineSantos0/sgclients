package com.jainejosiane.sgclients.services;

import com.jainejosiane.sgclients.dto.ClientDTO;
import com.jainejosiane.sgclients.entities.Client;
import com.jainejosiane.sgclients.repositories.ClientRepository;
import com.jainejosiane.sgclients.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> clients = repository.findAll(pageable);
        return clients.map(ClientDTO::new);
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyToDtoToEntity(dto, entity);
        repository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(ClientDTO dto, Long id) {
        try {
            Client entity = repository.getReferenceById(id);
            copyToDtoToEntity(dto, entity);
            repository.save(entity);
            return new ClientDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Client not found");
        }
    }

    @Transactional
    public void delete(Long id) {
        Client entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        repository.deleteById(id);
    }

    public void copyToDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }
}