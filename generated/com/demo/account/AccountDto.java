package com.demo.account;

import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
    private Integer accountId;
    private String accountNumber;
    private String accountName;
    private String accountType;
    private Double balance;
    private String currency;
    private String createdAt;
    private String createdBy;
    private String updatedAt;
    private String updatedBy;
}
