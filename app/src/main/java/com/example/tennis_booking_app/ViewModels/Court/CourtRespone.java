package com.example.tennis_booking_app.ViewModels.Court;

import com.example.tennis_booking_app.Models.CourtValue;

import java.util.List;

public class CourtRespone {
    private int Count,FirstItemOnPage,PageNumber,PageCount,PageSize,LstItemOnPage;
    private boolean HasNextPage,HasPreviousPage,IsFirstPage,IsLastPage;

    List<CourtValue> Value;

    public CourtRespone(int count, int firstItemOnPage, int pageNumber, int pageCount, int pageSize, int lstItemOnPage, boolean hasNextPage, boolean hasPreviousPage, boolean isFirstPage, boolean isLastPage, List<CourtValue> value) {
        Count = count;
        FirstItemOnPage = firstItemOnPage;
        PageNumber = pageNumber;
        PageCount = pageCount;
        PageSize = pageSize;
        LstItemOnPage = lstItemOnPage;
        HasNextPage = hasNextPage;
        HasPreviousPage = hasPreviousPage;
        IsFirstPage = isFirstPage;
        IsLastPage = isLastPage;
        Value = value;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public int getFirstItemOnPage() {
        return FirstItemOnPage;
    }

    public void setFirstItemOnPage(int firstItemOnPage) {
        FirstItemOnPage = firstItemOnPage;
    }

    public int getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(int pageNumber) {
        PageNumber = pageNumber;
    }

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int pageCount) {
        PageCount = pageCount;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getLstItemOnPage() {
        return LstItemOnPage;
    }

    public void setLstItemOnPage(int lstItemOnPage) {
        LstItemOnPage = lstItemOnPage;
    }

    public boolean isHasNextPage() {
        return HasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        HasNextPage = hasNextPage;
    }

    public boolean isHasPreviousPage() {
        return HasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        HasPreviousPage = hasPreviousPage;
    }

    public boolean isFirstPage() {
        return IsFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        IsFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return IsLastPage;
    }

    public void setLastPage(boolean lastPage) {
        IsLastPage = lastPage;
    }

    public List<CourtValue> getValue() {
        return Value;
    }

    public void setValue(List<CourtValue> value) {
        Value = value;
    }
}
