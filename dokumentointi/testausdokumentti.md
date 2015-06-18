##Testausdokumentti

Peli-luokka

Testaamatta jätetyt metodit ja niiden sisällä olevat lauseet:

- alustaPelilauta()</br>
Metodi alustaa pelilaudan arpomalla satunnaisiin peliruutuihin satunnaisia paloja, pyörittäen for-loopia 15 kertaa. Ei ole tärkeää, kuinka monta palaa ruudulla on ja missä ne ovat.

- arvoPala()</br>
Metodi arpoo satunnaisen palanumeron. Metodi palauttaa numeron 1 jos mikään ehtolauseista ei toteudu.

- vierekkaistenPalojenHaku()</br>
Ei ole testattu sitä, että for-loop toistuu vaaditut 5 kertaa.

- tarkistaRuudut()</br>
En tiedä, miksi kaksi ensimmäistä riviä ei testata, mutta kaksi viimeistä testataan.

- tarkistaRuutu()</br>
Metodi on näkyvyydeltään private, joten metodin ehtolausetta ei voi suoraan testata pelilaudan ulkopuolisilla ruuduilla.

- liikutaKarhua()</br>
Metodi arpoo suunnan, johon karhua liikutetaan, joten sitä ei ole testattu.

-liikutaKarhuRuutuun()</br>
Karhu-muuttuja on luokan sisäinen olio, joten sen muuttuneita koordinaatteja ei testata.

Bugit</br>
Pisteet eivät välttämättä kasva oikein, jos paloja yhdistettäessä tulee pidempi ketjureaktio.

Kun peli loppuu, pelin pisteet eivät näy pistetilastossa palatessa päävalikkoon, vaan sovelluksen joutuu käynnistämään uudelleen.
