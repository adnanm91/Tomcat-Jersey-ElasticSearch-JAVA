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

@Data
@NoArgsConstructor
@JsonPropertyOrder(value = {
        "_index", "_type","_version", "_id", "_score", "_source",
})
public class Hit<T> {

    @Id
    @JsonProperty("_id")
    private String  id;

    @JsonProperty("_type")
    private String type;

    @JsonProperty("_index")
    private String index;

    @JsonProperty("_version")
    private long version;

    @JsonProperty("_score")
    private float score;

    @JsonProperty("_source")
    private T  source;

    public Hit(String id, String type, String index, long version, float score, T source) {
        this.id = id;
        this.type = type;
        this.index = index;
        this.version = version;
        this.score = score;
        this.source = source;
    }
}