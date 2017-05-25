package project.repositories;

import org.springframework.data.repository.CrudRepository;

import project.entities.Sheme;

public interface ShemesRepository extends CrudRepository<Sheme, Long> {
    Sheme findByShemename(String shemename);
}