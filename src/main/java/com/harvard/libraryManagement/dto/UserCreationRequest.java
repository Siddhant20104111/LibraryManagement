package com.harvard.libraryManagement.dto;

import com.harvard.libraryManagement.entity.UserEntity;
import com.harvard.libraryManagement.enums.UserStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreationRequest{
    private String userName;

    @NotBlank(message="user email must not be blank")
    private String userEmailId;

    private String userAddress;
    private String userMobileNo;

    public UserEntity toUser(){
        return UserEntity.builder()
                .name(this.userName)
                .email(this.userEmailId)
                .phoneNo(this.userMobileNo)
                .address(this.userAddress)
                .userStatus(UserStatus.ACTIVE)
                .build();
    }

}
