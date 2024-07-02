package com.example.demo.dto;

import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {
    private String id;
    private String category;
}
