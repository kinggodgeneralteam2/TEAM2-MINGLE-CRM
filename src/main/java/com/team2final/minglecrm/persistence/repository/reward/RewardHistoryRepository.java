package com.team2final.minglecrm.persistence.repository.reward;


import com.team2final.minglecrm.entity.reward.RewardHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardHistoryRepository extends JpaRepository<RewardHistory, Long> {
}
