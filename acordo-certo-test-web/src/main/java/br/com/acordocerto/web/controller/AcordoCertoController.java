package br.com.acordocerto.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.acordocerto.domain.model.RegisteredData;
import br.com.acordocerto.service.AcordoCertoService;

@Controller
@RequestMapping("/")
public class AcordoCertoController {
	
	@Autowired(required=true)
	private AcordoCertoService acordoCertoService;
	
	@GetMapping()
    public String sayHello(ModelMap model) {
        return "home";
    }
	
	@PostMapping(value="saveform", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String saveData(@RequestBody RegisteredData request)
	{
		acordoCertoService.saveForm(request);
		return "saved";
	}
	
	@GetMapping(value="loadform", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<RegisteredData> loadData()
	{
		return acordoCertoService.receiveData();
	}
}
