package com.Pojo;

public class UpdatedUserResponse extends UpdatedUser {
    private String updatedAt;

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String createdAt) {
        this.updatedAt = createdAt;
    }

    @Override
    public String toString() {
        return "UpdatedUserResponse{" +
                "updatedAt='" + updatedAt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdatedUserResponse)) return false;
        if (!super.equals(o)) return false;
        UpdatedUserResponse that = (UpdatedUserResponse) o;
        return updatedAt.equals(that.updatedAt);
    }
}
