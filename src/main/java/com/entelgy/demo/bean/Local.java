package com.entelgy.demo.bean;

import java.util.Objects;

/**
 * Created on 20/02/2018.
 *
 * @author Entelgy
 */
public class Local {
    private String id;
    private String name;
    private String address;

    public Local() {
    }

    public Local(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Local local = (Local) o;
        return Objects.equals(getId(), local.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
