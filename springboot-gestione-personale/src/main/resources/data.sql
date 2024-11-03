-- Inserimento di un nuovo orario di lavoro
INSERT INTO orario_lavoro (id, orario_inizio, orario_fine)
VALUES (1, '08:00:00', '17:00:00'),
       (2, '09:00:00', '18:00:00'),
       (3, '08:00:00', '16:00:00');

-- Inserimento dei contratti
INSERT INTO contratto (id, RAL, tipocontratto, orario_lavoro_id)
VALUES (1, 50000, 'Tempo indeterminato', 1),
       (2, 40000, 'Tempo determinato', 2),
       (3, 45000, 'Apprendistato', 3);

-- Inserimento delle lingue
INSERT INTO lingue (id, nome_lingua)
VALUES (1, 'Italiano'),
       (2, 'Inglese'),
       (3, 'Francese'),
       (4, 'Tedesco'),
       (5, 'Spagnolo');

-- Inserimento dei ruoli
INSERT INTO ruolo (id, nome)
VALUES (0, 'Amminstratore'),
       (1, 'Curatore'),
       (2, 'Guida');

-- Inserimento del personale
INSERT INTO personale (id, nome, cognome, email, password, ruolo_id, contratto_id)
VALUES (0, 'Rohit', 'Admin', 'admin.admin@museo.com', 'password', 0, 1),
       (1, 'Mario', 'Rossi', 'mario.rossi@museo.com', 'password1', 1, 1),
       (2, 'Giulia', 'Bianchi', 'giulia.bianchi@museo.com', 'password2', 2, 1),
       (3, 'Luca', 'Verdi', 'luca.verdi@museo.com', 'password3', 1, 2),
       (4, 'Sara', 'Neri', 'sara.neri@museo.com', 'password4', 2, 3);
-- Inserimento di eventi nella tabella evento con il campo id specificato
INSERT INTO evento (id, titolo_evento, tipo, descrizione_evento, data_inizio, data_fine, limite_persone, stanza)
VALUES
    (1, 'Conferenza Annuale', 'Conferenza', 'Evento annuale aziendale', '2024-05-20', '2024-05-21', 150, 'Sala Conferenze'),
    (2, 'Workshop di Innovazione', 'Workshop', 'Laboratorio di idee innovative', '2024-06-10', '2024-06-10', 50, 'Aula Magna'),
    (3, 'Meeting Team', 'Meeting', 'Riunione mensile del team', '2024-07-01', '2024-07-01', 20, 'Sala Riunioni 3'),
    (4, 'Formazione Sicurezza', 'Formazione', 'Corso di sicurezza sul lavoro', '2024-08-15', '2024-08-16', 30, 'Aula Formazione');

-- Collegamento tra eventi e personale nella tabella di join personale_evento con id evento specifico
-- Evento ID 1 associato a personale con ID 1, 2, 3
INSERT INTO personale_evento (evento_id, personale_id) VALUES
                                                           (1, 1), (1, 2), (1, 3);

-- Evento ID 2 associato a personale con ID 2, 4
INSERT INTO personale_evento (evento_id, personale_id) VALUES
                                                           (2, 2), (2, 4);

-- Evento ID 3 associato a personale con ID 1, 3, 4
INSERT INTO personale_evento (evento_id, personale_id) VALUES
                                                           (3, 1), (3, 3), (3, 4);

-- Evento ID 4 associato a tutto il personale (ID 1, 2, 3, 4)
INSERT INTO personale_evento (evento_id, personale_id) VALUES
                                                           (4, 1), (4, 2), (4, 3), (4, 4);