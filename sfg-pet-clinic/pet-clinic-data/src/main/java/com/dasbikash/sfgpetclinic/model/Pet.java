package com.dasbikash.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {

    private PateType pateType;
    private Owner owner;
    private LocalDate localDate;

    public Pet() {
    }

    public Pet(PateType pateType, Owner owner, LocalDate localDate) {
        this.pateType = pateType;
        this.owner = owner;
        this.localDate = localDate;
    }

    public PateType getPateType() {
        return pateType;
    }

    public void setPateType(PateType pateType) {
        this.pateType = pateType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
