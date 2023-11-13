# CRUD de Fretes

Este projeto oferece uma API REST para realizar operações CRUD relacionadas a fretes, utilizando MongoDB como banco de dados. O ambiente de desenvolvimento é configurado com Docker e inclui uma interface SwaggerUI para testar os endpoints.

## Inicializando o Projeto

Para iniciar o projeto, utilize o seguinte comando:

```bash
docker-compose up
```

## Endpoints
Acesse a interface SwaggerUI para testar os endpoints em [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).

Importe a coleção do Postman para facilitar os testes. O arquivo `FreteApp.postman_collection.json` contém as configurações necessárias.

## Atualizando o Código

Ao realizar alterações no código, reconstrua e reinicie o projeto com o comando:

```bash
docker-compose up --build
```

Para depurar na IDE, é possível subir apenas o banco no Docker e alterar o host no arquivo `application.properties` de 'database' para 'localhost'.

## Banco de Dados MongoDB

Conecte-se ao banco de dados MongoDB Compass em `localhost:27017` utilizando o nome de banco de dados `frete-app`.

## Zerando o Banco e o Docker

Para zerar o banco de dados, remova o diretório `.mongo_data`:

```bash
sudo rm -r seu_path/frete/.mongo_data
```

Para zerar o Docker, utilize o seguinte comando:

```bash
docker system prune -a
```

## Obtendo o IP da Conexão do Banco de Dados no Docker

Para obter o IP da conexão do banco de dados no Docker, execute:

```bash
docker inspect mongodb-docker | grep "IPAddress"
```




