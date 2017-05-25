package project.repositories;

import org.springframework.data.repository.CrudRepository;

import project.entities.ShemeDetail;

public interface ShemesDetailsRepository extends CrudRepository<ShemeDetail, Long> {
    ShemeDetail findByShemename(String shemename);
}