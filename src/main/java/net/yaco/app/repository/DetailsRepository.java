package net.yaco.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.yaco.app.model.Detail;

@Repository
public interface DetailsRepository extends JpaRepository<Detail, Integer> {

}
