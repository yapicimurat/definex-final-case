package finalcase.api.response;

public class DataResponse<T> extends BaseResponse {
    public final T data;

    public DataResponse(T data, boolean isSuccess, String message){
        super(isSuccess, message);
        this.data = data;
    }
}