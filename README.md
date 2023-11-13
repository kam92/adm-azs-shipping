CRUD Fretes

API REST e MongoDB.

Para subir o projeto:
docker-compose up

SwaggerUI com os endpoints disponíveis para teste:
http://localhost:8080/swagger-ui/index.html

Para subir alterações no código:
docker-compose up --build


Utilidade:

Para debugar na IDE pode subir apenas o banco no Docker e alterar o host no application.properties de 'database' para 'localhost'
Para verificar o conteúdo do banco, pode conectar o MongoDB Compass em localhost:27017, database frete-app

Zerar o banco:
sudo rm -r seu_path/frete/.mongo_data

Zerar o docker:
docker system prune -a

Pegar o IP da conexão do banco de dados do docker:
docker inspect mongodb-docker | grep "IPAddress"

