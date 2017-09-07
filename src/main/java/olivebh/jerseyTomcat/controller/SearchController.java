package olivebh.jerseyTomcat.controller;


import olivebh.jerseyTomcat.Util.JsonMapper;
import olivebh.jerseyTomcat.domain.Accident;
import olivebh.jerseyTomcat.domain.Hit;
import olivebh.jerseyTomcat.domain.Tweet;
import olivebh.jerseyTomcat.services.SearchServices;
import org.elasticsearch.common.xcontent.ToXContent;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.aggregations.AbstractAggregationBuilder;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.InternalAggregation;
import org.elasticsearch.search.aggregations.InternalAggregations;
import org.elasticsearch.search.aggregations.bucket.MultiBucketsAggregation;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;


@Path("")
    public class SearchController {


    @Path("{index}/{type}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll(@PathParam("index") String _index, @PathParam("type") String _type) {
      //  String s=null;
   /*     if (SearchServices.getEsResponseAsObjectsList().getAggregations() != null) {

            try {
                XContentBuilder builderTemp = XContentFactory.contentBuilder(XContentType.JSON);
                builderTemp.startObject();
                for (Aggregation subAgg : SearchServices.getEsResponseAsObjectsList().getAggregations()) {
                    ((InternalAggregation)subAgg).toXContent(builderTemp, ToXContent.EMPTY_PARAMS);
                }
                s=builderTemp.string();
                builderTemp.endObject();

            } catch (IOException e) {
                System.out.println("Error parsing aggs");
            }
        }
        return s; */

      return JsonMapper.listToJsonString(SearchServices.getEsResponseAsObjectsList(Tweet.class, _type,_index));

    }

    @Path("{index}/{type}/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getOne(@PathParam("index") String _index, @PathParam("type") String _searchType, @PathParam("id") String _id) {
        String response=null;

        //  String s=null;
   /*     if (SearchServices.getEsResponseAsObjectsList().getAggregations() != null) {

            try {
                XContentBuilder builderTemp = XContentFactory.contentBuilder(XContentType.JSON);
                builderTemp.startObject();
                for (Aggregation subAgg : SearchServices.getEsResponseAsObjectsList().getAggregations()) {
                    ((InternalAggregation)subAgg).toXContent(builderTemp, ToXContent.EMPTY_PARAMS);
                }
                s=builderTemp.string();
                builderTemp.endObject();

            } catch (IOException e) {
                System.out.println("Error parsing aggs");
            }
        }
        return s; */
     try
    {
        response = JsonMapper.objectToJsonString(SearchServices.getEsResponseAsObject(Tweet.class, _searchType ,_index, _id));
    }
    catch(NullPointerException NpEx)

    {
        response = "ne valja ti Id";
    }
        return response;

    }
}