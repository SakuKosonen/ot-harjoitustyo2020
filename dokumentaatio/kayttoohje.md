# Käyttöohje

lataa [uusin release](https://github.com/SakuKosonen/ot-harjoitustyo2020/releases/tag/viikko7) kohdasta tiedostot 
- hirsipuu.jar
- statistiikka.txt
- sanat.txt

## Konfigurointi

- laita kaikki ladatut tiedostot saman hakemiston alle
  
- varmista että statistiikka.txt sisältää vain 4 kokonaislukua ja jokainen kokonaisluku on omalla rivillään


## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 
	> java -jar Hirsipuu.jar


## Pelin aloittaminen 

Kirjoita aloitus ruudun teksikenttään sana jolla halutaan pelata tai jätä tekstikenttä tyhjäksi jolloin aloitat pelin 
satunnaisella sanalla, joka arvotaan noin 94000 suomalaisesta sanasta.


## Pelaaminen 

- arvaa kirjaimia alareunan painikkeista kunnes luulet tietäväsi sanan jolloin voi kokeilla sanan arvaamista.

- sanaa voi arvata kirjoittamalla sanan arvaus tekstikenttään arvattava sana ja painamalla "arvaa sanaa" painiketta 

- peli voitetaan kun kaikki kirjaimet on arvattu tai sana on arvattu oikein

- peli hävitään kun vääriä arvauksia tulee liikaa ja kuva näkyy kokonaan

- pelin voi lopettaa kesken painamalla "takaisin" painiketta jolloin peli tilastoidaan hävityksi


## Statistiikka

- Aloitusruudun statistiikka nappulalla pääset seuraamaan peli tilastoja 

- Tilastot voi nollata painamalla nollaus nappulaa
