package org.example

import groovyx.net.http.RESTClient
import groovyx.net.http.Status
import org.apache.http.HttpStatus
import spock.lang.Specification


class HomeControllerSpec extends Specification {

    protected RESTClient client

    protected String applicationBaseUrl

    def setup() {
        applicationBaseUrl = System.getProperty('grails.testing.functional.baseUrl')
        assert applicationBaseUrl, "Failed to read base URL from System properties"
        client = new DefaultRESTClient(applicationBaseUrl)
    }

    def "invoke HomeController"() {

        when:
        def result = client.get(path: 'home')

        then:
        result.status == HttpStatus.SC_OK
    }


    static class DefaultRESTClient extends RESTClient {
        DefaultRESTClient(String baseUrl) {
            super(baseUrl)

            // success and failure responses should be handled by the RESTClient instance
            defaultResponseHandlers[Status.FAILURE] = defaultResponseHandlers[Status.SUCCESS]
        }
    }
}
