package org.example.catalog.product.elastic.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {

    @Value("${elasticsearch.url}")
    private String elasticsearchUrl;

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        JacksonJsonpMapper jacksonJsonpMapper = new JacksonJsonpMapper(objectMapper);

        RestClient restClient = RestClient
                .builder(HttpHost.create(elasticsearchUrl))
                .build();
        ElasticsearchTransport transport = new RestClientTransport(restClient, jacksonJsonpMapper);

        return new ElasticsearchClient(transport);
    }
}
