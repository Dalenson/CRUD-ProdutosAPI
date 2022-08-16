package com.dale.projetoestudo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.dale.projetoestudo.model.exception.ResourceNotFoundExecption;
import com.dale.projetoestudo.repository.ProdutosRepository;
import com.dale.projetoestudo.shared.ProdutoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dale.projetoestudo.model.Produto;
import com.dale.projetoestudo.repository.ProdutosRespository_old;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutosRepository produtosRespository;

    /**
     * Metodo de servico que retorna todos os produtos
     * @return
     */
    public List<ProdutoDTO> obterTodos(){
        List<Produto> produtos = produtosRespository.findAll();
        return produtos
                .stream()
                .map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Metodo de servico para retornar o produto por id
     * @param id do produto que será localizado.
     * @return Retorna um produto por id.
     */
    public Optional<ProdutoDTO> obterPorId(Integer id){
        Optional<Produto> produto = produtosRespository.findById(id);
        if (produto.isEmpty()) {
            throw new ResourceNotFoundExecption("Produto com id: "+id+" não foi encontrado!");
        }
        ProdutoDTO produtoDTO = new ModelMapper().map(produto.get(), ProdutoDTO.class);
        return Optional.of(produtoDTO);
    }

    /**
     * Metodo de servico para adicionar o produto na lista
     * @param dto a ser adicionado.
     * @return Retorna o produto que foi adicionado a lista.
     */
    public ProdutoDTO adicinar(ProdutoDTO dto){
        dto.setId(null);
        Produto produtoSaved = new ModelMapper().map(dto, Produto.class);
        produtoSaved = produtosRespository.save(produtoSaved);
        dto.setId(produtoSaved.getId());
        return dto;
    }

    /**
     * Metodo de servico para remover o produto na lista
     * @param id a ser deletado.
     */
    public void deletar(Integer id){
        Optional<Produto> produto = produtosRespository.findById(id);
        if (produto.isEmpty()) {
            throw new ResourceNotFoundExecption("Não foi possivel encontrar o registro ou já foi deletado!");
        }
        produtosRespository.deleteById(id);
    }

    /**
     * Metodo de servico para atulizar o produto na lista
     * @param produto a ser atuaizado.
     * @return o produto atualizado.
     */
    public ProdutoDTO atualizar(Integer id, ProdutoDTO dto){
        dto.setId(id);
        Produto produto = new ModelMapper().map(dto, Produto.class);
        produtosRespository.save(produto);
        return dto;
    }
}
