package com.example.demo.entity;

import com.example.demo.enums.LeaveType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Entity(name = "leave")
public class Leave {
    private LeaveType leaveType;
    @ManyToOne()
    private Employee employeeEmail;
    private String employeeName;
    private LocalDate date;
}
