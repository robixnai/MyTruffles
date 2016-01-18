package br.com.rmsystems.mytruffles.models;

public class Client {

    private Integer mId;
    private String mName;
    private String mEmail;

    public Client() {
        super();
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mEmail='" + mEmail + '\'' +
                '}';
    }

}