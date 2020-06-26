-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 26 Jun 2020 pada 06.20
-- Versi server: 10.1.35-MariaDB
-- Versi PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lapcov19`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `account`
--

CREATE TABLE `account` (
  `nama` varchar(50) NOT NULL,
  `jk` varchar(12) NOT NULL,
  `tanggallahir` date NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `nik` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `pekerjaan` varchar(50) NOT NULL,
  `foto` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `account`
--

INSERT INTO `account` (`nama`, `jk`, `tanggallahir`, `alamat`, `nik`, `username`, `password`, `pekerjaan`, `foto`, `role`) VALUES
('admin', 'perampuan', '2020-06-17', 'admin', 12312, 'admin', 'admin', 'admin', '1593133309958_image00000001.PNG', 'pengurus'),
('Ako', 'Perampuan', '2020-05-01', 'del', 121, 'leo', 'leo', 'pelajar', '1591450065740_image00000001.PNG', ''),
('ako1', 'Perampian', '2020-06-18', 'Del', 11418028, 'mahasiswa', '5787be38ee03a9ae5360f54d9026465f', 'Mahasiswa', 'default.png', 'penduduk');

-- --------------------------------------------------------

--
-- Struktur dari tabel `aspirasi`
--

CREATE TABLE `aspirasi` (
  `id_aspirasi` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `isi` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `cekkesehatan`
--

CREATE TABLE `cekkesehatan` (
  `id_cek` int(11) NOT NULL,
  `daftarpertanyaan_gejala` varchar(500) NOT NULL,
  `daftarpertanyaan_aktivitas` varchar(500) NOT NULL,
  `username` varchar(255) NOT NULL,
  `hasil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `cekkesehatan`
--

INSERT INTO `cekkesehatan` (`id_cek`, `daftarpertanyaan_gejala`, `daftarpertanyaan_aktivitas`, `username`, `hasil`) VALUES
(50, '1', '0', 'Leonard', 1),
(51, '1', '0', 'Sion', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_penduduk`
--

CREATE TABLE `data_penduduk` (
  `nik` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jk` varchar(5) NOT NULL,
  `tanggallahir` date NOT NULL,
  `alamat` int(11) NOT NULL,
  `foto` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `informasi`
--

CREATE TABLE `informasi` (
  `id_informasi` int(11) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `kategori` varchar(50) NOT NULL,
  `isi` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `informasi`
--

INSERT INTO `informasi` (`id_informasi`, `judul`, `tanggal`, `kategori`, `isi`) VALUES
(15, 'Fafaw', '2020-06-16', 'Umum', 'Suka muntaber');

-- --------------------------------------------------------

--
-- Struktur dari tabel `keluhan`
--

CREATE TABLE `keluhan` (
  `id_keluhan` int(11) NOT NULL,
  `pengirim` varchar(255) NOT NULL,
  `kategori` varchar(255) NOT NULL,
  `tanggal` date NOT NULL,
  `isi` varchar(500) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `masyarakat`
--

CREATE TABLE `masyarakat` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengajuan`
--

CREATE TABLE `pengajuan` (
  `id` int(11) NOT NULL,
  `topik` varchar(255) NOT NULL,
  `pengaju` varchar(255) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengurusdaerah`
--

CREATE TABLE `pengurusdaerah` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `resiko`
--

CREATE TABLE `resiko` (
  `id_resiko` int(11) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `solusi` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `status_penduduk`
--

CREATE TABLE `status_penduduk` (
  `id_status` int(11) NOT NULL,
  `jumlahpenduduk` int(11) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `aspirasi`
--
ALTER TABLE `aspirasi`
  ADD PRIMARY KEY (`id_aspirasi`);

--
-- Indeks untuk tabel `cekkesehatan`
--
ALTER TABLE `cekkesehatan`
  ADD PRIMARY KEY (`id_cek`);

--
-- Indeks untuk tabel `data_penduduk`
--
ALTER TABLE `data_penduduk`
  ADD PRIMARY KEY (`nik`);

--
-- Indeks untuk tabel `informasi`
--
ALTER TABLE `informasi`
  ADD PRIMARY KEY (`id_informasi`);

--
-- Indeks untuk tabel `keluhan`
--
ALTER TABLE `keluhan`
  ADD PRIMARY KEY (`id_keluhan`);

--
-- Indeks untuk tabel `masyarakat`
--
ALTER TABLE `masyarakat`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `pengajuan`
--
ALTER TABLE `pengajuan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `pengurusdaerah`
--
ALTER TABLE `pengurusdaerah`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `resiko`
--
ALTER TABLE `resiko`
  ADD PRIMARY KEY (`id_resiko`);

--
-- Indeks untuk tabel `status_penduduk`
--
ALTER TABLE `status_penduduk`
  ADD PRIMARY KEY (`id_status`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `cekkesehatan`
--
ALTER TABLE `cekkesehatan`
  MODIFY `id_cek` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT untuk tabel `informasi`
--
ALTER TABLE `informasi`
  MODIFY `id_informasi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT untuk tabel `keluhan`
--
ALTER TABLE `keluhan`
  MODIFY `id_keluhan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT untuk tabel `pengajuan`
--
ALTER TABLE `pengajuan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
