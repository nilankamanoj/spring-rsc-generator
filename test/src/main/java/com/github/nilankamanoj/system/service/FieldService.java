package com.github.nilankamanoj.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nilankamanoj.system.model.Field;
import com.github.nilankamanoj.system.repository.FieldRepository;
import java.util.List;

@Service
public class FieldService {
	@Autowired
	private FieldRepository fieldRepository;

	public List<Field> findAll() {
		List<Field> fields = fieldRepository.findAll();
		return fields;
	}

	public Field findOne(Integer id) {
		Field field = fieldRepository.findOne(id);
		return field;
	}

	public Field save(Field field) {
		fieldRepository.save(field);
		Field newField = fieldRepository.findOne(field.getId());
		return newField;
	}

}