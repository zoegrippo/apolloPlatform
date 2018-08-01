package com.apollo.services.db;

import com.apollo.entities.Trade;
import com.apollo.repos.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    private TradeRepository dao;

    @Override
    public Trade getTradeById(int id) {
        return dao.getOne(id);
    }

    @Override
    public void addNewTrade(Trade t) {
        dao.save(t);
    }

    @Override
    public void updateTrade(Trade t) {
        dao.save(t);
    }
}