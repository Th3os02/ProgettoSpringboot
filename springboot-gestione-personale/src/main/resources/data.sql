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
VALUES (1, 'Amministratore'),
       (2, 'Responsabile'),
       (3, 'Impiegato'),
       (4, 'Stagista');

-- Inserimento del personale
INSERT INTO personale (id, nome, cognome, email, password, ruolo_id, contratto_id)
VALUES (0, 'Rohit', 'Admin', 'admin.admin@museo.com', 'password', 2, 1),
       (1, 'Mario', 'Rossi', 'mario.rossi@example.com', 'password1', 1, 1),
       (2, 'Giulia', 'Bianchi', 'giulia.bianchi@example.com', 'password2', 2, 1),
       (3, 'Luca', 'Verdi', 'luca.verdi@example.com', 'password3', 3, 2),
       (4, 'Sara', 'Neri', 'sara.neri@example.com', 'password4', 4, 3);
