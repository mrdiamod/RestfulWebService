package project.repositories;

import org.springframework.data.repository.CrudRepository;

import project.entities.Detail;

public interface DetailsRepository extends CrudRepository<Detail, Long> {
    Detail findByDetailname(String detailname);
}