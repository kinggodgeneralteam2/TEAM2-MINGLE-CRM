package com.team2final.minglecrm.persistence.repository.log;

import com.team2final.minglecrm.entity.log.ViewLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewLogRepository extends JpaRepository<ViewLog, Long> {
}
