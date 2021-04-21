package cw.repository;

import cw.model.db.Docs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocsRepository extends JpaRepository<Docs, Long> {
}
