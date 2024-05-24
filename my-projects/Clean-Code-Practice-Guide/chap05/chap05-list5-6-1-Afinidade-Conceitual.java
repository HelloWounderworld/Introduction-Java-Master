// Afinidade conceitual, em programacao, significa em organizar os nomes de forma que fiquem proximos.

// Como podemos ver os metodos abaixo, possuem nomes proximos, independentemente se eles tem alguma dependencia ou nao.
// Mesmo assim, ele entra dentro do significado do conceito de afinidade conceitual.

public class Assert {
    static public void assertTrue(String message, boolean condition) {
        if(!condition) fail(message);
    }

    static public void assertTrue(boolean condition) {
        assertTrue(null, condition);
    }

    static public void assertFalse(String message, boolean condition) {
        assertTrue(message, !condition);
    }

    static public void assertFalse(boolean condition) {
        assertFalse(null, condition);
    }
}
