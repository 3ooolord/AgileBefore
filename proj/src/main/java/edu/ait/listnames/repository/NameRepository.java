package edu.ait.listnames.repository;

import edu.ait.listnames.dto.Name;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository<Name, Integer> {
}

