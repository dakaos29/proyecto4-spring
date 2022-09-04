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

import com.torres.app.oxxo.entities.Direccion;
import com.torres.app.oxxo.entities.Sucursal;
import com.torres.app.oxxo.services.ISucursalesService;

@Controller
@RequestMapping("/sucursales")
public class SucursalesController {
	
	@Autowired
	ISucursalesService sucursalesService;
	//api para obtener la lista de direcciones(recurso)
		@GetMapping(value = "/listar")
		public String listar(Model model) throws InterruptedException {
			return "sucursales/index";
		}
		/*api para listar direcciones en html*/
		@GetMapping(value = "/api/sucursales",
				produces = { "application/json" })
		public @ResponseBody Map<String, List<Sucursal>> apiListar() throws InterruptedException {
			Map<String, List<Sucursal>> map = new HashMap<String, List<Sucursal>>();
			map.put("data", sucursalesService.getAll());
			return map;
		}
		
		/*api para eliminar una direccion*/
		@DeleteMapping(value= "/api/delete/{id}",
				produces = { "application/json" })
		public @ResponseBody Map<String, String> apiDelete(
				@PathVariable(value = "id")
				Long id, Model model) {
			sucursalesService.delete(id);
			
			Map<String, String> resultados = new HashMap<String, String>();
			
			resultados.put("success", "true");
			resultados.put("message",
					"sucursal borrada correctamente");
			return resultados;
		}
		
		@GetMapping(value = "/create")
		public String create(Model model) {
			Sucursal sucursal = new Sucursal();
			
			model.addAttribute("sucursal" , sucursal);
			model.addAttribute("direcciones", sucursalesService.getListaDirecciones());
			//return "Instructores/create";
			
			//model.addAttribute("sucursal" , sucursal);
			model.addAttribute("gerentes", sucursalesService.getListaGerentes());
			return "sucursales/create";
		}
		
		@PostMapping(value = "/insert")
		public String insert(@Valid @ModelAttribute("sucursal") Sucursal sucursal, 
				BindingResult result, Model model) {
			
			if(sucursal.getDireccion().getId() == null) {
				FieldError error = new FieldError("sucursal", "direccion", "debes seleccionar una direccion");
						result.addError(error);
			}
			else if (sucursal.getGerente().getId() == null) {
				FieldError error = new FieldError("sucursal", "gerente", "debes seleccionar un gerente");
				result.addError(error);
			}
			
			if (result.hasErrors()) {
				model.addAttribute("direcciones", sucursalesService.getListaDirecciones());
				return "sucursales/create";
			}
			
			sucursalesService.save(sucursal);
			return "redirect:/sucursales/listar";
		}

}
