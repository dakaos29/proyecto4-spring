package com.torres.app.oxxo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.torres.app.oxxo.entities.Direccion;
import com.torres.app.oxxo.services.IDireccionesService;

@Controller
@RequestMapping("/direcciones")
public class DireccionesController {
	
	@Autowired
	IDireccionesService direccionesService;
	//api para obtener la lista de direcciones(recurso)
		@GetMapping(value = "/listar")
		public String listar(Model model) throws InterruptedException {
			return "Direcciones/index";
		}
		/*api para listar direcciones en html*/
		@GetMapping(value = "/api/listadoDirecciones",
				produces = { "application/json" })
		public @ResponseBody Map<String, List<Direccion>> apiListar() throws InterruptedException {
			Map<String, List<Direccion>> map = new HashMap<String, List<Direccion>>();
			map.put("data", direccionesService.getAll());
			return map;
		}
		
		/*api para eliminar una direccion*/
		@DeleteMapping(value= "/api/delete/{id}",
				produces = { "application/json" })
		public @ResponseBody Map<String, String> apiDelete(
				@PathVariable(value = "id")
				Long id, Model model) {
			direccionesService.delete(id);
			
			Map<String, String> resultados = new HashMap<String, String>();
			
			resultados.put("success", "true");
			resultados.put("message",
					"direccion borrada correctamente");
			return resultados;
		}

	@GetMapping(value = "/create")
	public String create (Model model) {
		//creamos el objeto con el que vamos a trabajar en la vista
		Direccion direccion = new Direccion();
		
		//pasamos el objeto categoria a la vista
		model.addAttribute("direccion", direccion);
		
		return "Direcciones/create";
	}

	@PostMapping(value="insert")
	public String insert(@Valid @ModelAttribute("direccion")
	Direccion direccion,
	BindingResult result) {
		if(result.hasErrors()) {
			return "Direccion/create";
		}
		
		direccionesService.save(direccion);
		return "redirect:/direcciones/listar";
	}

	@GetMapping(value="/edit/{id}")
	public String edit(@PathVariable(value = "id") Long id,
			Model model)
	{
		Direccion direccion = null;
		if (id  > 0) {
			//recuperamos el objeto categoria que queremos editar
			direccion = direccionesService.getById(id);
			if (direccion == null) {
				return "redirect:/direcciones/listar";
			}
		}
		else {
			return "redirect:/direcciones/listar";
		}
		//le pasamos el objeto categoria a la vista
		model.addAttribute("direccion", direccion);
		return "Direcciones/create";
	}

	@GetMapping(value="/detalles/{id}")
	public String detalles(@PathVariable(value = "id") Long id,
			Model model)
	{
		Direccion direccion = null;
		if (id  > 0) {
			//recuperamos el objeto categoria que queremos editar
			direccion = direccionesService.getById(id);
			if (direccion == null) {
				return "redirect:/direcciones/listar";
			}
		}
		else {
			return "redirect:/direcciones/listar";
		}
		//le pasamos el objeto categoria a la vista
		model.addAttribute("direccion", direccion);
		return "Direcciones/detalles";
	}


}
