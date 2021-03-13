package com.Pojo;

public class Support {

    public static Support support1 = new Support.Builder()
            .withUrl("https://reqres.in/#support-heading")
            .withText("To keep ReqRes free, contributions towards server costs are appreciated!")
            .build();

    private String url;
    private String text;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Support{" +
                "url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Support)) return false;
        Support support = (Support) o;
        return url.equals(support.url) &&
                text.equals(support.text);
    }

    public static class Builder {
        private String url;
        private String text;

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withText(String text) {
            this.text = text;
            return this;
        }

        public Support build() {
            Support support = new Support();
            support.url = this.url;
            support.text = this.text;
            return support;
        }
    }
}
