# Gestione Personale

## Consegna
- Il progetto ha lo scopo di gestire il personale di un museo.
- Entrando come amministratore si possono registrare o rimuovere utenti e modificare i loro dati, compreso il loro ruolo da cui dipende il livello di accesso.
- Tutti gli utenti registrati possono usare le credenziali con cui sono stati registrati per visualizzare il proprio profilo.

## ATTENZIONE

1. Il file `data.sql` contiene i dati iniziali per il riempimento del database. 
   - I dati potrebbero essere commentati per evitare errori durante l'update, poiché il reinserimento di dati con lo stesso ID di quelli esistenti causa un errore.
   - Durante il primo riempimento del database (impostando il DDL a `create`), rimuovere i commenti dai dati.
   - Negli esecuzioni successive del progetto (con DDL impostato a `update`), i dati devono essere commentati.

2. Sono presenti numerosi file controller nel progetto. 
   - Questa scelta è stata fatta per consentire a ciascun membro di lavorare su un file separato, evitando conflitti durante il push che potrebbero sorgere lavorando tutti sullo stesso file.

## Logins
Ecco i dati di login per ciascun ruolo (a meno che i dati non siano stati modificati dall'amministratore)

- **ADMIN**
  - Email: admin.admin@museo.com
  - Password: password

- **Curatore**
  - Email: mario.rossi@museo.com
  - Password: password1

- **Guida**
  - Email: giulia.bianchi@museo.com
  - Password: password2

## Membri
- Leandro Benaglio
- Diego Bendinelli
- Teshale Cella
- Riccardo Chen
- Matteo Dallavalle
- Giacomo Grieco
  
