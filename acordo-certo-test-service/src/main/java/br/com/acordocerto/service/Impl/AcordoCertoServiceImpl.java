package br.com.acordocerto.service.Impl;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.acordocerto.domain.model.RegisteredData;
import br.com.acordocerto.domain.model.RegisteredDataRepository;
import br.com.acordocerto.service.AcordoCertoService;

@Service
@Component
public class AcordoCertoServiceImpl implements AcordoCertoService {

	@Autowired
	RegisteredDataRepository registeredDataRepository2;

	@Override
	@Transactional(rollbackOn=Exception.class)
	public Long saveForm(RegisteredData data) {
		Long newId = -1l;
		try {
			newId = registeredDataRepository2.save(data).getId();
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return newId;
	}

	@Override
	public List<RegisteredData> receiveData() {
		List<RegisteredData> data = null;
		try {
			data = registeredDataRepository2.findAll();
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return data;
	}

}
