package com.dale.projetoestudo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dale.projetoestudo.model.Produto;
import com.dale.projetoestudo.repository.ProdutosRespository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutosRespository produtosRespository;

    /**
     * Metodo de servico que retorna todos os produtos
     * @return
     */
    public List<Produto> obterTodos(){
        return produtosRespository.obterTodos();
    }

    /**
     * Metodo de servico para retornar o produto por id
     * @param id do produto que será localizado.
     * @return Retorna um produto por id.
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtosRespository.obterPorId(id);
    }

    /**
     * Metodo de servico para adicionar o produto na lista
     * @param produto a ser adicionado.
     * @return Retorna o produto que foi adicionado a lista.
     */
    public Produto adicinar(Produto produto){
        return produtosRespository.adicinar(produto);
    }

    /**
     * Metodo de servico para remover o produto na lista
     * @param id a ser deletado.
     */
    public void deletar(Integer id){
        produtosRespository.deletar(id);
    }

    /**
     * Metodo de servico para atulizar o produto na lista
     * @param produto a ser atuaizado.
     * @return o produto atualizado.
     */
    public Produto atualizar(Integer id, Produto produto){
        produto.setId(id);
        return produtosRespository.atualizar(produto);
    }
}
