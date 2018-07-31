package com.apollo.service;

import com.apollo.entities.Strategy;
import com.apollo.entities.Trade;
import com.apollo.entities.User;
import com.apollo.repos.TradeRepository;
import com.apollo.service.TradeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestTradeService {

    @Mock
    TradeRepository data;

    @InjectMocks
    TradeServiceImpl tradeImpl;

    @Test
    public void canGetTradeById() {
        java.util.Date now = Calendar.getInstance().getTime();
        java.sql.Timestamp time = new java.sql.Timestamp(now.getTime());
        Trade t1 = new Trade(true, 99.99, 100, "AAPL", time, "Completed", new Strategy(), new User("Zoe"));
        t1.setId(2);
        Trade t2 = new Trade(true, 99.99, 100, "AAPL", time, "Completed", new Strategy(), new User("Zoe"));
        t2.setId(3);
        List<Trade> l = new ArrayList<>();
        l.add(t1);
        l.add(t2);

        when(data.findAll()).thenReturn(l);
        when(data.getOne(2)).thenReturn(t1);

        assertEquals(t1, tradeImpl.getTradeById(2));
    }
}
