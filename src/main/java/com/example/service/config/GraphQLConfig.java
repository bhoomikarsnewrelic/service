package com.example.service.config;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Configuration
public class GraphQLConfig {

    @Bean
    public GraphQL graphQL(ResourceLoader resourceLoader) throws IOException {
        // Load your schema file from the classpath resources
        Resource resource = resourceLoader.getResource("classpath:graphql/schema.graphqls");

        try (InputStream stream = resource.getInputStream();
             InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {

            // Read the schema definition file
            TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(reader);
            RuntimeWiring runtimeWiring = buildWiring();

            // Generate the schema
            GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeRegistry, runtimeWiring);

            // Build and return the GraphQL instance
            return GraphQL.newGraphQL(graphQLSchema).build();
        }
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("healthCheck", environment -> "OK")
                        .dataFetcher("organization", environment -> new Object())
                )
                .type("Mutation", typeWiring -> typeWiring
                        .dataFetcher("createGithubConfig", environment -> new Object()) // Example fetcher
                )
                // Add more data fetchers as necessary
                .build();
    }
}
