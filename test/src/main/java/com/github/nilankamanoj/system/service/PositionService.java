package com.github.nilankamanoj.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nilankamanoj.system.model.Position;
import com.github.nilankamanoj.system.repository.PositionRepository;
import java.util.List;

@Service
public class PositionService {
	@Autowired
	private PositionRepository positionRepository;

	public List<Position> findAll() {
		List<Position> positions = positionRepository.findAll();
		return positions;
	}

	public Position findOne(Integer id) {
		Position position = positionRepository.findOne(id);
		return position;
	}

	public Position save(Position position) {
		positionRepository.save(position);
		Position newPosition = positionRepository.findOne(position.getId());
		return newPosition;
	}

}