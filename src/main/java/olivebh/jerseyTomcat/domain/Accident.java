package olivebh.jerseyTomcat.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import com.fasterxml.jackson.annotation.JsonAnyGetter;
        import com.fasterxml.jackson.annotation.JsonAnySetter;
        import com.fasterxml.jackson.annotation.JsonIgnore;
        import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "message",
        "@version",
        "@timestamp",
        "host",
        "date",
        "time",
        "borough",
        "zip_code",
        "latitude",
        "longitude",
        "location",
        "on_street_name",
        "cross_street_name",
        "off_street_name",
        "number_of_persons_injured",
        "number_of_persons_killed",
        "number_of_pedestrians_injured",
        "number_of_pedestrians_killed",
        "number_of_cyclist_injured",
        "number_of_cyclist_killed",
        "number_of_motorist_injured",
        "number_of_motorist_killed",
        "unique_key",
        "contributing_factor_vehicle"
})
public class Accident {

    @JsonProperty("message")
    private List<String> message = null;
    @JsonProperty("@version")
    private String version;
    @JsonProperty("@timestamp")
    private String timestamp;
    @JsonProperty("host")
    private String host;
    @JsonProperty("date")
    private String date;
    @JsonProperty("time")
    private String time;
    @JsonProperty("borough")
    private Object borough;
    @JsonProperty("zip_code")
    private Object zipCode;
    @JsonProperty("latitude")
    private Object latitude;
    @JsonProperty("longitude")
    private Object longitude;
    @JsonProperty("location")
    private Object location;
    @JsonProperty("on_street_name")
    private String onStreetName;
    @JsonProperty("cross_street_name")
    private String crossStreetName;
    @JsonProperty("off_street_name")
    private Object offStreetName;
    @JsonProperty("number_of_persons_injured")
    private Integer numberOfPersonsInjured;
    @JsonProperty("number_of_persons_killed")
    private Integer numberOfPersonsKilled;
    @JsonProperty("number_of_pedestrians_injured")
    private Integer numberOfPedestriansInjured;
    @JsonProperty("number_of_pedestrians_killed")
    private Integer numberOfPedestriansKilled;
    @JsonProperty("number_of_cyclist_injured")
    private Integer numberOfCyclistInjured;
    @JsonProperty("number_of_cyclist_killed")
    private Integer numberOfCyclistKilled;
    @JsonProperty("number_of_motorist_injured")
    private Integer numberOfMotoristInjured;
    @JsonProperty("number_of_motorist_killed")
    private Integer numberOfMotoristKilled;
    @JsonProperty("unique_key")
    private String uniqueKey;
    @JsonProperty("contributing_factor_vehicle")
    private String contributingFactorVehicle;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("message")
    public List<String> getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(List<String> message) {
        this.message = message;
    }

    @JsonProperty("@version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("@version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("@timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("@timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("borough")
    public Object getBorough() {
        return borough;
    }

    @JsonProperty("borough")
    public void setBorough(Object borough) {
        this.borough = borough;
    }

    @JsonProperty("zip_code")
    public Object getZipCode() {
        return zipCode;
    }

    @JsonProperty("zip_code")
    public void setZipCode(Object zipCode) {
        this.zipCode = zipCode;
    }

    @JsonProperty("latitude")
    public Object getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Object getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("location")
    public Object getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Object location) {
        this.location = location;
    }

    @JsonProperty("on_street_name")
    public String getOnStreetName() {
        return onStreetName;
    }

    @JsonProperty("on_street_name")
    public void setOnStreetName(String onStreetName) {
        this.onStreetName = onStreetName;
    }

    @JsonProperty("cross_street_name")
    public String getCrossStreetName() {
        return crossStreetName;
    }

    @JsonProperty("cross_street_name")
    public void setCrossStreetName(String crossStreetName) {
        this.crossStreetName = crossStreetName;
    }

    @JsonProperty("off_street_name")
    public Object getOffStreetName() {
        return offStreetName;
    }

    @JsonProperty("off_street_name")
    public void setOffStreetName(Object offStreetName) {
        this.offStreetName = offStreetName;
    }

    @JsonProperty("number_of_persons_injured")
    public Integer getNumberOfPersonsInjured() {
        return numberOfPersonsInjured;
    }

    @JsonProperty("number_of_persons_injured")
    public void setNumberOfPersonsInjured(Integer numberOfPersonsInjured) {
        this.numberOfPersonsInjured = numberOfPersonsInjured;
    }

    @JsonProperty("number_of_persons_killed")
    public Integer getNumberOfPersonsKilled() {
        return numberOfPersonsKilled;
    }

    @JsonProperty("number_of_persons_killed")
    public void setNumberOfPersonsKilled(Integer numberOfPersonsKilled) {
        this.numberOfPersonsKilled = numberOfPersonsKilled;
    }

    @JsonProperty("number_of_pedestrians_injured")
    public Integer getNumberOfPedestriansInjured() {
        return numberOfPedestriansInjured;
    }

    @JsonProperty("number_of_pedestrians_injured")
    public void setNumberOfPedestriansInjured(Integer numberOfPedestriansInjured) {
        this.numberOfPedestriansInjured = numberOfPedestriansInjured;
    }

    @JsonProperty("number_of_pedestrians_killed")
    public Integer getNumberOfPedestriansKilled() {
        return numberOfPedestriansKilled;
    }

    @JsonProperty("number_of_pedestrians_killed")
    public void setNumberOfPedestriansKilled(Integer numberOfPedestriansKilled) {
        this.numberOfPedestriansKilled = numberOfPedestriansKilled;
    }

    @JsonProperty("number_of_cyclist_injured")
    public Integer getNumberOfCyclistInjured() {
        return numberOfCyclistInjured;
    }

    @JsonProperty("number_of_cyclist_injured")
    public void setNumberOfCyclistInjured(Integer numberOfCyclistInjured) {
        this.numberOfCyclistInjured = numberOfCyclistInjured;
    }

    @JsonProperty("number_of_cyclist_killed")
    public Integer getNumberOfCyclistKilled() {
        return numberOfCyclistKilled;
    }

    @JsonProperty("number_of_cyclist_killed")
    public void setNumberOfCyclistKilled(Integer numberOfCyclistKilled) {
        this.numberOfCyclistKilled = numberOfCyclistKilled;
    }

    @JsonProperty("number_of_motorist_injured")
    public Integer getNumberOfMotoristInjured() {
        return numberOfMotoristInjured;
    }

    @JsonProperty("number_of_motorist_injured")
    public void setNumberOfMotoristInjured(Integer numberOfMotoristInjured) {
        this.numberOfMotoristInjured = numberOfMotoristInjured;
    }

    @JsonProperty("number_of_motorist_killed")
    public Integer getNumberOfMotoristKilled() {
        return numberOfMotoristKilled;
    }

    @JsonProperty("number_of_motorist_killed")
    public void setNumberOfMotoristKilled(Integer numberOfMotoristKilled) {
        this.numberOfMotoristKilled = numberOfMotoristKilled;
    }

    @JsonProperty("unique_key")
    public String getUniqueKey() {
        return uniqueKey;
    }

    @JsonProperty("unique_key")
    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    @JsonProperty("contributing_factor_vehicle")
    public String getContributingFactorVehicle() {
        return contributingFactorVehicle;
    }

    @JsonProperty("contributing_factor_vehicle")
    public void setContributingFactorVehicle(String contributingFactorVehicle) {
        this.contributingFactorVehicle = contributingFactorVehicle;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}