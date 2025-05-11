package com.harvard.libraryManagement.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreationResponse {
    private String userName;
    private String emailId;
    private String address;
    private String mobileNo;
}
