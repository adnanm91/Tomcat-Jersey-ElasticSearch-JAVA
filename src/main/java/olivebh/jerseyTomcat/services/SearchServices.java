package olivebh.jerseyTomcat.services;

import olivebh.jerseyTomcat.dao.ClientSingleton;
import olivebh.jerseyTomcat.Util.JsonMapper;
import olivebh.jerseyTomcat.domain.Hit;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.*;

public class SearchServices{


           private SearchServices(){}
        public static<T> List<Hit<T>>  getEsResponseAsObjectsList(Class<T> _sourceClazz,String _type, String _searchIndices ) {

            SearchRequest query = new SearchRequest().types(_type)
                              .indices(_searchIndices)
                              .searchType(SearchType.QUERY_THEN_FETCH)
                              .source(SearchSourceBuilder.searchSource().size(10000).query(matchAllQuery()).version(true));

            SearchResponse response = ClientSingleton.client.search(query).actionGet();

            return JsonMapper.esJsonToObjectList(response, _sourceClazz);

        }

        public static <T> Hit<T> getEsResponseAsObject(Class<T> _sourceClazz, String _searchType, String _searchIndices, String _id){

            SearchRequest query = new SearchRequest()
                    .indices(_searchIndices)
                    .searchType(SearchType.QUERY_THEN_FETCH)
                    .source(SearchSourceBuilder.searchSource().query(idsQuery(_searchType).addIds(_id)).version(true));

            SearchResponse response = ClientSingleton.client.search(query).actionGet();

            return JsonMapper.esJsonToObject(response, _sourceClazz);


        }

        public static boolean documentExists( String _searchIndices, String _searchType, String _id){
            return  ClientSingleton.client
                        .prepareGet(_searchIndices,_searchType,_id)
                        .setRefresh(true)
                        .execute()
                        .actionGet()
                        .isExists();
}

}

  //  termQuery("on_street_name","UNION TURNPIKE")