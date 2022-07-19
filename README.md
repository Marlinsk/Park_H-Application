# <img src="https://github.com/Marlinsk/Park_H-backend/blob/main/.github/ParkH-Icon.svg" width="56px" height="56px"> Park-H / Rest Api ![](https://img.shields.io/static/v1?label&?style=flat&logo=apachemaven&logoColor=FFFFFF&message=Apache%20Maven&color=C71A36) ![](https://img.shields.io/static/v1?label&?style=flat&logo=springboot&logoColor=FFFFFF&message=Feito%20com%20Spring%20Boot%20Framework&color=6DB33F) ![](https://img.shields.io/static/v1?label&?style=flat&logo=docker&logoColor=FFFFFF&message=Projeto%20Dockeirizado!&color=2496ED) 

Este repositório foi tornado público com **o objetivo de divulgar a ideia e a lógica por trás do código-fonte da parte back-end** do aplicativo de aluguéis de garagem, **Park-H.** Aqui você poderá visualizar o código e usufruir de algumas ideias de implementação e utilizar como conceito ou ideia para o seu projeto no futuro.

**Um breve resumo da aplicação:** Park-H é uma plataforma de divulgação de aluguéis de garagem, que vão desde garagens de casas até comerciais, tudo é feito de uma forma independende, sendo até comparada ao [Airbnb](https://www.airbnb.com.br/?tab_id=home_tab&refinement_paths%5B%5D=%2Fhomes&search_mode=flex_destinations_search&flexible_trip_lengths%5B%5D=one_week&location_search=MIN_MAP_BOUNDS&search_type=category_change&category_tag=Tag%3A8522) só que de garagem.

A ideia foi dada por um colega, que chegou a fazer em um semestre anterior da faculdade, mas infelizmente o projeto não saiu.

## História 
**Park-H** é um projeto que surgiu durante uma matéria de semestre da faculdade(mais especificamento no 5º Período), onde na ocasião a matéria era sobre **Rest Api e microsservices**, o intuito foi aprender a construir uma aplicação backe-end utilizando **Spring Boot** e alguns serviços da **Amazon Web Service** como o **Dynamo DB e o ecossistema do EC2**, no final o projeto seria hospedado em um servidor (AWS) para depois ser consumido por um aplicativo feito no **Android Studio**. 

No final do desenvolvimento, o projeto foi um sucesso, chegando a ser hospedado na AWS, mas infelizmente não foi possível ser consumido devido a problemas técnicos, mas tudo serviu como um grande aprendizado, e o ponto do trabalho foi bem significativo já que a matéria foi focada em back-end, a maior parte da pontuação foi distribuída nesta parte. 

Após o fim do semestre, foi decidido refazer tudo do projeto, implementando um novo código, novos conceitos e tecnologias, para exxtrair e implementar de uma forma mais detalhada todo o conhecimento aprendido na matéria, agora com mais tempo para prestar atenção aos minímos detalhes que a aplicação precisava. 

O projeto após um ano de desenvolvimento e modificações, ele está pronto para ser divulgado para a comunidade e servir como uma inspiração.

## Tecnologias
Para desenvolver esta aplicação, foi utlizado:
 - Apache Maven
 - Spring Boot Framework
 - Postgres SQL
 - Swagger ui
 - Docker

## Maven Dependencies 
Dependências Maven das tecnologias listadas acima:
 
 - **Spring Boot Framework:**
   - [Spring Boot Maven Plugin](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-maven-plugin);
   - [Spring Boot Starter Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa); 
   - [Spring Boot Starter Validation](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation);
   - [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web);
   - [Spring Boot Starter Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test);
 - **Lombok:**
   - [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.24);
 - **Postgresql:**
   - [PostgreSQL JDBC Driver](https://mvnrepository.com/artifact/postgresql/postgresql);
 - **H2 Database:**
   - [H2 Database Engine](https://mvnrepository.com/artifact/com.h2database/h2);

**Link** para o documento [pom.xml](https://github.com/Marlinsk/Park_H-backend/blob/main/backend/pom.xml) do projeto.

## Tutorial
Passo a passo de como executar a aplicação no computador

**Aviso:** É necessário ter o docker instalado na máquina.

**1º passo:** Entre na pasta do projeto e execute o comando para fazer o build das imagens e rodar os serviços no docker:
```
docker-compose up
```

**2º passo:** Feito isso, a aplicação estará rodando no docker, e agora pode ser acessada:
```
http://localhost:8080/
```

**Acréscimo:** Para acessar a documentação da Api Rest, basta entrar nesta rota:
```
http://localhost:8080/swagger-ui/
```
