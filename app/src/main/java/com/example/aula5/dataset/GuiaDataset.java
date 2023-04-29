package com.example.aula5.dataset;

import com.example.aula5.Locais;
import com.example.aula5.R;
import com.example.aula5.Locais;
import java.util.ArrayList;
import java.util.List;

public class GuiaDataset {
    // criação de uma lista chamada "locais" que recebe objetos da classe Locais
    private static List<Locais> locais;

    // criação do método getLista que adiciona itens no array
    public static List<Locais> getLista(){
        locais = new ArrayList<>();
        // o que colocar na parte do botão?
        locais.add(new Locais("Jardim Botânico", "A intenção da criação do jardim é o estudo e pesquisa da flora da região, além de desenvolver a consciência ambiental e lazer da cidade de Sorocaba. ", R.mipmap.jdbotanico));
        locais.add(new Locais("Flow Public House", "Endereço: R. Santa Clara, 383 - Centro, Sorocaba - SP, 18035-252 / Fecha às 15:00 ⋅ Reabre às 18:00 / Telefone: (15) 3142-3657", R.mipmap.flow));
        locais.add(new Locais("Mr. Bowls", "Descrição...", R.mipmap.mrbowls));
        // retorna um array "locais" com todos os itens adicionados
        return locais;
    }

    // criação do método "addLocal", que recebe um objeto "local" da classe "Locais" e adiciona na lista "locais"
    public static void addLocal(Locais local){
        locais.add(local);
    }

}