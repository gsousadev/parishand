CREATE TABLE `paroquias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `missas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  `paroquia_id` int DEFAULT NULL,
  `data_hora` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `missa_paroquia_fk_idx` (`paroquia_id`),
  CONSTRAINT `missa_paroquia_fk` FOREIGN KEY (`paroquia_id`) REFERENCES `paroquias` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;