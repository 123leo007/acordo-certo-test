package br.com.acordocerto.service;

import java.util.List;

import br.com.acordocerto.domain.model.RegisteredData;

public interface AcordoCertoService {
	
	public Long saveForm(RegisteredData data);
	
	public List<RegisteredData> receiveData();
}
