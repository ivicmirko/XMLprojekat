INSERT INTO `megatravel`.`authority` (`id`, `name`) VALUES ('1', 'admin');
INSERT INTO `megatravel`.`authority` (`id`, `name`) VALUES ('2', 'agent');
INSERT INTO `megatravel`.`authority` (`id`, `name`) VALUES ('3', 'user');
INSERT INTO `megatravel`.`systemuser` (`id`, `address`, `email`, `is_active`, `is_not_removed`, `name`, `password`, `phone_num`, `surname`, `username`) VALUES ('1', 'kac', 'i@gmail.com', b'1', b'1', 'mirko', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '02131313', 'ivic', 'asd');
INSERT INTO `megatravel`.`systemuser` (`id`, `address`, `email`, `is_active`, `is_not_removed`, `name`, `password`, `phone_num`, `surname`, `username`) VALUES ('2', 'kac', 'ia@gmail.com', b'1', b'1', 'mirko', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '02131313', 'ivic', 'asg');
INSERT INTO `megatravel`.`systemuser` (`id`, `address`, `email`, `is_active`, `is_not_removed`, `name`, `password`, `phone_num`, `surname`, `username`) VALUES ('3', 'kac', 'ia2@gmail.com', b'1', b'1', 'mate', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '02131313', 'ivic', 'mate');


INSERT INTO `megatravel`.`user_authority` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `megatravel`.`user_authority` (user_id, authority_id) VALUES (2, 2);
INSERT INTO `megatravel`.`user_authority` (user_id, authority_id) VALUES (3, 3);

INSERT INTO `megatravel`.`agent` (`pib`, `id`) VALUES ('22325', '2');

