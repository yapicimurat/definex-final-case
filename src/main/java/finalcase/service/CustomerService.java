package finalcase.service;

import finalcase.api.request.customer.CustomerPostRequest;
import finalcase.api.request.customer.CustomerPutRequest;
import finalcase.api.response.BaseResponse;
import finalcase.api.response.DataResponse;
import finalcase.dto.ApplicationDto;
import finalcase.dto.CustomerDto;
import finalcase.dto.SecurityDepositDto;

import java.time.LocalDate;
import java.util.List;

public interface CustomerService {
    DataResponse<CustomerDto> create(CustomerPostRequest customerPostRequest);
    DataResponse<CustomerDto> update(CustomerPutRequest customerPutRequest);
    BaseResponse delete(String identityNumber);
    DataResponse<List<ApplicationDto>> getApplicationResultByIdentityNumberAndDateOfBirth(String identityNumber,
                                                                                    LocalDate dateOfBirth);
    DataResponse<List<SecurityDepositDto>> getSecurityDepositsByIdentityNumber(String identityNumber);
}
