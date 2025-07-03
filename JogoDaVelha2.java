import java.util.Scanner;

public class JogoDaVelha2{
    
    //Método para imprimir tabuleiro
    public static void imprimirTabuleiro(char[][] tabuleiro){
        System.out.println();
        for(int linha=0; linha<3; linha++){
            for(int coluna=0; coluna<3; coluna++){
                System.out.print("\t"+tabuleiro[linha][coluna]);
                if(coluna < 2)
                    System.out.print("\t|");
            }
            System.out.println();
            if(linha < 2)
                System.out.println("---------------------------------------------");
        }  
        System.out.println();      
    }

    //Método para verificar vencedor
    public static boolean verificarVelha(char[][] tabuleiro){
        boolean venceu = false;

        //Verifica as linhas
        for (int z = 0; z < 3; z++) {
            if (tabuleiro[z][0] != ' ' && tabuleiro[z][0] == tabuleiro[z][1] && tabuleiro[z][1] == tabuleiro[z][2]) {
                System.out.println("Jogador '" + tabuleiro[z][0] + "' venceu na linha " + (z + 1));
                venceu = true;
                break;
            }
        }
            
        //Verifica as colunas
        for (int l = 0; l < 3; l++) {
            if (tabuleiro[0][l] != ' ' && tabuleiro[0][l] == tabuleiro[1][l] && tabuleiro[1][l] == tabuleiro[2][l]) {
                System.out.println("Jogador '" + tabuleiro[0][l] + "' venceu na coluna " + (l + 1));
                venceu = true;
                break;
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

        return venceu;
    }

    public static void main(String[] args){
        System.out.println("### JOGO DA VELHA ###");
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        char jogador1 = 'X';
        char jogador2 = 'O';
        char[][] matriz = 
        {
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '},                
        };

        while(continuar){
            boolean vitoria = false;
            
            for(int i=0; i<9; i++){
                System.out.println("Rodada: "+(i+1));

                //Verificando jogador
                if(i % 2 == 0){
                    System.out.println("E a vez do jogador: 1 - 'X'");
                    System.out.print("Linha: ");
                    int linha = scanner.nextInt();
                    System.out.print("Coluna: ");
                    int coluna = scanner.nextInt();
                    matriz[linha-1][coluna-1] = jogador1;
                }else{
                    System.out.println("E a vez do jogador: 2 - 'O'");
                    System.out.print("Linha: ");
                    int linha = scanner.nextInt();
                    System.out.print("Coluna: ");
                    int coluna = scanner.nextInt();
                    matriz[linha-1][coluna-1] = jogador2;
                }

                //Exibindo matriz
                imprimirTabuleiro(matriz);

                //Verificando vencedor
                if(verificarVelha(matriz)) {
                    vitoria = true;
                    break;
                }

            }

            if(!vitoria){
                System.out.println("Empate!");
            }

            System.out.println("\nDeseja jogar novamente? s/n");
            String resposta = scanner.next();

            if(!resposta.equalsIgnoreCase("s")){
                continuar = false;
                System.out.println("Jogo encerrado!");
            } else {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                    matriz[i][j] = ' ';
                    }
                }
            }
        }
    }
}