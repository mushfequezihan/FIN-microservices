package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold customer and account info"
)
public class CustomerDto {

    @Schema(
            description = "name of the customer", example = "John Doe"
    )
    @NotEmpty(message = "Name can not be null or empty")
    @Size(min = 5, max = 30, message = "Name should be in between 5 and 30 char")
    private String name;

    @Schema(
            description = "Email of the customer", example = "test@test.com"
    )
    @NotEmpty(message = "Email can not be null or empty")
    @Email(message = "Email should be a valid one")
    private String email;

    @Schema(
            description = "Mobile number of the customer", example = "1234567890"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mob number must be 10 digit")
    private String mobileNumber;

    @Schema(
            description = "Account details of the customer"
    )
    private AccountsDto accountsDto;
}
