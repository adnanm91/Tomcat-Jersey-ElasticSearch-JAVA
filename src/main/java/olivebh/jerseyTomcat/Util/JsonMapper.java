package olivebh.jerseyTomcat.Util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import olivebh.jerseyTomcat.domain.Hit;
import olivebh.jerseyTomcat.domain.Tweet;
import org.elasticsearch.action.ActionResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonMapper {

    final static ObjectMapper mapper = new ObjectMapper();

    public static <T> Hit<T> esJsonToObject(SearchResponse _searchResponse, Class<T> clazz){


            T _source=null;
            SearchHit result = null;
            for (SearchHit hit : _searchResponse.getHits().getHits()) {
                try {
                    _source = mapper.readValue(hit.getSourceAsString(), clazz);
                } catch (JsonMappingException e) {
                    e.printStackTrace();
                } catch (JsonGenerationException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                result=hit;
            }
                return new Hit(result.getId(), result.getType(), result.getIndex(), result.getVersion(), result.getScore(), _source);


    }

    public static <T> List<Hit<T>> esJsonToObjectList(SearchResponse _searchResponse, Class<T> clazz){
        List<Hit<T>> results = new ArrayList<>();
        for( SearchHit hit :_searchResponse.getHits().getHits()){

            T _source=null;
            try {
                _source =  mapper.readValue(hit.getSourceAsString(), clazz);
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            results.add(new Hit(hit.getId(),hit.getType(),hit.getIndex(),hit.getVersion(),hit.getScore(),_source));
        }
        return results;
}

    public static<T> String listToJsonString(List<T> list){
       // List<Aggregation> results = new ArrayList<>();
        String jsonString=null;
        try {
            jsonString= mapper.writeValueAsString(list);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public static <T> String objectToJsonString(T _sourceObject){
        // List<Aggregation> results = new ArrayList<>();
        String jsonString=null;
        try {
            jsonString= mapper.writeValueAsString(_sourceObject);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

}
