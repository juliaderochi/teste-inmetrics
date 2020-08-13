## Teste Inmetrics - Passo-a-Passo


Requisitos:

1 - Estar com uma conexão de internet funcionando

2 - Baixar o projeto na maquina local

3 - Neste projeto se encontra os testes "Desafio - Website" e o "Desafio - WebService"

4 - Para rodar o "Desafio - Website":
	Na pasta "teste-inmetrics\src\test\java\br\com\inmetrics\teste\runner" se encontram 6 arquivos.
	Para Rodar "Cadastrar usuário", rodar o arquivo "RunnerCadastrarUsuario" como Junit Test
	Para Rodar "Login", rodar o arquivo "RunnerLogin" como Junit Test
	Para Rodar "Cadastrar Funcionário", rodar o arquivo "RunnerFuncionario" como Junit Test
	Para Rodar "Editar Funcionário", rodar o arquivo "RunnerFuncionarioEditar" como Junit Test
	Para Rodar "Excluir Funcionário", rodar o arquivo "RunnerFuncionarioDeletar" como Junit Test
  
5 - Para rodar o "Desafio - WebService":
	Na pasta "teste-inmetrics\src\test\java\br\com\inmetrics\teste\APIRest" se encontra o arquivo "ChamadasApi"
	Para rodar basta colocar "@Test" em cima da função que se deseja rodar e rodar o mesmo com Junit Test
	Lá se encontram as funções:
	1 - PostCadastraUsuario (Cadastrar usuário (POST))
	2 - GetUsuariosCadastradoPorID (Listar usuário cadastrados (GET))
	3 - GetUsuariosCadastrado (Listar todos usuários (GET))
	4 - PutAlteraUsuario (Alterar usuário (PUT))
	5 - PutAlteraEmpregado (Alterar Empregado (PUT))

