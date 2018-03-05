package com.chernik.forms.persistence.jparepository;

import com.chernik.forms.persistence.entity.FormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FormRepository extends JpaRepository<FormEntity, Long> {
    Optional<FormEntity> findByName(String name);
}
