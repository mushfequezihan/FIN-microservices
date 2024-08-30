package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     * @param mobileNumber - input mobile number
     *                     fetch account details based on mobile number
     */
    CustomerDto fetchAccount (String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}
