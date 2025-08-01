Pré-requisitos

Certifique-se de que você tem o seguinte software instalado na sua máquina:

    Java Development Kit (JDK) versão 17 ou superior.

    Apache Maven (para o backend).

    Node.js e npm (para o frontend).

    Angular CLI (instale com npm install -g @angular/cli).

Passo 1: Rodar o Backend (Spring Boot)

O backend precisa estar rodando para que o frontend possa se comunicar com ele.

    Abra um terminal e navegue até a pasta backend.

    Execute o comando Maven para empacotar o projeto e rodar a aplicação:
    Bash

mvn clean install
mvn spring-boot:run

    O servidor do backend estará acessível em http://localhost:8080. 
Agora vá até o repositório: https://github.com/gvcunhadev/crud-frontend e clone o frontend
