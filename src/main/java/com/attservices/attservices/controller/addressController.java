package com.attservices.attservices.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.attservices.attservices.model.address;
import com.attservices.attservices.service.addressService;

import net.bytebuddy.description.modifier.MethodArguments;

@RestController
public class addressController {

	@Autowired
	private addressService serv;
	
	//READ GET
	
	@GetMapping("/addresses")
	public List<address> addresses()
	{
		return serv.readAll();
	}
	
	@GetMapping("/address/{id}")
	public Optional<address> address(@PathVariable int id)
	{
		return serv.readByID(id);
	}
	
	@GetMapping("/addressOfZip/{zip}")
	public Optional<address> address(@PathVariable long zip)
	{
		return serv.readByZip(zip);
	}
	
	@GetMapping("/addressOfLikeContains/{addLine1}")
	public List<address> address(@PathVariable String addLine1)
	{
		return serv.readLine1Contains(addLine1);
	}
	
	//Insert Data POST
	
	@PostMapping("/InsertAddress")
	public address insert(@RequestBody address add)
	{
		return serv.save(add);
	}
	
	//Update Data PUT
	@PutMapping("/UpdateAddress")
	public address update(@RequestBody address add)
	{
		return serv.update(add);
	}
    
	@PutMapping("/UpdateAddressCon")
	public String updateCon(@RequestBody String req)
	{
		JSONObject obj = new JSONObject(req);
		String newAdd = obj.getString("newAdd");
		String charSeq = obj.getString("charSeq");
		return "Number of Records Updated : "+serv.updateContains(newAdd, charSeq);
	}
	
	//Delete Data DELETE
	@DeleteMapping("/DeleteAddress/{id}")
	public ResponseEntity<HashMap<String,String>> delete(@PathVariable int id)
	{
		HashMap<String,String> map = new HashMap<>();
		String msg = serv.delete(id);
		if(msg.contains("succesfully"))
		{
			map.put("msg", msg);
			return new ResponseEntity<HashMap<String,String>>(map,HttpStatus.OK);
		}
		else
		{
			map.put("msg", msg);
			return new ResponseEntity<HashMap<String,String>>(map,HttpStatus.BAD_REQUEST);
		}
	}
	
}
