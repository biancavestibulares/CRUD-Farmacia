

# Performance Goals - Farmácia

Criação e execução de um sistema de farmácia personalizado, projetado para atender às necessidades específicas da proposta de setor farmacêutico, oferecendo uma solução integrada e eficiente para gerenciamento de medicamentos, estoque, vendas, atendimento ao cliente e conformidade regulatória.

## Atributos do Sistema

**Tabela 1 - tb_categorias**
 
<div align="center">

| Atributo   | Descrição e motivo da escolha       | Chave       |
| :---------- | :--------- | :---------------------------------- |
| id  | Identificador único da tabela categoria | **PK** |
| nomeCategoria | Nome da categoria | **NN** |
| descricaoCategoria | Descrição do uma categoria de produtos | **NN** |
| produto | Chave estrangeira de tb_produtos | **FK** |

</div>

**Tabela 2 - tb_produtos**
 
<div align="center">

| Atributo   | Descrição e motivo da escolha       | Chave       |
| :---------- | :--------- | :---------------------------------- |
| id  | Identificador único da tabela produto | **PK** |
| nomeProduto | Nome do produto | **NN** |
| descricaoProduto | Descrição do produto | **NN** |
| estoque | Quantidade de produtos disponíveis | **NN** |
| preco | Valor unitário do produto | **NN** |
| dataValidade | Data de validade do produto | **NN** |
| categoria | Chave estrangeira de tb_categorias | **FK** |

</div>


## Funcionalidades
### CategoriaController
- **Listar Categorias**: `GET /categorias` para listar todas as categorias. 
- **Buscar por ID**: `GET /categorias/buscarPorId/{id}` para obter uma categoria por ID. 
- **Buscar por Descrição**: `GET /categorias/buscarPorDescricao/{descricaoCategoria}` para buscar categorias pela descrição. 
- **Criar Categoria**: `POST /categorias` para criar uma nova categoria.
- **Atualizar Categoria**: `PUT /categorias` para atualizar uma categoria existente. 
- **Deletar Categoria**: `DELETE /categorias/{id}` para excluir uma categoria por ID. 

### ProdutoController
- **Listar Produtos**: `GET /produtos` para listar todos os produtos.
- **Buscar por ID**: `GET /produtos/{id}` para obter um produto por ID.
- **Buscar por Nome**: `GET /produtos/buscarPorNome/{nomeProduto}` para buscar produtos pelo nome.
- **Criar Produto**: `POST /produtos` para criar um novo produto.
- **Atualizar Produto**: `PUT /produtos` para atualizar um produto existente.
- **Deletar Produto**: `DELETE /produtos/{id}` para excluir um produto por ID. 


## Tecnologias Utilizadas
- Java;
- Spring Boot;
- MySQL.


