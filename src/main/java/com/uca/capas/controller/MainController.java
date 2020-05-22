package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.service.EstudianteService;

@Controller
public class MainController {
	@Autowired
	EstudianteService estudianteService;
	
	@RequestMapping("/inicio")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = new Estudiante();
		mav.addObject("estudiante",estudiante);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView showList() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		
		try {
			estudiantes = estudianteService.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("listado");
		return mav;
	}	
	
	@RequestMapping("/delete")
	public ModelAndView showNewList(@RequestParam(value = "codigo") int id) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		estudianteService.delete(id);
		try {
			estudiantes = estudianteService.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("listado");
		return mav;
	}	
	
	@RequestMapping("/guardar")
	public ModelAndView formEstudiante(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav  = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("index");
		}
		else{
			estudianteService.save(estudiante);
			Estudiante student = new Estudiante();
			mav.addObject("estudiante", student);
			mav.setViewName("index");
		}
		
		return mav;
	}
	
	
}
