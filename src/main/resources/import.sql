INSERT INTO roles (id, name) VALUES(1, 'ADMIN');

INSERT INTO users (email, first_name, last_name, registered_at, password) VALUES('antonio@email.com', 'Antonio', 'Rossi', '2023-11-23 09:00', '{noop}antonio');

INSERT INTO users_roles (user_id, roles_id) VALUES(1, 1);

INSERT INTO photos (title, description, url, visible) VALUES ('Roma', 'Capitale Italia', 'https://www.turismoroma.it/sites/default/files/fontana_trevi_0.jpg', true);
INSERT INTO photos (title, description, url, visible) VALUES ('Berlino', 'Capitale della Germania', 'https://www.travel365.it/foto/brandenburgertor-berlino-2.jpg', true);
INSERT INTO photos (title, description, url, visible) VALUES ('Casa sul Mare', 'Vista Mozzafiato', 'https://images.italy-villas.it/vacation_rentals/187049/xwide/la-casa-sul-mare-delle-sirene-marina-del-cantone-appartamento-terrazza.jpg', true);
INSERT INTO photos (title, description, url, visible) VALUES ('Peluche', 'Giocattolo per bambini', 'https://m.media-amazon.com/images/I/61+qD14eLXL._AC_UF1000,1000_QL80_.jpg', true);
INSERT INTO photos (title, description, url, visible) VALUES ('Personal Computer', 'Apparecchio per lavoro e svago','https://www.pcspecialist.it/images/landing/pcs/gaming-pc/bundle.jpg', true);
INSERT INTO photos (title, description, url, visible) VALUES ('Bibita', 'Energy drink', 'https://www.drinkshoponline.com/_upload/prodotti/thumb/19205_700_1200_0.jpg', true);
INSERT INTO photos (title, description, url, visible) VALUES ('La Gioconda', 'Opera conosciuta in tutto il mondo','https://cdn.studenti.stbm.it/images/2017/01/10/gioconda-orig.jpeg', true);
INSERT INTO photos (title, description, url, visible) VALUES ('Mar Mediterraneo', 'Mare che confina con le costeafricane', 'https://ilbolive.unipd.it/sites/default/files/styles/style_1120x630/public/2021-01/mar-mediterraneo-costa.jpg?itok=zX1jZpYJ', true);

INSERT INTO categories(name) VALUES('Città');
INSERT INTO categories(name) VALUES('Paesaggi');
INSERT INTO categories(name) VALUES('Informatica');
INSERT INTO categories(name) VALUES('Arte');
INSERT INTO categories(name) VALUES('Intrattenimento');
INSERT INTO categories(name) VALUES('Alimenti');

INSERT INTO photos_categories(photo_id, categories_id) VALUES(2,1);
INSERT INTO photos_categories(photo_id, categories_id) VALUES(1,1);
INSERT INTO photos_categories(photo_id, categories_id) VALUES(3,2);
INSERT INTO photos_categories(photo_id, categories_id) VALUES(4,5);
INSERT INTO photos_categories(photo_id, categories_id) VALUES(5,3);
INSERT INTO photos_categories(photo_id, categories_id) VALUES(6,6);
INSERT INTO photos_categories(photo_id, categories_id) VALUES(7,4);
INSERT INTO photos_categories(photo_id, categories_id) VALUES(8,2);