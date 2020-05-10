#Testausdokumentti

Ohjelmaa on testattu JUnit testeillä sekä manuaalisesti

## Yksikkö- ja integraatiotestaus 

### sovelluslogiikka

Jokaiselle domain hakemistossa sijaitsevalle luokalle on oma JUnit testiluokka.
Testauksen rivikattavuus sovellus logiikassa on 92% ja haarautumakattavuus 86%.

(kuva tulee tähän)

### Järjestelmätestaus

Järmestelmätestaus on tehty manuaalisesti graafisen käyttöliittymän avulla. 

### Toiminnallisuudet

Sovelluksen kaikki määrittelydokumentin listaamat toiminnallisuudet ollaan kokeiltu ja todettu toimiviksi.

### Asennus ja konfigurointi

Sovellusta ollaan testattu ilman vaadittuja teksitiedostoja statistiikka.txt ja sanat.txt jolloin sovelluksessa ei ole 
aloitusruudun lisäksi mitään käytännön toiminnallisuutta.

## Sovellukseen jääneet laatuongelmat

- Sovelluksen ruudun koko vaihtelee tarpeettomasti etenkin statistiikka ruutuun mentäessä
- Joskus arvattavan lauseen tai sanan ollessa todella pitkä on peliruudun oletus koko liian pieni
- Erikoisia kirjaimia ei voi arvata yksittäisin kirjaimin, joten peli esim ranskaksi ei ole mahdollista
