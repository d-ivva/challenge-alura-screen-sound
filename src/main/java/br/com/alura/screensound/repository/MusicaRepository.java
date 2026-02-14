package br.com.alura.screensound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.screensound.model.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
    
}

