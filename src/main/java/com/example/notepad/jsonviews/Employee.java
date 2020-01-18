package com.example.notepad.jsonviews;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @JsonView(OrgViews.Public.class)
    private String name;

    @JsonView(OrgViews.Internal.class)
    private String address;

    @JsonView({OrgViews.Internal.class, OrgViews.Public.class})
    private String designation;

    // you know why long, :P
    @JsonView(OrgViews.HR.class)
    private long salary;

    @JsonView(OrgViews.Personal.class)
    private String medicalHistory;
}
