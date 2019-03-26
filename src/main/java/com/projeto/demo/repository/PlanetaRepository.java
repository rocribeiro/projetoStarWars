package com.projeto.demo.repository;

import com.projeto.demo.model.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetaRepository extends JpaRepository< Planeta,Long> {

    @Query(value="SELECT * FROM planeta p WHERE p.nome = :nome",nativeQuery = true)
    public Planeta buscarPlanetaNome(@Param("nome") String nome);

    @Query(value="SELECT * FROM planeta p WHERE p.id = :id",nativeQuery = true)
    public Planeta buscarPlanetaId(@Param("id") Long id);
}
