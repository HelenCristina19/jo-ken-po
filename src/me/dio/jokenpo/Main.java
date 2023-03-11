package me.dio.jokenpo;

import me.dio.jokenpo.model.JoKenPo;
import me.dio.jokenpo.model.Jogador;

public class Main {
    public static void main(String[] args) {
        Jogador helen = new Jogador("helen");
        Jogador maquina = new Jogador("IA");

        JoKenPo joKenPo = new JoKenPo(helen, maquina, 5);

        joKenPo.jogar();
        joKenPo.exibirResultadoFinal();
    }
}