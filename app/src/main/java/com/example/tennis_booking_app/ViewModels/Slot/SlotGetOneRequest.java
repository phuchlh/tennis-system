package com.example.tennis_booking_app.ViewModels.Slot;

public class SlotGetOneRequest {
    private int Id;

    public SlotGetOneRequest(int id) {
        Id = id;
    }

    public SlotGetOneRequest() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
