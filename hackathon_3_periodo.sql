-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26/06/2024 às 00:18
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

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
-- Estrutura para tabela `agendamentos`
--

CREATE TABLE `agendamentos` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_idoso` int(10) UNSIGNED DEFAULT NULL,
  `id_enfermeiro` int(10) UNSIGNED DEFAULT NULL,
  `id_vacina` int(10) UNSIGNED DEFAULT NULL,
  `data` date NOT NULL,
  `observacoes` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `agendamentos`
--

INSERT INTO `agendamentos` (`id`, `id_idoso`, `id_enfermeiro`, `id_vacina`, `data`, `observacoes`, `created_at`, `updated_at`) VALUES
(3, 2, 2, 2, '2024-06-25', 'Nenhuma observação', '2024-06-23 19:51:18', '2024-06-23 19:51:18'),
(4, 1, 1, 1, '2024-06-27', 'asfsafas', '2024-06-23 19:52:46', '2024-06-23 19:52:46'),
(12, 1, 1, 1, '2024-06-27', 'bbbb', '2024-06-25 22:04:19', '2024-06-25 22:04:19'),
(13, 1, 1, 1, '2024-06-30', 'fasfas', '2024-06-25 22:08:51', '2024-06-25 22:08:51'),
(14, 1, 1, 1, '2024-07-31', 'qeqweqwe', '2024-06-25 22:09:14', '2024-06-25 22:09:14');

-- --------------------------------------------------------

--
-- Estrutura para tabela `enfermeiros`
--

CREATE TABLE `enfermeiros` (
  `id` int(10) UNSIGNED NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `enfermeiros`
--

INSERT INTO `enfermeiros` (`id`, `nome`, `cpf`, `telefone`, `created_at`, `updated_at`) VALUES
(1, 'Jorge Matheus', '08547685921', '44887561245', '2024-06-23 19:51:07', '2024-06-23 19:51:07'),
(2, 'Cristiano Neto', '98657487690', '44996139520', '2024-06-23 19:51:07', '2024-06-23 19:51:07');

-- --------------------------------------------------------

--
-- Estrutura para tabela `historicos_medicos_idosos`
--

CREATE TABLE `historicos_medicos_idosos` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_idoso` int(10) UNSIGNED DEFAULT NULL,
  `alergias` text DEFAULT NULL,
  `condicoes_preexistentes` text DEFAULT NULL,
  `observacoes` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `historicos_medicos_idosos`
--

INSERT INTO `historicos_medicos_idosos` (`id`, `id_idoso`, `alergias`, `condicoes_preexistentes`, `observacoes`, `created_at`, `updated_at`) VALUES
(1, 2, 'Rinite, sinusite, todos os ite', 'Diabetes, pressão alta', '', '2024-06-23 19:49:42', '2024-06-23 19:49:42'),
(2, 2, 'Rinite, sinusite, todos os ite', 'Diabetes, pressão alta', '', '2024-06-23 19:49:42', '2024-06-23 19:49:42'),
(3, 1, 'Rinite, sinusite, todos os ite', 'Diabetes, pressão alta', '', '2024-06-23 19:49:45', '2024-06-23 19:49:45');

-- --------------------------------------------------------

--
-- Estrutura para tabela `idosos`
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
  `complemento` varchar(255) DEFAULT NULL,
  `uf` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `idosos`
--

INSERT INTO `idosos` (`id`, `id_responsavel`, `nome`, `cpf`, `telefone`, `data_nascimento`, `cep`, `rua`, `bairro`, `numero`, `complemento`, `uf`, `cidade`, `created_at`, `updated_at`) VALUES
(1, 1, 'Antônio Rocha', '12345679802', '(44) 99999-999', '2004-05-19', '99999-999', 'Rua Pinheirosss', 'Jardim América', 12345, '', 'PR', 'Umuarama', '2024-06-23 19:49:26', '2024-06-23 19:49:26'),
(2, 1, 'Antônio Rocha', '12345679802', '4499999999', '2004-05-19', '99999999', 'Rua Pinheiros', 'Jardim América', 58, '', 'PR', 'Umuarama', '2024-06-23 19:49:27', '2024-06-23 19:49:27'),
(3, 1, 'Antônio Rocha', '12345679802', '4499999999', '2004-05-19', '99999999', 'Rua Pinheiros', 'Jardim América', 58, '', 'PR', 'Umuarama', '2024-06-23 19:49:27', '2024-06-23 19:49:27'),
(4, 1, 'Antônio Rocha', '12345679802', '4499999999', '2004-05-19', '99999999', 'Rua Pinheiros', 'Jardim América', 58, '', 'PR', 'Umuarama', '2024-06-23 19:49:28', '2024-06-23 19:49:28'),
(5, 1, 'Antônio Rocha', '12345679802', '4499999999', '2004-05-19', '99999999', 'Rua Pinheiros', 'Jardim América', 58, '', 'PR', 'Umuarama', '2024-06-23 19:49:29', '2024-06-23 19:49:29'),
(6, 2, 'Antônio Rocha', '12345679802', '4499999999', '2004-05-19', '99999999', 'Rua Pinheiros', 'Jardim América', 58, '', 'PR', 'Umuarama', '2024-06-23 19:49:35', '2024-06-23 19:49:35'),
(7, 3, 'Antônio Rocha', '12345679802', '4499999999', '2004-05-19', '99999999', 'Rua Pinheiros', 'Jardim América', 58, '', 'PR', 'Umuarama', '2024-06-23 19:49:39', '2024-06-23 19:49:39');

-- --------------------------------------------------------

--
-- Estrutura para tabela `knex_migrations`
--

CREATE TABLE `knex_migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `batch` int(11) DEFAULT NULL,
  `migration_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `knex_migrations`
--

INSERT INTO `knex_migrations` (`id`, `name`, `batch`, `migration_time`) VALUES
(1, '20240618010908_createEnfermeiros.js', 1, '2024-06-23 19:48:10'),
(2, '20240618193001_createResponsaveisTable.js', 1, '2024-06-23 19:48:10'),
(3, '20240618193554_createVacinasTable.js', 1, '2024-06-23 19:48:10'),
(4, '20240618193817_createIdososTable.js', 1, '2024-06-23 19:48:10'),
(5, '20240618194331_createAgendamentosTable.js', 1, '2024-06-23 19:48:10'),
(6, '20240618194642_createHistoricoMedicoIdosoTable.js', 1, '2024-06-23 19:48:10');

-- --------------------------------------------------------

--
-- Estrutura para tabela `knex_migrations_lock`
--

CREATE TABLE `knex_migrations_lock` (
  `index` int(10) UNSIGNED NOT NULL,
  `is_locked` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `knex_migrations_lock`
--

INSERT INTO `knex_migrations_lock` (`index`, `is_locked`) VALUES
(1, 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `responsaveis`
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
  `complemento` varchar(255) DEFAULT NULL,
  `uf` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `responsaveis`
--

INSERT INTO `responsaveis` (`id`, `nome`, `cpf`, `telefone`, `data_nascimento`, `cep`, `rua`, `bairro`, `numero`, `complemento`, `uf`, `cidade`, `created_at`, `updated_at`) VALUES
(1, 'Pedro Pascutti', '00000000000', '(44) 99999-999', '2004-05-19', '99999-999', 'Rua Pinheiros', 'Jardim América', 12345, '', 'PR', 'Umuarama', '2024-06-23 19:49:21', '2024-06-23 19:49:21'),
(2, 'Pedro Pascutti', '00000000000', '4499999999', '2004-05-19', '99999999', 'Rua Pinheiros', 'Jardim América', 58, '', 'PR', 'Umuarama', '2024-06-23 19:49:23', '2024-06-23 19:49:23'),
(3, 'Pedro Pascutti', '00000000000', '4499999999', '2004-05-19', '99999999', 'Rua Pinheiros', 'Jardim América', 58, '', 'PR', 'Umuarama', '2024-06-23 19:49:24', '2024-06-23 19:49:24');

-- --------------------------------------------------------

--
-- Estrutura para tabela `vacinas`
--

CREATE TABLE `vacinas` (
  `id` int(10) UNSIGNED NOT NULL,
  `nome` varchar(255) NOT NULL,
  `prazo` int(11) DEFAULT NULL,
  `idade_minima` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `vacinas`
--

INSERT INTO `vacinas` (`id`, `nome`, `prazo`, `idade_minima`, `created_at`, `updated_at`) VALUES
(1, 'Poliomelite', NULL, NULL, '2024-06-23 19:50:15', '2024-06-23 19:50:15'),
(2, 'Tétano', 60, 2, '2024-06-23 19:50:15', '2024-06-23 19:50:15');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `agendamentos`
--
ALTER TABLE `agendamentos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `agendamentos_id_idoso_foreign` (`id_idoso`),
  ADD KEY `agendamentos_id_enfermeiro_foreign` (`id_enfermeiro`),
  ADD KEY `agendamentos_id_vacina_foreign` (`id_vacina`);

--
-- Índices de tabela `enfermeiros`
--
ALTER TABLE `enfermeiros`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `historicos_medicos_idosos`
--
ALTER TABLE `historicos_medicos_idosos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `historicos_medicos_idosos_id_idoso_foreign` (`id_idoso`);

--
-- Índices de tabela `idosos`
--
ALTER TABLE `idosos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idosos_id_responsavel_foreign` (`id_responsavel`);

--
-- Índices de tabela `knex_migrations`
--
ALTER TABLE `knex_migrations`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `knex_migrations_lock`
--
ALTER TABLE `knex_migrations_lock`
  ADD PRIMARY KEY (`index`);

--
-- Índices de tabela `responsaveis`
--
ALTER TABLE `responsaveis`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `vacinas`
--
ALTER TABLE `vacinas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `agendamentos`
--
ALTER TABLE `agendamentos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de tabela `enfermeiros`
--
ALTER TABLE `enfermeiros`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `historicos_medicos_idosos`
--
ALTER TABLE `historicos_medicos_idosos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `idosos`
--
ALTER TABLE `idosos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `knex_migrations`
--
ALTER TABLE `knex_migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `knex_migrations_lock`
--
ALTER TABLE `knex_migrations_lock`
  MODIFY `index` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `responsaveis`
--
ALTER TABLE `responsaveis`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `vacinas`
--
ALTER TABLE `vacinas`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `agendamentos`
--
ALTER TABLE `agendamentos`
  ADD CONSTRAINT `agendamentos_id_enfermeiro_foreign` FOREIGN KEY (`id_enfermeiro`) REFERENCES `enfermeiros` (`id`),
  ADD CONSTRAINT `agendamentos_id_idoso_foreign` FOREIGN KEY (`id_idoso`) REFERENCES `idosos` (`id`),
  ADD CONSTRAINT `agendamentos_id_vacina_foreign` FOREIGN KEY (`id_vacina`) REFERENCES `vacinas` (`id`);

--
-- Restrições para tabelas `historicos_medicos_idosos`
--
ALTER TABLE `historicos_medicos_idosos`
  ADD CONSTRAINT `historicos_medicos_idosos_id_idoso_foreign` FOREIGN KEY (`id_idoso`) REFERENCES `idosos` (`id`);

--
-- Restrições para tabelas `idosos`
--
ALTER TABLE `idosos`
  ADD CONSTRAINT `idosos_id_responsavel_foreign` FOREIGN KEY (`id_responsavel`) REFERENCES `responsaveis` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
