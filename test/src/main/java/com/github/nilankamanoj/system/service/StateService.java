package com.github.nilankamanoj.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nilankamanoj.system.model.State;
import com.github.nilankamanoj.system.repository.StateRepository;
import java.util.List;

@Service
public class StateService {
	@Autowired
	private StateRepository stateRepository;

	public List<State> findAll() {
		List<State> states = stateRepository.findAll();
		return states;
	}

	public State findOne(Integer id) {
		State state = stateRepository.findOne(id);
		return state;
	}

	public State save(State state) {
		stateRepository.save(state);
		State newState = stateRepository.findOne(state.getId());
		return newState;
	}

}