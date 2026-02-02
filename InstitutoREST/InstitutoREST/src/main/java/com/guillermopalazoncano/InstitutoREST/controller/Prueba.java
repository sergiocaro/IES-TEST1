/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guillermopalazoncano.InstitutoREST.controller;

import com.guillermopalazoncano.InstitutoREST.model.Alumno;
import com.guillermopalazoncano.InstitutoREST.utilidades.RangoNumeros;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guille
 */
@RestController
@RequestMapping("/api/ies")
public class Prueba {

    @GetMapping("/aleatorio")
    public int getAleatorio() {
        return numAleatorio(1, 10);
    }
    
    @GetMapping("/aleatoriomax")
    public ResponseEntity<String> getAleatorioMaximoQueryParams(@RequestParam int numMax) {
        if (numMax < 1 || numMax > 10) {
            return ResponseEntity.badRequest().body("Error, el número máximo debe estar entre 1 y 10");
        } else {
           return ResponseEntity.ok("El aleatorio calculado es: "+numAleatorio(1,numMax));
        }
    }

    @GetMapping("/aleatorio/min/{numMin}/max/{numMax}")
    public ResponseEntity<String> getAleatorioMinimoMaximo(@PathVariable int numMin, @PathVariable int numMax) {
        if (numMin > numMax) {
            return ResponseEntity.badRequest().body("Error, el número mínimo no puede ser mayor al máximo");
        } else {
           return ResponseEntity.ok("El aleatorio calculado es: "+numAleatorio(numMin,numMax));
        }
    }
    
    @GetMapping("/aleatorio/max/{numMax}")
    public ResponseEntity<String> getAleatorioMaximo(@PathVariable int numMax) {
        if (numMax < 1 || numMax > 10) {
            return ResponseEntity.badRequest().body("Error, el número máximo debe estar entre 1 y 10");
        } else {
           return ResponseEntity.ok("El aleatorio calculado es: "+numAleatorio(1,numMax));
        }
    }
    
    @GetMapping("/aleatoriominmax")
    public ResponseEntity<String> getAleatorioMinimoMaximoBody(
            @RequestBody Map<String, Integer> numeros) {
        
        int numMin = numeros.get("min");
        int numMax = numeros.get("max");
        
        if (numMin > numMax) {
            return ResponseEntity.badRequest().body("Error, el número mínimo no puede ser mayor al máximo");
        } else {
           return ResponseEntity.ok("El aleatorio calculado es: "+numAleatorio(numMin,numMax));
        }
    }
    
    @GetMapping("/aleatoriominmaxv2")
    public ResponseEntity<String> getAleatorioMinimoMaximoBodyv2(
            @RequestBody RangoNumeros numeros) {
        
        int numMin = numeros.getMinimo();
        int numMax = numeros.getMaximo();
        
        if (numMin > numMax) {
            return ResponseEntity.badRequest().body("Error, el número mínimo no puede ser mayor al máximo");
        } else {
           return ResponseEntity.ok("El aleatorio calculado es: "+numAleatorio(numMin,numMax));
        }
    }
    
    @GetMapping("/aleatorioscalculados")
    public ResponseEntity<RangoNumeros> getAleatorios() {
         RangoNumeros r = new RangoNumeros(numAleatorio(1,50),numAleatorio(51,100));
         return ResponseEntity.ok(r);
    }

    // CHUWIKI EL MEJOR
    public int numAleatorio(int min, int max) {
        return (int) (Math.floor(Math.random() * (max - min + 1) + min));
    }
}
