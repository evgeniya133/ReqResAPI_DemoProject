package com.Pojo;

public class Data {

    public static Data data1 = new Builder()
            .withID(1)
            .withFirstName("Mary")
            .withLasName("Jones")
            .withEmail("maryjones@yahoo.com")
            .withAvatar("https://reqres.in/img/faces/12-image.jpg")
            .build();
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data data = (Data) o;
        return id == data.id &&
                email.equals(data.email) &&
                first_name.equals(data.first_name) &&
                last_name.equals(data.last_name) &&
                avatar.equals(data.avatar);
    }

    public static class Builder {

        private int id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;

        public Builder withID(int id) {
            this.id = id;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withFirstName(String first_name) {
            this.first_name = first_name;
            return this;
        }

        public Builder withLasName(String last_name) {
            this.last_name = last_name;
            return this;
        }

        public Builder withAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public Data build() {
            Data data = new Data();
            data.id = this.id;
            data.first_name = this.first_name;
            data.last_name = this.last_name;
            data.email = this.email;
            data.avatar = this.avatar;
            return data;
        }

    }

}