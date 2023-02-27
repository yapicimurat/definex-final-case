package finalcase.api;

import finalcase.api.request.customer.CustomerPostRequest;
import finalcase.api.request.customer.CustomerPutRequest;
import finalcase.api.response.BaseResponse;
import finalcase.api.response.DataResponse;
import finalcase.dto.CustomerDto;
import finalcase.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<DataResponse<CustomerDto>> create(@RequestBody CustomerPostRequest request){
        final DataResponse<CustomerDto> result = customerService.create(request);

        return ResponseEntity.ok(result);
    }


    @PutMapping
    public ResponseEntity<DataResponse<CustomerDto>> update(@RequestBody CustomerPutRequest request){
        final DataResponse<CustomerDto> result = customerService.update(request) ;

        return ResponseEntity.ok(result);
    }

    @DeleteMapping
    public ResponseEntity<BaseResponse> delete(@PathVariable String identityNumber){
        final BaseResponse result = customerService.delete(identityNumber);

        return ResponseEntity.ok(result);
    }


}
