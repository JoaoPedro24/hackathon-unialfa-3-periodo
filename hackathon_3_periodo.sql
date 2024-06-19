-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 20-Jun-2024 às 00:46
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `hackathon_3_periodo`
--
CREATE DATABASE IF NOT EXISTS `hackathon_3_periodo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `hackathon_3_periodo`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `agendamentos`
--

CREATE TABLE `agendamentos` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_idoso` int(10) UNSIGNED DEFAULT NULL,
  `id_enfermeiro` int(10) UNSIGNED DEFAULT NULL,
  `id_vacina` int(10) UNSIGNED DEFAULT NULL,
  `observacoes` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `enfermeiros`
--

CREATE TABLE `enfermeiros` (
  `id` int(10) UNSIGNED NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `historicos_medicos_idosos`
--

CREATE TABLE `historicos_medicos_idosos` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_idoso` int(10) UNSIGNED DEFAULT NULL,
  `alergias` text DEFAULT NULL,
  `condicoes_preexistentes` text DEFAULT NULL,
  `observacoes` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `idosos`
--

CREATE TABLE `idosos` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_responsavel` int(10) UNSIGNED DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `data_nascimento` date NOT NULL,
  `cep` varchar(255) NOT NULL,
  `rua` varchar(255) NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `numero` int(11) NOT NULL,
  `complemento` varchar(255) NOT NULL,
  `uf` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `knex_migrations`
--

CREATE TABLE `knex_migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `batch` int(11) DEFAULT NULL,
  `migration_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `knex_migrations`
--

INSERT INTO `knex_migrations` (`id`, `name`, `batch`, `migration_time`) VALUES
(7, '20240618010908_createEnfermeiros.js', 1, '2024-06-19 22:33:03'),
(8, '20240618193001_createResponsaveisTable.js', 1, '2024-06-19 22:33:03'),
(9, '20240618193554_createVacinasTable.js', 1, '2024-06-19 22:33:03'),
(10, '20240618193817_createIdososTable.js', 1, '2024-06-19 22:33:03'),
(11, '20240618194331_createAgendamentosTable.js', 1, '2024-06-19 22:33:03'),
(12, '20240618194642_createHistoricoMedicoIdosoTable.js', 1, '2024-06-19 22:33:03');

-- --------------------------------------------------------

--
-- Estrutura da tabela `knex_migrations_lock`
--

CREATE TABLE `knex_migrations_lock` (
  `index` int(10) UNSIGNED NOT NULL,
  `is_locked` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `knex_migrations_lock`
--

INSERT INTO `knex_migrations_lock` (`index`, `is_locked`) VALUES
(1, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `responsaveis`
--

CREATE TABLE `responsaveis` (
  `id` int(10) UNSIGNED NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `data_nascimento` date NOT NULL,
  `cep` varchar(255) NOT NULL,
  `rua` varchar(255) NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `numero` int(11) NOT NULL,
  `complemento` varchar(255) NOT NULL,
  `uf` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `vacinas`
--

CREATE TABLE `vacinas` (
  `id` int(10) UNSIGNED NOT NULL,
  `nome` varchar(255) NOT NULL,
  `prazo` int(11) DEFAULT NULL,
  `idade_minima` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `agendamentos`
--
ALTER TABLE `agendamentos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `agendamentos_id_idoso_foreign` (`id_idoso`),
  ADD KEY `agendamentos_id_enfermeiro_foreign` (`id_enfermeiro`),
  ADD KEY `agendamentos_id_vacina_foreign` (`id_vacina`);

--
-- Índices para tabela `enfermeiros`
--
ALTER TABLE `enfermeiros`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `historicos_medicos_idosos`
--
ALTER TABLE `historicos_medicos_idosos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `historicos_medicos_idosos_id_idoso_foreign` (`id_idoso`);

--
-- Índices para tabela `idosos`
--
ALTER TABLE `idosos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idosos_id_responsavel_foreign` (`id_responsavel`);

--
-- Índices para tabela `knex_migrations`
--
ALTER TABLE `knex_migrations`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `knex_migrations_lock`
--
ALTER TABLE `knex_migrations_lock`
  ADD PRIMARY KEY (`index`);

--
-- Índices para tabela `responsaveis`
--
ALTER TABLE `responsaveis`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `vacinas`
--
ALTER TABLE `vacinas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `agendamentos`
--
ALTER TABLE `agendamentos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `enfermeiros`
--
ALTER TABLE `enfermeiros`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `historicos_medicos_idosos`
--
ALTER TABLE `historicos_medicos_idosos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `idosos`
--
ALTER TABLE `idosos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `knex_migrations`
--
ALTER TABLE `knex_migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `knex_migrations_lock`
--
ALTER TABLE `knex_migrations_lock`
  MODIFY `index` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `responsaveis`
--
ALTER TABLE `responsaveis`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `vacinas`
--
ALTER TABLE `vacinas`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `agendamentos`
--
ALTER TABLE `agendamentos`
  ADD CONSTRAINT `agendamentos_id_enfermeiro_foreign` FOREIGN KEY (`id_enfermeiro`) REFERENCES `enfermeiros` (`id`),
  ADD CONSTRAINT `agendamentos_id_idoso_foreign` FOREIGN KEY (`id_idoso`) REFERENCES `idosos` (`id`),
  ADD CONSTRAINT `agendamentos_id_vacina_foreign` FOREIGN KEY (`id_vacina`) REFERENCES `vacinas` (`id`);

--
-- Limitadores para a tabela `historicos_medicos_idosos`
--
ALTER TABLE `historicos_medicos_idosos`
  ADD CONSTRAINT `historicos_medicos_idosos_id_idoso_foreign` FOREIGN KEY (`id_idoso`) REFERENCES `idosos` (`id`);

--
-- Limitadores para a tabela `idosos`
--
ALTER TABLE `idosos`
  ADD CONSTRAINT `idosos_id_responsavel_foreign` FOREIGN KEY (`id_responsavel`) REFERENCES `responsaveis` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
