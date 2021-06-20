# Aplicação Park H 
Documento do repositório back-end da aplicação.<br/> 

**Aviso:** O projeto foi desenvolvido para fins de estudos acadêmicos, por isso não recomendamos aplicar essa arquitetura na sua empresa sem avaliar se os conceitos se aplicam às necessidades que sua empresa demanda.
<br/>

## Índice
- **Introdução;**
- **Arquitetura do projeto;**
- **Tecnologias e ferramentas utilizadas;**
- **Hands On;**

## Introdução
Os projetos neste repositório são microsserviços programados na linguagem Java com arquitetura API RestFull sobre o tema de aplicativo para divulgação de aluguel de garagem, onde os serviços vão desde a criação de conta do usuário até o anuncio do aluguel da garagem junto do preço.
<br/>

### Tecnologias e ferramentas utilizadas 
- **Apache Maven:** 
  - Maven compiler plugin;  
  - Maven buid;
  - Maven clean; 
  - Maven starter test;
- **Apache Commons:**
  - Commons Collections 4;
- **Amazon Web Service Tecnologies:**
  - AWS SDK;
  - AWS DynamoDB;
  - AWS CLI;
  - Amazon Elastic Container Registry (Amazon ECR);
  - Amazon Elastic Container Service (Amazon ECS); 
- **Spring Boot Framework:** 
  - Spring Boot Maven plugin;
  - Spring data DynamoDB;
  - Spring starter;
  - Spring starter parent;
  - Spring starter test;
  - Spring starter web;
  - Spring dev tools;
- **Swagger Software:** 
  - Swagger ui;
- **JUnit:**
  - JUnit test 4;
- **Docker:** utilizado para fazer os containers dos microsserviços.
- **Postman:** utilizado para realizar os testes dos serviços RestFULL de forma programada e automatizada.

## Dúvidas e Orientações 
**O que eu vou encontrar neste documento?**<br/> 
Neste documente está tudo sobre como foi implementada a arquitetura e as tecnologias utilizadas neste projeto, incluindo mini tutoriais para quem quiser fazer um fork para testar os códigos no seu próprio ambiente de desenvolvimento.

**O que eu vou precisar para rodar este projeto?**<br/>
- Recomendamos utilizar a IDE Eclipse com a extensão Apache Maven instalada, se não tiver instalado, pode fazer o download pela própria store(Ensinamos a como fazer isso no Hands On);
- Ter uma conta na Amazon Web Service;

**Posso contribuir no projeto?**<br/>
Para quem quiser contribuir com pull request, deve seguir as seguintes orientações: <br/>
- Quando for fazer um pull request para relatar um bug ou problema no código, escreva de forma detalhada junto de um print do erro;<br/>
- Se quiser passar uma sugestão de melhoramento do projeto, escreva onde o código deverá ser modificado para fazer essa melhora, e passe algumas sugestões de tecnológias que podem ajudar na construção dessa melhoria, também é válido links do Stack Overflow;<br/>
- Se a modificação do seu fork ficou legal e deseja mandá-lo para o código original como uma forma de contribuição no projeto. Escreva de forma detalhada as modificações e relate como essa modificação influência no funcionamento;<br/>
