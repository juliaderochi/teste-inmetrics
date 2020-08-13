package br.com.inmetrics.teste.APIRest;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class ChamadasApi {
	
	Integer idEmpregado;
	Integer acessoId;
	Response response;
	
	HelperTestes helperTestes = new HelperTestes();
	
	//Cadastrar Empregado para utilizar no cadastro de usuario
	public String PostCadastraEmpregado() {
		
		String urlCadastroUsuario = "https://inm-api-test.herokuapp.com/empregado/cadastrar";
		
		JSONObject objetoUsuario = new JSONObject();
		
		objetoUsuario.accumulate("admissao", "01/09/2020");
		objetoUsuario.accumulate("cargo", "479");
		objetoUsuario.accumulate("comissao", "2.500,00");
		objetoUsuario.accumulate("cpf", helperTestes.GetCPFValido());
		objetoUsuario.accumulate("departamentoId", "1");
		objetoUsuario.accumulate("nome", "Julia Zinco");
		objetoUsuario.accumulate("salario", "8.500,00");
		objetoUsuario.accumulate("sexo", "f");
		objetoUsuario.accumulate("tipoContratacao", "clt");
		
        System.out.println(objetoUsuario);;

		idEmpregado =        
			given()
				.relaxedHTTPSValidation()
		        .auth().basic("inmetrics", "automacao")
	               .contentType(ContentType.JSON)
	               .body(objetoUsuario.toString())
			.when()
				.post(urlCadastroUsuario)
			.then()
				.statusCode(202)
				.contentType(ContentType.JSON) 
		        .extract()
	            .path("empregadoId");
			
        System.out.println(idEmpregado.toString());
        
       return idEmpregado.toString();

	}
	
	//Cadastra usuario para listar
	public Integer PostCadastraUsuarioRetornaID() {
		
		String urlCadastroUsuario = "https://inm-api-test.herokuapp.com/acesso/cadastrar";
		
		JSONObject objetoUsuario = new JSONObject();
		
		objetoUsuario.accumulate("email", "juliaderochi@tsseste.com");
		objetoUsuario.accumulate("empregadoId", PostCadastraEmpregado());
		objetoUsuario.accumulate("password", "12345");
		
        acessoId =        
			given()
				.relaxedHTTPSValidation()
		        .auth().basic("inmetrics", "automacao")
	               .contentType(ContentType.JSON)
	               .body(objetoUsuario.toString())
			.when()
				.post(urlCadastroUsuario)
			.then()
				.statusCode(202)
				.contentType(ContentType.JSON) 
		        .extract()
	            .path("acessoId");
		
        System.out.println("o usuario é" +acessoId.toString());
		return acessoId;

	}
	
	//1 - Cadastrar Usuario	
	public void PostCadastraUsuario() {		
		String urlCadastroUsuario = "https://inm-api-test.herokuapp.com/acesso/cadastrar";
		
		JSONObject objetoUsuario = new JSONObject();
		
		objetoUsuario.accumulate("email", "juliaderochi@tsseste.com");
		objetoUsuario.accumulate("empregadoId", PostCadastraEmpregado());
		objetoUsuario.accumulate("password", "12345");
		
        System.out.println(objetoUsuario);;

		response =        
			given()
				.relaxedHTTPSValidation()
		        .auth().basic("inmetrics", "automacao")
	               .contentType(ContentType.JSON)
	               .body(objetoUsuario.toString())
			.when()
				.post(urlCadastroUsuario)
			.then()
				.statusCode(202)
				.contentType(ContentType.JSON) 
		        .extract()
		        .response();
			
		System.out.println(response.asString());

	}

	// 2 - Lista usuarios cadastrado passando o id
	
	public void GetUsuariosCadastradoPorID() {
		String urListaId = "https://inm-api-test.herokuapp.com/acesso/list/" + PostCadastraUsuarioRetornaID().toString();
	
		response =
			given()
				.relaxedHTTPSValidation()
		        .auth().basic("inmetrics", "automacao")
			.when()
				.get(urListaId)
			.then()
				.statusCode(202)
				.contentType(ContentType.JSON) 
		        .extract()
		        .response();
		
		System.out.println("O usuario cadastrado foi " + response.asString()); 
	}

	
	// 3 - Lista todos os usuarios cadastrados
	public void GetUsuariosCadastrado() {
		
		String urListaAll = "https://inm-api-test.herokuapp.com/acesso/list_all";

		response =
			given()
				.relaxedHTTPSValidation()
		        .auth().basic("inmetrics", "automacao")
			.when()
				.get(urListaAll)
			.then()
				.statusCode(200)
				.contentType(ContentType.JSON) 
		        .extract()
		        .response();
		        	
		JSONArray array = new JSONArray(response.asString());

        for(int i = 0 ; i < array.length() ; i++){
        	System.out.println(array.getJSONObject(i));
        }       
        
	}
	
	// 4 - Alterar o cadastro de usuario - Verificar que não é possivel realizar essa operação, acredito no back-end
	// Ao cadastrar um usuario
	// E tentar editar o mesmo
	// Ocorre o erro no servidor, criando um novo registro de usuario com os dados enviados para alterar
	
	public void PutAlteraUsuario() {
		String idUsuario = PostCadastraUsuarioRetornaID().toString();

		System.out.print("O id do usuario é" + idUsuario);
		String urlAlterar = "https://inm-api-test.herokuapp.com/acesso/alterar/" + idUsuario;
		
		JSONObject objetoUsuario = new JSONObject();
		
		objetoUsuario.accumulate("email", "testea@teste.com");
		objetoUsuario.accumulate("empregadoId", idEmpregado.toString());
		objetoUsuario.accumulate("password", "758d5");
		
			given()
				.relaxedHTTPSValidation()
		        .auth().basic("inmetrics", "automacao")
	            .contentType(ContentType.JSON)
	            .body(objetoUsuario.toString())
			.when()
				.put(urlAlterar)
			.then()
				.statusCode(202)
				.contentType(ContentType.JSON);
				
		
		System.out.println("O usuario com id "+ idUsuario +" foi alterado"); 
	}
	
	// 5 - Alterar Empregado - realizei para verificar que a função acima estava funcionando
	@Test
	public void PutAlteraEmpregado() {
		
		acessoId = PostCadastraUsuarioRetornaID();
		String urlAlterar = "https://inm-api-test.herokuapp.com/empregado/alterar/" + idEmpregado;
		
		JSONObject objetoUsuario = new JSONObject();
		
		objetoUsuario.accumulate("admissao", "01/09/2020");
		objetoUsuario.accumulate("cargo", "479");
		objetoUsuario.accumulate("comissao", "2.500,00");
		objetoUsuario.accumulate("cpf", helperTestes.GetCPFValido());
		objetoUsuario.accumulate("departamentoId", "1");
		objetoUsuario.accumulate("nome", "Julia Zinco");
		objetoUsuario.accumulate("salario", "8.700,00");
		objetoUsuario.accumulate("sexo", "f");
		objetoUsuario.accumulate("tipoContratacao", "clt");
		
			given()
				.relaxedHTTPSValidation()
		        .auth().basic("inmetrics", "automacao")
	            .contentType(ContentType.JSON)
	            .body(objetoUsuario.toString())
			.when()
				.put(urlAlterar)
			.then()
				.statusCode(202)
				.contentType(ContentType.JSON);
				
		
		System.out.println("O empregado com id "+ idEmpregado +" foi alterado"); 
	}


}