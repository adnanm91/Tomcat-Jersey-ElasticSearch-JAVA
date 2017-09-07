package olivebh.jerseyTomcat.domain;

import lombok.Data;

@Data
public class GenericJsonResponse<T>{

    String status;

    ErrorPayload errorPayload;

    T succesPayload;
}
