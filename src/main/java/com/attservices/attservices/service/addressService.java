package com.attservices.attservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attservices.attservices.model.address;
import com.attservices.attservices.repository.addressRepository;

@Service
public class addressService {
	
	@Autowired
	private addressRepository repo;
	
	//C - CREATE Records
	public address save(address add)
	{
		return repo.save(add);
	}
	
	//R - READ Records
	public List<address> readAll()
	{
		return repo.findAll();
	}
	
	public Optional<address> readByID(int id)
	{
		return repo.findById(id);
	}
	
	public Optional<address> readByZip(long Zip)
	{
		return repo.findByZip(Zip);
	}
	
	//U - UPDATE records
	public address update(address add)
	{
		address existingAdd = repo.findById(add.getAddID()).orElse(null);
		if(existingAdd != null)
		{
			existingAdd.setAddLine1(add.getAddLine1());
			existingAdd.setAddLin2(add.getAddLin2());
			existingAdd.setCity(add.getCity());
			existingAdd.setState(add.getState());
			existingAdd.setCountry(add.getCountry());
			existingAdd.setZip(add.getZip());
			return repo.save(existingAdd);
		}
		return null;
	}
	
	//D - DELETE Records
	public String delete(int id)
	{
		address existingAdd = repo.findById(id).orElse(null);
		if(existingAdd!=null)
		{
			repo.deleteById(id);
			return "Deleted succesfully!!!";
		}
		else 
		{
			return "No Records Found!!!";
		}
	}
	
	

}
