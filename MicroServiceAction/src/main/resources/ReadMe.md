http://localhost:8080/hello-world?name=Successful+Dropwizard+User
{"id":1,"content":"Hello, Successful Dropwizard User!"}

http://localhost:8081/
Operational Menu

Metrics
Ping
Threads
Healthcheck

http://localhost:8081/metrics
{"version":"3.0.0","gauges":{"jvm.buffers.direct.capacity":{"value":58086},"jvm.buffers.direct.count":{"value":8},"jvm.buffers.direct.used":{"value":58086},"jvm.buffers.mapped.capacity":{"value":0},"jvm.buffers.mapped.count":{"value":0},"jvm.buffers.mapped.used":{"value":0},"jvm.gc.PS-MarkSweep.count":{"value":0},"jvm.gc.PS-MarkSweep.time":{"value":0},"jvm.gc.PS-Scavenge.count":{"value":3},"jvm.gc.PS-Scavenge.time":{"value":53},"jvm.memory.heap.committed":{"value":66584576},"jvm.memory.heap.init":{"value":54493056},"jvm.memory.heap.max":{"value":775421952},"jvm.memory.heap.usage":{"value":0.052329630203711335},"jvm.memory.heap.used":{"value":40577544},"jvm.memory.non-heap.committed":{"value":24576000},"jvm.memory.non-heap.init":{"value":24576000},"jvm.memory.non-heap.max":{"value":136314880},"jvm.memory.non-heap.usage":{"value":0.15875408466045673},"jvm.memory.non-heap.used":{"value":21640544},"jvm.memory.pools.Code-Cache.usage":{"value":0.016241709391276043},"jvm.memory.pools.PS-Eden-Space.usage":{"value":0.09647094614980861},"jvm.memory.pools.PS-Old-Gen.usage":{"value":0.018626729898134582},"jvm.memory.pools.PS-Perm-Gen.usage":{"value":0.2421759628668064},"jvm.memory.pools.PS-Survivor-Space.usage":{"value":0.992218017578125},"jvm.memory.total.committed":{"value":91160576},"jvm.memory.total.init":{"value":79069056},"jvm.memory.total.max":{"value":911736832},"jvm.memory.total.used":{"value":62218088},"jvm.threads.blocked.count":{"value":0},"jvm.threads.count":{"value":23},"jvm.threads.daemon.count":{"value":5},"jvm.threads.deadlocks":{"value":[]},"jvm.threads.new.count":{"value":0},"jvm.threads.runnable.count":{"value":10},"jvm.threads.terminated.count":{"value":0},"jvm.threads.timed_waiting.count":{"value":10},"jvm.threads.waiting.count":{"value":3},"org.eclipse.jetty.util.thread.QueuedThreadPool.dw.jobs":{"value":0},"org.eclipse.jetty.util.thread.QueuedThreadPool.dw.size":{"value":8},"org.eclipse.jetty.util.thread.QueuedThreadPool.dw.utilization":{"value":0.375}},"counters":{"io.dropwizard.jetty.MutableServletContextHandler.active-dispatches":{"count":0},"io.dropwizard.jetty.MutableServletContextHandler.active-requests":{"count":0},"io.dropwizard.jetty.MutableServletContextHandler.active-suspended":{"count":0}},"histograms":{},"meters":{"ch.qos.logback.core.Appender.all":{"count":11,"m15_rate":0.29773762312054824,"m1_rate":1.925381301894483,"m5_rate":1.4747041012784068,"mean_rate":0.0868962791707821,"units":"events/second"},"ch.qos.logback.core.Appender.debug":{"count":0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"units":"events/second"},"ch.qos.logback.core.Appender.error":{"count":0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"units":"events/second"},"ch.qos.logback.core.Appender.info":{"count":11,"m15_rate":0.29773762312054824,"m1_rate":1.925381301894483,"m5_rate":1.4747041012784068,"mean_rate":0.08689617417682316,"units":"events/second"},"ch.qos.logback.core.Appender.trace":{"count":0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"units":"events/second"},"ch.qos.logback.core.Appender.warn":{"count":0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"units":"events/second"},"io.dropwizard.jetty.MutableServletContextHandler.1xx-responses":{"count":0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"units":"events/second"},"io.dropwizard.jetty.MutableServletContextHandler.2xx-responses":{"count":1,"m15_rate":0.0054124402384289035,"m1_rate":0.0010308274215719729,"m5_rate":0.002661751536257776,"mean_rate":0.008008912570734064,"units":"events/second"},"io.dropwizard.jetty.MutableServletContextHandler.3xx-responses":{"count":0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"units":"events/second"},"io.dropwizard.jetty.MutableServletContextHandler.4xx-responses":{"count":1,"m15_rate":0.0054124402384289035,"m1_rate":0.0010308274215719729,"m5_rate":0.002661751536257776,"mean_rate":0.008008891731087946,"units":"events/second"},"io.dropwizard.jetty.MutableServletContextHandler.5xx-responses":{"count":0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"units":"events/second"},"io.dropwizard.jetty.MutableServletContextHandler.async-dispatches":{"count":0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"units":"events/second"},"io.dropwizard.jetty.MutableServletContextHandler.async-timeouts":{"count":0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"units":"events/second"}},"timers":{"de.microservice.rechner.jerseyresources.RechnerResourceUserGreeting.sayHello":{"count":1,"max":0.055584811000000005,"mean":0.055584811000000005,"min":0.055584811000000005,"p50":0.055584811000000005,"p75":0.055584811000000005,"p95":0.055584811000000005,"p98":0.055584811000000005,"p99":0.055584811000000005,"p999":0.055584811000000005,"stddev":0.0,"m15_rate":0.0054124402384289035,"m1_rate":0.0010308274215719729,"m5_rate":0.002661751536257776,"mean_rate":0.00800735941234447,"duration_units":"seconds","rate_units":"calls/second"},"io.dropwizard.jetty.MutableServletContextHandler.connect-requests":{"count":0,"max":0.0,"mean":0.0,"min":0.0,"p50":0.0,"p75":0.0,"p95":0.0,"p98":0.0,"p99":0.0,"p999":0.0,"stddev":0.0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"duration_units":"seconds","rate_units":"calls/second"},"io.dropwizard.jetty.MutableServletContextHandler.delete-requests":{"count":0,"max":0.0,"mean":0.0,"min":0.0,"p50":0.0,"p75":0.0,"p95":0.0,"p98":0.0,"p99":0.0,"p999":0.0,"stddev":0.0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"duration_units":"seconds","rate_units":"calls/second"},"io.dropwizard.jetty.MutableServletContextHandler.dispatches":{"count":2,"max":0.2,"mean":0.101,"min":0.002,"p50":0.101,"p75":0.2,"p95":0.2,"p98":0.2,"p99":0.2,"p999":0.2,"stddev":0.1400071426749364,"m15_rate":0.010824880476857807,"m1_rate":0.0020616548431439457,"m5_rate":0.005323503072515552,"mean_rate":0.01601741691860399,"duration_units":"seconds","rate_units":"calls/second"},"io.dropwizard.jetty.MutableServletContextHandler.get-requests":{"count":2,"max":0.2,"mean":0.1015,"min":0.003,"p50":0.1015,"p75":0.2,"p95":0.2,"p98":0.2,"p99":0.2,"p999":0.2,"stddev":0.13930003589374987,"m15_rate":0.010824880476857807,"m1_rate":0.0020616548431439457,"m5_rate":0.005323503072515552,"mean_rate":0.01601746294132933,"duration_units":"seconds","rate_units":"calls/second"},"io.dropwizard.jetty.MutableServletContextHandler.head-requests":{"count":0,"max":0.0,"mean":0.0,"min":0.0,"p50":0.0,"p75":0.0,"p95":0.0,"p98":0.0,"p99":0.0,"p999":0.0,"stddev":0.0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"duration_units":"seconds","rate_units":"calls/second"},"io.dropwizard.jetty.MutableServletContextHandler.move-requests":{"count":0,"max":0.0,"mean":0.0,"min":0.0,"p50":0.0,"p75":0.0,"p95":0.0,"p98":0.0,"p99":0.0,"p999":0.0,"stddev":0.0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"duration_units":"seconds","rate_units":"calls/second"},"io.dropwizard.jetty.MutableServletContextHandler.options-requests":{"count":0,"max":0.0,"mean":0.0,"min":0.0,"p50":0.0,"p75":0.0,"p95":0.0,"p98":0.0,"p99":0.0,"p999":0.0,"stddev":0.0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"duration_units":"seconds","rate_units":"calls/second"},"io.dropwizard.jetty.MutableServletContextHandler.other-requests":{"count":0,"max":0.0,"mean":0.0,"min":0.0,"p50":0.0,"p75":0.0,"p95":0.0,"p98":0.0,"p99":0.0,"p999":0.0,"stddev":0.0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"duration_units":"seconds","rate_units":"calls/second"},"io.dropwizard.jetty.MutableServletContextHandler.post-requests":{"count":0,"max":0.0,"mean":0.0,"min":0.0,"p50":0.0,"p75":0.0,"p95":0.0,"p98":0.0,"p99":0.0,"p999":0.0,"stddev":0.0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"duration_units":"seconds","rate_units":"calls/second"},"io.dropwizard.jetty.MutableServletContextHandler.put-requests":{"count":0,"max":0.0,"mean":0.0,"min":0.0,"p50":0.0,"p75":0.0,"p95":0.0,"p98":0.0,"p99":0.0,"p999":0.0,"stddev":0.0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"duration_units":"seconds","rate_units":"calls/second"},"io.dropwizard.jetty.MutableServletContextHandler.requests":{"count":4,"max":0.2,"mean":0.10125,"min":0.002,"p50":0.1015,"p75":0.2,"p95":0.2,"p98":0.2,"p99":0.2,"p999":0.2,"stddev":0.11402740898573466,"m15_rate":0.021649760953715614,"m1_rate":0.0041233096862878914,"m5_rate":0.010647006145031104,"mean_rate":0.03203386311047837,"duration_units":"seconds","rate_units":"calls/second"},"io.dropwizard.jetty.MutableServletContextHandler.trace-requests":{"count":0,"max":0.0,"mean":0.0,"min":0.0,"p50":0.0,"p75":0.0,"p95":0.0,"p98":0.0,"p99":0.0,"p999":0.0,"stddev":0.0,"m15_rate":0.0,"m1_rate":0.0,"m5_rate":0.0,"mean_rate":0.0,"duration_units":"seconds","rate_units":"calls/second"},"org.eclipse.jetty.server.HttpConnectionFactory.8080.connections":{"count":2,"max":60.262335242000006,"mean":37.957795434000005,"min":15.653255626000002,"p50":37.957795434000005,"p75":60.262335242000006,"p95":60.262335242000006,"p98":60.262335242000006,"p99":60.262335242000006,"p999":60.262335242000006,"stddev":31.54338269896419,"m15_rate":0.019930230998522844,"m1_rate":0.0021381320217003993,"m5_rate":0.005949307102982542,"mean_rate":0.01581916699304227,"duration_units":"seconds","rate_units":"calls/second"},"org.eclipse.jetty.server.HttpConnectionFactory.8081.connections":{"count":1,"max":14.366038947000002,"mean":14.366038947000002,"min":14.366038947000002,"p50":14.366038947000002,"p75":14.366038947000002,"p95":14.366038947000002,"p98":14.366038947000002,"p99":14.366038947000002,"p999":14.366038947000002,"stddev":0.0,"m15_rate":0.012453894499523116,"m1_rate":0.0010897162674033895,"m5_rate":0.003144487893819254,"mean_rate":0.007910784257890786,"duration_units":"seconds","rate_units":"calls/second"}}}


C:\Users\admin>curl http://localhost:8080/datetime?year=100
{"id":1,"content":"100"}
C:\Users\admin>curl http://localhost:8080/datetime
{"id":2,"content":"2014"}
C:\Users\admin>curl http://localhost:8080/datetime?ss=2
{"id":3,"content":"2014"}
C:\Users\admin>curl http://localhost:8080/datetime?year=-1
{"id":4,"content":"-1"}

Continue mit
http://dropwizard.readthedocs.org/en/latest/manual/core.html