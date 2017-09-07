package olivebh.jerseyTomcat.controller;


import olivebh.jerseyTomcat.Util.JsonMapper;
import olivebh.jerseyTomcat.domain.Accident;
import olivebh.jerseyTomcat.domain.Hit;
import olivebh.jerseyTomcat.domain.Tweet;
import olivebh.jerseyTomcat.services.IndexServices;
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

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;


@Path("")
public class IndexController {

    @Path("{index}/{type}/{id}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String addNewDocumentWithAutoId(@PathParam("index") String _index, @PathParam("type") String _type,@PathParam("id") String _id, String _jsonRequestBody) throws IOException {

            return SearchServices.documentExists(_index,_type,_id)?"{\"msg\" : \"Ne mozes sa POSTOM MIJENJATI, KORISTI PUT\"}" :IndexServices.addDocument(_index,_type,_id,_jsonRequestBody);
    }

    @Path("{index}/{type}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String addNewDocumentWithCustomId(@PathParam("index") String _index, @PathParam("type") String _type, String _jsonRequestBody) throws IOException {


        return IndexServices.addDocument(_index,_type,null,_jsonRequestBody);
    }

    @Path("{index}/{type}/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response replaceExistingDocument(@PathParam("index") String _index, @PathParam("type") String _type, @PathParam("id") String _id, String _jsonRequestBody) throws IOException {

        return SearchServices.documentExists(_index,_type,_id) ? Response.ok().entity(IndexServices.addDocument(_index,_type,_id,_jsonRequestBody)).build(): Response.status(204).entity("{\"msg\" : \"NE MORES SA PUTOM DODAVATI NOVE!!!, KORISTI POST\"}").build();
    }


    @Path("{index}/{type}/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteDocument(@PathParam("index") String _index, @PathParam("type") String _type, @PathParam("id") String _id, String _jsonRequestBody) throws IOException {

        return SearchServices.documentExists(_index,_type,_id) ? IndexServices.deleteDocument(_index,_type,_id,_jsonRequestBody):"{\"msg\" : \"NE MOZES BRISAT CEGA NEJMA\"}";
    }



}
