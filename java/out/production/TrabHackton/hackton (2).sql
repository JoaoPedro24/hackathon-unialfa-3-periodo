-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 19/06/2024 às 23:09
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `hackton`
--
CREATE DATABASE IF NOT EXISTS `hackton` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `hackton`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `agendamento`
--

CREATE TABLE `agendamento` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `id_idoso` int(11) NOT NULL,
  `id_enfermeiro` int(11) NOT NULL,
  `id_vacina` int(11) NOT NULL,
  `observacao` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `agendamento`
--

INSERT INTO `agendamento` (`id`, `data`, `id_idoso`, `id_enfermeiro`, `id_vacina`, `observacao`) VALUES
(1, '2023-11-07', 1, 4, 1, 'Sem Observacoes'),
(2, '2023-10-10', 2, 1, 2, 'Doido de Pedra'),
(3, '2025-05-05', 2, 5, 1, 'nada'),
(4, '2024-05-07', 1, 2, 2, 'Nenhuma');

-- --------------------------------------------------------

--
-- Estrutura para tabela `enfermeiro`
--

CREATE TABLE `enfermeiro` (
  `id` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `cpf` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `enfermeiro`
--

INSERT INTO `enfermeiro` (`id`, `nome`, `telefone`, `cpf`) VALUES
(1, 'Paulo', '44983526870', '11122233344'),
(2, 'Cleberr', '11122223344', '11122233344'),
(4, 'Joaquim', '33987654321', '12312312312'),
(5, 'Jose', '12344446666', '11122233344');

-- --------------------------------------------------------

--
-- Estrutura para tabela `historico_medico`
--

CREATE TABLE `historico_medico` (
  `id` int(11) NOT NULL,
  `id_idoso` int(11) NOT NULL,
  `id_agendamento` int(11) NOT NULL,
  `alergias` varchar(200) NOT NULL,
  `cond_preexiste` varchar(200) NOT NULL,
  `observacao` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `historico_medico`
--

INSERT INTO `historico_medico` (`id`, `id_idoso`, `id_agendamento`, `alergias`, `cond_preexiste`, `observacao`) VALUES
(1, 1, 1, 'Abelha', 'Alzheimer', 'Apos 14hrs'),
(3, 2, 2, 'Agulha', 'Drogado', 'Cuidado');

-- --------------------------------------------------------

--
-- Estrutura para tabela `idoso`
--

CREATE TABLE `idoso` (
  `id` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `data_nascimento` date NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `id_responsavel` int(11) NOT NULL,
  `cep` varchar(8) NOT NULL,
  `rua` varchar(200) NOT NULL,
  `numero_casa` varchar(4) NOT NULL,
  `cidade` varchar(200) NOT NULL,
  `bairro` varchar(200) NOT NULL,
  `uf` varchar(200) NOT NULL,
  `complemento` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `idoso`
--

INSERT INTO `idoso` (`id`, `nome`, `cpf`, `data_nascimento`, `telefone`, `id_responsavel`, `cep`, `rua`, `numero_casa`, `cidade`, `bairro`, `uf`, `complemento`) VALUES
(1, 'Guilherme Da Silva', '11122233344', '1947-05-11', '61989378122', 1, '87540444', 'Avenida Brasil', '2365', 'Umuarama', 'Panorama', 'Parana', 'Casa Azul'),
(2, 'Pedro Alcantara Machado', '11122233344', '1950-08-08', '91995021705', 2, '87540333', 'Rua das Pedras', '6578', 'Umuarama', 'Garça 2', 'Parana', 'Longe demais');

-- --------------------------------------------------------

--
-- Estrutura para tabela `responsavel`
--

CREATE TABLE `responsavel` (
  `id` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `data_nascimento` date NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `cep` varchar(8) NOT NULL,
  `rua` varchar(200) NOT NULL,
  `numero_casa` varchar(4) NOT NULL,
  `cidade` varchar(200) NOT NULL,
  `bairro` varchar(200) NOT NULL,
  `uf` varchar(200) NOT NULL,
  `complemento` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `responsavel`
--

INSERT INTO `responsavel` (`id`, `nome`, `cpf`, `data_nascimento`, `telefone`, `cep`, `rua`, `numero_casa`, `cidade`, `bairro`, `uf`, `complemento`) VALUES
(1, 'João da Silva', '13113011178', '1968-05-11', '67982647739', '87540444', 'Avenida Das Flores', '2345', 'Umuarama', 'Centro', 'Parana', 'Em Frente ao Subway'),
(2, 'Cleber Machado', '12332144455', '1987-08-08', '65989549530', '87540455', 'Rua Jornal', '1254', 'Umuarama', 'Centro', 'Parana', 'Nada');

-- --------------------------------------------------------

--
-- Estrutura para tabela `vacina`
--

CREATE TABLE `vacina` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `prazo` date NOT NULL,
  `idade_minima` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `vacina`
--

INSERT INTO `vacina` (`id`, `nome`, `prazo`, `idade_minima`) VALUES
(1, 'Vacina da Gripe', '2024-12-12', 60),
(2, 'Vacina de Tetano', '2024-12-05', 60);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `agendamento`
--
ALTER TABLE `agendamento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk20` (`id_idoso`),
  ADD KEY `fk21` (`id_enfermeiro`),
  ADD KEY `fk22` (`id_vacina`);

--
-- Índices de tabela `enfermeiro`
--
ALTER TABLE `enfermeiro`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `historico_medico`
--
ALTER TABLE `historico_medico`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk24` (`id_agendamento`),
  ADD KEY `fk25` (`id_idoso`);

--
-- Índices de tabela `idoso`
--
ALTER TABLE `idoso`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk23` (`id_responsavel`);

--
-- Índices de tabela `responsavel`
--
ALTER TABLE `responsavel`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `vacina`
--
ALTER TABLE `vacina`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `agendamento`
--
ALTER TABLE `agendamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `enfermeiro`
--
ALTER TABLE `enfermeiro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `historico_medico`
--
ALTER TABLE `historico_medico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `idoso`
--
ALTER TABLE `idoso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `responsavel`
--
ALTER TABLE `responsavel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `vacina`
--
ALTER TABLE `vacina`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `agendamento`
--
ALTER TABLE `agendamento`
  ADD CONSTRAINT `fk20` FOREIGN KEY (`id_idoso`) REFERENCES `idoso` (`id`),
  ADD CONSTRAINT `fk21` FOREIGN KEY (`id_enfermeiro`) REFERENCES `enfermeiro` (`id`),
  ADD CONSTRAINT `fk22` FOREIGN KEY (`id_vacina`) REFERENCES `vacina` (`id`);

--
-- Restrições para tabelas `historico_medico`
--
ALTER TABLE `historico_medico`
  ADD CONSTRAINT `fk24` FOREIGN KEY (`id_agendamento`) REFERENCES `agendamento` (`id`),
  ADD CONSTRAINT `fk25` FOREIGN KEY (`id_idoso`) REFERENCES `idoso` (`id`);

--
-- Restrições para tabelas `idoso`
--
ALTER TABLE `idoso`
  ADD CONSTRAINT `fk23` FOREIGN KEY (`id_responsavel`) REFERENCES `responsavel` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
