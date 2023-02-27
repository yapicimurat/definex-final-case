package finalcase.service;

import finalcase.api.request.application.ApplicationPostRequest;
import finalcase.api.request.customer.CustomerApplicationResultGetRequest;
import finalcase.api.response.DataResponse;
import finalcase.dto.ApplicationDto;

import java.time.LocalDate;
import java.util.List;

public interface ApplicationService {

    DataResponse<ApplicationDto> create(ApplicationPostRequest request);

    DataResponse<List<ApplicationDto>> getApplicationResultsByCustomerIdentityNumberAndDateOfBirth(CustomerApplicationResultGetRequest request);
}
