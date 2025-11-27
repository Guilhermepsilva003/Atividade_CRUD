# CRUD Produto API (Java + Spring Boot)

API simples para gerenciar "Produto" (CRUD) com armazenamento em memória.

## Requisitos
- Java 17+
- Maven
- IntelliJ IDEA (opcional)

## Rodando localmente
1. Importar o projeto no IntelliJ como Maven project.
2. Executar a classe `com.example.crudproduto.CrudProdutoApiApplication`.
3. A API estará em: `http://localhost:8080/api/produtos`

## Endpoints (exemplos)
- GET /api/produtos -> lista todos
- GET /api/produtos/{id} -> busca por id
- POST /api/produtos -> cria (body JSON)
- PUT /api/produtos/{id} -> atualiza (body JSON)
- DELETE /api/produtos/{id} -> remove

Exemplo de JSON de POST:
{
  "nome": "Cookie",
  "descricao": "Cookie de chocolate",
  "preco": 4.5
}

## Comandos Git para subir no GitHub
# 1. inicializar repositório local
git init
git add .
git commit -m "Initial commit - CRUD Produto API"

# 2. criar repositório no GitHub (pelo site)
# -> crie um repo público chamado 'crud-produto-api'

# 3. adicionar remote e enviar:
git remote add origin https://github.com/SEU_USUARIO/crud-produto-api.git
git branch -M main
git push -u origin main

(Substitua SEU_USUARIO pelo seu usuário do GitHub)

## Testes com curl
# listar
curl -s http://localhost:8080/api/produtos | jq

# criar
curl -s -X POST -H "Content-Type: application/json" -d '{"nome":"Donut","descricao":"Doce","preco":5.0}' http://localhost:8080/api/produtos

# atualizar
curl -s -X PUT -H "Content-Type: application/json" -d '{"nome":"Donut","descricao":"Doce recheado","preco":6.0}' http://localhost:8080/api/produtos/1

# deletar
curl -s -X DELETE http://localhost:8080/api/produtos/1
