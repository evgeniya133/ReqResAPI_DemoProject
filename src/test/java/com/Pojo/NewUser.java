package com.Pojo;

public class NewUser {

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
        return "NewUser{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewUser)) return false;
        NewUser newUser = (NewUser) o;
        return name.equals(newUser.name) &&
                job.equals(newUser.job);
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

        public NewUser build() {
            NewUser newUser = new NewUser();
            newUser.name = this.name;
            newUser.job = this.job;
            return newUser;
        }
    }
}
