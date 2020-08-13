package br.com.inmetrics.teste.APIRest;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class HelperTestes {

	
	public String GetCPFValido() {
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
	
	public void DeletarUsuario(String id) {
		String urlCadastroUsuario = "https://inm-api-test.herokuapp.com/acesso/deletar/" + id;
		
        given()
	        .relaxedHTTPSValidation()
	        .auth().basic("inmetrics", "automacao")
	    .when()
	        .delete(urlCadastroUsuario)
	    .then()
	        .statusCode(202);

    	System.out.println("O usuario com Id " + id + " foi deletado");

	}


}
