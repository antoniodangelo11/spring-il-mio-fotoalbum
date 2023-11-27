INSERT INTO roles (id, name) VALUES(1, 'ADMIN');
INSERT INTO roles (id, name) VALUES(2, 'USER');

INSERT INTO users (email, first_name, last_name, registered_at, password) VALUES('antonio@email.com', 'Antonio', 'Rossi', '2023-11-23 09:00', '{noop}antonio');
INSERT INTO users (email, first_name, last_name, registered_at, password) VALUES('valeria@email.com', 'Valeria', 'Bianchi', '2023-11-20 16:20','{noop}valeria');

INSERT INTO users_roles (user_id, roles_id) VALUES(1, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES(1, 2);
INSERT INTO users_roles (user_id, roles_id) VALUES(2, 2);

INSERT INTO photos (title, description, url, visible) VALUES ('Roma', 'Capitale Italia', 'https://www.turismoroma.it/sites/default/files/fontana_trevi_0.jpg', true);
INSERT INTO photos (title, description, url, visible) VALUES ('Berlino', 'Capitale della Germania', 'https://www.travel365.it/foto/brandenburgertor-berlino-2.jpg', true);
INSERT INTO photos (title, description, url, visible) VALUES ('Casa sul Mare', 'Vista Mozzafiato', 'https://images.italy-villas.it/vacation_rentals/187049/xwide/la-casa-sul-mare-delle-sirene-marina-del-cantone-appartamento-terrazza.jpg', true);
INSERT INTO photos (title, description, url, visible) VALUES ('Peluche', 'Giocattolo per bambini', 'https://www.getdigital.de/web/img/products/1100x1100/1992719927KuschelTotoroMain.220426.webp', true);
INSERT INTO photos (title, description, url, visible) VALUES ('Personal Computer', 'Apparecchio per lavoro e svago','https://www.messoanuovo.it/wp-content/uploads/2021/12/PC-gaming-scaled.jpg', true);
INSERT INTO photos (title, description, url, visible) VALUES ('Bibita', 'Energy drink', 'https://m.media-amazon.com/images/I/51mu5G4SAHL._AC_UF894,1000_QL80_.jpg', true);
INSERT INTO photos (title, description, url, visible) VALUES ('La Gioconda', 'Opera conosciuta in tutto il mondo', 'https://cdn.studenti.stbm.it/images/2017/01/10/gioconda-orig.jpeg', true);
INSERT INTO photos (title, description, url, visible) VALUES ('Mar Mediterraneo', 'Mare che confina con le coste africane', 'https://ilbolive.unipd.it/sites/default/files/styles/style_1120x630/public/2021-01/mar-mediterraneo-costa.jpg?itok=zX1jZpYJ', true);

INSERT INTO categories(name) VALUES('Città');
INSERT INTO categories(name) VALUES('Paesaggi');
INSERT INTO categories(name) VALUES('Informatica');
INSERT INTO categories(name) VALUES('Arte');
INSERT INTO categories(name) VALUES('Intrattenimento');
INSERT INTO categories(name) VALUES('Alimenti');

INSERT INTO photos_categories(photos_id, categories_id) VALUES(2,1);
INSERT INTO photos_categories(photos_id, categories_id) VALUES(1,1);
INSERT INTO photos_categories(photos_id, categories_id) VALUES(3,2);
INSERT INTO photos_categories(photos_id, categories_id) VALUES(4,5);
INSERT INTO photos_categories(photos_id, categories_id) VALUES(5,3);
INSERT INTO photos_categories(photos_id, categories_id) VALUES(6,6);
INSERT INTO photos_categories(photos_id, categories_id) VALUES(7,4);
INSERT INTO photos_categories(photos_id, categories_id) VALUES(8,2);

INSERT INTO contacts (email, message) VALUES('carlo.rossi@email.com', 'Complimenti è davvero bello!');
INSERT INTO contacts (email, message) VALUES('gennaro.rossi@email.com', 'Complimenti è davvero bello!');
INSERT INTO contacts (email, message) VALUES('roberto.neri@email.com', 'Complimenti è davvero bello!');