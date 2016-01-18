package br.com.rmsystems.mytruffles.models;

import java.io.Serializable;
import java.util.List;

import br.com.rmsystems.mytruffles.repositorys.TruffleRepository;

public class Truffle implements Serializable {

    private Integer mId;
    private String mFlavor;
    private double mValue;
    private String mImage;
    private Integer mQuantity;

    public Truffle() {
        super();
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        this.mId = id;
    }

    public String getFlavor() {
        return mFlavor;
    }

    public void setFlavor(String flavor) {
        this.mFlavor = flavor;
    }

    public double getValue() {
        return mValue;
    }

    public void setValue(double value) {
        this.mValue = value;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        this.mImage = image;
    }

    public Integer getQuantity() {
        return mQuantity;
    }

    public void setQuantity(Integer quantity) {
        this.mQuantity = quantity;
    }

    @Override
    public String toString() {
        return "Truffle{" +
                "mId=" + mId +
                ", mFlavor='" + mFlavor + '\'' +
                ", mValue=" + mValue +
                ", mImage='" + mImage + '\'' +
                ", mQuantity=" + mQuantity +
                '}';
    }

    public static List<Truffle> getAll() {
        return TruffleRepository.getInstance().getAll();
    }

}
