import packages.IO;
import java.util.ArrayList;


// Classe principal BlackJack
public class main {
    public static void main(String[] args) {
        Baralho bj = new baralhoBJ();
        while (true) {
            DealerPlayer player = new DealerPlayer();
            DealerPlayer dealer = new DealerPlayer();
            bj.baralhoCreate();
            bj.embaralhar();
            int opcao = IO.prinInt(
                "\n------------------------------"
                + "\n\tBLACK JACK 21"   
                + "\n------------------------------"
                + "\n1 - Começar o jogo"
                + "\n2 - Sair", "Digite uma opção válida"
                );
            switch (opcao) {
                case 1:
                    for(int i = 0; i < 1; i++) {
                        player.comprar(bj);
                    }
                    for(int i = 0; i < 1; i++) {
                        dealer.comprar(bj);
                    }
                    int index = 1;
                    dealer.printCartasDealer("Dealer", index);
                    dealer.verificarAS("Dealer", false);
                    player.printCartasPlayer("Player", index);
                    player.verificarAS("Player", true);
                    int totalPlayer = player.sumarNumeros();
                    while (true) { 
                        while (true) {
                        totalPlayer = player.sumarNumeros();
                        if (totalPlayer == 21) {
                            IO.prin("\nA soma da tuas cartas dá: " + totalPlayer 
                            + "\nBLACK JACK");
                            break;
                        } else {
                            int opcaoCompra = IO.prinInt("\nA soma da tuas cartas dá: " + totalPlayer
                            + "\nQuer comprar uma nova carta? "
                            + "\n1 - Sim"
                            + "\n2 - Não", "Digite uma opção válida");
                            bj.embaralhar();
                            if (opcaoCompra == 1) {
                                player.comprar(bj);
                                player.verificarAS("Player", true);
                                totalPlayer = player.sumarNumeros();
                                player.printCartasComprada("Player", index);
                                if (totalPlayer > 21) {
                                    IO.prin("\nA soma da tuas cartas dá: " + totalPlayer 
                                    + "\nArrebentou o valor: VOCÊ PERDEU");
                                    break;
                                }
                            } else if (opcaoCompra == 2) {
                                break;
                            } else {
                                IO.prin("Digite uma opção válida");
                            }
                        }
                    }
                    if (totalPlayer > 21) {
                        break;
                    }
                    dealer.printCartasPlayer("Dealer", index);
                    int totalDealer = dealer.sumarNumeros();
                    IO.prin("\nA soma das cartas do Dealer é: " + totalDealer);
                    if (totalDealer < totalPlayer) {
                        bj.embaralhar();
                        while (totalDealer < totalPlayer) {
                            dealer.comprar(bj);
                            dealer.verificarAS("Dealer", false);
                            dealer.printCartasComprada("Dealer", index);
                            totalDealer = dealer.sumarNumeros();
                            if (totalDealer > 21) {
                                IO.prin("\nA soma das cartas do Dealer é: " + totalDealer 
                                + "\nO Dealer arrebentou o valor: VOCÊ GANHOU");
                                break;
                            } else if (totalDealer == 21 && totalPlayer == 21) {
                                IO.prin(
                            "\nA soma da tuas cartas dá: " + totalPlayer
                            + "\nA soma das cartas do Dealer é: " + totalDealer
                            + "\nEMPATE BLACK JACK");
                                break;
                            } else if (totalDealer > totalPlayer) {
                                IO.prin(
                            "\nA soma da tuas cartas dá: " + totalPlayer
                            + "\nA soma das cartas do Dealer é: " + totalDealer
                            + "\nDEALER GANHOU");
                                break;
                            } else if (totalPlayer == totalDealer) {
                                IO.prin(
                            "\nA soma da tuas cartas dá: " + totalPlayer
                            + "\nA soma das cartas do Dealer é: " + totalDealer
                            + "\nEMPATE");
                                break;
                            }
                        }
                    } else if (totalDealer > totalPlayer) {
                        IO.prin(
                            "\nA soma da tuas cartas dá: " + totalPlayer
                            + "\nA soma das cartas do Dealer é: " + totalDealer
                            + "\nDEALER GANHOU");
                    } else if (totalDealer == totalPlayer) {
                        IO.prin(
                            "\nA soma da tuas cartas dá: " + totalPlayer
                            + "\nA soma das cartas do Dealer é: " + totalDealer
                            + "\nEMPATE");
                    } 
                    if (totalDealer == totalPlayer) {
                        break;
                    } else if (totalDealer > 21) {
                        break;
                    } else  if (totalDealer == 21 && totalPlayer == 21) {
                        break;
                    } else if (totalDealer > totalPlayer) {
                        break;
                    } else if (totalPlayer == totalDealer) {
                        break;
                    }
                }
                break;
                case 2:
                    IO.prin("Encerrando...");
                    return; 
                default:
                    IO.prin("Opção inválida.");
            }
        }
    }
}
