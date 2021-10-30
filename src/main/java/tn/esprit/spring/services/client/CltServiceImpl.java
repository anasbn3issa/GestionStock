package tn.esprit.spring.services.client;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.repositories.ClientRepository;

@Service
public class CltServiceImpl implements ClientServiceImpl{
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> retrieveAllClients() {
		// TODO Auto-generated method stub
		return (List<Client>) clientRepository.findAll();
	}

	@Override
	public Client addClient(Client c) {
		// TODO Auto-generated method stub
		
		return clientRepository.save(c);
	}

	@Override
	public void deleteClient(Long id) {

		clientRepository.deleteById(id);
	}

	@Override
	public Client updateClient(Client c) {
		// TODO Auto-generated method stub
		return clientRepository.save(c);
	}

	@Override
	public Client retrieveClient(Long id) {
		// TODO Auto-generated method stub
		return clientRepository.findById(id).orElse(null);
	}

	@Override
	public List<Client> retrieveClientsByProfession(Date date1, Date date2) {
		return clientRepository.retrieveClientsByProfession(date1, date2) ;
	}

}
