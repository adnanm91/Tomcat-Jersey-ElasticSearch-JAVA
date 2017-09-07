package olivebh.jerseyTomcat.services;

import olivebh.jerseyTomcat.dao.ClientSingleton;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

public class IndexServices{

    private IndexServices(){}

    public static String addDocument( String index, String type,String _id, String _requestBody  ) throws IOException {

        IndexResponse indexResponse = ClientSingleton.client.prepareIndex(index,type,_id).setSource(
               _requestBody
        ).get();

        return "{\"id\": " +"\""+indexResponse.getId()+"\"}" ;
    }

    public static String deleteDocument( String index, String type,String _id, String _requestBody  ) throws IOException {

        DeleteResponse deleteResponse = ClientSingleton.client.prepareDelete(index,type,_id).get();

        return "{\"id\": " +"\""+deleteResponse.getId()+"\"}" ;
    }
}
