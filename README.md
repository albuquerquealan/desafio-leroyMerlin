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



