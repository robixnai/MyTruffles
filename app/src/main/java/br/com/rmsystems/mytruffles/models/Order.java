package br.com.rmsystems.mytruffles.models;

import java.util.Date;
import java.util.List;

public class Order {

    private Integer mId;
    private Client mClient;
    private Date mOrderDate;
    private List<Truffle> mTruffle;
    private Date mDeliveryDate;
    private boolean mWithdrawal;
    private String mPlace;

    public Order() {
        super();
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
       this.mId = id;
    }

    public Client getClient() {
        return mClient;
    }

    public void setClient(Client client) {
        this.mClient = client;
    }

    public Date getOrderDate() {
        return mOrderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.mOrderDate = orderDate;
    }

    public List<Truffle> getTruffle() {
        return mTruffle;
    }

    public void setTruffle(List<Truffle> mTruffle) {
        this.mTruffle = mTruffle;
    }

    public Date getDeliveryDate() {
        return mDeliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.mDeliveryDate = deliveryDate;
    }

    public boolean isWithdrawal() {
        return mWithdrawal;
    }

    public void setWithdrawal(boolean withdrawal) {
        this.mWithdrawal = withdrawal;
    }

    public String getPlace() {
        return mPlace;
    }

    public void setPlace(String place) {
        this.mPlace = place;
    }

    @Override
    public String toString() {
        return "Order{" +
                "mId=" + mId +
                ", mClient=" + mClient +
                ", mOrderDate=" + mOrderDate +
                ", mTruffle=" + mTruffle +
                ", mDeliveryDate=" + mDeliveryDate +
                ", mWithdrawal=" + mWithdrawal +
                ", mPlace='" + mPlace + '\'' +
                '}';
    }
}
