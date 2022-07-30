package com.ssafy.rent.model.service;

import java.util.List;

import com.ssafy.rent.model.dto.EnvPollution;

public interface EnvPollutionService {
	public List<EnvPollution> search(String name);
	public List<EnvPollution> search();
}
