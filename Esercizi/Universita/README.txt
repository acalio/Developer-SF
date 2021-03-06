Antonio Caliò


Traccia
=======

  Implementare le seguenti classi:
  - *Docente*, che contenga le seguenti le informazioni:
    - Attributi
      - Codice Identificativo
        - Tipo:
          1. String:
             1. Codice
                1. Iniziale Nome, Cognome, anno di nascita -> (-)
                   Problema collisioni
                2. Codice Fiscale -> (+) Risolve problema collisioni;
                   (-) Dobbiamo specificarlo manualmente

          2. Intero
             1. Matricola -> Intero progressivo (e.g., parto da 0 e
                incremento di uno ogni volta che creo un nuovo
                docente). *Utilizzo una variabile statica*: (+) non
                dobbiamo inserirla manualmente

      - Nome
        - Tipo: String
      - Cognome
        - Tipo: String
      - Eta
        - Tipo: Intero

      - Ruolo del docente, i.e, Ricercatore, Associato, Ordinario
        - Tipo:
          1. Intero: ogni ruolo corrisponde ad un intero.
          2. String ("Ricercatore", "Associato", "Ordinario")
          3. Enumerator

    - Funzionalità
      - Costruttore (parametrico e di default)
      - getter/setter
      - toString


  - *Università*, che contenga le seguenti informazioni:
    - Attributi
      - Nome
        - Tipo: String
      - Indirizzo: String
      - Una collezione di docenti afferenti alla Università
        - Tipo: Docente [] docenti
          - Q: Come lo inizializziamo? Quante posizioni?
      - Per ogni ruolo, il numero di docenti (abbiamo tre ruoli)
        - Tipo:
          - Tre interi: numRic, numAss, numOrd
          - int[] numProf = { #ricercatori, #associati, #ordinari } (*)

    - Funzionalità
      - Costruttore (parametrico e di default)
        - Di default: Quindi array si setta a null
        - Parametrico:
          - Input:
            - String nome
            - String inidirizzo
            - Array[] docenti

      - getter/setter
      - toString

      - Metodo per trovare un docente
      - Metodo per promuovere un docente (e.g., da ricercatore ad
        associato)
      - Metodo per retrocedere un docente (e.g., da associato a
        ricercatore)
      - Metodo per trovare il docente più giovane
      - Metodo per trovare il docente più anziano per un determinato
        ruolo
      - Metodo per l'aggiornamento del ruolo di un docente
      - Metodo per l'inserimento di un docente
