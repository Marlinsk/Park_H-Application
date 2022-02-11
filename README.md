# Park H - API  
### Documentação back-end da aplicação Park H.<br/> 

**Aviso importante:** O projeto foi desenvolvido para fins de estudos acadêmicos, por isso não recomendamos aplicar essa arquitetura na sua empresa sem avaliar se os conceitos se aplicam para resolver às demandas de sua empresa.
<br/>

## O projeto
Park H é uma plataforma feita para anúnciar aluguel de garagem com o intuito de diversificar as opções desse serviço. Visando democratizar a procura pelo aluguel ideial que atende suas necessidades.

O projeto foi feito durante o 5º semestre da faculdade, com o intuito de estudar como funciona um projeto feito em arquitetura de microsserviços.

## Tecnologias
Para desenvolver esta aplicação utiliza-mos:
- [AWS Dynamo DB](https://aws.amazon.com/pt/dynamodb/)
- [Apache Maven](https://maven.apache.org/)
- [JUnit 5](https://junit.org/junit5/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Swagger UI](https://swagger.io/tools/swagger-ui/)
- [Postman](https://www.postman.com/)
## Maven Dependencies
Dependências Maven das tecnologias listadas acima:
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
Passo a passo de como rodar a aplicação na sua máquina:

**1º passo:** Crie uma conta na **AWS** (**obs.:** é necessário ter um cartão de crédito, mas não se preocupe, pois a cobrança só será feita a partir do momento em que exceder o limite dos serviços gratuitos), após criada a conta, procure em **Services** por **DynamoDB**.

**2º passo:** Após clicar no **DynamoDB** em **Services**, clique no em tabelas, feito procure pela opção criar uma nova tabela, nisso é só seguir o que pede. Na chave de partição escreva **id**. 

**3º passo:** Antes de ir para o **Eclipse**, na barra de menu superior do site da **AWS**, clique em cima do nome da sua conta e depois clique na opção **My Security Credentials**. Feito isso procure por **Chaves de acesso** e depois clique na opção **Criar uma nova chave de acesso** copie as duas senhas e crie um arquivo **application.properties** com a seguinte anotação:
```
 amazon.aws.accesskey=CHAVE DE ACESSO
 amazon.aws.secretkey=CHAVE SECRETA
```
Finalizado está parte, é hora de ir para o **Eclipse**.

**4º passo:** No **Eclipse**, clone o repositório e abra a classe entidade **AluguelGaragem**, procure e altere o nome tabela na seguinte anotação:
```
@DynamoDBTable(tableName = "NOME DA SUA TABELA CRIADA NA AWS") 
```
**5º passo:** Agora clique na setinha ao lado do botão verde de rodar a aplicação, ao fazer isso clique em **Run Configurations**, depois vá em **Java Application** e clique duas vezes. 

**6º passo:** Criado a nova configuração, coloque a classe principal(classe Application) em **Main class**, depois selecione **Arguments** e digite em **VM arguments**: 
```
-ea -Dspring.config.location=CAMINHO DO DIRETÓRIO EM QUE ESTÁ O application.properties 
```
Exemplo de como ficaria:
```
-ea -Dspring.config.location=C:/Users/Usuario/aws/ 
```
**Obs.:** Não é necessário colocar o nome application.properties, somente a pasta onde ele está, e ' / '.

**7º passo:** Para finalizar vá para a opção **Dependencies** e selecione **Exclude test code** e depois ponha a aplicação para rodar. 

**8º passo:** Para interagir com as API's acesse os links abaixo:

Link para interagir com os serviços Rest via **Swagger UI**:
```
http://localhost:8080/park-api/swagger-ui.html
```
Link para interagir com os serviços Rest via **Postman**:
```
http://localhost:8080/park-api/cadastrar-aluguel/
```
