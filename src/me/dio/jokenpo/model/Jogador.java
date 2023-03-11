package me.dio.jokenpo.model;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public record Jogador(String nome, AtomicInteger pontos) {

    public Jogador(String nome) {
        this(nome, new AtomicInteger(0));
    }

    public TiposJogada randomizarJogada() {
        TiposJogada[] tiposJogadas = TiposJogada.values();
        int indiceJogada = new Random().nextInt(tiposJogadas.length);
        return definirJogada(indiceJogada);
    }

    public TiposJogada definirJogada(int jogada) {
        TiposJogada[] tiposJogadas = TiposJogada.values();
        return tiposJogadas[jogada];
    }

    public int contabilizarVitoria() {
        return this.pontos.incrementAndGet();
    }
}
