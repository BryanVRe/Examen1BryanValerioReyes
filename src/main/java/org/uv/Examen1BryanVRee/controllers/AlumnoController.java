/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Examen1BryanVRee.controllers;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.uv.Examen1BryanVRe.Alumnos;
import org.uv.Examen1BryanVRe.DAOAlumno;

/**
 *
 * @author carte
 */

@RestController
public class AlumnoController {
    //http://localhost:8080/Alumnos1
    
    @Autowired
    DAOAlumno alumnoRepository;
    
  @GetMapping("/Alumnos1")
    public List<Alumnos> IstAlumno(){
        return alumnoRepository.findAll();
    }
      @GetMapping("/Alumnos1/{id}")
    public Alumnos byIdAlumno(@PathVariable long id){
        Optional<Alumnos> opt= alumnoRepository.findById(id);
        
        if(opt.isPresent())
           return opt.get();
        else
            return null;
        
    }
    
    @PostMapping("/Alumnos1")
    public Alumnos addAlumno(@RequestBody Alumnos alumno){
        Alumnos tempAlumno=alumnoRepository.save(alumno);
        return tempAlumno;
    }
//      @GetMapping("/hola")
//    public String holaMundo(){
//        return "hola Mundo en Rest";
//    }
//       @PostMapping("/holaa")
//    public String holaPost(){
//        return "hola en un  post";
//    }
    
    @PutMapping("/Alumnos1/{id}")
	public Alumnos updateAlumno(@PathVariable Long id ,@RequestBody Alumnos alumno) {
		return alumnoRepository.save(alumno);
	}
    
    @DeleteMapping("/Alumnos1/{id}")
	public void deleteAlumno(@PathVariable("id") Long id) {
		alumnoRepository.deleteById(id);
	}
}
