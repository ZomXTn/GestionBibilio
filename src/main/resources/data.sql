INSERT INTO Oeuvre (id, titre, editeur, date_publication, type_oeuvre, issn, num_volume, periodicite)
VALUES
    (UUID(), 'National Geographic', 'National Geographic Society', '1888-10-01', 'MAGAZINE', '00279358', 1, 'MONTHLY'),
    (UUID(), 'Time Magazine', 'Time Inc.', '1923-03-03', 'MAGAZINE', '0040781X', 2, 'WEEKLY'),
    (UUID(), 'Scientific American', 'Springer Nature', '1845-08-28', 'MAGAZINE', '00368733', 1, 'MONTHLY'),
    (UUID(), 'Le Monde', 'Le Monde SA', '1944-12-19', 'MAGAZINE', '1950-6244', 1, 'DAILY'),
    (UUID(), 'The Economist', 'The Economist Group', '1843-09-02', 'MAGAZINE', '00130613', 1843, 'WEEKLY');
INSERT INTO Oeuvre (id, titre, editeur, date_publication, type_oeuvre, isbn, nb_pages, auteur)
VALUES
    (UUID(), 'Le Petit Prince', 'Gallimard', '1943-04-06', 'LIVRE', '9782070612758', 96, 'Antoine de Saint-Exupéry'),
    (UUID(), 'Harry Potter and the Philosopher''s Stone', 'Bloomsbury', '1997-06-26', 'LIVRE', '9780747532743', 332, 'J.K. Rowling'),
    (UUID(), 'To Kill a Mockingbird', 'J.B. Lippincott & Co.', '1960-07-11', 'LIVRE', '9780061120084', 281, 'Harper Lee');
-- Insertion de données pour la table Usager
INSERT INTO Usager (id, email, nom, prenom, adresse)
VALUES
    (UUID(), 'jean.dupont@example.com', 'Dupont', 'Jean', '15 Rue de la Liberté, 75001 Paris'),
    (UUID(), 'marie.leclerc@example.com', 'Leclerc', 'Marie', '22 Avenue des Champs-Élysées, 75008 Paris'),
    (UUID(), 'pierre.martin@example.com', 'Martin', 'Pierre', '8 Rue de la Paix, 75002 Paris');

