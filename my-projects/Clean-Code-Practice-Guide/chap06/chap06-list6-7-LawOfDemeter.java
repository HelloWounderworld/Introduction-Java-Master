// https://pt.wikipedia.org/wiki/Lei_de_Demeter

// Vamos fornecer doi exemplos uma que nao retrata e outra que retrata direito a Lei de Demeter (LoD).
// Leia o conceito de Lei de Demeter e explique por si mesmo onde esta errado do exemplo que nao segue essa lei e outra que segue.

// Cada unidade deve ter conhecimento limitado sobre outras unidades: apenas unidades próximas se relacionam. 
// Cada unidade deve apenas conversar com seus amigos; Não fale com estranhos. 
// Apenas fale com seus amigos imediatos.

// Exemplo do que nao segue a Lei de Demeter
public class Engine {
    private Oil oil;

    public Oil getOil() {
        return oil;
    }
}

public class Car {
    private Engine engine;

    public Engine getEngine() {
        return engine;
    }
}

public class Driver {
    private Car car;

    public Driver(Car car) {
        this.car = car;
    }

    public void checkOilLevel() {
        // This code violates the Law of Demeter because it reaches through multiple objects.
        Oil oil = car.getEngine().getOil();
        System.out.println("Oil level: " + oil.getLevel());
    }
}

// Exemplo do que segue a Lei de Demeter
public class Oil {
    public int getLevel() {
        // Assume some logic to get oil level
        return 5;
    }
}

public class Engine {
    private Oil oil;

    public int getOilLevel() {
        return oil.getLevel();
    }
}

public class Car {
    private Engine engine;

    public int getOilLevel() {
        return engine.getOilLevel();
    }
}

public class Driver {
    private Car car;

    public Driver(Car car) {
        this.car = car;
    }

    public void checkOilLevel() {
        // This code follows the Law of Demeter because it only talks to its immediate friend, the Car.
        int oilLevel = car.getOilLevel();
        System.out.println("Oil level: " + oilLevel);
    }
}
