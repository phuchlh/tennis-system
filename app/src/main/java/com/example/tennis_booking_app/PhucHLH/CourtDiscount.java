package com.example.tennis_booking_app.PhucHLH;

import java.io.Serializable;

public class CourtDiscount implements Serializable {

    private String courtName;
    private String discountText;
    private int courtImage;
    private String discountDescription;

    public CourtDiscount(String courtName, String discountText, int courtImage, String discountDescription) {
        this.courtName = courtName;
        this.discountText = discountText;
        this.courtImage = courtImage;
        this.discountDescription = discountDescription;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public void setDiscountDescription(String discountDescription) {
        this.discountDescription = discountDescription;
    }

    public String getCourtName() {
        return this.courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public String getDiscountText() {
        return this.discountText;
    }

    public void setDiscountText(String discountText) {
        this.discountText = discountText;
    }

    public int getCourtImage() {
        return this.courtImage;
    }

    public void setCourtImage(int courtImage) {
        this.courtImage = courtImage;
    }

    @Override
    public String toString() {
        return "CourtDiscount{" +
                "courtName='" + courtName + '\'' +
                ", discountText='" + discountText + '\'' +
                ", courtImage=" + courtImage +
                ", discountDescription='" + discountDescription + '\'' +
                '}';
    }
}
