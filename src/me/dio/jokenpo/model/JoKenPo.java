package me.dio.jokenpo.model;

import java.util.Scanner;

public record JoKenPo(Jogador usuario, Jogador maquina, int rounds) {

    public void jogar() {
        for (int i = 1; i <= rounds; i++) {
            System.out.println("0 - PEDRA: ");
            System.out.println("1 - PAPEL: ");
            System.out.println("2 - TESOURA: ");
            System.out.printf("RODADA %d - Digite sua jogada: ", i);

            Scanner scan = new Scanner(System.in);
            int escolhaUsuario = scan.nextInt();

            if (escolhaUsuario > 2 || escolhaUsuario < 0) {
                System.out.printf("Digite uma jogada válida (0, 1 ou 2)! Ponto para %s!%n", maquina.nome());
                maquina.contabilizarVitoria();
                continue;
            }

            TiposJogada jogadaUsuario = usuario.definirJogada(escolhaUsuario);
            TiposJogada jogadaMaquina = maquina.randomizarJogada();

            int resultado = jogadaUsuario.ordinal() - jogadaMaquina.ordinal();

            String vencedorRodada;
            if (resultado == 0) {
                vencedorRodada = "EMPATE";
            } else if (resultado == -1 || resultado == 2) {
                vencedorRodada = maquina.nome();
                maquina.contabilizarVitoria();
            } else {
                vencedorRodada = usuario.nome();
                usuario.contabilizarVitoria();
            }
            System.out.printf("%s vs %s: %s!%n", jogadaUsuario, jogadaMaquina, vencedorRodada);
            System.out.println();
        }
    }

    public void exibirResultadoFinal() {
        int pontuacaoFinalUsuario = usuario.pontos().get();
        int pontuacaoFinalMaquina = maquina.pontos().get();

        System.out.println("---------------------------------------");
        System.out.println("Pontuação: User = " + pontuacaoFinalUsuario + " vs Máquina = " + pontuacaoFinalMaquina);

        if (pontuacaoFinalMaquina > pontuacaoFinalUsuario) {
            System.out.println("VENCEDOR = MÁQUINA");
        } else if (pontuacaoFinalMaquina < pontuacaoFinalUsuario) {
            System.out.println("VENCEDOR = USER");
        } else {
            System.out.println("EMPATE!");
        }
    }
}
