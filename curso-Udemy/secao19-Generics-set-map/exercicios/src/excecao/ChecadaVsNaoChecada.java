package excecao;

public class ChecadaVsNaoChecada {

	public static void main(String[] args) {
		try {
			geraErro1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
//		geraErro1();
		
		// Porém, mesmo que eu corrija o método abaixo, a sua chamada está tendo problema
//		geraErro2();
//		try {
//			geraErro2();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
		
		// Tratamento mais genérico
		try {
			geraErro2();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		System.out.println("Fim :)");
	}
	
	// Exceção Não checada ou não verificada = O tratamento do erro é opcional
	// Logo eu posso até colocar o "throw RuntimeException" abaixo que
	// na chamada "geraErro1()" sem o try/catch, não dará nenhum erro
	static void geraErro1() throws RuntimeException {
		// Só assim, não irá exibir nada
//		new RuntimeException("Ocorreu um erro bem legal #01!");
		throw new RuntimeException("Ocorreu um erro bem legal #01!");
//		System.out.println("..."); // não irá chegar até aqui
	}
	
	// É necessário colocar "throws Exception" para exceção checada ou verificada
	// Porém, mesmo ajustando o método abaixo com isso, acima, vamos ver que não vamos
	// conseguir chamar esse método
	// Se mesmo assim, eu quiser usar o método com a correção acima, então, uma das alternativas
	// é acrescentar "throws Exception" no método main
	// public static void main(String[] args) throws Exception
	// Mas, se vc não quiser lançar isso, a outra alternativa seria usando o try catch
	// na chamada "geraErro2()"
	// Para Exceção checada ou verificada = É necessário tratar o problema
	static void geraErro2() throws Exception {
		// Só assim, não irá exibir nada
//		new Exception("Ocorreu um erro bem legal #02!");
		throw new Exception("Ocorreu um erro bem legal #02!");
	}
	
	// Corrigindo o problema que está dando em "gerarErro2()"
//	static void geraErro2() {
//		// Só assim, não irá exibir nada
////		new Exception("Ocorreu um erro bem legal #02!");
//		try {
//			throw new Exception("Ocorreu um erro bem legal #02!");
//		} catch(Exception e) {
//			System.out.println("Legal!");
//		}
//	}
}
