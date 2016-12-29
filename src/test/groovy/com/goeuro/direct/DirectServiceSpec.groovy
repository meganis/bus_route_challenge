package com.goeuro.direct

import com.goeuro.direct.api.DirectConnectionRequest
import com.goeuro.direct.impl.DirectServiceImpl
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by segr on 29.12.16.
 */
class DirectServiceSpec extends Specification {

    DirectServiceImpl service = new DirectServiceImpl()

    def setup() {
        service.readData(new File(Thread.currentThread().getContextClassLoader().getResource("routes0.txt").toURI()).absolutePath)
    }

    def "proper responses for routes0.txt"() {
        when:
        DirectConnectionRequest req = new DirectConnectionRequest(); req.depSid = a; req.arrSid = b
        def res = service.checkDirectConnection(req)

        then:
        res.directBusRoute == c

        where:
        a  |  b || c
        0  |  2 || true
        0  |  5 || false
    }


    def "false responses for unspecified stations"() {
        when:
        DirectConnectionRequest req = new DirectConnectionRequest(); req.depSid = a; req.arrSid = b
        def res = service.checkDirectConnection(req)

        then:
        res.directBusRoute == c

        where:
        a  |  b || c
        -1 |  2 || false
         0 |  8 || false
         0 |  Integer.MAX_VALUE || false
    }
}
