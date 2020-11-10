# Desafio Leroy Merlin - Backend

Projeto desenvolvido para o desafio Leroy Merlin. 

## Rodando o projeto

Para buildar o projeto, validar os testes unitários, para isso é necessário possuir o maven instalado:
```
mvn clean build
```

Para rodar o projeto via linha de comando:

```
mvn spring-boot:run
```

## Documentação

A documentação esta disponível utilizando [Swagger API](https://swagger.io/)

Para acesso:
- [/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Modelo Excel para inserção de dados
![](https://github.com/albuquerquealan/desafio-leroyMerlin/blob/main/modelo-inser%C3%A7%C3%A3o%20dados.png "Modelo planilha para inserção de dados")

Devido a limitações de tempo, caso a planilha fuja do modelo acima o endpoint 
responsável [EndPoint Cadastro(POST)](http://localhost:8080/products) 
irá retornar uma exceção 500 devido ao erro na leitura.
## Monitoração

A monitoração esta disponível utilizando [Spring Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html)

Os endpoints disponível para monitação são:
- [/actuator/health](http://localhost:8080/actuator/health)
- [/actuator/info](http://localhost:8080/actuator/info)

## Queue
Está sendo utilizado [RabbitMQ](https://www.rabbitmq.com/#getstarted) e para isso é necessário utilizar 
[Docker](https://circleci.com/docs/2.0/building-docker-images/?utm_medium=SEM&utm_source=gnb&utm_campaign=SEM-gb-DSA-Eng-latam&utm_content=&utm_term=dynamicSearch-&gclid=CjwKCAiAkan9BRAqEiwAP9X6Uc0yXFqYZVV_RH_y7Sqoy1o67zZC4o6ttnNbz9KCRNL7uRb5RvMtnxoCPjoQAvD_BwE) 
e a seguir é o comando para subir o servidor RabbitMQ
```
docker run --rm -it --hostname my-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
```





