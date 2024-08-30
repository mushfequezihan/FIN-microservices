package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.dto.ErrorResponseDto;
import com.eazybytes.accounts.dto.ResponseDto;
import com.eazybytes.accounts.service.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD Rest APIs for Accounts for Bank",
        description = "CREATE update FETCH and Delete Account details"
)
@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountsController {

    private IAccountsService iAccountsService;

    @Operation(
            summary = "Create Account REST api",
            description = "REST api to create new customer and account for bank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP status Created."
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto){

        iAccountsService.createAccount(customerDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Fetch Account REST api",
            description = "REST api to Fetch created customer and account for bank with mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status Success."
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails (@RequestParam
                                                                @Pattern(regexp = "(^$|[0-9]{10})", message = "Mob number must be 10 digit")
                                                                        String mobileNumber){

        CustomerDto customerDto = iAccountsService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @Operation(
            summary = "Update Account REST api",
            description = "REST api to Update customer and account for bank info"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "HTTP status OK"
                    ),
                    @ApiResponse(
                            responseCode = "417",
                            description = "Exception Failed"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "HTTP status Internal Server Error",
                            content = @Content(
                                    schema = @Schema( implementation = ErrorResponseDto.class )
                            )
                    )
            }
    )
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = iAccountsService.updateAccount(customerDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary = "Delete Account REST api",
            description = "REST api to Delete customer details with mobile number"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "HTTP status OK"
                    ),
                    @ApiResponse(
                            responseCode = "417",
                            description = "Exception Failed"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "HTTP status Internal Server Error",
                            content = @Content(
                            schema = @Schema( implementation = ErrorResponseDto.class )
                        )
                    )
            }
    )
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam
                                                                @Pattern(regexp = "(^$|[0-9]{10})", message = "Mob number must be 10 digit")
                                                                        String mobileNumber) {
        boolean isDeleted = iAccountsService.deleteAccount(mobileNumber);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_DELETE));
        }
    }


}
