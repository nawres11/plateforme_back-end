package com.sg.uib.controller;

import com.sg.uib.model.*;
import com.sg.uib.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class FluxRestController {

	
	@Autowired
    private FluxService fluxService;

	@GetMapping("/fluxs")
    public List<Flux> getAllFluxs(){
        return fluxService.getAllFluxs();
    }

    @GetMapping("/fluxs/{id}")
    public Flux getFluxById(@PathVariable("id")long id_flux){
        return fluxService.getFluxById(id_flux);
    }
    
    @PostMapping("/fluxs")
    public Flux addFlux(@RequestBody Flux flux){
        return fluxService.addFlux(flux);
    }
   
    @GetMapping("/fluxs/serversList")
    public List<Serveur> getAllServers(){
        return fluxService.getAllServers();
    }

    @GetMapping("/fluxs/fluxsByServers/{id_serveur}")
    public List<Flux> getFluxByServer(@PathVariable("id_serveur") long id_serveur){
        return fluxService.findByServer(id_serveur);
    }
}
