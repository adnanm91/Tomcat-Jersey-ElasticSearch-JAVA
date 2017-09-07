package olivebh.jerseyTomcat.domain;

import lombok.Data;

@Data
public class ErrorPayload {

    String errCode;
    String errMsg;
}
