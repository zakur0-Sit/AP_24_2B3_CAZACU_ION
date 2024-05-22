## Structura Proiectului

Proiectul este împărțit în două părți principale:
- Client: Aplicația pe care jucătorii o folosesc pentru a trimite comenzi către server.
- Server: Aplicația care gestionează logica jocului și comunicarea între jucători.

### Fisierele Proiectului

- `Client.java`: Codul clientului care se conectează la server și trimite comenzi.
- `ClientThread.java`: Thread-ul serverului care gestionează comunicarea cu un client.
- `GameServer.java`: Codul principal al serverului care ascultă conexiunile și pornește `ClientThread`-uri.
- `TimeControl.java`: Thread care gestionează timpul rămas pentru fiecare mutare.
- `Battleship.java`: Clasa care gestionează logica jocului.
- `Player.java`: Clasa care reprezintă un jucător și flota sa.

## Funcționalități

- **Crearea unui joc**: Un jucător poate crea un joc nou.
- **Alăturarea la un joc**: Un jucător se poate alătura unui joc existent.
- **Trimiterea unei mutări**: Un jucător poate trimite o mutare pentru a ataca o poziție a oponentului.
- **Controlul timpului**: Serverul poate controla timpul rămas pentru fiecare mutare.

## Comenzi Disponibile

- `create game`: Creează un joc nou dacă nu există deja unul.
- `join game`: Se alătură unui joc existent.
- `submit move x y`: Trimite o mutare pentru a ataca poziția `(x, y)`. Coordonatele `x` și `y` trebuie să fie între 0 și 9.
- `stop`: Oprește serverul.
- `exit`: Oprește clientul.

## Exemple de Utilizare

1. Crearea uni joc:
    ```
    create game
    ```

2. Alăturarea jocului:
    ```
    join game
    ```

3. Trimiterea mutării:
    ```
    submit move 3 4
    ```
