package br.com.inmetrics.teste.APIRest;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HelperTestes {
	
	String NomeFuncionario;
	
	public String GetCPFValidoComPontuacao() {
		String urlCPF = "https://www.4devs.com.br/ferramentas_online.php";
		
		Response response =   
		given()
			.relaxedHTTPSValidation()
			.formParam("acao", "gerar_cpf")
			.formParam("pontuacao", "S")
			.formParam("cpf_estado", "")			
		.when()
			.post(urlCPF)
		.then()
			.statusCode(200)
	        .extract()
	        .response();
		
        System.out.println(response.asString());
        
        return response.asString();		
	}
	
	public String GetCPFValidoSemPontuacao() {
		String urlCPF = "https://www.4devs.com.br/ferramentas_online.php";
		
		Response response =   
		given()
			.relaxedHTTPSValidation()
			.formParam("acao", "gerar_cpf")
			.formParam("pontuacao", "S")
			.formParam("cpf_estado", "")			
		.when()
			.post(urlCPF)
		.then()
			.statusCode(200)
	        .extract()
	        .response();
		
        System.out.println(response.asString());
        
        return response.asString();		
	}
	
	public void PostCadastraEmpregado(String Nome) {
		
		String urlCadastroUsuario = "https://inm-api-test.herokuapp.com/empregado/cadastrar";
		
		JSONObject objetoUsuario = new JSONObject();
		
		objetoUsuario.accumulate("admissao", "01/09/2020");
		objetoUsuario.accumulate("cargo", "479");
		objetoUsuario.accumulate("comissao", "2.500,00");
		objetoUsuario.accumulate("cpf", GetCPFValidoComPontuacao());
		objetoUsuario.accumulate("departamentoId", "1");
		objetoUsuario.accumulate("nome", Nome);
		objetoUsuario.accumulate("salario", "8.500,00");
		objetoUsuario.accumulate("sexo", "f");
		objetoUsuario.accumulate("tipoContratacao", "clt");
		
        System.out.println(objetoUsuario);
        
			given()
				.relaxedHTTPSValidation()
		        .auth().basic("inmetrics", "automacao")
	               .contentType(ContentType.JSON)
	               .body(objetoUsuario.toString())
			.when()
				.post(urlCadastroUsuario)
			.then()
				.statusCode(202)
				.contentType(ContentType.JSON) ;

	}
}
