package olivebh.jerseyTomcat.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@JsonPropertyOrder(value = {
        "user", "post_dat", "message"})
@Document(indexName = "tweeter", type = "tweet")
public class Tweet {

    @JsonProperty("user")
    @Field(type = FieldType.String)
    private String  user;

    @JsonProperty("post_date")
    @Field(type = FieldType.Date)
    private Date date;

    @JsonProperty("message")
    @Field(type = FieldType.String)
    private String message;




}