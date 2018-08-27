package com.github.nilankamanoj.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nilankamanoj.system.model.Pannel;
import com.github.nilankamanoj.system.repository.PannelRepository;
import java.util.List;

@Service
public class PannelService {
	@Autowired
	private PannelRepository pannelRepository;

	public List<Pannel> findAll() {
		List<Pannel> pannels = pannelRepository.findAll();
		return pannels;
	}

	public Pannel findOne(Integer id) {
		Pannel pannel = pannelRepository.findOne(id);
		return pannel;
	}

	public Pannel save(Pannel pannel) {
		pannelRepository.save(pannel);
		Pannel newPannel = pannelRepository.findOne(pannel.getId());
		return newPannel;
	}

}