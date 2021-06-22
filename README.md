# Aplicação Park H 
Documento do repositório back-end da aplicação.<br/> 

**Aviso:** O projeto foi desenvolvido para fins de estudos acadêmicos, por isso não recomendamos aplicar essa arquitetura na sua empresa sem avaliar se os conceitos se aplicam às necessidades que sua empresa demanda.
<br/>

## Dúvidas e Orientações 
**O que eu vou encontrar neste documento?**<br/> 
Neste documente está tudo sobre como foi implementada a arquitetura e as tecnologias utilizadas neste projeto, incluindo mini tutoriais para quem quiser fazer um fork para testar os códigos no seu próprio ambiente de desenvolvimento.

**O que eu vou precisar para rodar este projeto?**<br/>
- Sistema operacional de **86x 64bits**;
- Recomendamos utilizar a IDE Eclipse com a extensão Apache Maven instalada, se não tiver instalado, pode fazer o download pela própria store(Ensinamos a como fazer isso no Hands On);
- Ter uma conta na Amazon Web Service;

**Posso contribuir no projeto?**<br/>
Para quem quiser contribuir com pull request, deve seguir as seguintes orientações: <br/>
- Quando for fazer um pull request para relatar um bug ou problema no código, escreva de forma detalhada junto de um print do erro;<br/>
- Se quiser passar uma sugestão de melhoramento do projeto, escreva onde o código deverá ser modificado para fazer essa melhora, e passe algumas sugestões de tecnológias que podem ajudar na construção dessa melhoria, também é válido links do Stack Overflow;<br/>
- Se a modificação do seu fork ficou legal e deseja mandá-lo para o código original como uma forma de contribuição no projeto. Escreva de forma detalhada as modificações e relate como essa modificação influência no funcionamento;<br/>

## Introdução
Os projetos neste repositório são microsserviços programados na linguagem Java com arquitetura API RestFull sobre o tema de aplicativo para divulgação de aluguel de garagem, onde os serviços vão desde a criação de conta do usuário até o anuncio do aluguel da garagem junto do preço.
<br/>

### Arquitetura do projeto<br/>
![Diagrama da arquitetura](https://github.com/MarlonTSantosRodrigues/App_Park_H/blob/master/Arquitetura%20dos%20microsservi%C3%A7os.png)<br/> 

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

## Hands On
É hora de botar a mão na massa.

### Configurando a IDE
A IDE que vamos utilizar é o Eclipse, mas caso queira usar outra IDE, fique sabendo que algumas funções estão organizadas de formas diferentes, podendo confundir um pouco para quem é iniciante. Então por isso caso você seja um iniciante, recomendamos usar o Eclipse pois dessa forma você ficará menos perdido com as orientações que vamos passar.<br/>

### 1. Instalando o Eclipse Interprise
**Observação:** Para não precisar configurar o Maven direto no eclispe, vamos instalar o Eclipse Interprise, que vem com o Maven instalado e configurado.    

Acessando esse **link:** <https://www.eclipse.org/downloads/packages/release/2020-12/r/eclipse-ide-enterprise-java-developers>, você irá abrir esta página abaixo:

![Eclipse Interprise Download page](https://github.com/MarlonTSantosRodrigues/App_Park_H/blob/master/Tela%20do%20site%20Eclipse%20IDE%20foudation%201%201%20(1).png)

**Aviso:** Você precisa de um sistema operacional **x86_64bits.**<br/>

Escolha o sistema operacional que você possui e faça o download do installer e siga o passo a passo. Lembrando, caso queira instalar através do Zip, abra-o numa pasta que não possua ponto no inicio do nome da pasta. <br/>

### 2. Instalando o ZIP do projeto pelo repositório do GitHub
Com o Eclipse Enterprise IDE instalado, vamos agora instalar o código, existem várias formas de fazer o download do código para usar na máquina, uma forma que iremos aprender é instalando o pacote zip do projeto que é mais simples para quem não tem muito conhecimento das funções de clone do git.<br/>

Na página inicial do projeto clique no botão verde escrito **Code**, clicando nele irá aparecer um dropdown list com as opções, depois clique na opção escrita **Download ZIP**. <br/>

![Print da tela da opção de download do zip](https://github.com/MarlonTSantosRodrigues/App_Park_H/blob/master/Tela%20do%20github%20download%20zip%201.png)

Depois de fazer o dowload do zip, não é necessário, mas pra deixar o local organizado crie uma pasta e abra o zip dentro dela. Agora iremos para o próximo passo.

### 3. Importando o projeto para o Workspace do Eclipse
No Eplise clique em **File** e depois procure a opção **Import**.
<br/><br/>
Clicando em **Import** abrirá uma página com várias pastas, procure pela pasta **Maven** e clique na opção **Existing Maven Projects** e depois em **Next**.

![Step 1](https://github.com/MarlonTSantosRodrigues/App_Park_H/blob/master/Tela%20do%20Eclipse%201%201.png)

Depois de clicar em **Browser**, procure pela pasta que você criou para guardar o código extraído do zip que você fez o download. Após selecionar a página clique em **Finish**.

![Step 2](https://github.com/MarlonTSantosRodrigues/App_Park_H/blob/master/Tela%20do%20Eclipse%202%201.png)
