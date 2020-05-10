# Arkkitehtuuri


## Rakenne ja sovelluslogiikka

Luokka ja pakkauskaavio

(kuva)

Sovelluksen käyttöliittymän rakentava koodi ja sovellus logiikka on koitettu eriyttää. Sovellus on jaettu 
sovelluslogiikaksi(domain) ja käyttöliittymäksi (ui) joka koostuu käyttöliittymä palasista (komponents). Peli sisältää paljon 
grafiikkaa jonka takia ui luokka sisältää paljon palasia. Sovellus ei sisällä erikseen db/dao osuutta, vaikka statistiikka ehkä 
toimiikin hieman dao perjaatteilla. Sovellus tallentaa pelistä vain neljää numeroa ja yhtä isoa sanalistaa tallessa jonka takia
hienost
uneempaa tietokantaa ei sovellukseen toistaiseksi tarvita.

## Käyttöliittymä 

Käyttöliittymä rakentuu kolmesta näkymästä 

- Aloitusruutu

- Statistiikka

- Peli 

Jokainen näistä on oma luokkansa jotka sisältävät ruudulle laitettavan oman scenensä jonka voi laittaa stage olioon näkyville.
Aloitusruudun välillä voi siirtyä pelin ja statistiikan välillä. Aloitusruudulla valitaan myös uuden pelin sana.

## Tietojen tallennus ja tiedostot

- sanat.txt 
- statistiikka.txt

Pelissä käytetään satunnaista pelia varten tekstitiedostoa sanat.txt joka sisältää suomalaisia sanoja joista arvotaan peliä varten
aina yksi. Peleistä kerätään myös peli tilastoja tiedostoon statistiikka.txt. Johon tallennetaan pelit, voitot, arvaukset ja 
oikeat arvaukset. Muut tilastoitavat tiedot saadaan selville näiden neljän avulla. 

## Rakenteeseen jääneet heikkoudet

Pelissä on paljon grafiikkaa jonka vuoksi sovelluksen kasvaessa logiikan ja käyttöliittymän raja on paikoin hieman häilyvä. 
Esimerkiksi jotta statistiikasta sai selkeän kyseisellä rakenteella oli helpoin laittaa tilastointi kutsut tapahtumaan suoraan
käyttöliittymästä, jonka olisi voinut selkeämmällä pelin rakenteella laittaa vain peli luokkaan.



