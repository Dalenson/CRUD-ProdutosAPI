package com.dale.projetoestudo.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import com.dale.projetoestudo.shared.ProdutoDTO;
import com.dale.projetoestudo.view.model.ProdutoRequest;
import com.dale.projetoestudo.view.model.ProdutoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dale.projetoestudo.model.Produto;
import com.dale.projetoestudo.services.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> obterTodos(){
        List<ProdutoDTO> produtos = produtoService.obterTodos();
        ModelMapper mapper = new ModelMapper();
        List<ProdutoResponse> response = produtos.stream().map(produtoDTO -> mapper.map(produtoDTO, ProdutoResponse.class)).collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> adicionar(@RequestBody ProdutoRequest produtoReq){
        ModelMapper modelMapper = new ModelMapper();
        ProdutoDTO dto = modelMapper.map(produtoReq, ProdutoDTO.class);
        dto = produtoService.adicinar(dto);
        return new ResponseEntity<>(modelMapper.map(dto, ProdutoResponse.class), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProdutoResponse>> obterPorId(@PathVariable Integer id){
        Optional<ProdutoDTO> dto = produtoService.obterPorId(id);
        ProdutoResponse response = new ModelMapper().map(dto.get(), ProdutoResponse.class);
        return new ResponseEntity<>(Optional.of(response), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        produtoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@PathVariable Integer id, @RequestBody ProdutoRequest produtoReq){
        ModelMapper modelMapper = new ModelMapper();
        ProdutoDTO dto = modelMapper.map(produtoReq, ProdutoDTO.class);
        dto = produtoService.atualizar(id, dto);
        return new ResponseEntity<>(modelMapper.map(dto, ProdutoResponse.class), HttpStatus.OK);
    }
}
