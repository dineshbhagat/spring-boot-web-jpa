package com.example.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Manga {
    private String title;
    private String description;
    private Integer volumes;
    private Double score;
}
