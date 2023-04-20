package Domain;

public class Calculadora extends Operaciones {
    // Hereda la clase operaciones para usar sus funciones ya definidas
    private boolean status;

    public Calculadora(){
        this.status = true;
    }

    public boolean getStatus() {
        return status;
    }

}
