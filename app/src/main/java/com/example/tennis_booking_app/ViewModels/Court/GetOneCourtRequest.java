package com.example.tennis_booking_app.ViewModels.Court;

public class GetOneCourtRequest {
    private int Id;

    public GetOneCourtRequest(int id) {
        Id = id;
    }


    public GetOneCourtRequest() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
