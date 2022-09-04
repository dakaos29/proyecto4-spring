package com.torres.app.oxxo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.torres.app.oxxo.entities.Gerente;
import com.torres.app.oxxo.entities.Sucursal;
import com.torres.app.oxxo.services.IGerentesService;


@Controller
@RequestMapping("/gerentes")
public class GerentesController {
	
	@Autowired
	IGerentesService gerentesService;
	//api para obtener la lista de direcciones(recurso)
			@GetMapping(value = "/listar")
			public String listar(Model model) throws InterruptedException {
				return "gerentes/index";
			}
			/*api para listar direcciones en html*/
			@GetMapping(value = "/api/listar",
					produces = { "application/json" })
			public @ResponseBody Map<String, List<Gerente>> apiListar() throws InterruptedException {
				Map<String, List<Gerente>> map = new HashMap<String, List<Gerente>>();
				map.put("data", gerentesService.getAll());
				return map;
			}
			
			@DeleteMapping(value= "/api/delete/{id}",
					produces = { "application/json" })
			public @ResponseBody Map<String, String> apiDelete(
					@PathVariable(value = "id")
					Long id, Model model) {
				gerentesService.delete(id);
				
				Map<String, String> resultados = new HashMap<String, String>();
				
				resultados.put("success", "true");
				resultados.put("message",
						"gerente borrado correctamente");
				return resultados;
			}
			
			@GetMapping(value = "/create")
			public String create(Model model) {
				Gerente gerente = new Gerente();
				
				model.addAttribute("gerente" , gerente);
				model.addAttribute("direcciones", gerentesService.getListaDirecciones());
				//model.addAttribute("sucursales", gerentesService.getListaSucursales());
				return "gerentes/create";
			}
			
			@PostMapping(value = "/insert")
			public String insert(@Valid @ModelAttribute("gerente") Gerente gerente, 
					BindingResult result, Model model) {
				
				if(gerente.getDireccion().getId() == null) {
					FieldError error = new FieldError("gerente", "direccion", "debes seleccionar una direccion");
							result.addError(error);
				}
				/*else if (gerente.getSucursal().getId() == null) {
					FieldError error = new FieldError("gerente", "sucursal", "debes seleccionar una sucursal");
					result.addError(error);
				}*/
				
				if (result.hasErrors()) {
					model.addAttribute("direcciones", gerentesService.getListaDirecciones());
					return "gerentes/create";
				}
				
				gerentesService.save(gerente);
				return "redirect:/gerentes/listar";
			}

}
