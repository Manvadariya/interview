package com.shipmnt.interview.restapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Rates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String type;
    @NotNull
    private String fromLocation;
    @NotNull
    private String toLocation;
    @NotNull
    private LocalDate validFrom;
    @NotNull
    private LocalDate validTo;
    @NotNull
    private Integer price;
    @NotNull
    private String currency;
    @NotNull
    private Integer transitDays;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getType() {
        return type;
    }

    public void setType(@NotNull String type) {
        this.type = type;
    }

    public @NotNull String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(@NotNull String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public @NotNull String getToLocation() {
        return toLocation;
    }

    public void setToLocation(@NotNull String toLocation) {
        this.toLocation = toLocation;
    }

    public @NotNull LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(@NotNull LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public @NotNull LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(@NotNull LocalDate validTo) {
        this.validTo = validTo;
    }

    public @NotNull Integer getPrice() {
        return price;
    }

    public void setPrice(@NotNull Integer price) {
        this.price = price;
    }

    public @NotNull String getCurrency() {
        return currency;
    }

    public void setCurrency(@NotNull String currency) {
        this.currency = currency;
    }

    public @NotNull Integer getTransitDays() {
        return transitDays;
    }

    public void setTransitDays(@NotNull Integer transitDays) {
        this.transitDays = transitDays;
    }
}