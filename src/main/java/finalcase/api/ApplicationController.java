package finalcase.api;

import finalcase.api.request.application.ApplicationPostRequest;
import finalcase.api.request.customer.CustomerApplicationResultGetRequest;
import finalcase.api.response.DataResponse;
import finalcase.dto.ApplicationDto;
import finalcase.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/application")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<DataResponse<ApplicationDto>> applyCredit(@RequestBody ApplicationPostRequest request){
        final DataResponse<ApplicationDto> result = applicationService.create(request);


        return ResponseEntity.ok(result);
    }

    @GetMapping("/customer-result")
    public ResponseEntity<DataResponse<List<ApplicationDto>>> getResult(
            @RequestBody CustomerApplicationResultGetRequest request
    ){
        final DataResponse<List<ApplicationDto>> result = applicationService
                .getApplicationResultsByCustomerIdentityNumberAndDateOfBirth(request);


        return ResponseEntity.ok(result);
    }
}
