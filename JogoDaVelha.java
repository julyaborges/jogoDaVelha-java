import java.util.Scanner;

public class JogoDaVelha{

    public static void main(String[] args){

        char[][] tabuleiro = new char[3][3];
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        char jogador1 = 'X';
        char jogador2 = 'O';

        // Inicializar o tabuleiro com espaços vazios
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }

        while(continuar){
            boolean venceu = false;

            //Controlando as rodadas
            for(int i = 0; i < 9; i++){
                System.out.println("Rodada: "+(i+1));

                //Verificando jogador
                if(i % 2 == 0){
                    System.out.println("E a vez do jogador: 1 - X");
                    System.out.print("Linha: ");
                    int linha = scanner.nextInt();
                    System.out.print("Coluna: ");
                    int coluna = scanner.nextInt();
                    tabuleiro[linha-1][coluna-1] = jogador1;
                }else{
                    System.out.println("E a vez do jogador: 2 - O");
                    System.out.print("Linha: ");
                    int linha = scanner.nextInt();
                    System.out.print("Coluna: ");
                    int coluna = scanner.nextInt();
                    tabuleiro[linha-1][coluna-1] = jogador2;
                }
                
                //Exibir Tabuleiro
                for(int y=0; y<3; y++){
                    for(int j = 0; j<3; j++){
                        tabuleiro[i][j] = ' ';
                        System.out.print(tabuleiro[y][j]+" | ");
                    }
                    System.out.println("");
                }

                //Verifica as linhas
                for (int z = 0; z < 3; z++) {
                    if (tabuleiro[z][0] != ' ' && tabuleiro[z][0] == tabuleiro[z][1] && tabuleiro[z][1] == tabuleiro[z][2]) {
                        System.out.println("Jogador " + tabuleiro[z][0] + " venceu na linha " + z);
                        venceu = true;
                    }
                }
                //Verifica as colunas
                for (int l = 0; l < 3; l++) {
                    if (tabuleiro[0][l] != ' ' && tabuleiro[0][l] == tabuleiro[1][l] && tabuleiro[1][l] == tabuleiro[2][l]) {
                        System.out.println("Jogador " + tabuleiro[0][l] + " venceu na coluna " + l);
                        venceu = true;
                    }
                }
                //Verifica diagonal principal
                if (tabuleiro[0][0] != ' ' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
                    System.out.println("Jogador " + tabuleiro[0][0] + " venceu na diagonal principal");
                    venceu = true;
                }
                //Verifica diagonal secundária
                if (tabuleiro[0][2] != ' ' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
                    System.out.println("Jogador " + tabuleiro[0][2] + " venceu na diagonal 2");
                    venceu = true;
                }
                
                break;
            }

            if(!venceu){
                System.out.println("Empate!");
            }

            System.out.println("\nDeseja jogar novamente? s/n");
            String resposta = scanner.next();

            if(!resposta.equalsIgnoreCase("s")){
                continuar = false;
                System.out.println("Jogo encerrado!");
            }
        }

    }
}