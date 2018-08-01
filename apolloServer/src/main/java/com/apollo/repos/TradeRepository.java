package com.apollo.repos;

import com.apollo.entities.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer> {
    @Query(value = "select * from trades as t inner join strategies as s on t.strategyid = s.id;", nativeQuery = true)
    Collection<Trade> getAllByStrategy_Id(int id);
}