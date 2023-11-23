INSERT INTO roles (id, name) VALUES(1, 'ADMIN');

INSERT INTO users (email, first_name, last_name, registered_at, password) VALUES('antonio@email.com', 'Antonio', 'Rossi', '2023-11-23 09:00', '{noop}antonio');

INSERT INTO users_roles (user_id, roles_id) VALUES(1, 1);