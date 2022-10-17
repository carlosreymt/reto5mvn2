package com.ciclo3.reto.Entidades.DTO;

public class TotalPorEstado {
    private Long completed;
    private Long cancelled;

    public TotalPorEstado() {
    }

    public TotalPorEstado(Long completed, Long cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public Long getCompleted() {
        return completed;
    }

    public void setCompleted(Long completed) {
        this.completed = completed;
    }

    public Long getCancelled() {
        return cancelled;
    }

    public void setCancelled(Long cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public String toString() {
        return "TotalPorEstado{" +
                "completed=" + completed +
                ", cancelled=" + cancelled +
                '}';
    }
}
