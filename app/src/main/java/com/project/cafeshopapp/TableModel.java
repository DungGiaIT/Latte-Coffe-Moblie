package com.project.cafeshopapp;

import com.google.gson.annotations.SerializedName;

public class TableModel {
    @SerializedName("id")
    private String id;

    @SerializedName("tableId")
    private int tableId;  // Đây là số bàn

    @SerializedName("createdAt")
    private String createdAt;

    @SerializedName("updatedAt")
    private String updatedAt;

    // Getters
    public String getId() { return id; }
    public int getTableId() { return tableId; }  // Sử dụng getTableId() cho số bàn
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setTableId(int tableId) { this.tableId = tableId; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}