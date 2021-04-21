package cw.repository;

import cw.model.db.Reqs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReqsRepository extends JpaRepository<Reqs, Long> {
}
