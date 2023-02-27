package finalcase.api;

import finalcase.api.request.user.UserPostRequest;
import finalcase.api.request.user.UserPutRequest;
import finalcase.api.response.BaseResponse;
import finalcase.api.response.DataResponse;
import finalcase.dto.UserDto;
import finalcase.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<DataResponse<UserDto>> create(@RequestBody UserPostRequest request){
        final DataResponse<UserDto> result = userService.create(request);

        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<DataResponse<UserDto>> update(@RequestBody UserPutRequest request){
        final DataResponse<UserDto> result = userService.update(request);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable String id){
        final BaseResponse result = userService.delete(id);

        return ResponseEntity.ok(result);
    }

}
