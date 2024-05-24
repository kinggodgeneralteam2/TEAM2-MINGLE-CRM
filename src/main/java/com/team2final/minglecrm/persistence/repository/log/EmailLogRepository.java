package com.team2final.minglecrm.persistence.repository.log;

import com.team2final.minglecrm.entity.log.EmailLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailLogRepository extends JpaRepository<EmailLog, Long> {
}
