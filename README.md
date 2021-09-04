# Park H - API  
Documentação back-end da aplicação Park H.<br/> 

**Aviso:** O projeto foi desenvolvido para fins de estudos acadêmicos, por isso não recomendamos aplicar essa arquitetura na sua empresa sem avaliar se os conceitos se aplicam para resolver às demandas de sua empresa.
<br/>

## O projeto
Park H é uma plataforma feita para anúnciar aluguel de garagem com o intuito de diversificar as opções desse serviço. Visando democratizar a procura pelo aluguel ideial que atende suas necessidades.

O projeto foi feito durante o 5º semestre da faculdade, com o intuito de estudar como funciona um projeto feito em arquitetura de microsserviços.

## Tecnologias
Para desenvolver esta aplicação utiliza-mos :
- [AWS Dynamo DB](https://aws.amazon.com/pt/dynamodb/)
- [Apache Maven](https://maven.apache.org/)
- [JUnit 5](https://junit.org/junit5/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Swagger UI](https://swagger.io/tools/swagger-ui/)
- [Postman](https://www.postman.com/)
## Maven Dependencies
Dependências Maven das tecnologias listadas acima :
- **Apache Maven:** 
  - [Maven compiler plugin](https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin/3.8.1);  
- **Apache Commons:**
  - [Commons Collections 4](https://mvnrepository.com/artifact/org.apache.commons/commons-collections4/4.4);
- **Amazon Web Service Tecnologies:**
  - [AWS Java SDK: Bill of Materials](https://mvnrepository.com/artifact/software.amazon.awssdk/bom/2.17.29);
  - [AWS Java SDK: Services - Amazon S3](https://mvnrepository.com/artifact/software.amazon.awssdk/s3/2.17.29);
- **Spring Boot Framework:** 
  - [Spring Boot Maven plugin](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-maven-plugin/2.5.4);
  - [Spring Data DynamoDB](https://mvnrepository.com/artifact/com.github.derjust/spring-data-dynamodb/5.1.0);
  - [Spring starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter/2.5.4);
  - [Spring starter parent](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-parent/2.5.4);
  - [Spring starter test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test/2.5.4);
  - [Spring starter web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web/2.5.4);
  - [Spring dev tools](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools/2.5.4);
- **Swagger:** 
  - [SpringFox Swagger2](https://mvnrepository.com/artifact/io.springfox/springfox-swagger2/3.0.0);
  - [SpringFox Swagger2 UI](https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui/3.0.0);
- **JUnit:**
  - [JUnit](https://mvnrepository.com/artifact/junit/junit/4.13.2);

**Link** para o documento [pom.xml](https://github.com/Marlinsk/Park_H-Backend/blob/master/backend-park/pom.xml) do projeto.

## Tutorial
Passo a passo para rodar o clone do projeto em sua máquina:<br/>

1. Execute o comando abaixo no Git Bash.
   
   ```bash
   $ git clone https://github.com/Marlinsk/Park_H-Backend.git
   ```
   **Observação:** Após clonar o repositório certifique-se de achar diretório onde ele está localizado em sua máquina*.

2. Terminando de clonar o repositório, abra o eclipse e siga os seguintes passos: <br/>

   1 - Clique em **File**; 
   
   2 - Clique em **Import**;

