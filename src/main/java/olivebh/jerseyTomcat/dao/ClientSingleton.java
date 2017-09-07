package olivebh.jerseyTomcat.dao;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class ClientSingleton {
    public static final TransportClient client = new TransportClient(ImmutableSettings.builder().put("cluster.name", "elasticsearch"))
            .addTransportAddresses(
                    new InetSocketTransportAddress("localhost", 9300));
  private  ClientSingleton(){}

}
