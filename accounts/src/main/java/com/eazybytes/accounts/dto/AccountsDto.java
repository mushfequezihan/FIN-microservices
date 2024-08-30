package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold account info"
)
public class AccountsDto {

    @NotEmpty(message = "Acc Num can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Acc number must be 10 digit")
    @Schema(
            description = "Account Number for a bank", example = "1987654321"
    )
    private Long accountNumber;

    @Schema(
            description = "Account type for a bank", example = "Checking"
    )
    @NotEmpty(message = "Acc type not be null or empty")
    private String accountType;

    @Schema(
            description = "Account Branch address for a bank", example = "123 New York"
    )
    @NotEmpty(message = "Branch add can not be null or empty")
    private String branchAddress;
}
