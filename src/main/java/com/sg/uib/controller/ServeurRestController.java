package com.sg.uib.controller;

import com.sg.uib.dto.ServerCreationFormDto;
import com.sg.uib.model.*;
import com.sg.uib.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class ServeurRestController {

    @Autowired
    private ServerService serverService;

    @GetMapping("/servers/count")
    public long countServers() {
        return serverService.count();
    }

    @GetMapping("/servers")
    public List<Serveur> getAllServers() {
        return serverService.getAllServers();
    }

    @GetMapping("/servers/{id}")
    public Serveur getServerById(@PathVariable("id") Long id) throws ResponseStatusException  {
        return serverService.getServerById(id);
    }

    @PostMapping("/servers")
    public Serveur addServer(@RequestBody ServerCreationFormDto server) {
        return serverService.addServer(server);
    }

    @PutMapping("/servers/{id}")
    public void updateServer(@Valid @RequestBody Serveur server, @PathVariable("id") long id) {
        serverService.updateServer(server, id);
    }
    @DeleteMapping("/servers/{id}")
    public void deleteProjectById(@PathVariable("id") Long id) {
    	 serverService.removeServer(id);
    }


}
