## Teste Inmetrics - Passo-a-Passo

Projeto rodando no ChromeDriver 83.0.4103.39
Para outras versões do Chrome trocar o .exe na pasta drivers do projeto.

ChromeDriver Download: http://chromedriver.chromium.org/downloads

Requisitos:

1 - Estar com uma conexão de internet funcionando<br/>
2 - Ter instalado o eclipse ou outro software da sua preferencia que execute os testes em java, com jdk, jre instalados na maquina.
3 - Baixar o projeto na maquina local<br/>
4 - Neste projeto se encontra os testes "Desafio - Website" e o "Desafio - WebService"<br/>
5 - Para rodar o "Desafio - Website":<br/>
--> Na pasta "teste-inmetrics\src\test\java\br\com\inmetrics\teste\runner" se encontram 6 arquivos.<br/>
--> Para Rodar "Cadastrar usuário", rodar o arquivo "RunnerCadastrarUsuario" como Junit Test<br/>
--> Para Rodar "Login", rodar o arquivo "RunnerLogin" como Junit Test<br/>
--> Para Rodar "Cadastrar Funcionário", rodar o arquivo "RunnerFuncionario" como Junit Test<br/>
--> Para Rodar "Editar Funcionário", rodar o arquivo "RunnerFuncionarioEditar" como Junit Test<br/>
--> Para Rodar "Excluir Funcionário", rodar o arquivo "RunnerFuncionarioDeletar" como Junit Test<br/><br/>
  
6 - Para rodar o "Desafio - WebService":<br/>
--> Na pasta "teste-inmetrics\src\test\java\br\com\inmetrics\teste\APIRest" se encontra o arquivo "ChamadasApi"<br/>
--> Para rodar basta rodar o arquivo "ChamadasApi" com o Junit Test<br/>
--> Lá se encontram as funções:<br/>
----> 1 - PostCadastraUsuario (Cadastrar usuário (POST))<br/>
----> 2 - GetUsuariosCadastradoPorID (Listar usuário cadastrados (GET))<br/>
----> 3 - GetUsuariosCadastrado (Listar todos usuários (GET))<br/>
----> 4 - PutAlteraUsuario (Alterar usuário (PUT))<br/>
----> 5 - PutAlteraEmpregado (Alterar Empregado (PUT))<br/>

As configurações do jenkins e arquivos de evindências em HTML foram encaminhadas por e-mail e também se encontram na pasta do link abaixo:<br/>
https://drive.google.com/drive/folders/1lHtosm-MkD3C8VE9v48v9HcSyK3kXrAs?usp=sharing

