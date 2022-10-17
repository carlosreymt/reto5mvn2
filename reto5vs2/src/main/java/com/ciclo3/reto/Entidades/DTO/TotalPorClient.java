package com.ciclo3.reto.Entidades.DTO;

import com.ciclo3.reto.Entidades.Client;

public class TotalPorClient {
    private Long total;
    private Client client;

    public TotalPorClient() {
    }

    public TotalPorClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "TotalPorClient{" +
                "total=" + total +
                ", client=" + client +
                '}';
    }
}
