package com.sg.uib.controller;

import com.sg.uib.model.*;
import com.sg.uib.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Serveur getServerById(@PathVariable("id") Long id) {
        return serverService.getServerById(id);
    }

    @PostMapping("/servers")
    public Serveur addServer(@RequestBody Serveur server) {
        return serverService.addServer(server);
    }

    @PutMapping("/servers/{id}")
    public void updateServer(@Valid @RequestBody Serveur server, @PathVariable("id") long id) {
        serverService.updateServer(server, id);
    }


}
