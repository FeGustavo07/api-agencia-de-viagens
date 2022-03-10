package com.dreamtrip.destinos.gateways.controllers;

import com.dreamtrip.destinos.domain.Destino;
import com.dreamtrip.destinos.gateways.controllers.requests.DestinoRequest;
import com.dreamtrip.destinos.gateways.controllers.responses.DestinoResponse;
import com.dreamtrip.destinos.usecases.AtualizarDestino;
import com.dreamtrip.destinos.usecases.CriarDestino;
import com.dreamtrip.destinos.usecases.ExcluirDestino;
import com.dreamtrip.destinos.usecases.ListarDestinos;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/destinos/gerenciar")
@RequiredArgsConstructor
public class DestinoController {

    private final AtualizarDestino atualizarDestino;
    private final CriarDestino criarDestino;
    private final ExcluirDestino excluirDestino;
    private final ListarDestinos listarDestinos;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public DestinoResponse criarDestino(@RequestBody DestinoRequest destinoRequest) {
        Destino destino = destinoRequest.converteParaDomain();
        Destino destinoSalvo = criarDestino.executar(destino);
        return new DestinoResponse(destinoSalvo);
    }

    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DestinoResponse atualizarDestino(@PathVariable("id") Long id, @RequestBody DestinoRequest destinoRequest) {
        Destino destino = destinoRequest.converteParaDomain();
        destino.setId(id);
        Destino destinoSalvo = atualizarDestino.executar(destino);
        return new DestinoResponse(destinoSalvo);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarDestino(@PathVariable("id") Long id) {
        Destino destino = Destino.builder().build();
        destino.setId(id);
        excluirDestino.executar(destino);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<DestinoResponse> listarDestinos() {
        List<Destino> destinos = listarDestinos.executar();
        return destinos.stream().map(DestinoResponse::new).collect(Collectors.toList());
    }
}
