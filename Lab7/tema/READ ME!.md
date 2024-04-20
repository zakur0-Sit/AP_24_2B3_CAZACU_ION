READ ME!

Toată logica jocului are loc în class Player și metoda extractToken() din class Bag

Ideea este următoare:

1) fiecare player după ce a fost inițializat începe a extrage câte un token din pungă, extragerea se face astfel:
  - obligatoru scoate doar un player câte un token în decursul unui timp setat (tura de extragere)
  - playerul nu poate extrage același token care a fost extras de alt player înaintea lui
  - fiecare player concurează cu ceilalți, deci nu va așteptă pe alții DAR așteaptă tura următoare de extragere (adică așteaptă un timp comun pentru toți și dacă e mai rapid atunci scoate un token)
  - fiecare token il stochează în lista de tokeni proprii extrași

2) după extragerea tuturor tokenilor din pungă sau după ce trece un timp setat de durată a jocului, se începe crearea secvențelor complete ( t1=(i1,i2), t2=(i2,i3),...,tk=(ik,i1) ):
  - în prima iterație se creează toate secvențele incomplete (primul token nu este obligatoriu egal cu ultimul) 
  - în ierațiile următoare se vor crea secvențele prin adăugarea altor tokeni rămași din lista de tokeni
  - și în sfârșit se mai verifică odată dacă sigur nu s-ar fi putut omite o altă secvență mai lungă

3) se afișează toate datele de la extragere până la afișarea câștigătorului
  - se preiau secvențele finale și se obțin lungimile lor
  - urmează compararea lungimilor și afișarea câștigătorului