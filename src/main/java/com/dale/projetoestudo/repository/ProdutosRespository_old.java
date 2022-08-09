package com.dale.projetoestudo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dale.projetoestudo.model.Produto;
import com.dale.projetoestudo.model.exception.ResourceNotFoundExecption;

@Repository
public class ProdutosRespository_old {
    /**
     * Metodo para retornar uma lista de produtos
     * @return lista de produtos.
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Metodo para retornar o produto por id
     * @param id do produto que será localizado.
     * @return Retorna um produto por id.
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    /**
     * Metodo para adicionar o produto na lista
     * @param produto a ser adicionado.
     * @return Retorna o produto que foi adicionado a lista.
     */
    public Produto adicinar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /**
     * Metodo para remover o produto na lista
     * @param id a ser deletado.
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Metodo para atulizar o produto na lista
     * @param produto a ser atuaizado.
     * @return o produto atualizado.
     */
    public Produto atualizar(Produto produto){
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        if(produtoEncontrado.isEmpty()){
            throw new ResourceNotFoundExecption("Produto não encontrado");
        }
        deletar(produto.getId());
        produtos.add(produto);
        return produto;
    }
}
