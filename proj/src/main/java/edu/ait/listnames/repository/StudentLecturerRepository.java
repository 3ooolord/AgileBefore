
package edu.ait.listnames.repository;

import edu.ait.listnames.dto.StudentLecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



public interface StudentLecturerRepository extends JpaRepository<StudentLecturer, String>,
        JpaSpecificationExecutor<StudentLecturer> {

}