package com.app.turistae.dataset;

import com.app.turistae.model.Turismo;


import java.util.ArrayList;
import java.util.List;

public class TurismoDataset {

    private static List<Turismo> lista;

    public static List<Turismo> getLista(){
        lista = new ArrayList<>();
//        lista.add(new Turismo("Zoológico de sorocaba", "O zoológico de Sorocaba é um parque de conservação animal que abriga mais de 1000 animais de diferentes espécies em um ambiente naturalista e educativo.", "R. Teodoro Kaisel, 883 - Vila Hortência, Sorocaba - SP, 18020-268", "https://www.sorocaba.sp.gov.br/zoologico/","(15) 3227-5454", R.mipmap.zoo,  new int[]{R.mipmap.zoo,R.mipmap.zoo_1,R.mipmap.zoo_2} ));
//        lista.add(new Turismo("Parque das águas", "Um grande parque público com uma série de atividades para toda a família, incluindo trilhas, áreas de piquenique, playgrounds, quadras esportivas, lagos, fontes e muito mais.", "R. Antônio Joaquim Santana, 714 – Jardim Abaete – Sorocaba – SP – CEP: 18081-295", "https://turismo.sorocaba.sp.gov.br/visite/parque-das-aguas/","(15) 3227-1173", R.mipmap.parque_das_aguas_1, new int[]{R.mipmap.parque_das_aguas_1,R.mipmap.parque_das_aguas_2,R.mipmap.parque_das_aguas_3} ));
//        lista.add(new Turismo("Mercado Municipal de Sorocaba", " Mercado tradicional com mais de 90 anos de história, oferecendo produtos frescos e lanchonetes/restaurantes.", "R. Padre Luiz, 82 - Centro, Sorocaba - SP, 18035-011", "https://www.ipatrimonio.org/sorocaba-mercado-municipal/","(15) 3233-2057", R.mipmap.mercado_municipal_1, new int[]{R.mipmap.mercado_municipal_1,R.mipmap.mercado_municipal_2,R.mipmap.mercado_municipal_3} ));
//        lista.add(new Turismo("Parque da Biquinha", " Parque urbano com áreas verdes, playground, academia ao ar livre, quadra poliesportiva e fonte de água em formato de biquinho.", "Av. Comendador Pereira Inácio, 1112 - Jardim Vergueiro, Sorocaba - SP, 18030-005", "https://turismo.sorocaba.sp.gov.br/visite/parque-da-biquinha-2/","(15) 3224-1997", R.mipmap.biquinha_1, new int[]{R.mipmap.biquinha_1,R.mipmap.biquinha_2,R.mipmap.biquinha_3} ));

        return lista;

    }

    public static void addTurismo(Turismo turismo){
        lista.add(turismo);

    }


}
