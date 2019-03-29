[![Build Status](https://travis-ci.org/f800r/development.png)](https://travis-ci.org/f800r/development)

# Literatur und Doku

* <http://docs.spring.io/spring-boot/docs/1.1.8.RELEASE/reference/htmlsingle/#production-ready-endpoints/>
* <https://spring.io/guides/gs/spring-boot/#_learn_what_you_can_do_with_spring_boot/>
* <http://spring.io/guides/gs/rest-service//>
* <https://github.com/jayway/rest-assured/blob/master/examples/rest-assured-itest-java/src/test/java/com/jayway/restassured/itest/java/JSONGetITest.java/>
* <http://rest-assured.googlecode.com/svn/tags/1.6.2/apidocs/com/jayway/restassured/specification/ResponseSpecification.html/>
* <https://code.google.com/p/rest-assured/wiki/Usage#Additional_Examples/>
* <http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html/>
* <http://docs.spring.io/spring-boot/docs/current/reference/html/howto-embedded-servlet-containers.html/>

## Aufrufbeispiele des Microservice

Mehr zum Tool curl unter <http://curl.haxx.se/> 

```
curl -k  https://localhost
Greetings from Spring Boot!

curl -k  https://localhost/health
{"status":"UP"}

curl -k -X POST https://localhost/shutdown
{"message":"Shutting down, bye..."}

curl -k https://localhost/data?xpath=/configuration/stage/server/text()
solv048.f800r.local solv049.f800r.local
```

## Spring Boot Metrics und Prometheus Metrics

```
curl -sk https://localhost:8443/metrics | grep -i rechner
{"mem":474778,"mem.free":401477,"processors":4,"instance.uptime":20610,"uptime":25333,"systemload.average":3.44189453125,"heap.committed":423936,"heap.init":262144,"heap.used":22458,"heap":3728384,"nonheap.committed":52352,"nonheap.init":2496,"nonheap.used":50844,"nonheap":0,"threads.peak":17,"threads.daemon":15,"threads.totalStarted":21,"threads":17,"classes":6428,"classes.loaded":6428,"classes.unloaded":0,"gc.ps_scavenge.count":5,"gc.ps_scavenge.time":103,"gc.ps_marksweep.count":2,"gc.ps_marksweep.time":119,"rechner.counter":0,"httpsessions.max":-1,"httpsessions.active":0}

curl -sk https://localhost:8443/prometheus | grep -i rechner
# HELP rechner_counter rechner_counter
# TYPE rechner_counter gauge
rechner_counter 1.0

curl -sk https://localhost:8443/prometheusMetricsServlet | grep -i rechner
# HELP rechner_counter rechner_counter
# TYPE rechner_counter gauge
rechner_counter 2.0
```

## Integrativer Test in RechnerApplicationTest.java

Testhelper von com.jayway.restassured.RestAssured verwendet

SpringBootTest Annotation für integrative Tests
```
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RechnerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RechnerPrometheusConfigurationTest
```


