package main.kotlin

import com.expediagroup.graphql.client.GraphQLKtorClient
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.shopify.generated.OrdersQuery
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.logging.*
import kotlinx.coroutines.runBlocking
import java.net.URL


fun main(args: Array<String>) {
    runBlocking {
        val client = GraphQLKtorClient(
            url = URL("http://localhost:8888/gql.json"),
            engineFactory = OkHttp,
            mapper = jacksonObjectMapper()
        ) {
            engine {}
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.HEADERS
            }
        }

        val ordersQuery = OrdersQuery(client)

        ordersQuery.execute(variables = OrdersQuery.Variables(first = 10))
    }
}

