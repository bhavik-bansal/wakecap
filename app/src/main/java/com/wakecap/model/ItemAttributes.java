package com.wakecap.model;

import com.google.gson.annotations.SerializedName;

public class ItemAttributes {
    @SerializedName("full_name")
    private String fullName;
    private String role;

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }
}
