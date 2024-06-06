package com.example.demo.entity;

import jakarta.persistence.OneToOne;

public class LeaveManagement {
    private String name;
    @OneToOne()
    private String email;
    private final int totalLeaves=18;
    private int LeavesCount;
    private int lossOfPayCount;

}
