package finalcase.service;

import finalcase.api.request.user.UserPostRequest;
import finalcase.api.request.user.UserPutRequest;
import finalcase.api.response.BaseResponse;
import finalcase.api.response.DataResponse;
import finalcase.dto.UserDto;

public interface UserService {
    DataResponse<UserDto> create(UserPostRequest request);
    DataResponse<UserDto> update(UserPutRequest request);
    BaseResponse delete(String id);
}
