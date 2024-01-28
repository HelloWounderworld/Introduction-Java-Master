package lambdas;

public class Threads {

	public static void main(String[] args) {
		
		// Classe anônima
		Runnable trabalho1 = new Trabalho1();
		Runnable trabalho2 = new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println("Tarefa #02");
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		};
		
//		Runnable trabalho3 = () -> {
//			for(int i = 0; i < 100; i++) {
//				System.out.println("Tarefa #03");
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//			}
//		};
		
		// Method Reference com classe.
		Runnable trabalho3 = Threads::trabalho3;
		
		// Processo paralelo
		Thread t1 = new Thread(trabalho1);
		Thread t2 = new Thread(trabalho2);
		Thread t3 = new Thread(trabalho3);
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	static void trabalho3() {
		for(int i = 0; i < 100; i++) {
			System.out.println("Tarefa #03");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
