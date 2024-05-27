import packages.IO;


// Classe que representa uma carta do baralho
class Carta {
    // Atributos
    private int numeroCarta;
    private String corCarta;
    private String simboloCarta;
    // Construtor
    public Carta(int numeroCarta, String corCarta, String simboloCarta) {
        this.numeroCarta = numeroCarta;
        this.corCarta = corCarta;
        this.simboloCarta = simboloCarta;
    }
    @Override
    public String toString() {
        return ("Número: "+ this.getNumeroCarta() +
                    " Cor: "+ this.getCorCarta() +
                    " Simbolo: "+ this.getSimboloCarta());
    }
    // getter
    public int getNumeroCarta() { return numeroCarta; }
    public String getCorCarta() { return corCarta; }
    public String getSimboloCarta() { return simboloCarta; }
    // setter
    public void setNumero(int numeroCarta) { this.numeroCarta = numeroCarta; }
    public void setCor(String corCarta) { this.corCarta = corCarta; }
    public void setSimbolo(String simboloCarta) {this.simboloCarta = simboloCarta; }
}
