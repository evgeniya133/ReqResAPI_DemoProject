package com.Pojo;

import java.util.Objects;

public class NewUserResponse extends NewUser {
    private String id;
    private String createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "NewUserResponse{" +
                "id='" + id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewUserResponse)) return false;
        if (!super.equals(o)) return false;
        NewUserResponse that = (NewUserResponse) o;
        return id.equals(that.id) &&
                createdAt.equals(that.createdAt);
    }

}
