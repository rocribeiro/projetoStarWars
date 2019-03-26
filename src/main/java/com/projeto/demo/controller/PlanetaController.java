package com.projeto.demo.controller;

import com.projeto.demo.model.Planeta;
import com.projeto.demo.service.PlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class PlanetaController {
    @Autowired
    PlanetaService ps;

    @PostMapping("/addPlaneta")
    public void adicionarPlaneta(@RequestBody Planeta planeta){
        ps.adicionarPlaneta(planeta);
    }
    @DeleteMapping("/removePlaneta")
    public void removerPlaneta(Planeta planeta) {
        ps.removerPlaneta(planeta);
    }
    @GetMapping("/listPlanetaBd")
    public @ResponseBody List<Planeta> listarPlanetaBd(){
        return ps.listarPlanetaBd();
    }
    @GetMapping("/listPlanetaApi")
    public  @ResponseBody List<Planeta> listarPlanetaApi() throws IOException {
        return ps.listarPlanetaApi();
    }
    @GetMapping("/buscarPlanetaId/{id}")
    public @ResponseBody Planeta buscarPlanetaId(@PathVariable("id")Long id){
        return ps.buscarPlanetaId(id);
    }
    @GetMapping("/buscarPlanetaNome/{nome}")
    public @ResponseBody Planeta buscarPlanetaNome(@PathVariable("nome") String nome){
        return ps.buscarPlanetaNome(nome);
    }

}
