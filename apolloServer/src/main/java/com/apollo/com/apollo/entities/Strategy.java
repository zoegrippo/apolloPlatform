package com.apollo.com.apollo.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="strategies")

@NamedQueries(
        {
                @NamedQuery(name="strategies.getActive",
                        query="select strategy from Strategy as strategy where strategy.isRunning = true",
                        hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
                @NamedQuery(name="strategies.getTickers",
                        query="select distinct strategy.stock from Strategy as strategy where strategy.isRunning = true",
                        hints = {@QueryHint (name = "org.hibernate.cacheable", value = "true")})
        })

public class Strategy implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id") private Integer id;

    @Column(name="strategyName") private String strategyName;
    @Column(name="isRunning") private boolean isRunning;
    @Column(name="startingVol") private Integer startingVol;
    @Column(name="stock") private String stock; // stock ticker symbol
    @Column(name="exitProfitPercent") private Double exitProfitPercent;
    @Column(name="exitLossPercent") private Double exitLossPercent;
    @Column(name="stdDevs") private Double stdDevs; // bollinger bands
    @Column(name="shortTime") private Integer shortTime; // two moving averages. short time also used for other two strategies
    @JoinColumn(name="userId", referencedColumnName="id", nullable = false)
    private User user;

    public Strategy() {}

    public Strategy(String strategyName, boolean isRunning, Integer startingVol, String stock, Double exitProfitPercent, Double exitLossPercent, Double stdDevs, Integer shortTime, User user) {
        this.strategyName = strategyName;
        this.isRunning = isRunning;
        this.startingVol = startingVol;
        this.stock = stock;
        this.exitProfitPercent = exitProfitPercent;
        this.exitLossPercent = exitLossPercent;
        this.stdDevs = stdDevs;
        this.shortTime = shortTime;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Integer getStartingVol() {
        return startingVol;
    }

    public void setStartingVol(Integer startingVol) {
        this.startingVol = startingVol;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Double getExitProfitPercent() {
        return exitProfitPercent;
    }

    public void setExitProfitPercent(Double exitProfitPercent) {
        this.exitProfitPercent = exitProfitPercent;
    }

    public Double getExitLossPercent() {
        return exitLossPercent;
    }

    public void setExitLossPercent(Double exitLossPercent) {
        this.exitLossPercent = exitLossPercent;
    }

    public Double getStdDevs() {
        return stdDevs;
    }

    public void setStdDevs(Double stdDevs) {
        this.stdDevs = stdDevs;
    }

    public Integer getShortTime() {
        return shortTime;
    }

    public void setShortTime(Integer shortTime) {
        this.shortTime = shortTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}