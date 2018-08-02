package com.apollo.service;

import com.apollo.entities.Trade;
import com.apollo.repos.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;

@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    private TradeRepository dao;

    @Override
    public Trade getTradeById(int id) {
        return dao.getOne(id);
    }

    // at the /trade endpoint
    @Override
    public Collection<Trade> getAll() {
        return dao.findAll();
    }

    // at the /trade/{id} endpoint
    @Override
    public Collection<Trade> getTradeByStrategy(int id) {
        return dao.getAllByStrategy_Id(id);
    }

    // at the /trade/{id}/{date} endpoint
    @Override
    public Collection<Trade> getTradeByStrategyAndTradeId(int sid, int tid) {
        return dao.getAllByStrategy_IdAndTrade_Id(sid, tid);
    }
}
