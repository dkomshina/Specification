package cw.repository;

import cw.model.db.Traces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TracesRepository extends JpaRepository<Traces, Long> {
}
