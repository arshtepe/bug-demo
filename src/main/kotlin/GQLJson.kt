package main.kotlin

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GQLJson {

    @PostMapping(value = arrayOf("/gql.json"), produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun greeting(): String {
        return "{\"data\":{\"orders\":{\"edges\":[{\"node\":{\"cancelReason\":null},\"cursor\":\"eyJsYXN0X2lkIjozMTI1ODgzMTA5NTcwLCJsYXN0X3ZhbHVlIjoiMjAyMC0xMi0xMCAyMToyMToxNS44NjgwNDQifQ==\"}],\"pageInfo\":{\"hasNextPage\":true,\"hasPreviousPage\":false}}},\"extensions\":{\"cost\":{\"requestedQueryCost\":3,\"actualQueryCost\":3,\"throttleStatus\":{\"maximumAvailable\":1000.0,\"currentlyAvailable\":997,\"restoreRate\":50.0}}}}";
    }

    @GetMapping("/")
    fun helloKotlin(): String {
        return "hello world"
    }
}