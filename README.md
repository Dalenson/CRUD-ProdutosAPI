
# CRUD de Produtos

Projeto apenas para estudo, visando a implementação de um projeto CRUD, que faça as principais funções: Criação, Leitura, Atualização e Delete.


## Stack utilizada

**Back-end:** Spring Boot, MySql, Heroku, Eureka.

## Documentação da API

#### Retorna todos os produtos

```
  GET /api/produtos
```

#### Retorna um produto por ID

```
  GET /api/produtos/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. ID do produto |

#### Adiciona um produto

```
  POST /api/produtos
```
```
{
    "nome":"Nome Produto",
    "quantidade":1,
    "valor":2,
    "observacoes":"Observação do produto"
}
```
#### Exclui um produto por ID

```
  DELETE /api/produtos/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. ID do produto |

#### Atualiza um produto por ID

```
  PUT /api/produtos/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. ID do produto |
