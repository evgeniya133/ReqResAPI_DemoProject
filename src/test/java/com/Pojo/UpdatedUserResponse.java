package com.Pojo;

public class UpdatedUserResponse extends UpdatedUser {
    private String createdAt;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "UpdatedUserResponse{" +
                "createdAt='" + createdAt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdatedUserResponse)) return false;
        if (!super.equals(o)) return false;
        UpdatedUserResponse that = (UpdatedUserResponse) o;
        return createdAt.equals(that.createdAt);
    }
}
