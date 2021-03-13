package com.Pojo;

public class SingleUser {
    private Data data;
    private Support support;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    @Override
    public String toString() {
        return "User{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SingleUser)) return false;
        SingleUser singleUser = (SingleUser) o;
        return data.equals(singleUser.data) &&
                support.equals(singleUser.support);
    }

    public static class Builder {
        private Data data;
        private Support support;

        public Builder withData(Data data) {
            this.data = data;
            return this;
        }

        public Builder withSupport(Support support) {
            this.support = support;
            return this;
        }

        public SingleUser build() {
            SingleUser singleUser = new SingleUser();
            singleUser.data = this.data;
            singleUser.support = this.support;
            return singleUser;
        }
    }
}
