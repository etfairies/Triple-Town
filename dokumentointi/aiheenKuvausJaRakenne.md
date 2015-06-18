#Aihe: Triple Town -klooni

Triple Townissa rakennetaan kaupunkia yhdistelemällä samanlaisia palasia pelilaudalla. Kolmesta ruohikosta tulee pensas, kolmesta pensaasta puu, kolmesta puusta talo, jne kunnes pelilauta on täynnä taloja, kartanoita ja linnoja. Peli arpoo palaset, jotka pelaaja asettaa yksitellen pelilaudalle. Pelilaudalla voi olla myös liikkuvia karhuja eli esteitä, joiden paikalle ei voi asettaa palasia. Pisteitä saa jokaisesta yhdistetystä palasesta niin, että pensaasta saa vähiten pisteitä, linnasta eniten. Pisteet tallennetaan tiedostoon levylle. Pelilauta on 6x6 ruudun kokoinen.

Toiminnot:
- Pelin aloitus
- Palasen asettaminen pelilaudalle
- Pelin lopetus
- Pistetilaston tarkastelu

##Ohjelman rakenne:
Ohjelma koostuu Käyttöliittymä -luokasta joka luo graafisen käyttöliittymän, logiikkaluokasta Peli jossa on pelin logiikka, sekä Pala-luokasta ja sen aliluokista, joihin on tallennettu kunkin palan koordinaatit ja pisteet. Luokka Pistetilasto hoitaa pisteiden lukemisen ja tallettamisen tekstitiedostoon.

Käyttöliittymä kommunikoi Peli-luokan kanssa, joka hoitaa varsinaiset muutokset pelilaudalla. Peli-luokka luo Pala-olioita.

Käyttöliittymään kuuluu kuuntelijat aloitusruudun napeille ja pelilaudan ruuduille.

