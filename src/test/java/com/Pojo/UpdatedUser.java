package com.Pojo;

public class UpdatedUser {

    private String name;
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "UpdatedUser{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdatedUser)) return false;
        UpdatedUser that = (UpdatedUser) o;
        return name.equals(that.name) &&
                job.equals(that.job);
    }

    public static class Builder {
        private String name;
        private String job;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withJob(String job) {
            this.job = job;
            return this;
        }

        public UpdatedUser build(){
            UpdatedUser updatedUser = new UpdatedUser();
            updatedUser.name = this.name;
            updatedUser.job = this.job;
            return updatedUser;
        }
    }

}
