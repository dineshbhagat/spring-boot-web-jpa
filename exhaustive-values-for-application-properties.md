# Spring Boot Application Properties Reference

> **Source:** <https://docs.spring.io/spring-boot/appendix/application-properties/index.html>
> **Total properties:** 1840  
> **Spring Boot version:** 4.0.5

---

## Actuator Properties (397 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `management.appoptics.metrics.export.api-token` | AppOptics API token. |  |
| `management.appoptics.metrics.export.batch-size` | Number of measurements per request to use for this backend. If more measurements are found, then multiple requests will be made. | `500` |
| `management.appoptics.metrics.export.connect-timeout` | Connection timeout for requests to this backend. | `5s` |
| `management.appoptics.metrics.export.enabled` | Whether exporting of metrics to this backend is enabled. | `true` |
| `management.appoptics.metrics.export.floor-times` | Whether to ship a floored time, useful when sending measurements from multiple hosts to align them on a given time boundary. | `false` |
| `management.appoptics.metrics.export.host-tag` | Tag that will be mapped to "@host" when shipping metrics to AppOptics. | `instance` |
| `management.appoptics.metrics.export.read-timeout` | Read timeout for requests to this backend. | `10s` |
| `management.appoptics.metrics.export.step` | Step size (i.e. reporting frequency) to use. | `1m` |
| `management.appoptics.metrics.export.uri` | URI to ship metrics to. | `https://api.appoptics.com/v1/measurements` |
| `management.atlas.metrics.export.batch-size` | Number of measurements per request to use for this backend. If more measurements are found, then multiple requests will be made. | `10000` |
| `management.atlas.metrics.export.config-refresh-frequency` | Frequency for refreshing config settings from the LWC service. | `10s` |
| `management.atlas.metrics.export.config-time-to-live` | Time to live for subscriptions from the LWC service. | `150s` |
| `management.atlas.metrics.export.config-uri` | URI for the Atlas LWC endpoint to retrieve current subscriptions. | `http://localhost:7101/lwc/api/v1/expressions/local-dev` |
| `management.atlas.metrics.export.connect-timeout` | Connection timeout for requests to this backend. | `1s` |
| `management.atlas.metrics.export.enabled` | Whether exporting of metrics to this backend is enabled. | `true` |
| `management.atlas.metrics.export.eval-uri` | URI for the Atlas LWC endpoint to evaluate the data for a subscription. | `http://localhost:7101/lwc/api/v1/evaluate` |
| `management.atlas.metrics.export.lwc-enabled` | Whether to enable streaming to Atlas LWC. | `false` |
| `management.atlas.metrics.export.lwc-ignore-publish-step` | Whether expressions with the same step size as Atlas publishing should be ignored for streaming. Used for cases where data being published to Atlas is also sent into streaming from the backend. | `true` |
| `management.atlas.metrics.export.lwc-step` | Step size (reporting frequency) to use for streaming to Atlas LWC. This is the highest supported resolution for getting an on-demand stream of the data. It must be less than or equal to management.metrics.export.atlas.step and management.metrics.export.atlas.step should be an even multiple of this value. | `5s` |
| `management.atlas.metrics.export.meter-time-to-live` | Time to live for meters that do not have any activity. After this period the meter will be considered expired and will not get reported. | `15m` |
| `management.atlas.metrics.export.num-threads` | Number of threads to use with the metrics publishing scheduler. | `4` |
| `management.atlas.metrics.export.read-timeout` | Read timeout for requests to this backend. | `10s` |
| `management.atlas.metrics.export.step` | Step size (i.e. reporting frequency) to use. | `1m` |
| `management.atlas.metrics.export.uri` | URI of the Atlas server. | `http://localhost:7101/api/v1/publish` |
| `management.auditevents.enabled` | Whether to enable storage of audit events. | `true` |
| `management.brave.tracing.span-joining-supported` | Whether the propagation type and tracing backend support sharing the span ID between client and server spans. Requires B3 propagation and a compatible backend. | `false` |
| `management.cloudfoundry.enabled` | Whether to enable extended Cloud Foundry actuator endpoints. | `true` |
| `management.cloudfoundry.skip-ssl-validation` | Whether to skip SSL verification for Cloud Foundry actuator endpoint security calls. | `false` |
| `management.datadog.metrics.export.api-key` | Datadog API key. |  |
| `management.datadog.metrics.export.application-key` | Datadog application key. Not strictly required, but improves the Datadog experience by sending meter descriptions, types, and base units to Datadog. |  |
| `management.datadog.metrics.export.batch-size` | Number of measurements per request to use for this backend. If more measurements are found, then multiple requests will be made. | `10000` |
| `management.datadog.metrics.export.connect-timeout` | Connection timeout for requests to this backend. | `1s` |
| `management.datadog.metrics.export.descriptions` | Whether to publish descriptions metadata to Datadog. Turn this off to minimize the amount of metadata sent. | `true` |
| `management.datadog.metrics.export.enabled` | Whether exporting of metrics to this backend is enabled. | `true` |
| `management.datadog.metrics.export.host-tag` | Tag that will be mapped to "host" when shipping metrics to Datadog. | `instance` |
| `management.datadog.metrics.export.read-timeout` | Read timeout for requests to this backend. | `10s` |
| `management.datadog.metrics.export.step` | Step size (i.e. reporting frequency) to use. | `1m` |
| `management.datadog.metrics.export.uri` | URI to ship metrics to. Set this if you need to publish metrics to a Datadog site other than US, or to an internal proxy en-route to Datadog. | `https://api.datadoghq.com` |
| `management.defaults.metrics.export.enabled` | Whether to enable default metrics exporters. | `true` |
| `management.dynatrace.metrics.export.api-token` | Dynatrace authentication token. |  |
| `management.dynatrace.metrics.export.batch-size` | Number of measurements per request to use for this backend. If more measurements are found, then multiple requests will be made. | `10000` |
| `management.dynatrace.metrics.export.connect-timeout` | Connection timeout for requests to this backend. | `1s` |
| `management.dynatrace.metrics.export.enabled` | Whether exporting of metrics to this backend is enabled. | `true` |
| `management.dynatrace.metrics.export.read-timeout` | Read timeout for requests to this backend. | `10s` |
| `management.dynatrace.metrics.export.step` | Step size (i.e. reporting frequency) to use. | `1m` |
| `management.dynatrace.metrics.export.uri` | URI to ship metrics to. Should be used for SaaS, self-managed instances or to en-route through an internal proxy. |  |
| `management.dynatrace.metrics.export.v1.device-id` | ID of the custom device that is exporting metrics to Dynatrace. |  |
| `management.dynatrace.metrics.export.v1.group` | Group for exported metrics. Used to specify custom device group name in the Dynatrace UI. |  |
| `management.dynatrace.metrics.export.v1.technology-type` | Technology type for exported metrics. Used to group metrics under a logical technology name in the Dynatrace UI. | `java` |
| `management.dynatrace.metrics.export.v2.default-dimensions.*` | Default dimensions that are added to all metrics in the form of key-value pairs. These are overwritten by Micrometer tags if they use the same key. |  |
| `management.dynatrace.metrics.export.v2.enrich-with-dynatrace-metadata` | Whether to enable Dynatrace metadata export. | `true` |
| `management.dynatrace.metrics.export.v2.export-meter-metadata` | Whether to export meter metadata (unit and description) to the Dynatrace backend. | `true` |
| `management.dynatrace.metrics.export.v2.metric-key-prefix` | Prefix string that is added to all exported metrics. |  |
| `management.dynatrace.metrics.export.v2.use-dynatrace-summary-instruments` | Whether to fall back to the built-in micrometer instruments for Timer and DistributionSummary. | `true` |
| `management.elastic.metrics.export.api-key-credentials` | Base64-encoded credentials string. Mutually exclusive with user-name and password. |  |
| `management.elastic.metrics.export.auto-create-index` | Whether to create the index automatically if it does not exist. | `true` |
| `management.elastic.metrics.export.batch-size` | Number of measurements per request to use for this backend. If more measurements are found, then multiple requests will be made. | `10000` |
| `management.elastic.metrics.export.connect-timeout` | Connection timeout for requests to this backend. | `1s` |
| `management.elastic.metrics.export.enable-source` | Whether to enable _source in the default index template when auto-creating the index. | `false` |
| `management.elastic.metrics.export.enabled` | Whether exporting of metrics to this backend is enabled. | `true` |
| `management.elastic.metrics.export.host` | Host to export metrics to. | `http://localhost:9200` |
| `management.elastic.metrics.export.index` | Index to export metrics to. | `micrometer-metrics` |
| `management.elastic.metrics.export.index-date-format` | Index date format used for rolling indices. Appended to the index name. | `yyyy-MM` |
| `management.elastic.metrics.export.index-date-separator` | Prefix to separate the index name from the date format used for rolling indices. | `-` |
| `management.elastic.metrics.export.password` | Login password of the Elastic server. Mutually exclusive with api-key-credentials. |  |
| `management.elastic.metrics.export.pipeline` | Ingest pipeline name. By default, events are not pre-processed. |  |
| `management.elastic.metrics.export.read-timeout` | Read timeout for requests to this backend. | `10s` |
| `management.elastic.metrics.export.step` | Step size (i.e. reporting frequency) to use. | `1m` |
| `management.elastic.metrics.export.timestamp-field-name` | Name of the timestamp field. | `@timestamp` |
| `management.elastic.metrics.export.user-name` | Login user of the Elastic server. Mutually exclusive with api-key-credentials. |  |
| `management.endpoint.auditevents.access` | Permitted level of access for the auditevents endpoint. | `unrestricted` |
| `management.endpoint.auditevents.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.beans.access` | Permitted level of access for the beans endpoint. | `unrestricted` |
| `management.endpoint.beans.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.caches.access` | Permitted level of access for the caches endpoint. | `unrestricted` |
| `management.endpoint.caches.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.conditions.access` | Permitted level of access for the conditions endpoint. | `unrestricted` |
| `management.endpoint.conditions.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.configprops.access` | Permitted level of access for the configprops endpoint. | `unrestricted` |
| `management.endpoint.configprops.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.configprops.roles` | Roles used to determine whether a user is authorized to be shown unsanitized values. When empty, all authenticated users are authorized. |  |
| `management.endpoint.configprops.show-values` | When to show unsanitized values. | `never` |
| `management.endpoint.env.access` | Permitted level of access for the env endpoint. | `unrestricted` |
| `management.endpoint.env.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.env.roles` | Roles used to determine whether a user is authorized to be shown unsanitized values. When empty, all authenticated users are authorized. |  |
| `management.endpoint.env.show-values` | When to show unsanitized values. | `never` |
| `management.endpoint.flyway.access` | Permitted level of access for the flyway endpoint. | `unrestricted` |
| `management.endpoint.flyway.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.health.access` | Permitted level of access for the health endpoint. | `unrestricted` |
| `management.endpoint.health.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.health.group.*` | Health endpoint groups. |  |
| `management.endpoint.health.logging.slow-indicator-threshold` | Threshold after which a warning will be logged for slow health indicators. | `10s` |
| `management.endpoint.health.probes.add-additional-paths` | Whether to make the liveness and readiness health groups available on the main server port. | `false` |
| `management.endpoint.health.probes.enabled` | Whether to enable liveness and readiness probes. | `true` |
| `management.endpoint.health.roles` | Roles used to determine whether a user is authorized to be shown details. When empty, all authenticated users are authorized. |  |
| `management.endpoint.health.show-components` | When to show components. If not specified the 'show-details' setting will be used. |  |
| `management.endpoint.health.show-details` | When to show full health details. | `never` |
| `management.endpoint.health.status.http-mapping.*` | Mapping of health statuses to HTTP status codes. By default, registered health statuses map to sensible defaults (for example, UP maps to 200). |  |
| `management.endpoint.health.status.order` | List of health statuses in order of severity. | `[DOWN, OUT_OF_SERVICE, UP, UNKNOWN]` |
| `management.endpoint.health.validate-group-membership` | Whether to validate health group membership on startup. Validation fails if a group includes or excludes a health contributor that does not exist. | `true` |
| `management.endpoint.heapdump.access` | Permitted level of access for the heapdump endpoint. | `none` |
| `management.endpoint.heapdump.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.httpexchanges.access` | Permitted level of access for the httpexchanges endpoint. | `unrestricted` |
| `management.endpoint.httpexchanges.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.info.access` | Permitted level of access for the info endpoint. | `unrestricted` |
| `management.endpoint.info.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.integrationgraph.access` | Permitted level of access for the integrationgraph endpoint. | `unrestricted` |
| `management.endpoint.integrationgraph.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.liquibase.access` | Permitted level of access for the liquibase endpoint. | `unrestricted` |
| `management.endpoint.liquibase.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.logfile.access` | Permitted level of access for the logfile endpoint. | `unrestricted` |
| `management.endpoint.logfile.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.logfile.external-file` | External Logfile to be accessed. Can be used if the logfile is written by output redirect and not by the logging system itself. |  |
| `management.endpoint.loggers.access` | Permitted level of access for the loggers endpoint. | `unrestricted` |
| `management.endpoint.loggers.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.mappings.access` | Permitted level of access for the mappings endpoint. | `unrestricted` |
| `management.endpoint.mappings.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.metrics.access` | Permitted level of access for the metrics endpoint. | `unrestricted` |
| `management.endpoint.metrics.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.prometheus.access` | Permitted level of access for the prometheus endpoint. | `unrestricted` |
| `management.endpoint.quartz.access` | Permitted level of access for the quartz endpoint. | `unrestricted` |
| `management.endpoint.quartz.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.quartz.roles` | Roles used to determine whether a user is authorized to be shown unsanitized job or trigger values. When empty, all authenticated users are authorized. |  |
| `management.endpoint.quartz.show-values` | When to show unsanitized job or trigger values. | `never` |
| `management.endpoint.sbom.access` | Permitted level of access for the sbom endpoint. | `unrestricted` |
| `management.endpoint.sbom.additional.*` | Additional SBOMs. |  |
| `management.endpoint.sbom.application.location` | Location to the SBOM. If null, the location will be auto-detected. |  |
| `management.endpoint.sbom.application.media-type` | Media type of the SBOM. If null, the media type will be auto-detected. |  |
| `management.endpoint.sbom.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.scheduledtasks.access` | Permitted level of access for the scheduledtasks endpoint. | `unrestricted` |
| `management.endpoint.scheduledtasks.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.sessions.access` | Permitted level of access for the sessions endpoint. | `unrestricted` |
| `management.endpoint.shutdown.access` | Permitted level of access for the shutdown endpoint. | `none` |
| `management.endpoint.startup.access` | Permitted level of access for the startup endpoint. | `unrestricted` |
| `management.endpoint.startup.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoint.threaddump.access` | Permitted level of access for the threaddump endpoint. | `unrestricted` |
| `management.endpoint.threaddump.cache.time-to-live` | Maximum time that a response can be cached. | `0ms` |
| `management.endpoints.access.default` | Default access level for all endpoints. |  |
| `management.endpoints.access.max-permitted` | Maximum level of endpoint access that is permitted. Caps an endpoint's individual access level (management.endpoint.<id>.access) and the default access (management.endpoints.access.default).' | `unrestricted` |
| `management.endpoints.jackson.isolated-json-mapper` | Whether to use an isolated JsonMapper to serialize endpoint JSON. | `true` |
| `management.endpoints.jmx.domain` | Endpoints JMX domain name. Fallback to 'spring.jmx.default-domain' if set. | `org.springframework.boot` |
| `management.endpoints.jmx.exposure.exclude` | Endpoint IDs that should be excluded or '*' for all. |  |
| `management.endpoints.jmx.exposure.include` | Endpoint IDs that should be included or '*' for all. | `health` |
| `management.endpoints.jmx.static-names` | Additional static properties to append to all ObjectNames of MBeans representing Endpoints. |  |
| `management.endpoints.migrate-legacy-ids` | Whether to transparently migrate legacy endpoint IDs. | `false` |
| `management.endpoints.web.base-path` | Base path for Web endpoints. Relative to the servlet context path (server.servlet.context-path) or WebFlux base path (spring.webflux.base-path) when the management server is sharing the main server port. Relative to the management server base path (management.server.base-path) when a separate management server port (management.server.port) is configured. | `/actuator` |
| `management.endpoints.web.cors.allow-credentials` | Whether credentials are supported. When not set, credentials are not supported. |  |
| `management.endpoints.web.cors.allowed-headers` | List of headers to allow in a request. '*' allows all headers. |  |
| `management.endpoints.web.cors.allowed-methods` | List of methods to allow. '*' allows all methods. When not set, defaults to GET. |  |
| `management.endpoints.web.cors.allowed-origin-patterns` | List of origin patterns to allow. Unlike allowed origins which only supports '*', origin patterns are more flexible (for example 'https://*.example.com') and can be used when credentials are allowed. When no allowed origin patterns or allowed origins are set, CORS support is disabled. |  |
| `management.endpoints.web.cors.allowed-origins` | List of origins to allow. '*' allows all origins. When credentials are allowed, '*' cannot be used and origin patterns should be configured instead. When no allowed origins or allowed origin patterns are set, CORS support is disabled. |  |
| `management.endpoints.web.cors.exposed-headers` | List of headers to include in a response. |  |
| `management.endpoints.web.cors.max-age` | How long the response from a pre-flight request can be cached by clients. If a duration suffix is not specified, seconds will be used. | `1800s` |
| `management.endpoints.web.discovery.enabled` | Whether the discovery page is enabled. | `true` |
| `management.endpoints.web.exposure.exclude` | Endpoint IDs that should be excluded or '*' for all. |  |
| `management.endpoints.web.exposure.include` | Endpoint IDs that should be included or '*' for all. | `[health]` |
| `management.endpoints.web.path-mapping.*` | Mapping between endpoint IDs and the path that should expose them. |  |
| `management.ganglia.metrics.export.addressing-mode` | UDP addressing mode, either unicast or multicast. | `multicast` |
| `management.ganglia.metrics.export.duration-units` | Base time unit used to report durations. | `milliseconds` |
| `management.ganglia.metrics.export.enabled` | Whether exporting of metrics to Ganglia is enabled. | `true` |
| `management.ganglia.metrics.export.host` | Host of the Ganglia server to receive exported metrics. | `localhost` |
| `management.ganglia.metrics.export.port` | Port of the Ganglia server to receive exported metrics. | `8649` |
| `management.ganglia.metrics.export.step` | Step size (i.e. reporting frequency) to use. | `1m` |
| `management.ganglia.metrics.export.time-to-live` | Time to live for metrics on Ganglia. Set the multicast Time-To-Live to be one greater than the number of hops (routers) between the hosts. | `1` |
| `management.graphite.metrics.export.duration-units` | Base time unit used to report durations. | `milliseconds` |
| `management.graphite.metrics.export.enabled` | Whether exporting of metrics to Graphite is enabled. | `true` |
| `management.graphite.metrics.export.graphite-tags-enabled` | Whether Graphite tags should be used, as opposed to a hierarchical naming convention. Enabled by default unless "tagsAsPrefix" is set. |  |
| `management.graphite.metrics.export.host` | Host of the Graphite server to receive exported metrics. | `localhost` |
| `management.graphite.metrics.export.port` | Port of the Graphite server to receive exported metrics. | `2004` |
| `management.graphite.metrics.export.protocol` | Protocol to use while shipping data to Graphite. | `pickled` |
| `management.graphite.metrics.export.rate-units` | Base time unit used to report rates. | `seconds` |
| `management.graphite.metrics.export.step` | Step size (i.e. reporting frequency) to use. | `1m` |
| `management.graphite.metrics.export.tags-as-prefix` | For the hierarchical naming convention, turn the specified tag keys into part of the metric prefix. Ignored if "graphiteTagsEnabled" is true. | `[]` |
| `management.health.cassandra.enabled` | Whether to enable Cassandra health check. | `true` |
| `management.health.couchbase.enabled` | Whether to enable Couchbase health check. | `true` |
| `management.health.db.enabled` | Whether to enable database health check. | `true` |
| `management.health.db.ignore-routing-data-sources` | Whether to ignore AbstractRoutingDataSources when creating database health indicators. | `false` |
| `management.health.defaults.enabled` | Whether to enable default health indicators. | `true` |
| `management.health.diskspace.enabled` | Whether to enable disk space health check. | `true` |
| `management.health.diskspace.path` | Path used to compute the available disk space. |  |
| `management.health.diskspace.threshold` | Minimum disk space that should be available. | `10MB` |
| `management.health.elasticsearch.enabled` | Whether to enable Elasticsearch health check. | `true` |
| `management.health.jms.enabled` | Whether to enable JMS health check. | `true` |
| `management.health.ldap.enabled` | Whether to enable LDAP health check. | `true` |
| `management.health.livenessstate.enabled` | Whether to enable liveness state health check. | `false` |
| `management.health.mail.enabled` | Whether to enable Mail health check. | `true` |
| `management.health.mongodb.enabled` | Whether to enable MongoDB health check. | `true` |
| `management.health.neo4j.enabled` | Whether to enable Neo4j health check. | `true` |
| `management.health.ping.enabled` | Whether to enable ping health check. | `true` |
| `management.health.rabbit.enabled` | Whether to enable RabbitMQ health check. | `true` |
| `management.health.readinessstate.enabled` | Whether to enable readiness state health check. | `false` |
| `management.health.redis.enabled` | Whether to enable Redis health check. | `true` |
| `management.health.ssl.certificate-validity-warning-threshold` | If an SSL Certificate will be invalid within the time span defined by this threshold, it should trigger a warning. | `14d` |
| `management.health.ssl.enabled` | Whether to enable SSL certificate health check. | `true` |
| `management.httpexchanges.recording.enabled` | Whether to enable HTTP request-response exchange recording. | `true` |
| `management.httpexchanges.recording.include` | Items to be included in the exchange recording. Defaults to request headers (excluding Authorization and Cookie), response headers (excluding Set-Cookie), and time taken. | `[request-headers, response-headers, errors]` |
| `management.humio.metrics.export.api-token` | Humio API token. |  |
| `management.humio.metrics.export.batch-size` | Number of measurements per request to use for this backend. If more measurements are found, then multiple requests will be made. | `10000` |
| `management.humio.metrics.export.connect-timeout` | Connection timeout for requests to this backend. | `5s` |
| `management.humio.metrics.export.enabled` | Whether exporting of metrics to this backend is enabled. | `true` |
| `management.humio.metrics.export.read-timeout` | Read timeout for requests to this backend. | `10s` |
| `management.humio.metrics.export.step` | Step size (i.e. reporting frequency) to use. | `1m` |
| `management.humio.metrics.export.tags.*` | Humio tags describing the data source in which metrics will be stored. Humio tags are a distinct concept from Micrometer's tags. Micrometer's tags are used to divide metrics along dimensional boundaries. |  |
| `management.humio.metrics.export.uri` | URI to ship metrics to. If you need to publish metrics to an internal proxy en-route to Humio, you can define the location of the proxy with this. | `https://cloud.humio.com` |
| `management.influx.metrics.export.api-version` | API version of InfluxDB to use. Defaults to 'v1' unless an org is configured. If an org is configured, defaults to 'v2'. |  |
| `management.influx.metrics.export.auto-create-db` | Whether to create the Influx database if it does not exist before attempting to publish metrics to it. InfluxDB v1 only. | `true` |
| `management.influx.metrics.export.batch-size` | Number of measurements per request to use for this backend. If more measurements are found, then multiple requests will be made. | `10000` |
| `management.influx.metrics.export.bucket` | Bucket for metrics. Use either the bucket name or ID. Defaults to the value of the db property if not set. InfluxDB v2 only. |  |
| `management.influx.metrics.export.compressed` | Whether to enable GZIP compression of metrics batches published to Influx. | `true` |
| `management.influx.metrics.export.connect-timeout` | Connection timeout for requests to this backend. | `1s` |
| `management.influx.metrics.export.consistency` | Write consistency for each point. | `one` |
| `management.influx.metrics.export.db` | Database to send metrics to. InfluxDB v1 only. | `mydb` |
| `management.influx.metrics.export.enabled` | Whether exporting of metrics to this backend is enabled. | `true` |
| `management.influx.metrics.export.org` | Org to write metrics to. InfluxDB v2 only. |  |
| `management.influx.metrics.export.password` | Login password of the Influx server. InfluxDB v1 only. |  |
| `management.influx.metrics.export.read-timeout` | Read timeout for requests to this backend. | `10s` |
| `management.influx.metrics.export.retention-duration` | Time period for which Influx should retain data in the current database. For instance 7d, check the influx documentation for more details on the duration format. InfluxDB v1 only. |  |
| `management.influx.metrics.export.retention-policy` | Retention policy to use (Influx writes to the DEFAULT retention policy if one is not specified). InfluxDB v1 only. |  |
| `management.influx.metrics.export.retention-replication-factor` | How many copies of the data are stored in the cluster. Must be 1 for a single node instance. InfluxDB v1 only. |  |
| `management.influx.metrics.export.retention-shard-duration` | Time range covered by a shard group. For instance 2w, check the influx documentation for more details on the duration format. InfluxDB v1 only. |  |
| `management.influx.metrics.export.step` | Step size (i.e. reporting frequency) to use. | `1m` |
| `management.influx.metrics.export.token` | Authentication token to use with calls to the InfluxDB backend. For InfluxDB v1, the Bearer scheme is used. For v2, the Token scheme is used. |  |
| `management.influx.metrics.export.uri` | URI of the Influx server. | `http://localhost:8086` |
| `management.influx.metrics.export.user-name` | Login user of the Influx server. InfluxDB v1 only. |  |
| `management.info.build.enabled` | Whether to enable build info. | `true` |
| `management.info.defaults.enabled` | Whether to enable default info contributors. | `true` |
| `management.info.env.enabled` | Whether to enable environment info. | `false` |
| `management.info.git.enabled` | Whether to enable git info. | `true` |
| `management.info.git.mode` | Mode to use to expose git information. | `simple` |
| `management.info.java.enabled` | Whether to enable Java info. | `false` |
| `management.info.os.enabled` | Whether to enable Operating System info. | `false` |
| `management.info.process.enabled` | Whether to enable process info. | `false` |
| `management.info.ssl.enabled` | Whether to enable SSL certificate info. | `false` |
| `management.jmx.metrics.export.domain` | Metrics JMX domain name. | `metrics` |
| `management.jmx.metrics.export.enabled` | Whether exporting of metrics to this backend is enabled. | `true` |
| `management.jmx.metrics.export.step` | Step size (i.e. reporting frequency) to use. | `1m` |
| `management.kairos.metrics.export.batch-size` | Number of measurements per request to use for this backend. If more measurements are found, then multiple requests will be made. | `10000` |
| `management.kairos.metrics.export.connect-timeout` | Connection timeout for requests to this backend. | `1s` |
| `management.kairos.metrics.export.enabled` | Whether exporting of metrics to this backend is enabled. | `true` |
| `management.kairos.metrics.export.password` | Login password of the KairosDB server. |  |
| `management.kairos.metrics.export.read-timeout` | Read timeout for requests to this backend. | `10s` |
| `management.kairos.metrics.export.step` | Step size (i.e. reporting frequency) to use. | `1m` |
| `management.kairos.metrics.export.uri` | URI of the KairosDB server. | `http://localhost:8080/api/v1/datapoints` |
| `management.kairos.metrics.export.user-name` | Login user of the KairosDB server. |  |
| `management.logging.export.enabled` | Whether auto-configuration of logging is enabled to export logs. | `true` |
| `management.logging.export.otlp.enabled` | Whether auto-configuration of logging is enabled to export logs over OTLP. | `true` |
| `management.metrics.data.repository.autotime.enabled` | Whether to enable auto-timing. | `true` |
| `management.metrics.data.repository.autotime.percentiles` | Percentiles for which additional time series should be published. |  |
| `management.metrics.data.repository.autotime.percentiles-histogram` | Whether to publish percentile histograms. | `false` |
| `management.metrics.data.repository.metric-name` | Name of the metric for sent requests. | `spring.data.repository.invocations` |
| `management.metrics.distribution.buffer-length.*` | Number of histograms for meter IDs starting with the specified name to keep in the ring buffer. The longest match wins, the key `all` can also be used to configure all meters. |  |
| `management.metrics.distribution.expiry.*` | Maximum amount of time that samples for meter IDs starting with the specified name are accumulated to decaying distribution statistics before they are reset and rotated. The longest match wins, the key `all` can also be used to configure all meters. |  |
| `management.metrics.distribution.maximum-expected-value.*` | Maximum value that meter IDs starting with the specified name are expected to observe. The longest match wins. Values can be specified as a double or as a Duration value (for timer meters, defaulting to ms if no unit specified). |  |
| `management.metrics.distribution.minimum-expected-value.*` | Minimum value that meter IDs starting with the specified name are expected to observe. The longest match wins. Values can be specified as a double or as a Duration value (for timer meters, defaulting to ms if no unit specified). |  |
| `management.metrics.distribution.percentiles.*` | Specific computed non-aggregable percentiles to ship to the backend for meter IDs starting-with the specified name. The longest match wins, the key 'all' can also be used to configure all meters. |  |
| `management.metrics.distribution.percentiles-histogram.*` | Whether meter IDs starting with the specified name should publish percentile histograms. For monitoring systems that support aggregable percentile calculation based on a histogram, this can be set to true. For other systems, this has no effect. The longest match wins, the key 'all' can also be used to configure all meters. |  |
| `management.metrics.distribution.slo.*` | Specific service-level objective boundaries for meter IDs starting with the specified name. The longest match wins. Counters will be published for each specified boundary. Values can be specified as a double or as a Duration value (for timer meters, defaulting to ms if no unit specified). |  |
| `management.metrics.enable.*` | Whether meter IDs starting with the specified name should be enabled. The longest match wins, the key 'all' can also be used to configure all meters. |  |
| `management.metrics.mongodb.command.enabled` | Whether to enable Mongo client command metrics. | `true` |
| `management.metrics.mongodb.connectionpool.enabled` | Whether to enable Mongo connection pool metrics. | `true` |
| `management.metrics.observations.ignored-meters` | Meters that should be ignored when recoding observations. |  |
| `management.metrics.system.diskspace.paths` | List of paths to report disk metrics for. | `[.]` |
| `management.metrics.tags.*` | Common tags that are applied to every meter. |  |
| `management.metrics.use-global-registry` | Whether auto-configured MeterRegistry implementations should be bound to the global static registry on Metrics. For testing, set this to 'false' to maximize test independence. | `true` |
| `management.metrics.web.client.max-uri-tags` | Maximum number of unique URI tag values allowed. After the max number of tag values is reached, metrics with additional tag values are denied by filter. | `100` |
| `management.metrics.web.server.max-uri-tags` | Maximum number of unique URI tag values allowed. After the max number of tag values is reached, metrics with additional tag values are denied by filter. | `100` |
| `management.newrelic.metrics.export.account-id` | New Relic account ID. |  |
| `management.newrelic.metrics.export.api-key` | New Relic API key. |  |
| `management.newrelic.metrics.export.batch-size` | Number of measurements per request to use for this backend. If more measurements are found, then multiple requests will be made. | `10000` |
| `management.newrelic.metrics.export.client-provider-type` | Client provider type to use. | `insights-api` |
| `management.newrelic.metrics.export.connect-timeout` | Connection timeout for requests to this backend. | `1s` |
| `management.newrelic.metrics.export.enabled` | Whether exporting of metrics to this backend is enabled. | `true` |
| `management.newrelic.metrics.export.event-type` | The event type that should be published. This property will be ignored if 'meter-name-event-type-enabled' is set to 'true'. | `SpringBootSample` |
| `management.newrelic.metrics.export.meter-name-event-type-enabled` | Whether to send the meter name as the event type instead of using the 'event-type' configuration property value. Can be set to 'true' if New Relic guidelines are not being followed or event types consistent with previous Spring Boot releases are required. | `false` |
| `management.newrelic.metrics.export.read-timeout` | Read timeout for requests to this backend. | `10s` |
| `management.newrelic.metrics.export.step` | Step size (i.e. reporting frequency) to use. | `1m` |
| `management.newrelic.metrics.export.uri` | URI to ship metrics to. | `https://insights-collector.newrelic.com` |
| `management.observations.annotations.enabled` | Whether auto-configuration of Micrometer annotations is enabled. | `false` |
| `management.observations.enable.*` | Whether observations starting with the specified name should be enabled. The longest match wins, the key 'all' can also be used to configure all observations. |  |
| `management.observations.http.client.requests.name` | Name of the observation for client requests. | `http.client.requests` |
| `management.observations.http.server.requests.name` | Name of the observation for server requests. | `http.server.requests` |
| `management.observations.key-values.*` | Common key-values that are applied to every observation. |  |
| `management.observations.r2dbc.include-parameter-values` | Whether to tag actual query parameter values. | `false` |
| `management.opentelemetry.logging.export.otlp.compression` | Method used to compress the payload. | `none` |
| `management.opentelemetry.logging.export.otlp.connect-timeout` | Connect timeout for the OTel collector connection. | `10s` |
| `management.opentelemetry.logging.export.otlp.endpoint` | URL to the OTel collector's HTTP API. |  |
| `management.opentelemetry.logging.export.otlp.headers.*` | Custom HTTP headers you want to pass to the collector, for example auth headers. |  |
| `management.opentelemetry.logging.export.otlp.timeout` | Call timeout for the OTel Collector to process an exported batch of data. This timeout spans the entire call: resolving DNS, connecting, writing the request body, server processing, and reading the response body. If the call requires redirects or retries all must complete within one timeout period. | `10s` |
| `management.opentelemetry.logging.export.otlp.transport` | Transport used to send the logs. | `http` |
| `management.opentelemetry.resource-attributes.*` | Resource attributes. |  |
| `management.opentelemetry.tracing.export.include-unsampled` | Whether unsampled spans should be exported. | `false` |
| `management.opentelemetry.tracing.export.max-batch-size` | Maximum batch size for each export. This must be less than or equal to 'maxQueueSize'. | `512` |
| `management.opentelemetry.tracing.export.max-queue-size` | Maximum number of spans that are kept in the queue before they will be dropped. | `2048` |
| `management.opentelemetry.tracing.export.otlp.compression` | Method used to compress the payload. | `none` |
| `management.opentelemetry.tracing.export.otlp.connect-timeout` | Connect timeout for the OTel collector connection. | `10s` |
| `management.opentelemetry.tracing.export.otlp.endpoint` | URL to the OTel collector's HTTP API. |  |
| `management.opentelemetry.tracing.export.otlp.headers.*` | Custom HTTP headers you want to pass to the collector, for example auth headers. |  |
| `management.opentelemetry.tracing.export.otlp.timeout` | Call timeout for the OTel Collector to process an exported batch of data. This timeout spans the entire call: resolving DNS, connecting, writing the request body, server processing, and reading the response body. If the call requires redirects or retries all must complete within one timeout period. | `10s` |
| `management.opentelemetry.tracing.export.otlp.transport` | Transport used to send the spans. | `http` |
| `management.opentelemetry.tracing.export.schedule-delay` | The delay interval between two consecutive exports. | `5s` |
| `management.opentelemetry.tracing.export.timeout` | Maximum time an export will be allowed to run before being cancelled. | `30s` |
| `management.otlp.metrics.export.aggregation-temporality` | Aggregation temporality of sums. It defines the way additive values are expressed. This setting depends on the backend you use, some only support one temporality. | `cumulative` |
| `management.otlp.metrics.export.base-time-unit` | Time unit for exported metrics. | `milliseconds` |
| `management.otlp.metrics.export.batch-size` | Number of measurements per request to use for this backend. If more measurements are found, then multiple requests will be made. | `10000` |
| `management.otlp.metrics.export.connect-timeout` | Connection timeout for requests to this backend. | `1s` |
| `management.otlp.metrics.export.enabled` | Whether exporting of metrics to this backend is enabled. | `true` |
| `management.otlp.metrics.export.headers.*` | Headers for the exported metrics. |  |
| `management.otlp.metrics.export.histogram-flavor` | Default histogram type when histogram publishing is enabled. | `explicit-bucket-histogram` |
| `management.otlp.metrics.export.max-bucket-count` | Default maximum number of buckets to be used for exponential histograms, if configured. This has no effect on explicit bucket histograms. | `160` |
| `management.otlp.metrics.export.max-scale` | Max scale to use for exponential histograms, if configured. | `20` |
| `management.otlp.metrics.export.meter.*` | Per-meter properties that can be used to override defaults. |  |
| `management.otlp.metrics.export.read-timeout` | Read timeout for requests to this backend. | `10s` |
| `management.otlp.metrics.export.step` | Step size (i.e. reporting frequency) to use. | `1m` |
| `management.otlp.metrics.export.url` | URI of the OTLP server. |  |
| `management.prometheus.metrics.export.descriptions` | Whether to enable publishing descriptions as part of the scrape payload to Prometheus. Turn this off to minimize the amount of data sent on each scrape. | `true` |
| `management.prometheus.metrics.export.enabled` | Whether exporting of metrics to this backend is enabled. | `true` |
| `management.prometheus.metrics.export.properties.*` | Additional properties to pass to the Prometheus client. |  |
| `management.prometheus.metrics.export.pushgateway.address` | Address (host:port) for the Pushgateway. | `localhost:9091` |
| `management.prometheus.metrics.export.pushgateway.enabled` | Enable publishing over a Prometheus Pushgateway. | `false` |
| `management.prometheus.metrics.export.pushgateway.format` | Format to use when pushing metrics. | `protobuf` |
| `management.prometheus.metrics.export.pushgateway.grouping-key.*` | Grouping key for the pushed metrics. |  |
| `management.prometheus.metrics.export.pushgateway.job` | Job identifier for this application instance. |  |
| `management.prometheus.metrics.export.pushgateway.password` | Login password of the Prometheus Pushgateway. |  |
| `management.prometheus.metrics.export.pushgateway.push-rate` | Frequency with which to push metrics. | `1m` |
| `management.prometheus.metrics.export.pushgateway.scheme` | Scheme to use when pushing metrics. | `http` |
| `management.prometheus.metrics.export.pushgateway.shutdown-operation` | Operation that should be performed on shutdown. | `none` |
| `management.prometheus.metrics.export.pushgateway.token` | Token to use for authentication with the Prometheus Pushgateway. |  |
| `management.prometheus.metrics.export.pushgateway.username` | Login user of the Prometheus Pushgateway. |  |
| `management.prometheus.metrics.export.step` | Step size (i.e. reporting frequency) to use. | `1m` |
| `management.server.add-application-context-header` | Add the "X-Application-Context" HTTP header in each response. | `false` |
| `management.server.address` | Network address to which the management endpoints should bind. Requires a custom management.server.port. |  |
| `management.server.base-path` | Management endpoint base path (for instance, '/management'). Requires a custom management.server.port. |  |
| `management.server.jetty.accesslog.prefix` | Management log file name prefix. | `management_` |
| `management.server.port` | Management endpoint HTTP port (uses the same port as the application by default). Configure a different port to use management-specific SSL. |  |
| `management.server.ssl.bundle` | Name of a configured SSL bundle. |  |
| `management.server.ssl.certificate` | Path to a PEM-encoded SSL certificate file. |  |
| `management.server.ssl.certificate-private-key` | Path to a PEM-encoded private key file for the SSL certificate. |  |
| `management.server.ssl.ciphers` | Supported SSL ciphers. |  |
| `management.server.ssl.client-auth` | Client authentication mode. Requires a trust store. |  |
| `management.server.ssl.enabled` | Whether to enable SSL support. | `true` |
| `management.server.ssl.enabled-protocols` | Enabled SSL protocols. |  |
| `management.server.ssl.key-alias` | Alias that identifies the key in the key store. |  |
| `management.server.ssl.key-password` | Password used to access the key in the key store. |  |
| `management.server.ssl.key-store` | Path to the key store that holds the SSL certificate (typically a jks file). |  |
| `management.server.ssl.key-store-password` | Password used to access the key store. |  |
| `management.server.ssl.key-store-provider` | Provider for the key store. |  |
| `management.server.ssl.key-store-type` | Type of the key store. |  |
| `management.server.ssl.protocol` | SSL protocol to use. | `TLS` |
| `management.server.ssl.server-name-bundles` | Mapping of host names to SSL bundles for SNI configuration. |  |
| `management.server.ssl.trust-certificate` | Path to a PEM-encoded SSL certificate authority file. |  |
| `management.server.ssl.trust-certificate-private-key` | Path to a PEM-encoded private key file for the SSL certificate authority. |  |
| `management.server.ssl.trust-store` | Trust store that holds SSL certificates. |  |
| `management.server.ssl.trust-store-password` | Password used to access the trust store. |  |
| `management.server.ssl.trust-store-provider` | Provider for the trust store. |  |
| `management.server.ssl.trust-store-type` | Type of the trust store. |  |
| `management.server.tomcat.accesslog.prefix` | Management log file name prefix. | `management_` |
| `management.simple.metrics.export.enabled` | Whether exporting of metrics to this backend is enabled. | `true` |
| `management.simple.metrics.export.mode` | Counting mode. | `cumulative` |
| `management.simple.metrics.export.step` | Step size (i.e. reporting frequency) to use. | `1m` |
| `management.stackdriver.metrics.export.auto-create-metric-descriptors` | Whether it should be attempted to create a metric descriptor before writing a time series. | `true` |
| `management.stackdriver.metrics.export.batch-size` | Number of measurements per request to use for this backend. If more measurements are found, then multiple requests will be made. | `10000` |
| `management.stackdriver.metrics.export.connect-timeout` | Connection timeout for requests to this backend. | `1s` |
| `management.stackdriver.metrics.export.enabled` | Whether exporting of metrics to this backend is enabled. | `true` |
| `management.stackdriver.metrics.export.metric-type-prefix` | Prefix for metric type. Valid prefixes are described in the Google Cloud documentation (https://cloud.google.com/monitoring/custom-metrics#identifier). | `custom.googleapis.com/` |
| `management.stackdriver.metrics.export.project-id` | Identifier of the Google Cloud project to monitor. |  |
| `management.stackdriver.metrics.export.read-timeout` | Read timeout for requests to this backend. | `10s` |
| `management.stackdriver.metrics.export.resource-labels.*` | Monitored resource's labels. |  |
| `management.stackdriver.metrics.export.resource-type` | Monitored resource type. | `global` |
| `management.stackdriver.metrics.export.step` | Step size (i.e. reporting frequency) to use. | `1m` |
| `management.stackdriver.metrics.export.use-semantic-metric-types` | Whether to use semantically correct metric types. When false, counter metrics are published as the GAUGE MetricKind. When true, counter metrics are published as the CUMULATIVE MetricKind. | `false` |
| `management.statsd.metrics.export.buffered` | Whether measurements should be buffered before sending to the StatsD server. | `true` |
| `management.statsd.metrics.export.enabled` | Whether exporting of metrics to StatsD is enabled. | `true` |
| `management.statsd.metrics.export.flavor` | StatsD line protocol to use. | `datadog` |
| `management.statsd.metrics.export.host` | Host of the StatsD server to receive exported metrics. | `localhost` |
| `management.statsd.metrics.export.max-packet-length` | Total length of a single payload should be kept within your network's MTU. | `1400` |
| `management.statsd.metrics.export.polling-frequency` | How often gauges will be polled. When a gauge is polled, its value is recalculated and if the value has changed (or publishUnchangedMeters is true), it is sent to the StatsD server. | `10s` |
| `management.statsd.metrics.export.port` | Port of the StatsD server to receive exported metrics. | `8125` |
| `management.statsd.metrics.export.protocol` | Protocol of the StatsD server to receive exported metrics. | `udp` |
| `management.statsd.metrics.export.publish-unchanged-meters` | Whether to send unchanged meters to the StatsD server. | `true` |
| `management.statsd.metrics.export.step` | Step size to use in computing windowed statistics like max. To get the most out of these statistics, align the step interval to be close to your scrape interval. | `1m` |
| `management.tracing.baggage.correlation.enabled` | Whether to enable correlation of the baggage context with logging contexts. | `true` |
| `management.tracing.baggage.correlation.fields` | List of fields that should be correlated with the logging context. That means that these fields would end up as key-value pairs in e.g. MDC. |  |
| `management.tracing.baggage.enabled` | Whether to enable Micrometer Tracing baggage propagation. | `true` |
| `management.tracing.baggage.local-fields` | List of fields that should be accessible within the JVM process but not propagated over the wire. Local fields are not supported with OpenTelemetry. |  |
| `management.tracing.baggage.remote-fields` | List of fields that are referenced the same in-process as it is on the wire. For example, the field "x-vcap-request-id" would be set as-is including the prefix. |  |
| `management.tracing.baggage.tag-fields` | List of fields that should automatically become tags. |  |
| `management.tracing.export.enabled` | Whether auto-configuration of tracing is enabled to export and propagate traces. | `true` |
| `management.tracing.export.otlp.enabled` | Whether auto-configuration of tracing is enabled to export OTLP traces. | `true` |
| `management.tracing.export.zipkin.connect-timeout` | Connection timeout for requests to Zipkin. | `1s` |
| `management.tracing.export.zipkin.enabled` | Whether auto-configuration of tracing is enabled to export Zipkin traces. | `true` |
| `management.tracing.export.zipkin.encoding` | How to encode the POST body to the Zipkin API. | `json` |
| `management.tracing.export.zipkin.endpoint` | URL to the Zipkin API. | `http://localhost:9411/api/v2/spans` |
| `management.tracing.export.zipkin.read-timeout` | Read timeout for requests to Zipkin. | `10s` |
| `management.tracing.propagation.consume` | Tracing context propagation types consumed by the application. | `[W3C, B3, B3_MULTI]` |
| `management.tracing.propagation.produce` | Tracing context propagation types produced by the application. | `[W3C]` |
| `management.tracing.propagation.type` | Tracing context propagation types produced and consumed by the application. Setting this property overrides the more fine-grained propagation type properties. |  |
| `management.tracing.sampling.probability` | Probability in the range from 0.0 to 1.0 that a trace will be sampled. | `0.1` |

## Cache Properties (12 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `spring.cache.cache-names` | List of cache names to create if supported by the underlying cache manager. Usually, this disables the ability to create additional caches on-the-fly. |  |
| `spring.cache.caffeine.spec` | The spec to use to create caches. See CaffeineSpec for more details on the spec format. |  |
| `spring.cache.couchbase.expiration` | Entry expiration. By default the entries never expire. Note that this value is ultimately converted to seconds. |  |
| `spring.cache.infinispan.config` | The location of the configuration file to use to initialize Infinispan. |  |
| `spring.cache.jcache.config` | The location of the configuration file to use to initialize the cache manager. The configuration file is dependent of the underlying cache implementation. |  |
| `spring.cache.jcache.provider` | Fully qualified name of the CachingProvider implementation to use to retrieve the JSR-107 compliant cache manager. Needed only if more than one JSR-107 implementation is available on the classpath. |  |
| `spring.cache.redis.cache-null-values` | Allow caching null values. | `true` |
| `spring.cache.redis.enable-statistics` | Whether to enable cache statistics. | `false` |
| `spring.cache.redis.key-prefix` | Key prefix. |  |
| `spring.cache.redis.time-to-live` | Entry expiration. By default the entries never expire. |  |
| `spring.cache.redis.use-key-prefix` | Whether to use the key prefix when writing to Redis. | `true` |
| `spring.cache.type` | Cache type. By default, auto-detected according to the environment. |  |

## Core Properties (140 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `debug` | Enable debug logs. | `false` |
| `info.*` | Arbitrary properties to add to the info endpoint. |  |
| `logging.charset.console` | Charset to use for console output. |  |
| `logging.charset.file` | Charset to use for file output. |  |
| `logging.config` | Location of the logging configuration file. For instance, `classpath:logback.xml` for Logback. |  |
| `logging.console.enabled` | Whether to enable console-based logging. |  |
| `logging.exception-conversion-word` | Conversion word used when logging exceptions. | `%wEx` |
| `logging.file.name` | Log file name (for instance, `myapp.log`). Names can be an exact location or relative to the current directory. |  |
| `logging.file.path` | Location of the log file. For instance, `/var/log`. |  |
| `logging.group.*` | Log groups to quickly change multiple loggers at the same time. For instance, `logging.group.db=org.hibernate,org.springframework.jdbc`. |  |
| `logging.include-application-group` | Whether to include the application group in the logs. | `true` |
| `logging.include-application-name` | Whether to include the application name in the logs. | `true` |
| `logging.level.*` | Log levels severity mapping. For instance, `logging.level.org.springframework=DEBUG`. |  |
| `logging.log4j2.config.override` | Overriding configuration files used to create a composite configuration. Can be prefixed with 'optional:' to only load the override if it exists. |  |
| `logging.logback.rollingpolicy.clean-history-on-start` | Whether to clean the archive log files on startup. | `false` |
| `logging.logback.rollingpolicy.file-name-pattern` | Pattern for rolled-over log file names. | `${LOG_FILE}.%d{yyyy-MM-dd}.%i.gz` |
| `logging.logback.rollingpolicy.max-file-size` | Maximum log file size. | `10MB` |
| `logging.logback.rollingpolicy.max-history` | Maximum number of archive log files to keep. | `7` |
| `logging.logback.rollingpolicy.total-size-cap` | Total size of log backups to be kept. | `0B` |
| `logging.pattern.console` | Appender pattern for output to the console. Its default value varies according to the logging system. |  |
| `logging.pattern.correlation` | Appender pattern for log correlation. Its default value varies according to the logging system. |  |
| `logging.pattern.dateformat` | Appender pattern for log date format. | `yyyy-MM-dd'T'HH:mm:ss.SSSXXX` |
| `logging.pattern.file` | Appender pattern for output to a file. Its default value varies according to the logging system. |  |
| `logging.pattern.level` | Appender pattern for log level. | `%5p` |
| `logging.register-shutdown-hook` | Register a shutdown hook for the logging system when it is initialized. Disabled automatically when deployed as a war file. | `true` |
| `logging.structured.ecs.service.environment` | Structured ECS service environment. |  |
| `logging.structured.ecs.service.name` | Structured ECS service name (defaults to 'spring.application.name'). |  |
| `logging.structured.ecs.service.node-name` | Structured ECS service node name. |  |
| `logging.structured.ecs.service.version` | Structured ECS service version (defaults to 'spring.application.version'). |  |
| `logging.structured.format.console` | Structured logging format for output to the console. Must be either a format id or a fully qualified class name. |  |
| `logging.structured.format.file` | Structured logging format for output to a file. Must be either a format id or a fully qualified class name. |  |
| `logging.structured.gelf.host` | Structured GELF host (defaults to 'spring.application.name'). |  |
| `logging.structured.gelf.service.version` | Structured GELF service version (defaults to 'spring.application.version'). |  |
| `logging.structured.json.add.*` | Additional members that should be added to structured logging JSON |  |
| `logging.structured.json.context.include` | Whether context data should be included in the JSON. |  |
| `logging.structured.json.context.prefix` | The prefix to use when inserting context data. |  |
| `logging.structured.json.customizer` | Fully qualified class names of StructuredLoggingJsonMembersCustomizer implementations |  |
| `logging.structured.json.exclude` | Member paths that should be excluded from structured logging JSON |  |
| `logging.structured.json.include` | Member paths that should be included in structured logging JSON |  |
| `logging.structured.json.rename.*` | Mapping between member paths and an alternative name that should be used in structured logging JSON |  |
| `logging.structured.json.stacktrace.include-common-frames` | Whether common frames should be included. |  |
| `logging.structured.json.stacktrace.include-hashes` | Whether stack trace hashes should be included. |  |
| `logging.structured.json.stacktrace.max-length` | Maximum length to print. |  |
| `logging.structured.json.stacktrace.max-throwable-depth` | Maximum throwable depth to print. |  |
| `logging.structured.json.stacktrace.printer` | Name of the printer to use. Can be 'standard', 'logging-system', or the fully-qualified class name of a StackTracePrinter. When not specified 'logging-system' or 'standard' will be used depending if other properties are set. |  |
| `logging.structured.json.stacktrace.root` | Root ordering (root first or root last). |  |
| `logging.threshold.console` | Log level threshold for console output. | `TRACE` |
| `logging.threshold.file` | Log level threshold for file output. | `TRACE` |
| `spring.aop.auto` | Add @EnableAspectJAutoProxy. | `true` |
| `spring.aop.proxy-target-class` | Whether subclass-based (CGLIB) proxies are to be created (true), as opposed to standard Java interface-based proxies (false). | `true` |
| `spring.application.admin.enabled` | Whether to enable admin features for the application. | `false` |
| `spring.application.admin.jmx-name` | JMX name of the application admin MBean. | `org.springframework.boot:type=Admin,name=SpringApplication` |
| `spring.application.group` | Application group. Typically used with logging to help identify the application. |  |
| `spring.application.name` | Application name. Typically used with logging to help identify the application. |  |
| `spring.application.version` | Application version (defaults to 'Implementation-Version' from the manifest). |  |
| `spring.autoconfigure.exclude` | Auto-configuration classes to exclude. |  |
| `spring.banner.charset` | Banner file encoding. | `UTF-8` |
| `spring.banner.location` | Banner text resource location. | `classpath:banner.txt` |
| `spring.beaninfo.ignore` | Whether to skip search of BeanInfo classes. | `true` |
| `spring.config.activate.on-cloud-platform` | Required cloud platform for the document to be included. |  |
| `spring.config.activate.on-profile` | Profile expressions that should match for the document to be included. |  |
| `spring.config.additional-location` | Config file locations used in addition to the defaults. |  |
| `spring.config.import` | Import additional config data. |  |
| `spring.config.location` | Config file locations that replace the defaults. |  |
| `spring.config.name` | Config file name. | `application` |
| `spring.info.build.encoding` | File encoding. | `UTF-8` |
| `spring.info.build.location` | Location of the generated build-info.properties file. | `classpath:META-INF/build-info.properties` |
| `spring.info.git.encoding` | File encoding. | `UTF-8` |
| `spring.info.git.location` | Location of the generated git.properties file. | `classpath:git.properties` |
| `spring.jmx.default-domain` | JMX domain name. |  |
| `spring.jmx.enabled` | Expose Spring's management beans to the JMX domain. | `false` |
| `spring.jmx.registration-policy` | JMX Registration policy. | `fail-on-existing` |
| `spring.jmx.server` | MBeanServer bean name. | `mbeanServer` |
| `spring.jmx.unique-names` | Whether unique runtime object names should be ensured. | `false` |
| `spring.lifecycle.timeout-per-shutdown-phase` | Timeout for the shutdown of any phase (group of SmartLifecycle beans with the same 'phase' value). | `30s` |
| `spring.main.allow-bean-definition-overriding` | Whether bean definition overriding, by registering a definition with the same name as an existing definition, is allowed. | `false` |
| `spring.main.allow-circular-references` | Whether to allow circular references between beans and automatically try to resolve them. | `false` |
| `spring.main.banner-mode` | Mode used to display the banner when the application runs. Defaults to 'off' if structured logging is enabled or to 'console' otherwise |  |
| `spring.main.cloud-platform` | Override the Cloud Platform auto-detection. |  |
| `spring.main.keep-alive` | Whether to keep the application alive even if there are no more non-daemon threads. | `false` |
| `spring.main.lazy-initialization` | Whether initialization should be performed lazily. | `false` |
| `spring.main.log-startup-info` | Whether to log information about the application when it starts. | `true` |
| `spring.main.register-shutdown-hook` | Whether the application should have a shutdown hook registered. | `true` |
| `spring.main.sources` | Sources (class names, package names, or XML resource locations) to include in the ApplicationContext. |  |
| `spring.main.web-application-type` | Flag to explicitly request a specific type of web application. If not set, auto-detected based on the classpath. |  |
| `spring.mandatory-file-encoding` | Expected character encoding the application must use. |  |
| `spring.messages.always-use-message-format` | Whether to always apply the MessageFormat rules, parsing even messages without arguments. | `false` |
| `spring.messages.basename` | List of basenames (essentially a fully-qualified classpath location), each following the ResourceBundle convention with relaxed support for slash based locations. If it doesn't contain a package qualifier (such as "org.mypackage"), it will be resolved from the classpath root. | `[messages]` |
| `spring.messages.cache-duration` | Loaded resource bundle files cache duration. When not set, bundles are cached forever. If a duration suffix is not specified, seconds will be used. |  |
| `spring.messages.common-messages` | List of locale-independent property file resources containing common messages. |  |
| `spring.messages.encoding` | Message bundles encoding. | `UTF-8` |
| `spring.messages.fallback-to-system-locale` | Whether to fall back to the system Locale if no files for a specific Locale have been found. if this is turned off, the only fallback will be the default file (e.g. "messages.properties" for basename "messages"). | `true` |
| `spring.messages.use-code-as-default-message` | Whether to use the message code as the default message instead of throwing a "NoSuchMessageException". Recommended during development only. | `false` |
| `spring.output.ansi.enabled` | Configures the ANSI output. | `detect` |
| `spring.pid.fail-on-write-error` | Fails if ApplicationPidFileWriter is used but it cannot write the PID file. |  |
| `spring.pid.file` | Location of the PID file to write (if ApplicationPidFileWriter is used). |  |
| `spring.profiles.active` | Comma-separated list of active profiles. Can be overridden by a command line switch. |  |
| `spring.profiles.default` | Name of the profile to enable if no profile is active. | `default` |
| `spring.profiles.group.*` | Profile groups to define a logical name for a related group of profiles. |  |
| `spring.profiles.include` | Unconditionally activate the specified comma-separated list of profiles (or list of profiles if using YAML). |  |
| `spring.profiles.validate` | Whether profiles should be validated to ensure sensible names are used. | `true` |
| `spring.quartz.auto-startup` | Whether to automatically start the scheduler after initialization. | `true` |
| `spring.quartz.jdbc.comment-prefix` | Prefixes for single-line comments in SQL initialization scripts. | `[#, --]` |
| `spring.quartz.jdbc.continue-on-error` | Whether initialization should continue when an error occurs when applying a schema script. | `true` |
| `spring.quartz.jdbc.initialize-schema` | Database schema initialization mode. | `embedded` |
| `spring.quartz.jdbc.platform` | Platform to use in initialization scripts if the @@platform@@ placeholder is used. Auto-detected by default. |  |
| `spring.quartz.jdbc.schema` | Path to the SQL file to use to initialize the database schema. |  |
| `spring.quartz.job-store-type` | Quartz job store type. | `memory` |
| `spring.quartz.overwrite-existing-jobs` | Whether configured jobs should overwrite existing job definitions. | `false` |
| `spring.quartz.properties.*` | Additional Quartz Scheduler properties. |  |
| `spring.quartz.scheduler-name` | Name of the scheduler. | `quartzScheduler` |
| `spring.quartz.startup-delay` | Delay after which the scheduler is started once initialization completes. Setting this property makes sense if no jobs should be run before the entire application has started up. | `0s` |
| `spring.quartz.wait-for-jobs-to-complete-on-shutdown` | Whether to wait for running jobs to complete on shutdown. | `false` |
| `spring.reactor.context-propagation` | Context Propagation support mode for Reactor operators. | `limited` |
| `spring.reactor.debug-agent.enabled` | Whether the Reactor Debug Agent should be enabled when reactor-tools is present. | `true` |
| `spring.reactor.netty.shutdown-quiet-period` | Amount of time to wait before shutting down resources. |  |
| `spring.ssl.bundle.jks.*` | Java keystore SSL trust material. |  |
| `spring.ssl.bundle.pem.*` | PEM-encoded SSL trust material. |  |
| `spring.ssl.bundle.watch.file.quiet-period` | Quiet period, after which changes are detected. | `10s` |
| `spring.task.execution.mode` | Determine when the task executor is to be created. | `auto` |
| `spring.task.execution.pool.allow-core-thread-timeout` | Whether core threads are allowed to time out. This enables dynamic growing and shrinking of the pool. Doesn't have an effect if virtual threads are enabled. | `true` |
| `spring.task.execution.pool.core-size` | Core number of threads. Doesn't have an effect if virtual threads are enabled. | `8` |
| `spring.task.execution.pool.keep-alive` | Time limit for which threads may remain idle before being terminated. Doesn't have an effect if virtual threads are enabled. | `60s` |
| `spring.task.execution.pool.max-size` | Maximum allowed number of threads. If tasks are filling up the queue, the pool can expand up to that size to accommodate the load. Ignored if the queue is unbounded. Doesn't have an effect if virtual threads are enabled. |  |
| `spring.task.execution.pool.queue-capacity` | Queue capacity. An unbounded capacity does not increase the pool and therefore ignores the "max-size" property. Doesn't have an effect if virtual threads are enabled. |  |
| `spring.task.execution.pool.shutdown.accept-tasks-after-context-close` | Whether to accept further tasks after the application context close phase has begun. | `false` |
| `spring.task.execution.shutdown.await-termination` | Whether the executor should wait for scheduled tasks to complete on shutdown. | `false` |
| `spring.task.execution.shutdown.await-termination-period` | Maximum time the executor should wait for remaining tasks to complete. |  |
| `spring.task.execution.simple.cancel-remaining-tasks-on-close` | Whether to cancel remaining tasks on close. Only recommended if threads are commonly expected to be stuck. | `false` |
| `spring.task.execution.simple.concurrency-limit` | Set the maximum number of parallel accesses allowed. -1 indicates no concurrency limit at all. |  |
| `spring.task.execution.simple.reject-tasks-when-limit-reached` | Whether to reject tasks when the concurrency limit has been reached. | `false` |
| `spring.task.execution.thread-name-prefix` | Prefix to use for the names of newly created threads. | `task-` |
| `spring.task.scheduling.pool.size` | Maximum allowed number of threads. Doesn't have an effect if virtual threads are enabled. | `1` |
| `spring.task.scheduling.shutdown.await-termination` | Whether the executor should wait for scheduled tasks to complete on shutdown. | `false` |
| `spring.task.scheduling.shutdown.await-termination-period` | Maximum time the executor should wait for remaining tasks to complete. |  |
| `spring.task.scheduling.simple.concurrency-limit` | Set the maximum number of parallel accesses allowed. -1 indicates no concurrency limit at all. |  |
| `spring.task.scheduling.thread-name-prefix` | Prefix to use for the names of newly created threads. | `scheduling-` |
| `spring.threads.virtual.enabled` | Whether to use virtual threads. | `false` |
| `spring.validation.method.adapt-constraint-violations` | Whether to adapt ConstraintViolations to MethodValidationResult. | `false` |
| `trace` | Enable trace logs. | `false` |

## Data Migration Properties (95 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `spring.flyway.baseline-description` | Description to tag an existing schema with when applying a baseline. | `<< Flyway Baseline >>` |
| `spring.flyway.baseline-on-migrate` | Whether to automatically call baseline when migrating a non-empty schema. | `false` |
| `spring.flyway.baseline-version` | Version to tag an existing schema with when executing baseline. | `1` |
| `spring.flyway.batch` | Whether to batch SQL statements when executing them. |  |
| `spring.flyway.callback-locations` | Locations of callbacks. Can contain the special "{vendor}" placeholder to use vendor-specific callbacks. Unprefixed locations or locations starting with "classpath:" point to a package on the classpath and may contain both SQL and Java-based callbacks. Locations starting with "filesystem:" point to a directory on the filesystem, may only contain SQL callbacks. |  |
| `spring.flyway.clean-disabled` | Whether to disable cleaning of the database. | `true` |
| `spring.flyway.community-db-support-enabled` | Whether to enable community database support. |  |
| `spring.flyway.connect-retries` | Maximum number of retries when attempting to connect to the database. | `0` |
| `spring.flyway.connect-retries-interval` | Maximum time between retries when attempting to connect to the database. If a duration suffix is not specified, seconds will be used. | `120s` |
| `spring.flyway.create-schemas` | Whether Flyway should attempt to create the schemas specified in the schemas property. | `true` |
| `spring.flyway.default-schema` | Default schema name managed by Flyway (case-sensitive). |  |
| `spring.flyway.detect-encoding` | Whether to attempt to automatically detect SQL migration file encoding. |  |
| `spring.flyway.driver-class-name` | Fully qualified name of the JDBC driver. Auto-detected based on the URL by default. |  |
| `spring.flyway.dry-run-output` | File to which the SQL statements of a migration dry run should be output. Requires Flyway Teams. |  |
| `spring.flyway.enabled` | Whether to enable flyway. | `true` |
| `spring.flyway.encoding` | Encoding of SQL migrations. | `UTF-8` |
| `spring.flyway.error-overrides` | Rules for the built-in error handling to override specific SQL states and error codes. Requires Flyway Teams. |  |
| `spring.flyway.execute-in-transaction` | Whether Flyway should execute SQL within a transaction. | `true` |
| `spring.flyway.fail-on-missing-locations` | Whether to fail if a location of migration scripts doesn't exist. | `false` |
| `spring.flyway.group` | Whether to group all pending migrations together in the same transaction when applying them. | `false` |
| `spring.flyway.ignore-migration-patterns` | List of patterns that identify migrations to ignore when performing validation. | `*:future` |
| `spring.flyway.init-sqls` | SQL statements to execute to initialize a connection immediately after obtaining it. |  |
| `spring.flyway.installed-by` | Username recorded in the schema history table as having applied the migration. |  |
| `spring.flyway.jdbc-properties.*` | Properties to pass to the JDBC driver. |  |
| `spring.flyway.kerberos-config-file` | Path of the Kerberos config file. Requires Flyway Teams. |  |
| `spring.flyway.locations` | Locations of migrations scripts. Can contain the special "{vendor}" placeholder to use vendor-specific locations. |  |
| `spring.flyway.lock-retry-count` | Maximum number of retries when trying to obtain a lock. | `50` |
| `spring.flyway.loggers` | Loggers Flyway should use. | `[slf4j]` |
| `spring.flyway.mixed` | Whether to allow mixing transactional and non-transactional statements within the same migration. | `false` |
| `spring.flyway.oracle.kerberos-cache-file` | Path of the Oracle Kerberos cache file. Requires Flyway Teams. |  |
| `spring.flyway.oracle.sqlplus` | Whether to enable support for Oracle SQL*Plus commands. Requires Flyway Teams. |  |
| `spring.flyway.oracle.sqlplus-warn` | Whether to issue a warning rather than an error when a not-yet-supported Oracle SQL*Plus statement is encountered. Requires Flyway Teams. |  |
| `spring.flyway.oracle.wallet-location` | Location of the Oracle Wallet, used to sign in to the database automatically. Requires Flyway Teams. |  |
| `spring.flyway.out-of-order` | Whether to allow migrations to be run out of order. | `false` |
| `spring.flyway.output-query-results` | Whether Flyway should output a table with the results of queries when executing migrations. |  |
| `spring.flyway.password` | Login password of the database to migrate. |  |
| `spring.flyway.placeholder-prefix` | Prefix of placeholders in migration scripts. | `${` |
| `spring.flyway.placeholder-replacement` | Perform placeholder replacement in migration scripts. | `true` |
| `spring.flyway.placeholder-separator` | Separator of default placeholders. | `:` |
| `spring.flyway.placeholder-suffix` | Suffix of placeholders in migration scripts. | `}` |
| `spring.flyway.placeholders.*` | Placeholders and their replacements to apply to sql migration scripts. |  |
| `spring.flyway.postgresql.transactional-lock` | Whether transactional advisory locks should be used. If set to false, session-level locks are used instead. |  |
| `spring.flyway.powershell-executable` | PowerShell executable to use for running PowerShell scripts. Default to "powershell" on Windows, "pwsh" on other platforms. |  |
| `spring.flyway.repeatable-sql-migration-prefix` | File name prefix for repeatable SQL migrations. | `R` |
| `spring.flyway.schemas` | Scheme names managed by Flyway (case-sensitive). |  |
| `spring.flyway.script-placeholder-prefix` | Prefix of placeholders in migration scripts. | `FP__` |
| `spring.flyway.script-placeholder-suffix` | Suffix of placeholders in migration scripts. | `__` |
| `spring.flyway.skip-default-callbacks` | Whether to skip default callbacks. If true, only custom callbacks are used. | `false` |
| `spring.flyway.skip-default-resolvers` | Whether to skip default resolvers. If true, only custom resolvers are used. | `false` |
| `spring.flyway.skip-executing-migrations` | Whether Flyway should skip executing the contents of the migrations and only update the schema history table. |  |
| `spring.flyway.sql-migration-prefix` | File name prefix for SQL migrations. | `V` |
| `spring.flyway.sql-migration-separator` | File name separator for SQL migrations. | `__` |
| `spring.flyway.sql-migration-suffixes` | File name suffix for SQL migrations. |  |
| `spring.flyway.sqlserver.kerberos-login-file` | Path to the SQL Server Kerberos login file. Requires Flyway Teams. |  |
| `spring.flyway.stream` | Whether to stream SQL migrations when executing them. |  |
| `spring.flyway.table` | Name of the schema history table that will be used by Flyway. | `flyway_schema_history` |
| `spring.flyway.tablespace` | Tablespace in which the schema history table is created. Ignored when using a database that does not support tablespaces. Defaults to the default tablespace of the connection used by Flyway. |  |
| `spring.flyway.target` | Target version up to which migrations should be considered. | `latest` |
| `spring.flyway.url` | JDBC url of the database to migrate. If not set, the primary configured data source is used. |  |
| `spring.flyway.user` | Login user of the database to migrate. |  |
| `spring.flyway.validate-migration-naming` | Whether to validate migrations and callbacks whose scripts do not obey the correct naming convention. | `false` |
| `spring.flyway.validate-on-migrate` | Whether to automatically call validate when performing a migration. | `true` |
| `spring.liquibase.analytics-enabled` | Whether to send product usage data and analytics to Liquibase. |  |
| `spring.liquibase.change-log` | Change log configuration path. | `classpath:/db/changelog/db.changelog-master.yaml` |
| `spring.liquibase.clear-checksums` | Whether to clear all checksums in the current changelog, so they will be recalculated upon the next update. | `false` |
| `spring.liquibase.contexts` | List of runtime contexts to use. |  |
| `spring.liquibase.database-change-log-lock-table` | Name of table to use for tracking concurrent Liquibase usage. | `DATABASECHANGELOGLOCK` |
| `spring.liquibase.database-change-log-table` | Name of table to use for tracking change history. | `DATABASECHANGELOG` |
| `spring.liquibase.default-schema` | Default database schema. |  |
| `spring.liquibase.driver-class-name` | Fully qualified name of the JDBC driver. Auto-detected based on the URL by default. |  |
| `spring.liquibase.drop-first` | Whether to first drop the database schema. | `false` |
| `spring.liquibase.enabled` | Whether to enable Liquibase support. | `true` |
| `spring.liquibase.label-filter` | List of runtime labels to use. |  |
| `spring.liquibase.license-key` | Liquibase Pro license key. |  |
| `spring.liquibase.liquibase-schema` | Schema to use for Liquibase objects. |  |
| `spring.liquibase.liquibase-tablespace` | Tablespace to use for Liquibase objects. |  |
| `spring.liquibase.parameters.*` | Change log parameters. |  |
| `spring.liquibase.password` | Login password of the database to migrate. |  |
| `spring.liquibase.rollback-file` | File to which rollback SQL is written when an update is performed. |  |
| `spring.liquibase.show-summary` | Whether to print a summary of the update operation. | `summary` |
| `spring.liquibase.show-summary-output` | Where to print a summary of the update operation. | `log` |
| `spring.liquibase.tag` | Tag name to use when applying database changes. Can also be used with "rollbackFile" to generate a rollback script for all existing changes associated with that tag. |  |
| `spring.liquibase.test-rollback-on-update` | Whether rollback should be tested before update is performed. | `false` |
| `spring.liquibase.ui-service` | Which UIService to use. | `logger` |
| `spring.liquibase.url` | JDBC URL of the database to migrate. If not set, the primary configured data source is used. |  |
| `spring.liquibase.user` | Login user of the database to migrate. |  |
| `spring.sql.init.continue-on-error` | Whether initialization should continue when an error occurs. | `false` |
| `spring.sql.init.data-locations` | Locations of the data (DML) scripts to apply to the database. |  |
| `spring.sql.init.encoding` | Encoding of the schema and data scripts. |  |
| `spring.sql.init.mode` | Mode to apply when determining whether initialization should be performed. | `embedded` |
| `spring.sql.init.password` | Password of the database to use when applying initialization scripts (if different). |  |
| `spring.sql.init.platform` | Platform to use in the default schema or data script locations, schema-${platform}.sql and data-${platform}.sql. | `all` |
| `spring.sql.init.schema-locations` | Locations of the schema (DDL) scripts to apply to the database. |  |
| `spring.sql.init.separator` | Statement separator in the schema and data scripts. | `;` |
| `spring.sql.init.username` | Username of the database to use when applying initialization scripts (if different). |  |

## Data Properties (244 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `spring.cassandra.compression` | Compression supported by the Cassandra binary protocol. | `none` |
| `spring.cassandra.config` | Location of the configuration file to use. |  |
| `spring.cassandra.connection.connect-timeout` | Timeout to use when establishing driver connections. | `5s` |
| `spring.cassandra.connection.init-query-timeout` | Timeout to use for internal queries that run as part of the initialization process, just after a connection is opened. | `5s` |
| `spring.cassandra.contact-points` | Cluster node addresses in the form 'host:port', or a simple 'host' to use the configured port. | `[127.0.0.1:9042]` |
| `spring.cassandra.controlconnection.timeout` | Timeout to use for control queries. | `5s` |
| `spring.cassandra.keyspace-name` | Keyspace name to use. |  |
| `spring.cassandra.local-datacenter` | Datacenter that is considered "local". Contact points should be from this datacenter. |  |
| `spring.cassandra.password` | Login password of the server. |  |
| `spring.cassandra.pool.heartbeat-interval` | Heartbeat interval after which a message is sent on an idle connection to make sure it's still alive. | `30s` |
| `spring.cassandra.pool.idle-timeout` | Idle timeout before an idle connection is removed. | `5s` |
| `spring.cassandra.port` | Port to use if a contact point does not specify one. | `9042` |
| `spring.cassandra.request.consistency` | Queries consistency level. |  |
| `spring.cassandra.request.page-size` | How many rows will be retrieved simultaneously in a single network round-trip. | `5000` |
| `spring.cassandra.request.serial-consistency` | Queries serial consistency level. |  |
| `spring.cassandra.request.throttler.drain-interval` | How often the throttler attempts to dequeue requests. Set this high enough that each attempt will process multiple entries in the queue, but not delay requests too much. |  |
| `spring.cassandra.request.throttler.max-concurrent-requests` | Maximum number of requests that are allowed to execute in parallel. |  |
| `spring.cassandra.request.throttler.max-queue-size` | Maximum number of requests that can be enqueued when the throttling threshold is exceeded. |  |
| `spring.cassandra.request.throttler.max-requests-per-second` | Maximum allowed request rate. |  |
| `spring.cassandra.request.throttler.type` | Request throttling type. | `none` |
| `spring.cassandra.request.timeout` | How long the driver waits for a request to complete. | `2s` |
| `spring.cassandra.schema-action` | Schema action to take at startup. | `none` |
| `spring.cassandra.session-name` | Name of the Cassandra session. |  |
| `spring.cassandra.ssl.bundle` | SSL bundle name. |  |
| `spring.cassandra.ssl.enabled` | Whether to enable SSL support. |  |
| `spring.cassandra.username` | Login user of the server. |  |
| `spring.couchbase.authentication.jks.location` | Java KeyStore location for certificate-based cluster authentication. |  |
| `spring.couchbase.authentication.jks.password` | Java KeyStore password for certificate-based cluster authentication. |  |
| `spring.couchbase.authentication.pem.certificates` | PEM-formatted certificates for certificate-based cluster authentication. |  |
| `spring.couchbase.authentication.pem.private-key` | PEM-formatted private key for certificate-based cluster authentication. |  |
| `spring.couchbase.authentication.pem.private-key-password` | Private key password for certificate-based cluster authentication. |  |
| `spring.couchbase.connection-string` | Connection string used to locate the Couchbase cluster. |  |
| `spring.couchbase.env.io.idle-http-connection-timeout` | Length of time an HTTP connection may remain idle before it is closed and removed from the pool. | `1s` |
| `spring.couchbase.env.io.max-endpoints` | Maximum number of sockets per node. | `12` |
| `spring.couchbase.env.io.min-endpoints` | Minimum number of sockets per node. | `1` |
| `spring.couchbase.env.ssl.bundle` | SSL bundle name. |  |
| `spring.couchbase.env.ssl.enabled` | Whether to enable SSL support. Enabled automatically if a "bundle" is provided unless specified otherwise. |  |
| `spring.couchbase.env.timeouts.analytics` | Timeout for the analytics service. | `75s` |
| `spring.couchbase.env.timeouts.connect` | Bucket connect timeout. | `10s` |
| `spring.couchbase.env.timeouts.disconnect` | Bucket disconnect timeout. | `10s` |
| `spring.couchbase.env.timeouts.key-value` | Timeout for operations on a specific key-value. | `2500ms` |
| `spring.couchbase.env.timeouts.key-value-durable` | Timeout for operations on a specific key-value with a durability level. | `10s` |
| `spring.couchbase.env.timeouts.management` | Timeout for the management operations. | `75s` |
| `spring.couchbase.env.timeouts.query` | N1QL query operations timeout. | `75s` |
| `spring.couchbase.env.timeouts.search` | Timeout for the search service. | `75s` |
| `spring.couchbase.env.timeouts.view` | Regular and geospatial view operations timeout. | `75s` |
| `spring.couchbase.password` | Cluster password. |  |
| `spring.couchbase.username` | Cluster username. |  |
| `spring.data.cassandra.repositories.type` | Type of Cassandra repositories to enable. | `auto` |
| `spring.data.couchbase.auto-index` | Automatically create views and indexes. Use the meta-data provided by "@ViewIndexed", "@N1qlPrimaryIndexed" and "@N1qlSecondaryIndexed". | `false` |
| `spring.data.couchbase.bucket-name` | Name of the bucket to connect to. |  |
| `spring.data.couchbase.field-naming-strategy` | Fully qualified name of the FieldNamingStrategy to use. |  |
| `spring.data.couchbase.repositories.type` | Type of Couchbase repositories to enable. | `auto` |
| `spring.data.couchbase.scope-name` | Name of the scope used for all collection access. |  |
| `spring.data.couchbase.type-key` | Name of the field that stores the type information for complex types when using "MappingCouchbaseConverter". | `_class` |
| `spring.data.elasticsearch.repositories.enabled` | Whether to enable Elasticsearch repositories. | `true` |
| `spring.data.jdbc.dialect` | Dialect to use. By default, the dialect is determined by inspecting the database connection. |  |
| `spring.data.jdbc.repositories.enabled` | Whether to enable JDBC repositories. | `true` |
| `spring.data.jpa.repositories.bootstrap-mode` | Bootstrap mode for JPA repositories. | `default` |
| `spring.data.jpa.repositories.enabled` | Whether to enable JPA repositories. | `true` |
| `spring.data.ldap.repositories.enabled` | Whether to enable LDAP repositories. | `true` |
| `spring.data.mongodb.auto-index-creation` | Whether to enable auto-index creation. |  |
| `spring.data.mongodb.field-naming-strategy` | Fully qualified name of the FieldNamingStrategy to use. |  |
| `spring.data.mongodb.gridfs.bucket` | GridFS bucket name. |  |
| `spring.data.mongodb.gridfs.database` | GridFS database name. |  |
| `spring.data.mongodb.repositories.type` | Type of Mongo repositories to enable. | `auto` |
| `spring.data.mongodb.representation.big-decimal` | Representation to use when converting a BigDecimal. | `unspecified` |
| `spring.data.neo4j.database` | Database name to use. By default, the server decides the default database to use. |  |
| `spring.data.neo4j.repositories.type` | Type of Neo4j repositories to enable. | `auto` |
| `spring.data.r2dbc.repositories.enabled` | Whether to enable R2DBC repositories. | `true` |
| `spring.data.redis.client-name` | Client name to be set on connections with CLIENT SETNAME. |  |
| `spring.data.redis.client-type` | Type of client to use. By default, auto-detected according to the classpath. |  |
| `spring.data.redis.cluster.max-redirects` | Maximum number of redirects to follow when executing commands across the cluster. |  |
| `spring.data.redis.cluster.nodes` | List of "host:port" pairs to bootstrap from. This represents an "initial" list of cluster nodes and is required to have at least one entry. |  |
| `spring.data.redis.connect-timeout` | Connection timeout. |  |
| `spring.data.redis.database` | Database index used by the connection factory. | `0` |
| `spring.data.redis.host` | Redis server host. | `localhost` |
| `spring.data.redis.jedis.pool.enabled` | Whether to enable the pool. Enabled automatically if "commons-pool2" is available. With Jedis, pooling is implicitly enabled in sentinel mode and this setting only applies to single node setup. |  |
| `spring.data.redis.jedis.pool.max-active` | Maximum number of connections that can be allocated by the pool at a given time. Use a negative value for no limit. | `8` |
| `spring.data.redis.jedis.pool.max-idle` | Maximum number of "idle" connections in the pool. Use a negative value to indicate an unlimited number of idle connections. | `8` |
| `spring.data.redis.jedis.pool.max-wait` | Maximum amount of time a connection allocation should block before throwing an exception when the pool is exhausted. Use a negative value to block indefinitely. | `-1ms` |
| `spring.data.redis.jedis.pool.min-idle` | Target for the minimum number of idle connections to maintain in the pool. This setting only has an effect if both it and time between eviction runs are positive. | `0` |
| `spring.data.redis.jedis.pool.time-between-eviction-runs` | Time between runs of the idle object evictor thread. When positive, the idle object evictor thread starts, otherwise no idle object eviction is performed. |  |
| `spring.data.redis.lettuce.cluster.refresh.adaptive` | Whether adaptive topology refreshing using all available refresh triggers should be used. | `false` |
| `spring.data.redis.lettuce.cluster.refresh.dynamic-refresh-sources` | Whether to discover and query all cluster nodes for obtaining the cluster topology. When set to false, only the initial seed nodes are used as sources for topology discovery. | `true` |
| `spring.data.redis.lettuce.cluster.refresh.period` | Cluster topology refresh period. |  |
| `spring.data.redis.lettuce.pool.enabled` | Whether to enable the pool. Enabled automatically if "commons-pool2" is available. With Jedis, pooling is implicitly enabled in sentinel mode and this setting only applies to single node setup. |  |
| `spring.data.redis.lettuce.pool.max-active` | Maximum number of connections that can be allocated by the pool at a given time. Use a negative value for no limit. | `8` |
| `spring.data.redis.lettuce.pool.max-idle` | Maximum number of "idle" connections in the pool. Use a negative value to indicate an unlimited number of idle connections. | `8` |
| `spring.data.redis.lettuce.pool.max-wait` | Maximum amount of time a connection allocation should block before throwing an exception when the pool is exhausted. Use a negative value to block indefinitely. | `-1ms` |
| `spring.data.redis.lettuce.pool.min-idle` | Target for the minimum number of idle connections to maintain in the pool. This setting only has an effect if both it and time between eviction runs are positive. | `0` |
| `spring.data.redis.lettuce.pool.time-between-eviction-runs` | Time between runs of the idle object evictor thread. When positive, the idle object evictor thread starts, otherwise no idle object eviction is performed. |  |
| `spring.data.redis.lettuce.read-from` | Defines from which Redis nodes data is read. |  |
| `spring.data.redis.lettuce.shutdown-timeout` | Shutdown timeout. | `100ms` |
| `spring.data.redis.masterreplica.nodes` | Static list of "host:port" pairs to use, at least one entry is required. |  |
| `spring.data.redis.password` | Login password of the redis server. |  |
| `spring.data.redis.port` | Redis server port. | `6379` |
| `spring.data.redis.repositories.enabled` | Whether to enable Redis repositories. | `true` |
| `spring.data.redis.sentinel.master` | Name of the Redis server. |  |
| `spring.data.redis.sentinel.nodes` | List of "host:port" pairs. |  |
| `spring.data.redis.sentinel.password` | Password for authenticating with sentinel(s). |  |
| `spring.data.redis.sentinel.username` | Login username for authenticating with sentinel(s). |  |
| `spring.data.redis.ssl.bundle` | SSL bundle name. |  |
| `spring.data.redis.ssl.enabled` | Whether to enable SSL support. Enabled automatically if "bundle" is provided unless specified otherwise. |  |
| `spring.data.redis.timeout` | Read timeout. |  |
| `spring.data.redis.url` | Connection URL. Overrides host, port, username, password, and database. Example: redis://user:[email protected]:6379/8 |  |
| `spring.data.redis.username` | Login username of the redis server. |  |
| `spring.data.rest.base-path` | Base path to be used by Spring Data REST to expose repository resources. |  |
| `spring.data.rest.default-media-type` | Content type to use as a default when none is specified. |  |
| `spring.data.rest.default-page-size` | Default size of pages. |  |
| `spring.data.rest.detection-strategy` | Strategy to use to determine which repositories get exposed. | `default` |
| `spring.data.rest.enable-enum-translation` | Whether to enable enum value translation through the Spring Data REST default resource bundle. |  |
| `spring.data.rest.limit-param-name` | Name of the URL query string parameter that indicates how many results to return at once. |  |
| `spring.data.rest.max-page-size` | Maximum size of pages. |  |
| `spring.data.rest.page-param-name` | Name of the URL query string parameter that indicates what page to return. |  |
| `spring.data.rest.return-body-on-create` | Whether to return a response body after creating an entity. |  |
| `spring.data.rest.return-body-on-update` | Whether to return a response body after updating an entity. |  |
| `spring.data.rest.sort-param-name` | Name of the URL query string parameter that indicates what direction to sort results. |  |
| `spring.data.web.pageable.default-page-size` | Default page size. | `20` |
| `spring.data.web.pageable.max-page-size` | Maximum page size to be accepted. | `2000` |
| `spring.data.web.pageable.one-indexed-parameters` | Whether to expose and assume 1-based page number indexes. Defaults to "false", meaning a page number of 0 in the request equals the first page. | `false` |
| `spring.data.web.pageable.page-parameter` | Page index parameter name. | `page` |
| `spring.data.web.pageable.prefix` | General prefix to be prepended to the page number and page size parameters. |  |
| `spring.data.web.pageable.qualifier-delimiter` | Delimiter to be used between the qualifier and the actual page number and size properties. | `_` |
| `spring.data.web.pageable.serialization-mode` | Configures how to render Spring Data Pageable instances. | `direct` |
| `spring.data.web.pageable.size-parameter` | Page size parameter name. | `size` |
| `spring.data.web.sort.sort-parameter` | Sort parameter name. | `sort` |
| `spring.datasource.dbcp2.abandoned-usage-tracking
spring.datasource.dbcp2.access-to-underlying-connection-allowed
spring.datasource.dbcp2.auto-commit-on-return
spring.datasource.dbcp2.cache-state
spring.datasource.dbcp2.clear-statement-pool-on-return
spring.datasource.dbcp2.connection-factory-class-name
spring.datasource.dbcp2.connection-init-sqls
spring.datasource.dbcp2.default-auto-commit
spring.datasource.dbcp2.default-catalog
spring.datasource.dbcp2.default-read-only
spring.datasource.dbcp2.default-schema
spring.datasource.dbcp2.default-transaction-isolation
spring.datasource.dbcp2.disconnection-ignore-sql-codes
spring.datasource.dbcp2.disconnection-sql-codes
spring.datasource.dbcp2.driver-class-name
spring.datasource.dbcp2.duration-between-eviction-runs
spring.datasource.dbcp2.eviction-policy-class-name
spring.datasource.dbcp2.fast-fail-validation
spring.datasource.dbcp2.initial-size
spring.datasource.dbcp2.jmx-name
spring.datasource.dbcp2.lifo
spring.datasource.dbcp2.log-abandoned
spring.datasource.dbcp2.log-expired-connections
spring.datasource.dbcp2.login-timeout
spring.datasource.dbcp2.max-idle
spring.datasource.dbcp2.max-open-prepared-statements
spring.datasource.dbcp2.max-total
spring.datasource.dbcp2.min-idle
spring.datasource.dbcp2.num-tests-per-eviction-run
spring.datasource.dbcp2.password
spring.datasource.dbcp2.pool-prepared-statements
spring.datasource.dbcp2.remove-abandoned-on-borrow
spring.datasource.dbcp2.remove-abandoned-on-maintenance
spring.datasource.dbcp2.rollback-on-return
spring.datasource.dbcp2.test-on-borrow
spring.datasource.dbcp2.test-on-create
spring.datasource.dbcp2.test-on-return
spring.datasource.dbcp2.test-while-idle
spring.datasource.dbcp2.url
spring.datasource.dbcp2.username
spring.datasource.dbcp2.validation-query` | Commons DBCP2 specific settings bound to an instance of DBCP2's BasicDataSource |  |
| `spring.datasource.driver-class-name` | Fully qualified name of the JDBC driver. Auto-detected based on the URL by default. |  |
| `spring.datasource.embedded-database-connection` | Connection details for an embedded database. Defaults to the most suitable embedded database that is available on the classpath. |  |
| `spring.datasource.generate-unique-name` | Whether to generate a random datasource name. | `true` |
| `spring.datasource.hikari.allow-pool-suspension
spring.datasource.hikari.auto-commit
spring.datasource.hikari.catalog
spring.datasource.hikari.connection-init-sql
spring.datasource.hikari.connection-test-query
spring.datasource.hikari.connection-timeout
spring.datasource.hikari.credentials-provider-class-name
spring.datasource.hikari.data-source-class-name
spring.datasource.hikari.data-source-j-n-d-i
spring.datasource.hikari.data-source-properties
spring.datasource.hikari.driver-class-name
spring.datasource.hikari.exception-override-class-name
spring.datasource.hikari.health-check-properties
spring.datasource.hikari.idle-timeout
spring.datasource.hikari.initialization-fail-timeout
spring.datasource.hikari.isolate-internal-queries
spring.datasource.hikari.jdbc-url
spring.datasource.hikari.keepalive-time
spring.datasource.hikari.leak-detection-threshold
spring.datasource.hikari.login-timeout
spring.datasource.hikari.max-lifetime
spring.datasource.hikari.maximum-pool-size
spring.datasource.hikari.minimum-idle
spring.datasource.hikari.password
spring.datasource.hikari.pool-name
spring.datasource.hikari.read-only
spring.datasource.hikari.register-mbeans
spring.datasource.hikari.schema
spring.datasource.hikari.transaction-isolation
spring.datasource.hikari.username
spring.datasource.hikari.validation-timeout` | Hikari specific settings bound to an instance of Hikari's HikariDataSource |  |
| `spring.datasource.jndi-name` | JNDI location of the datasource. Class, url, username and password are ignored when set. |  |
| `spring.datasource.name` | Datasource name to use if "generate-unique-name" is false. Defaults to "testdb" when using an embedded database, otherwise null. |  |
| `spring.datasource.oracleucp.abandoned-connection-timeout
spring.datasource.oracleucp.commit-on-connection-return
spring.datasource.oracleucp.connection-factory-class-name
spring.datasource.oracleucp.connection-factory-properties
spring.datasource.oracleucp.connection-harvest-max-count
spring.datasource.oracleucp.connection-harvest-trigger-count
spring.datasource.oracleucp.connection-labeling-high-cost
spring.datasource.oracleucp.connection-pool-name
spring.datasource.oracleucp.connection-properties
spring.datasource.oracleucp.connection-repurpose-threshold
spring.datasource.oracleucp.connection-validation-timeout
spring.datasource.oracleucp.connection-wait-duration
spring.datasource.oracleucp.connection-wait-timeout-while-service-down
spring.datasource.oracleucp.create-connection-in-borrow-thread
spring.datasource.oracleucp.data-source-name
spring.datasource.oracleucp.database-name
spring.datasource.oracleucp.description
spring.datasource.oracleucp.fast-connection-failover-enabled
spring.datasource.oracleucp.high-cost-connection-reuse-threshold
spring.datasource.oracleucp.inactive-connection-timeout
spring.datasource.oracleucp.initial-pool-size
spring.datasource.oracleucp.login-timeout
spring.datasource.oracleucp.max-connection-reuse-count
spring.datasource.oracleucp.max-connection-reuse-time
spring.datasource.oracleucp.max-connections-per-shard
spring.datasource.oracleucp.max-idle-time
spring.datasource.oracleucp.max-pool-size
spring.datasource.oracleucp.max-statements
spring.datasource.oracleucp.min-idle
spring.datasource.oracleucp.min-pool-size
spring.datasource.oracleucp.network-protocol
spring.datasource.oracleucp.o-n-s-configuration
spring.datasource.oracleucp.pdb-roles
spring.datasource.oracleucp.port-number
spring.datasource.oracleucp.property-cycle
spring.datasource.oracleucp.query-timeout
spring.datasource.oracleucp.read-only-instance-allowed
spring.datasource.oracleucp.role-name
spring.datasource.oracleucp.s-q-l-for-validate-connection
spring.datasource.oracleucp.seconds-to-trust-idle-connection
spring.datasource.oracleucp.server-name
spring.datasource.oracleucp.sharding-mode
spring.datasource.oracleucp.time-to-live-connection-timeout
spring.datasource.oracleucp.timeout-check-interval
spring.datasource.oracleucp.u-r-l
spring.datasource.oracleucp.user
spring.datasource.oracleucp.validate-connection-on-borrow` | Oracle UCP specific settings bound to an instance of Oracle UCP's PoolDataSource |  |
| `spring.datasource.password` | Login password of the database. |  |
| `spring.datasource.tomcat.abandon-when-percentage-full
spring.datasource.tomcat.access-to-underlying-connection-allowed
spring.datasource.tomcat.alternate-username-allowed
spring.datasource.tomcat.commit-on-return
spring.datasource.tomcat.connection-properties
spring.datasource.tomcat.data-source-j-n-d-i
spring.datasource.tomcat.db-properties
spring.datasource.tomcat.default-auto-commit
spring.datasource.tomcat.default-catalog
spring.datasource.tomcat.default-read-only
spring.datasource.tomcat.default-transaction-isolation
spring.datasource.tomcat.driver-class-name
spring.datasource.tomcat.fair-queue
spring.datasource.tomcat.ignore-exception-on-pre-load
spring.datasource.tomcat.init-s-q-l
spring.datasource.tomcat.initial-size
spring.datasource.tomcat.jdbc-interceptors
spring.datasource.tomcat.jmx-enabled
spring.datasource.tomcat.log-abandoned
spring.datasource.tomcat.log-validation-errors
spring.datasource.tomcat.login-timeout
spring.datasource.tomcat.max-active
spring.datasource.tomcat.max-age
spring.datasource.tomcat.max-idle
spring.datasource.tomcat.max-wait
spring.datasource.tomcat.min-evictable-idle-time-millis
spring.datasource.tomcat.min-idle
spring.datasource.tomcat.name
spring.datasource.tomcat.num-tests-per-eviction-run
spring.datasource.tomcat.password
spring.datasource.tomcat.propagate-interrupt-state
spring.datasource.tomcat.remove-abandoned
spring.datasource.tomcat.remove-abandoned-timeout
spring.datasource.tomcat.rollback-on-return
spring.datasource.tomcat.suspect-timeout
spring.datasource.tomcat.test-on-borrow
spring.datasource.tomcat.test-on-connect
spring.datasource.tomcat.test-on-return
spring.datasource.tomcat.test-while-idle
spring.datasource.tomcat.time-between-eviction-runs-millis
spring.datasource.tomcat.url
spring.datasource.tomcat.use-disposable-connection-facade
spring.datasource.tomcat.use-equals
spring.datasource.tomcat.use-lock
spring.datasource.tomcat.use-statement-facade
spring.datasource.tomcat.username
spring.datasource.tomcat.validation-interval
spring.datasource.tomcat.validation-query
spring.datasource.tomcat.validation-query-timeout
spring.datasource.tomcat.validator-class-name` | Tomcat datasource specific settings bound to an instance of Tomcat JDBC's DataSource |  |
| `spring.datasource.type` | Fully qualified name of the DataSource implementation to use. By default, a connection pool implementation is auto-detected from the classpath. |  |
| `spring.datasource.url` | JDBC URL of the database. |  |
| `spring.datasource.username` | Login username of the database. |  |
| `spring.datasource.xa.data-source-class-name` | XA datasource fully qualified name. |  |
| `spring.datasource.xa.properties.*` | Properties to pass to the XA data source. |  |
| `spring.elasticsearch.api-key` | API key for authentication with Elasticsearch. |  |
| `spring.elasticsearch.connection-timeout` | Connection timeout used when communicating with Elasticsearch. | `1s` |
| `spring.elasticsearch.password` | Password for authentication with Elasticsearch. |  |
| `spring.elasticsearch.path-prefix` | Prefix added to the path of every request sent to Elasticsearch. |  |
| `spring.elasticsearch.restclient.sniffer.delay-after-failure` | Delay of a sniff execution scheduled after a failure. | `1m` |
| `spring.elasticsearch.restclient.sniffer.enabled` | Whether the sniffer is enabled. | `false` |
| `spring.elasticsearch.restclient.sniffer.interval` | Interval between consecutive ordinary sniff executions. | `5m` |
| `spring.elasticsearch.restclient.ssl.bundle` | SSL bundle name. |  |
| `spring.elasticsearch.socket-keep-alive` | Whether to enable socket keep alive between client and Elasticsearch. | `false` |
| `spring.elasticsearch.socket-timeout` | Socket timeout used when communicating with Elasticsearch. | `30s` |
| `spring.elasticsearch.uris` | List of the Elasticsearch instances to use. | `[http://localhost:9200]` |
| `spring.elasticsearch.username` | Username for authentication with Elasticsearch. |  |
| `spring.h2.console.enabled` | Whether to enable the console. | `false` |
| `spring.h2.console.path` | Path at which the console is available. | `/h2-console` |
| `spring.h2.console.settings.trace` | Whether to enable trace output. | `false` |
| `spring.h2.console.settings.web-admin-password` | Password to access preferences and tools of H2 Console. |  |
| `spring.h2.console.settings.web-allow-others` | Whether to enable remote access. | `false` |
| `spring.jdbc.template.fetch-size` | Number of rows that should be fetched from the database when more rows are needed. Use -1 to use the JDBC driver's default configuration. | `-1` |
| `spring.jdbc.template.ignore-warnings` | Whether to ignore JDBC statement warnings (SQLWarning). When set to false, throw an SQLWarningException instead. | `true` |
| `spring.jdbc.template.max-rows` | Maximum number of rows. Use -1 to use the JDBC driver's default configuration. | `-1` |
| `spring.jdbc.template.query-timeout` | Query timeout. Default is to use the JDBC driver's default configuration. If a duration suffix is not specified, seconds will be used. |  |
| `spring.jdbc.template.results-map-case-insensitive` | Whether execution of a CallableStatement will return the results in a Map that uses case-insensitive names for the parameters. | `false` |
| `spring.jdbc.template.skip-results-processing` | Whether results processing should be skipped. Can be used to optimize callable statement processing when we know that no results are being passed back. | `false` |
| `spring.jdbc.template.skip-undeclared-results` | Whether undeclared results should be skipped. | `false` |
| `spring.jooq.config` | Location of the jOOQ config file. |  |
| `spring.jooq.sql-dialect` | SQL dialect to use. Auto-detected by default. |  |
| `spring.jpa.database` | Target database to operate on, auto-detected by default. Can be alternatively set using the "databasePlatform" property. |  |
| `spring.jpa.database-platform` | Name of the target database to operate on, auto-detected by default. Can be alternatively set using the "Database" enum. |  |
| `spring.jpa.defer-datasource-initialization` | Whether to defer DataSource initialization until after any EntityManagerFactory beans have been created and initialized. | `false` |
| `spring.jpa.generate-ddl` | Whether to initialize the schema on startup. | `false` |
| `spring.jpa.hibernate.ddl-auto` | DDL mode. This is actually a shortcut for the "hibernate.hbm2ddl.auto" property. Defaults to "create-drop" when using an embedded database and no schema manager was detected. Otherwise, defaults to "none". |  |
| `spring.jpa.hibernate.naming.implicit-strategy` | Fully qualified name of the implicit naming strategy. |  |
| `spring.jpa.hibernate.naming.physical-strategy` | Fully qualified name of the physical naming strategy. |  |
| `spring.jpa.mapping-resources` | Mapping resources (equivalent to "mapping-file" entries in persistence.xml). |  |
| `spring.jpa.open-in-view` | Register OpenEntityManagerInViewInterceptor. Binds a JPA EntityManager to the thread for the entire processing of the request. | `true` |
| `spring.jpa.properties.*` | Additional native properties to set on the JPA provider. |  |
| `spring.jpa.show-sql` | Whether to enable logging of SQL statements. | `false` |
| `spring.ldap.anonymous-read-only` | Whether read-only operations should use an anonymous environment. Disabled by default unless a username is set. |  |
| `spring.ldap.base` | Base suffix from which all operations should originate. |  |
| `spring.ldap.base-environment.*` | LDAP specification settings. |  |
| `spring.ldap.embedded.base-dn` | List of base DNs. |  |
| `spring.ldap.embedded.credential.password` | Embedded LDAP password. |  |
| `spring.ldap.embedded.credential.username` | Embedded LDAP username. |  |
| `spring.ldap.embedded.ldif` | Schema (LDIF) script resource reference. | `classpath:schema.ldif` |
| `spring.ldap.embedded.port` | Embedded LDAP port. | `0` |
| `spring.ldap.embedded.validation.enabled` | Whether to enable LDAP schema validation. | `true` |
| `spring.ldap.embedded.validation.schema` | Path to the custom schema. |  |
| `spring.ldap.password` | Login password of the server. |  |
| `spring.ldap.referral` | Specify how referrals encountered by the service provider are to be processed. If not specified, the default is determined by the provider. |  |
| `spring.ldap.template.ignore-name-not-found-exception` | Whether NameNotFoundException should be ignored in searches through the LdapTemplate. | `false` |
| `spring.ldap.template.ignore-partial-result-exception` | Whether PartialResultException should be ignored in searches through the LdapTemplate. | `false` |
| `spring.ldap.template.ignore-size-limit-exceeded-exception` | Whether SizeLimitExceededException should be ignored in searches through the LdapTemplate. | `true` |
| `spring.ldap.urls` | LDAP URLs of the server. |  |
| `spring.ldap.username` | Login username of the server. |  |
| `spring.mongodb.additional-hosts` | Additional server hosts. Ignored if 'uri' is set or if 'host' is omitted. Additional hosts will use the default mongo port of 27017. If you want to use a different port you can use the "host:port" syntax. |  |
| `spring.mongodb.authentication-database` | Authentication database name. |  |
| `spring.mongodb.database` | Database name. Overrides database in URI. |  |
| `spring.mongodb.host` | Mongo server host. Ignored if 'uri' is set. |  |
| `spring.mongodb.password` | Login password of the mongo server. Ignored if 'uri' is set. |  |
| `spring.mongodb.port` | Mongo server port. Ignored if 'uri' is set. |  |
| `spring.mongodb.protocol` | Protocol to be used for the MongoDB connection. Ignored if 'uri' is set. | `mongodb` |
| `spring.mongodb.replica-set-name` | Required replica set name for the cluster. Ignored if 'uri' is set. |  |
| `spring.mongodb.representation.uuid` | Representation to use when converting a UUID to a BSON binary value. | `unspecified` |
| `spring.mongodb.ssl.bundle` | SSL bundle name. |  |
| `spring.mongodb.ssl.enabled` | Whether to enable SSL support. Enabled automatically if "bundle" is provided unless specified otherwise. |  |
| `spring.mongodb.uri` | Mongo database URI. Overrides host, port, username, and password. | `mongodb://localhost/test` |
| `spring.mongodb.username` | Login user of the mongo server. Ignored if 'uri' is set. |  |
| `spring.neo4j.authentication.kerberos-ticket` | Kerberos ticket for connecting to the database. Mutual exclusive with a given username. |  |
| `spring.neo4j.authentication.password` | Login password of the server. |  |
| `spring.neo4j.authentication.realm` | Realm to connect to. |  |
| `spring.neo4j.authentication.username` | Login user of the server. |  |
| `spring.neo4j.connection-timeout` | Timeout for borrowing connections from the pool. | `30s` |
| `spring.neo4j.max-transaction-retry-time` | Maximum time transactions are allowed to retry. | `30s` |
| `spring.neo4j.pool.connection-acquisition-timeout` | Acquisition of new connections will be attempted for at most configured timeout. | `60s` |
| `spring.neo4j.pool.idle-time-before-connection-test` | Pooled connections that have been idle in the pool for longer than this threshold will be tested before they are used again. |  |
| `spring.neo4j.pool.log-leaked-sessions` | Whether to log leaked sessions. | `false` |
| `spring.neo4j.pool.max-connection-lifetime` | Pooled connections older than this threshold will be closed and removed from the pool. | `1h` |
| `spring.neo4j.pool.max-connection-pool-size` | Maximum amount of connections in the connection pool towards a single database. | `100` |
| `spring.neo4j.security.cert-file` | Path to the file that holds the trusted certificates. |  |
| `spring.neo4j.security.encrypted` | Whether the driver should use encrypted traffic. | `false` |
| `spring.neo4j.security.hostname-verification-enabled` | Whether hostname verification is required. | `true` |
| `spring.neo4j.security.trust-strategy` | Trust strategy to use. | `trust-system-ca-signed-certificates` |
| `spring.neo4j.uri` | URI used by the driver. | `bolt://localhost:7687` |
| `spring.persistence.exceptiontranslation.enabled` | Whether to enable the PersistenceExceptionTranslationPostProcessor. | `true` |
| `spring.r2dbc.generate-unique-name` | Whether to generate a random database name. Ignore any configured name when enabled. | `false` |
| `spring.r2dbc.name` | Database name. Set if no name is specified in the url. Default to "testdb" when using an embedded database. |  |
| `spring.r2dbc.password` | Login password of the database. Set if no password is specified in the url. |  |
| `spring.r2dbc.pool.acquire-retry` | Number of acquire retries if the first acquire attempt fails. | `1` |
| `spring.r2dbc.pool.enabled` | Whether pooling is enabled. Requires r2dbc-pool. | `true` |
| `spring.r2dbc.pool.initial-size` | Initial connection pool size. | `10` |
| `spring.r2dbc.pool.max-acquire-time` | Maximum time to acquire a connection from the pool. By default, wait indefinitely. |  |
| `spring.r2dbc.pool.max-create-connection-time` | Maximum time to wait to create a new connection. By default, wait indefinitely. |  |
| `spring.r2dbc.pool.max-idle-time` | Maximum amount of time that a connection is allowed to sit idle in the pool. | `30m` |
| `spring.r2dbc.pool.max-life-time` | Maximum lifetime of a connection in the pool. By default, connections have an infinite lifetime. |  |
| `spring.r2dbc.pool.max-size` | Maximal connection pool size. | `10` |
| `spring.r2dbc.pool.max-validation-time` | Maximum time to validate a connection from the pool. By default, wait indefinitely. |  |
| `spring.r2dbc.pool.min-idle` | Minimal number of idle connections. | `0` |
| `spring.r2dbc.pool.validation-depth` | Validation depth. | `local` |
| `spring.r2dbc.pool.validation-query` | Validation query. |  |
| `spring.r2dbc.properties.*` | Additional R2DBC options. |  |
| `spring.r2dbc.url` | R2DBC URL of the database. database name, username, password and pooling options specified in the url take precedence over individual options. |  |
| `spring.r2dbc.username` | Login username of the database. Set if no username is specified in the url. |  |

## Devtools Properties (17 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `spring.devtools.add-properties` | Whether to enable development property defaults. | `true` |
| `spring.devtools.livereload.enabled` | Whether to enable a livereload.com-compatible server. | `false` |
| `spring.devtools.livereload.port` | Server port. | `35729` |
| `spring.devtools.remote.context-path` | Context path used to handle the remote connection. | `/.~~spring-boot!~` |
| `spring.devtools.remote.proxy.host` | The host of the proxy to use to connect to the remote application. |  |
| `spring.devtools.remote.proxy.port` | The port of the proxy to use to connect to the remote application. |  |
| `spring.devtools.remote.restart.enabled` | Whether to enable remote restart. | `true` |
| `spring.devtools.remote.secret` | A shared secret required to establish a connection (required to enable remote support). |  |
| `spring.devtools.remote.secret-header-name` | HTTP header used to transfer the shared secret. | `X-AUTH-TOKEN` |
| `spring.devtools.restart.additional-exclude` | Additional patterns that should be excluded from triggering a full restart. |  |
| `spring.devtools.restart.additional-paths` | Additional paths to watch for changes. |  |
| `spring.devtools.restart.enabled` | Whether to enable automatic restart. | `true` |
| `spring.devtools.restart.exclude` | Patterns that should be excluded from triggering a full restart. | `META-INF/maven/**,META-INF/resources/**,resources/**,static/**,public/**,templates/**,**/*Test.class,**/*Tests.class,git.properties,META-INF/build-info.properties` |
| `spring.devtools.restart.log-condition-evaluation-delta` | Whether to log the condition evaluation delta upon restart. | `true` |
| `spring.devtools.restart.poll-interval` | Amount of time to wait between polling for classpath changes. | `1s` |
| `spring.devtools.restart.quiet-period` | Amount of quiet time required without any classpath changes before a restart is triggered. | `400ms` |
| `spring.devtools.restart.trigger-file` | Name of a specific file that, when changed, triggers the restart check. Must be a simple name (without any path) of a file that appears on your classpath. If not specified, any classpath file change triggers the restart. |  |

## Docker Compose Properties (18 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `spring.docker.compose.arguments` | Arguments to pass to the Docker Compose command. |  |
| `spring.docker.compose.enabled` | Whether Docker Compose support is enabled. | `true` |
| `spring.docker.compose.file` | Paths to the Docker Compose configuration files. |  |
| `spring.docker.compose.host` | Hostname or IP of the machine where the docker containers are started. |  |
| `spring.docker.compose.lifecycle-management` | Docker compose lifecycle management. | `start-and-stop` |
| `spring.docker.compose.profiles.active` | Docker compose profiles that should be active. |  |
| `spring.docker.compose.readiness.tcp.connect-timeout` | Timeout for connections. | `200ms` |
| `spring.docker.compose.readiness.tcp.read-timeout` | Timeout for reads. | `200ms` |
| `spring.docker.compose.readiness.timeout` | Timeout of the readiness checks. | `2m` |
| `spring.docker.compose.readiness.wait` | Wait strategy to use. | `always` |
| `spring.docker.compose.skip.in-tests` | Whether to skip in tests. | `true` |
| `spring.docker.compose.start.arguments` | Arguments to pass to the start command. |  |
| `spring.docker.compose.start.command` | Command used to start Docker Compose. | `up` |
| `spring.docker.compose.start.log-level` | Log level for output. | `info` |
| `spring.docker.compose.start.skip` | Whether to skip executing the start command. | `if-running` |
| `spring.docker.compose.stop.arguments` | Arguments to pass to the stop command. |  |
| `spring.docker.compose.stop.command` | Command used to stop Docker Compose. | `stop` |
| `spring.docker.compose.stop.timeout` | Timeout for stopping Docker Compose. Use '0' for forced stop. | `10s` |

## Integration Properties (397 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `spring.activemq.broker-url` | URL of the ActiveMQ broker. Auto-generated by default. |  |
| `spring.activemq.close-timeout` | Time to wait before considering a close complete. | `15s` |
| `spring.activemq.embedded.enabled` | Whether to enable embedded mode if the ActiveMQ Broker is available. | `true` |
| `spring.activemq.non-blocking-redelivery` | Whether to stop message delivery before re-delivering messages from a rolled back transaction. This implies that message order is not preserved when this is enabled. | `false` |
| `spring.activemq.packages.trust-all` | Whether to trust all packages. |  |
| `spring.activemq.packages.trusted` | List of specific packages to trust (when not trusting all packages). |  |
| `spring.activemq.password` | Login password of the broker. |  |
| `spring.activemq.pool.block-if-full` | Whether to block when a connection is requested and the pool is full. Set it to false to throw a "JMSException" instead. | `true` |
| `spring.activemq.pool.block-if-full-timeout` | Blocking period before throwing an exception if the pool is still full. | `-1ms` |
| `spring.activemq.pool.enabled` | Whether a JmsPoolConnectionFactory should be created, instead of a regular ConnectionFactory. | `false` |
| `spring.activemq.pool.idle-timeout` | Connection idle timeout. | `30s` |
| `spring.activemq.pool.max-connections` | Maximum number of pooled connections. | `1` |
| `spring.activemq.pool.max-sessions-per-connection` | Maximum number of pooled sessions per connection in the pool. | `500` |
| `spring.activemq.pool.time-between-expiration-check` | Time to sleep between runs of the idle connection eviction thread. When negative, no idle connection eviction thread runs. | `-1ms` |
| `spring.activemq.pool.use-anonymous-producers` | Whether to use only one anonymous "MessageProducer" instance. Set it to false to create one "MessageProducer" every time one is required. | `true` |
| `spring.activemq.send-timeout` | Time to wait on message sends for a response. Set it to 0 to wait forever. | `0ms` |
| `spring.activemq.user` | Login user of the broker. |  |
| `spring.artemis.broker-url` | Artemis broker url. | `tcp://localhost:61616` |
| `spring.artemis.embedded.cluster-password` | Cluster password. Randomly generated on startup by default. |  |
| `spring.artemis.embedded.data-directory` | Journal file directory. Not necessary if persistence is turned off. |  |
| `spring.artemis.embedded.enabled` | Whether to enable embedded mode if the Artemis server APIs are available. | `true` |
| `spring.artemis.embedded.persistent` | Whether to enable persistent store. | `false` |
| `spring.artemis.embedded.queues` | List of queues to create on startup. | `[]` |
| `spring.artemis.embedded.server-id` | Server ID. By default, an auto-incremented counter is used. |  |
| `spring.artemis.embedded.topics` | List of topics to create on startup. | `[]` |
| `spring.artemis.mode` | Artemis deployment mode, auto-detected by default. |  |
| `spring.artemis.password` | Login password of the broker. |  |
| `spring.artemis.pool.block-if-full` | Whether to block when a connection is requested and the pool is full. Set it to false to throw a "JMSException" instead. | `true` |
| `spring.artemis.pool.block-if-full-timeout` | Blocking period before throwing an exception if the pool is still full. | `-1ms` |
| `spring.artemis.pool.enabled` | Whether a JmsPoolConnectionFactory should be created, instead of a regular ConnectionFactory. | `false` |
| `spring.artemis.pool.idle-timeout` | Connection idle timeout. | `30s` |
| `spring.artemis.pool.max-connections` | Maximum number of pooled connections. | `1` |
| `spring.artemis.pool.max-sessions-per-connection` | Maximum number of pooled sessions per connection in the pool. | `500` |
| `spring.artemis.pool.time-between-expiration-check` | Time to sleep between runs of the idle connection eviction thread. When negative, no idle connection eviction thread runs. | `-1ms` |
| `spring.artemis.pool.use-anonymous-producers` | Whether to use only one anonymous "MessageProducer" instance. Set it to false to create one "MessageProducer" every time one is required. | `true` |
| `spring.artemis.user` | Login user of the broker. |  |
| `spring.batch.jdbc.continue-on-error` | Whether initialization should continue when an error occurs when applying a schema script. | `true` |
| `spring.batch.jdbc.initialize-schema` | Database schema initialization mode. | `embedded` |
| `spring.batch.jdbc.isolation-level-for-create` | Transaction isolation level to use when creating job meta-data for new jobs. |  |
| `spring.batch.jdbc.platform` | Platform to use in initialization scripts if the @@platform@@ placeholder is used. Auto-detected by default. |  |
| `spring.batch.jdbc.schema` | Path to the SQL file to use to initialize the database schema. |  |
| `spring.batch.jdbc.table-prefix` | Table prefix for all the batch meta-data tables. |  |
| `spring.batch.jdbc.validate-transaction-state` | Whether to validate the transaction state. | `true` |
| `spring.batch.job.enabled` | Whether to execute a Spring Batch job on startup. When multiple jobs are present in the context, set spring.batch.job.name to identify the job to execute. | `true` |
| `spring.batch.job.name` | Job name to execute on startup. Must be specified if multiple Jobs are found in the context. |  |
| `spring.hazelcast.config` | The location of the configuration file to use to initialize Hazelcast. |  |
| `spring.integration.channel.auto-create` | Whether to create input channels if necessary. | `true` |
| `spring.integration.channel.max-broadcast-subscribers` | Default number of subscribers allowed on, for example, a 'PublishSubscribeChannel'. |  |
| `spring.integration.channel.max-unicast-subscribers` | Default number of subscribers allowed on, for example, a 'DirectChannel'. |  |
| `spring.integration.endpoint.default-timeout` | Default timeout for blocking operations such as sending or receiving messages. | `30s` |
| `spring.integration.endpoint.no-auto-startup` | List of endpoint bean names patterns that should not be started automatically during application startup. |  |
| `spring.integration.endpoint.read-only-headers` | List of message header names that should not be populated into Message instances during a header copying operation. |  |
| `spring.integration.endpoint.throw-exception-on-late-reply` | Whether to throw an exception when a reply is not expected anymore by a gateway. | `false` |
| `spring.integration.error.ignore-failures` | Whether to ignore failures for one or more of the handlers of the global 'errorChannel'. | `true` |
| `spring.integration.error.require-subscribers` | Whether to not silently ignore messages on the global 'errorChannel' when there are no subscribers. | `true` |
| `spring.integration.jdbc.continue-on-error` | Whether initialization should continue when an error occurs when applying a schema script. | `true` |
| `spring.integration.jdbc.initialize-schema` | Database schema initialization mode. | `embedded` |
| `spring.integration.jdbc.platform` | Platform to use in initialization scripts if the @@platform@@ placeholder is used. Auto-detected by default. |  |
| `spring.integration.jdbc.schema` | Path to the SQL file to use to initialize the database schema. |  |
| `spring.integration.management.default-logging-enabled` | Whether Spring Integration components should perform logging in the main message flow. When disabled, such logging will be skipped without checking the logging level. When enabled, such logging is controlled as normal by the logging system's log level configuration. | `true` |
| `spring.integration.management.observation-patterns` | List of simple patterns to match against the names of Spring Integration components. When matched, observation instrumentation will be performed for the component. Please refer to the javadoc of the smartMatch method of Spring Integration's PatternMatchUtils for details of the pattern syntax. |  |
| `spring.integration.poller.cron` | Cron expression for polling. Mutually exclusive with 'fixedDelay' and 'fixedRate'. |  |
| `spring.integration.poller.fixed-delay` | Polling delay period. Mutually exclusive with 'cron' and 'fixedRate'. |  |
| `spring.integration.poller.fixed-rate` | Polling rate period. Mutually exclusive with 'fixedDelay' and 'cron'. |  |
| `spring.integration.poller.initial-delay` | Polling initial delay. Applied for 'fixedDelay' and 'fixedRate'; ignored for 'cron'. |  |
| `spring.integration.poller.max-messages-per-poll` | Maximum number of messages to poll per polling cycle. |  |
| `spring.integration.poller.receive-timeout` | How long to wait for messages on poll. | `1s` |
| `spring.integration.rsocket.client.host` | TCP RSocket server host to connect to. |  |
| `spring.integration.rsocket.client.port` | TCP RSocket server port to connect to. |  |
| `spring.integration.rsocket.client.uri` | WebSocket RSocket server uri to connect to. |  |
| `spring.integration.rsocket.server.message-mapping-enabled` | Whether to handle message mapping for RSocket through Spring Integration. | `false` |
| `spring.jms.cache.consumers` | Whether to cache message consumers. | `false` |
| `spring.jms.cache.enabled` | Whether to cache sessions. | `true` |
| `spring.jms.cache.producers` | Whether to cache message producers. | `true` |
| `spring.jms.cache.session-cache-size` | Size of the session cache (per JMS Session type). | `1` |
| `spring.jms.client-id` | Client id of the connection. |  |
| `spring.jms.jndi-name` | Connection factory JNDI name. When set, takes precedence to others connection factory auto-configurations. |  |
| `spring.jms.listener.auto-startup` | Start the container automatically on startup. | `true` |
| `spring.jms.listener.max-concurrency` | Maximum number of concurrent consumers. |  |
| `spring.jms.listener.max-messages-per-task` | Maximum number of messages to process in one task. By default, unlimited unless a SchedulingTaskExecutor is configured on the listener (10 messages), as it indicates a preference for short-lived tasks. |  |
| `spring.jms.listener.min-concurrency` | Minimum number of concurrent consumers. When max-concurrency is not specified the minimum will also be used as the maximum. |  |
| `spring.jms.listener.receive-timeout` | Timeout to use for receive calls. Use -1 for a no-wait receive or 0 for no timeout at all. The latter is only feasible if not running within a transaction manager and is generally discouraged since it prevents clean shutdown. | `1s` |
| `spring.jms.listener.session.acknowledge-mode` | Acknowledge mode of the listener container. | `auto` |
| `spring.jms.listener.session.transacted` | Whether the listener container should use transacted JMS sessions. Defaults to false in the presence of a JtaTransactionManager and true otherwise. |  |
| `spring.jms.pub-sub-domain` | Whether the default destination type is topic. | `false` |
| `spring.jms.subscription-durable` | Whether the subscription is durable. | `false` |
| `spring.jms.template.default-destination` | Default destination to use on send and receive operations that do not have a destination parameter. |  |
| `spring.jms.template.delivery-delay` | Delivery delay to use for send calls. |  |
| `spring.jms.template.delivery-mode` | Delivery mode. Enables QoS (Quality of Service) when set. |  |
| `spring.jms.template.priority` | Priority of a message when sending. Enables QoS (Quality of Service) when set. |  |
| `spring.jms.template.qos-enabled` | Whether to enable explicit QoS (Quality of Service) when sending a message. When enabled, the delivery mode, priority and time-to-live properties will be used when sending a message. QoS is automatically enabled when at least one of those settings is customized. |  |
| `spring.jms.template.receive-timeout` | Timeout to use for receive calls. |  |
| `spring.jms.template.session.acknowledge-mode` | Acknowledge mode used when creating sessions. | `auto` |
| `spring.jms.template.session.transacted` | Whether to use transacted sessions. | `false` |
| `spring.jms.template.time-to-live` | Time-to-live of a message when sending. Enables QoS (Quality of Service) when set. |  |
| `spring.kafka.admin.auto-create` | Whether to automatically create topics during context initialization. When set to false, disables automatic topic creation during context initialization. | `true` |
| `spring.kafka.admin.client-id` | ID to pass to the server when making requests. Used for server-side logging. |  |
| `spring.kafka.admin.close-timeout` | Close timeout. |  |
| `spring.kafka.admin.fail-fast` | Whether to fail fast if the broker is not available on startup. | `false` |
| `spring.kafka.admin.modify-topic-configs` | Whether to enable modification of existing topic configuration. | `false` |
| `spring.kafka.admin.operation-timeout` | Operation timeout. |  |
| `spring.kafka.admin.properties.*` | Additional admin-specific properties used to configure the client. |  |
| `spring.kafka.admin.security.protocol` | Security protocol used to communicate with brokers. |  |
| `spring.kafka.admin.ssl.bundle` | Name of the SSL bundle to use. |  |
| `spring.kafka.admin.ssl.key-password` | Password of the private key in either key store key or key store file. |  |
| `spring.kafka.admin.ssl.key-store-certificate-chain` | Certificate chain in PEM format with a list of X.509 certificates. |  |
| `spring.kafka.admin.ssl.key-store-key` | Private key in PEM format with PKCS#8 keys. |  |
| `spring.kafka.admin.ssl.key-store-location` | Location of the key store file. |  |
| `spring.kafka.admin.ssl.key-store-password` | Store password for the key store file. |  |
| `spring.kafka.admin.ssl.key-store-type` | Type of the key store. |  |
| `spring.kafka.admin.ssl.protocol` | SSL protocol to use. |  |
| `spring.kafka.admin.ssl.trust-store-certificates` | Trusted certificates in PEM format with X.509 certificates. |  |
| `spring.kafka.admin.ssl.trust-store-location` | Location of the trust store file. |  |
| `spring.kafka.admin.ssl.trust-store-password` | Store password for the trust store file. |  |
| `spring.kafka.admin.ssl.trust-store-type` | Type of the trust store. |  |
| `spring.kafka.bootstrap-servers` | List of host:port pairs to use for establishing the initial connections to the Kafka cluster. Applies to all components unless overridden. |  |
| `spring.kafka.client-id` | ID to pass to the server when making requests. Used for server-side logging. |  |
| `spring.kafka.consumer.auto-commit-interval` | Frequency with which the consumer offsets are auto-committed to Kafka if 'enable.auto.commit' is set to true. |  |
| `spring.kafka.consumer.auto-offset-reset` | What to do when there is no initial offset in Kafka or if the current offset no longer exists on the server. |  |
| `spring.kafka.consumer.bootstrap-servers` | List of host:port pairs to use for establishing the initial connections to the Kafka cluster. Overrides the global property, for consumers. |  |
| `spring.kafka.consumer.client-id` | ID to pass to the server when making requests. Used for server-side logging. |  |
| `spring.kafka.consumer.enable-auto-commit` | Whether the consumer's offset is periodically committed in the background. |  |
| `spring.kafka.consumer.fetch-max-wait` | Maximum amount of time the server blocks before answering the fetch request if there isn't sufficient data to immediately satisfy the requirement given by "fetch-min-size". |  |
| `spring.kafka.consumer.fetch-min-size` | Minimum amount of data the server should return for a fetch request. |  |
| `spring.kafka.consumer.group-id` | Unique string that identifies the consumer group to which this consumer belongs. |  |
| `spring.kafka.consumer.heartbeat-interval` | Expected time between heartbeats to the consumer coordinator. |  |
| `spring.kafka.consumer.isolation-level` | Isolation level for reading messages that have been written transactionally. | `read-uncommitted` |
| `spring.kafka.consumer.key-deserializer` | Deserializer class for keys. |  |
| `spring.kafka.consumer.max-poll-interval` | Maximum delay between invocations of poll() when using consumer group management. |  |
| `spring.kafka.consumer.max-poll-records` | Maximum number of records returned in a single call to poll(). |  |
| `spring.kafka.consumer.properties.*` | Additional consumer-specific properties used to configure the client. |  |
| `spring.kafka.consumer.security.protocol` | Security protocol used to communicate with brokers. |  |
| `spring.kafka.consumer.ssl.bundle` | Name of the SSL bundle to use. |  |
| `spring.kafka.consumer.ssl.key-password` | Password of the private key in either key store key or key store file. |  |
| `spring.kafka.consumer.ssl.key-store-certificate-chain` | Certificate chain in PEM format with a list of X.509 certificates. |  |
| `spring.kafka.consumer.ssl.key-store-key` | Private key in PEM format with PKCS#8 keys. |  |
| `spring.kafka.consumer.ssl.key-store-location` | Location of the key store file. |  |
| `spring.kafka.consumer.ssl.key-store-password` | Store password for the key store file. |  |
| `spring.kafka.consumer.ssl.key-store-type` | Type of the key store. |  |
| `spring.kafka.consumer.ssl.protocol` | SSL protocol to use. |  |
| `spring.kafka.consumer.ssl.trust-store-certificates` | Trusted certificates in PEM format with X.509 certificates. |  |
| `spring.kafka.consumer.ssl.trust-store-location` | Location of the trust store file. |  |
| `spring.kafka.consumer.ssl.trust-store-password` | Store password for the trust store file. |  |
| `spring.kafka.consumer.ssl.trust-store-type` | Type of the trust store. |  |
| `spring.kafka.consumer.value-deserializer` | Deserializer class for values. |  |
| `spring.kafka.jaas.control-flag` | Control flag for login configuration. | `required` |
| `spring.kafka.jaas.enabled` | Whether to enable JAAS configuration. | `false` |
| `spring.kafka.jaas.login-module` | Login module. | `com.sun.security.auth.module.Krb5LoginModule` |
| `spring.kafka.jaas.options.*` | Additional JAAS options. |  |
| `spring.kafka.listener.ack-count` | Number of records between offset commits when ackMode is "COUNT" or "COUNT_TIME". |  |
| `spring.kafka.listener.ack-mode` | Listener AckMode. See the spring-kafka documentation. |  |
| `spring.kafka.listener.ack-time` | Time between offset commits when ackMode is "TIME" or "COUNT_TIME". |  |
| `spring.kafka.listener.async-acks` | Support for asynchronous record acknowledgements. Only applies when spring.kafka.listener.ack-mode is manual or manual-immediate. |  |
| `spring.kafka.listener.auth-exception-retry-interval` | Time between retries after authentication exceptions. |  |
| `spring.kafka.listener.auto-startup` | Whether to auto start the container. | `true` |
| `spring.kafka.listener.change-consumer-thread-name` | Whether to instruct the container to change the consumer thread name during initialization. |  |
| `spring.kafka.listener.client-id` | Prefix for the listener's consumer client.id property. |  |
| `spring.kafka.listener.concurrency` | Number of threads to run in the listener containers. |  |
| `spring.kafka.listener.idle-between-polls` | Sleep interval between Consumer.poll(Duration) calls. | `0` |
| `spring.kafka.listener.idle-event-interval` | Time between publishing idle consumer events (no data received). |  |
| `spring.kafka.listener.idle-partition-event-interval` | Time between publishing idle partition consumer events (no data received for partition). |  |
| `spring.kafka.listener.immediate-stop` | Whether the container stops after the current record is processed or after all the records from the previous poll are processed. | `false` |
| `spring.kafka.listener.log-container-config` | Whether to log the container configuration during initialization (INFO level). |  |
| `spring.kafka.listener.missing-topics-fatal` | Whether the container should fail to start if at least one of the configured topics are not present on the broker. | `false` |
| `spring.kafka.listener.monitor-interval` | Time between checks for non-responsive consumers. If a duration suffix is not specified, seconds will be used. |  |
| `spring.kafka.listener.no-poll-threshold` | Multiplier applied to "pollTimeout" to determine if a consumer is non-responsive. |  |
| `spring.kafka.listener.observation-enabled` | Whether to enable observation. | `false` |
| `spring.kafka.listener.poll-timeout` | Timeout to use when polling the consumer. |  |
| `spring.kafka.listener.type` | Listener type. | `single` |
| `spring.kafka.producer.acks` | Number of acknowledgments the producer requires the leader to have received before considering a request complete. |  |
| `spring.kafka.producer.batch-size` | Default batch size. A small batch size will make batching less common and may reduce throughput (a batch size of zero disables batching entirely). |  |
| `spring.kafka.producer.bootstrap-servers` | List of host:port pairs to use for establishing the initial connections to the Kafka cluster. Overrides the global property, for producers. |  |
| `spring.kafka.producer.buffer-memory` | Total memory size the producer can use to buffer records waiting to be sent to the server. |  |
| `spring.kafka.producer.client-id` | ID to pass to the server when making requests. Used for server-side logging. |  |
| `spring.kafka.producer.compression-type` | Compression type for all data generated by the producer. |  |
| `spring.kafka.producer.key-serializer` | Serializer class for keys. |  |
| `spring.kafka.producer.properties.*` | Additional producer-specific properties used to configure the client. |  |
| `spring.kafka.producer.retries` | When greater than zero, enables retrying of failed sends. |  |
| `spring.kafka.producer.security.protocol` | Security protocol used to communicate with brokers. |  |
| `spring.kafka.producer.ssl.bundle` | Name of the SSL bundle to use. |  |
| `spring.kafka.producer.ssl.key-password` | Password of the private key in either key store key or key store file. |  |
| `spring.kafka.producer.ssl.key-store-certificate-chain` | Certificate chain in PEM format with a list of X.509 certificates. |  |
| `spring.kafka.producer.ssl.key-store-key` | Private key in PEM format with PKCS#8 keys. |  |
| `spring.kafka.producer.ssl.key-store-location` | Location of the key store file. |  |
| `spring.kafka.producer.ssl.key-store-password` | Store password for the key store file. |  |
| `spring.kafka.producer.ssl.key-store-type` | Type of the key store. |  |
| `spring.kafka.producer.ssl.protocol` | SSL protocol to use. |  |
| `spring.kafka.producer.ssl.trust-store-certificates` | Trusted certificates in PEM format with X.509 certificates. |  |
| `spring.kafka.producer.ssl.trust-store-location` | Location of the trust store file. |  |
| `spring.kafka.producer.ssl.trust-store-password` | Store password for the trust store file. |  |
| `spring.kafka.producer.ssl.trust-store-type` | Type of the trust store. |  |
| `spring.kafka.producer.transaction-id-prefix` | When non empty, enables transaction support for producer. |  |
| `spring.kafka.producer.value-serializer` | Serializer class for values. |  |
| `spring.kafka.properties.*` | Additional properties, common to producers and consumers, used to configure the client. |  |
| `spring.kafka.retry.topic.attempts` | Total number of processing attempts made before sending the message to the DLT. | `3` |
| `spring.kafka.retry.topic.backoff.delay` | Base delay after the initial invocation. Can be combined with a "multiplier" to use an exponential back off strategy. | `1s` |
| `spring.kafka.retry.topic.backoff.jitter` | Jitter value for the base retry attempt, randomly subtracted or added to the calculated delay, resulting in a value between 'delay - jitter' and 'delay + jitter' but never below the base delay or above the max delay. | `0` |
| `spring.kafka.retry.topic.backoff.max-delay` | Maximum delay for any retry attempt, limiting how far jitter and the multiplier can increase the delay. | `30s` |
| `spring.kafka.retry.topic.backoff.multiplier` | Multiplier for a delay for the next retry attempt, applied to the previous delay, starting with the initial delay as well as to the applicable jitter for each attempt. Fixed delay by default. | `1` |
| `spring.kafka.retry.topic.enabled` | Whether to enable topic-based non-blocking retries. | `false` |
| `spring.kafka.security.protocol` | Security protocol used to communicate with brokers. |  |
| `spring.kafka.ssl.bundle` | Name of the SSL bundle to use. |  |
| `spring.kafka.ssl.key-password` | Password of the private key in either key store key or key store file. |  |
| `spring.kafka.ssl.key-store-certificate-chain` | Certificate chain in PEM format with a list of X.509 certificates. |  |
| `spring.kafka.ssl.key-store-key` | Private key in PEM format with PKCS#8 keys. |  |
| `spring.kafka.ssl.key-store-location` | Location of the key store file. |  |
| `spring.kafka.ssl.key-store-password` | Store password for the key store file. |  |
| `spring.kafka.ssl.key-store-type` | Type of the key store. |  |
| `spring.kafka.ssl.protocol` | SSL protocol to use. |  |
| `spring.kafka.ssl.trust-store-certificates` | Trusted certificates in PEM format with X.509 certificates. |  |
| `spring.kafka.ssl.trust-store-location` | Location of the trust store file. |  |
| `spring.kafka.ssl.trust-store-password` | Store password for the trust store file. |  |
| `spring.kafka.ssl.trust-store-type` | Type of the trust store. |  |
| `spring.kafka.streams.application-id` | Kafka streams application.id property; default spring.application.name. |  |
| `spring.kafka.streams.auto-startup` | Whether to auto-start the streams factory bean. | `true` |
| `spring.kafka.streams.bootstrap-servers` | List of host:port pairs to use for establishing the initial connections to the Kafka cluster. Overrides the global property, for streams. |  |
| `spring.kafka.streams.cleanup.on-shutdown` | Cleanup the application’s local state directory on shutdown. | `false` |
| `spring.kafka.streams.cleanup.on-startup` | Cleanup the application’s local state directory on startup. | `false` |
| `spring.kafka.streams.client-id` | ID to pass to the server when making requests. Used for server-side logging. |  |
| `spring.kafka.streams.properties.*` | Additional Kafka properties used to configure the streams. |  |
| `spring.kafka.streams.replication-factor` | The replication factor for change log topics and repartition topics created by the stream processing application. |  |
| `spring.kafka.streams.security.protocol` | Security protocol used to communicate with brokers. |  |
| `spring.kafka.streams.ssl.bundle` | Name of the SSL bundle to use. |  |
| `spring.kafka.streams.ssl.key-password` | Password of the private key in either key store key or key store file. |  |
| `spring.kafka.streams.ssl.key-store-certificate-chain` | Certificate chain in PEM format with a list of X.509 certificates. |  |
| `spring.kafka.streams.ssl.key-store-key` | Private key in PEM format with PKCS#8 keys. |  |
| `spring.kafka.streams.ssl.key-store-location` | Location of the key store file. |  |
| `spring.kafka.streams.ssl.key-store-password` | Store password for the key store file. |  |
| `spring.kafka.streams.ssl.key-store-type` | Type of the key store. |  |
| `spring.kafka.streams.ssl.protocol` | SSL protocol to use. |  |
| `spring.kafka.streams.ssl.trust-store-certificates` | Trusted certificates in PEM format with X.509 certificates. |  |
| `spring.kafka.streams.ssl.trust-store-location` | Location of the trust store file. |  |
| `spring.kafka.streams.ssl.trust-store-password` | Store password for the trust store file. |  |
| `spring.kafka.streams.ssl.trust-store-type` | Type of the trust store. |  |
| `spring.kafka.streams.state-dir` | Directory location for the state store. |  |
| `spring.kafka.streams.state-store-cache-max-size` | Maximum size of the in-memory state store cache across all threads. |  |
| `spring.kafka.template.default-topic` | Default topic to which messages are sent. |  |
| `spring.kafka.template.observation-enabled` | Whether to enable observation. | `false` |
| `spring.kafka.template.transaction-id-prefix` | Transaction id prefix, override the transaction id prefix in the producer factory. |  |
| `spring.pulsar.admin.authentication.param.*` | Authentication parameter(s) as a map of parameter names to parameter values. |  |
| `spring.pulsar.admin.authentication.plugin-class-name` | Fully qualified class name of the authentication plugin. |  |
| `spring.pulsar.admin.connection-timeout` | Duration to wait for a connection to server to be established. | `1m` |
| `spring.pulsar.admin.read-timeout` | Server response read time out for any request. | `1m` |
| `spring.pulsar.admin.request-timeout` | Server request time out for any request. | `5m` |
| `spring.pulsar.admin.service-url` | Pulsar web URL for the admin endpoint in the format '(http\|https)://host:port'. | `http://localhost:8080` |
| `spring.pulsar.client.authentication.param.*` | Authentication parameter(s) as a map of parameter names to parameter values. |  |
| `spring.pulsar.client.authentication.plugin-class-name` | Fully qualified class name of the authentication plugin. |  |
| `spring.pulsar.client.connection-timeout` | Duration to wait for a connection to a broker to be established. | `10s` |
| `spring.pulsar.client.failover.backup-clusters` | List of backup clusters. The backup cluster is chosen in the sequence of the given list. If all backup clusters are available, the Pulsar client chooses the first backup cluster. |  |
| `spring.pulsar.client.failover.check-interval` | Frequency of performing a probe task. |  |
| `spring.pulsar.client.failover.delay` | Delay before the Pulsar client switches from the primary cluster to the backup cluster. |  |
| `spring.pulsar.client.failover.policy` | Cluster failover policy. | `order` |
| `spring.pulsar.client.failover.switch-back-delay` | Delay before the Pulsar client switches from the backup cluster to the primary cluster. |  |
| `spring.pulsar.client.lookup-timeout` | Client lookup timeout. |  |
| `spring.pulsar.client.operation-timeout` | Client operation timeout. | `30s` |
| `spring.pulsar.client.service-url` | Pulsar service URL in the format '(pulsar\|pulsar+ssl)://host:port'. | `pulsar://localhost:6650` |
| `spring.pulsar.client.threads.io` | Number of threads to be used for handling connections to brokers. |  |
| `spring.pulsar.client.threads.listener` | Number of threads to be used for message listeners. |  |
| `spring.pulsar.consumer.dead-letter-policy.dead-letter-topic` | Name of the dead topic where the failing messages will be sent. |  |
| `spring.pulsar.consumer.dead-letter-policy.initial-subscription-name` | Name of the initial subscription of the dead letter topic. When not set, the initial subscription will not be created. However, when the property is set then the broker's 'allowAutoSubscriptionCreation' must be enabled or the DLQ producer will fail. |  |
| `spring.pulsar.consumer.dead-letter-policy.max-redeliver-count` | Maximum number of times that a message will be redelivered before being sent to the dead letter queue. | `0` |
| `spring.pulsar.consumer.dead-letter-policy.retry-letter-topic` | Name of the retry topic where the failing messages will be sent. |  |
| `spring.pulsar.consumer.name` | Consumer name to identify a particular consumer from the topic stats. |  |
| `spring.pulsar.consumer.priority-level` | Priority level for shared subscription consumers. | `0` |
| `spring.pulsar.consumer.read-compacted` | Whether to read messages from the compacted topic rather than the full message backlog. | `false` |
| `spring.pulsar.consumer.retry-enable` | Whether to auto retry messages. | `false` |
| `spring.pulsar.consumer.subscription.initial-position` | Position where to initialize a newly created subscription. | `latest` |
| `spring.pulsar.consumer.subscription.mode` | Subscription mode to be used when subscribing to the topic. | `durable` |
| `spring.pulsar.consumer.subscription.name` | Subscription name for the consumer. |  |
| `spring.pulsar.consumer.subscription.topics-mode` | Determines which type of topics (persistent, non-persistent, or all) the consumer should be subscribed to when using pattern subscriptions. | `persistentonly` |
| `spring.pulsar.consumer.subscription.type` | Subscription type to be used when subscribing to a topic. | `exclusive` |
| `spring.pulsar.consumer.topics` | Topics the consumer subscribes to. |  |
| `spring.pulsar.consumer.topics-pattern` | Pattern for topics the consumer subscribes to. |  |
| `spring.pulsar.defaults.topic.enabled` | Whether to enable default tenant and namespace support for topics. | `true` |
| `spring.pulsar.defaults.topic.namespace` | Default namespace to use when producing or consuming messages against a non-fully-qualified topic URL. | `default` |
| `spring.pulsar.defaults.topic.tenant` | Default tenant to use when producing or consuming messages against a non-fully-qualified topic URL. | `public` |
| `spring.pulsar.defaults.type-mappings` | List of mappings from message type to topic name and schema info to use as a defaults when a topic name and/or schema is not explicitly specified when producing or consuming messages of the mapped type. |  |
| `spring.pulsar.function.enabled` | Whether to enable function support. | `true` |
| `spring.pulsar.function.fail-fast` | Whether to stop processing further function creates/updates when a failure occurs. | `true` |
| `spring.pulsar.function.propagate-failures` | Whether to throw an exception if any failure is encountered during server startup while creating/updating functions. | `true` |
| `spring.pulsar.function.propagate-stop-failures` | Whether to throw an exception if any failure is encountered during server shutdown while enforcing stop policy on functions. | `false` |
| `spring.pulsar.listener.concurrency` | Number of threads used by listener container. |  |
| `spring.pulsar.listener.observation-enabled` | Whether to record observations for when the Observations API is available and the client supports it. | `false` |
| `spring.pulsar.listener.schema-type` | SchemaType of the consumed messages. |  |
| `spring.pulsar.producer.access-mode` | Type of access to the topic the producer requires. | `shared` |
| `spring.pulsar.producer.batching-enabled` | Whether to automatically batch messages. | `true` |
| `spring.pulsar.producer.cache.enabled` | Whether to enable caching in the PulsarProducerFactory. | `true` |
| `spring.pulsar.producer.cache.expire-after-access` | Time period to expire unused entries in the cache. | `1m` |
| `spring.pulsar.producer.cache.initial-capacity` | Initial size of cache. | `50` |
| `spring.pulsar.producer.cache.maximum-size` | Maximum size of cache (entries). | `1000` |
| `spring.pulsar.producer.chunking-enabled` | Whether to split large-size messages into multiple chunks. | `false` |
| `spring.pulsar.producer.compression-type` | Message compression type. |  |
| `spring.pulsar.producer.hashing-scheme` | Message hashing scheme to choose the partition to which the message is published. | `javastringhash` |
| `spring.pulsar.producer.message-routing-mode` | Message routing mode for a partitioned producer. | `roundrobinpartition` |
| `spring.pulsar.producer.name` | Name for the producer. If not assigned, a unique name is generated. |  |
| `spring.pulsar.producer.send-timeout` | Time before a message has to be acknowledged by the broker. | `30s` |
| `spring.pulsar.producer.topic-name` | Topic the producer will publish to. |  |
| `spring.pulsar.reader.name` | Reader name. |  |
| `spring.pulsar.reader.read-compacted` | Whether to read messages from a compacted topic rather than a full message backlog of a topic. | `false` |
| `spring.pulsar.reader.subscription-name` | Subscription name. |  |
| `spring.pulsar.reader.subscription-role-prefix` | Prefix of subscription role. |  |
| `spring.pulsar.reader.topics` | Topics the reader subscribes to. |  |
| `spring.pulsar.template.observations-enabled` | Whether to record observations for when the Observations API is available. | `false` |
| `spring.pulsar.transaction.enabled` | Whether transaction support is enabled. | `false` |
| `spring.rabbitmq.address-shuffle-mode` | Mode used to shuffle configured addresses. | `none` |
| `spring.rabbitmq.addresses` | List of addresses to which the client should connect. When set, the host and port are ignored. |  |
| `spring.rabbitmq.cache.channel.checkout-timeout` | Duration to wait to obtain a channel if the cache size has been reached. If 0, always create a new channel. |  |
| `spring.rabbitmq.cache.channel.size` | Number of channels to retain in the cache. When "check-timeout" > 0, max channels per connection. |  |
| `spring.rabbitmq.cache.connection.mode` | Connection factory cache mode. | `channel` |
| `spring.rabbitmq.cache.connection.size` | Number of connections to cache. Only applies when mode is CONNECTION. |  |
| `spring.rabbitmq.channel-rpc-timeout` | Continuation timeout for RPC calls in channels. Set it to zero to wait forever. | `10m` |
| `spring.rabbitmq.connection-timeout` | Connection timeout. Set it to zero to wait forever. |  |
| `spring.rabbitmq.dynamic` | Whether to create an AmqpAdmin bean. | `true` |
| `spring.rabbitmq.host` | RabbitMQ host. Ignored if an address is set. | `localhost` |
| `spring.rabbitmq.listener.direct.acknowledge-mode` | Acknowledge mode of container. |  |
| `spring.rabbitmq.listener.direct.auto-startup` | Whether to start the container automatically on startup. | `true` |
| `spring.rabbitmq.listener.direct.consumers-per-queue` | Number of consumers per queue. |  |
| `spring.rabbitmq.listener.direct.de-batching-enabled` | Whether the container should present batched messages as discrete messages or call the listener with the batch. | `true` |
| `spring.rabbitmq.listener.direct.default-requeue-rejected` | Whether rejected deliveries are re-queued by default. |  |
| `spring.rabbitmq.listener.direct.force-stop` | Whether the container (when stopped) should stop immediately after processing the current message or stop after processing all pre-fetched messages. | `false` |
| `spring.rabbitmq.listener.direct.idle-event-interval` | How often idle container events should be published. |  |
| `spring.rabbitmq.listener.direct.missing-queues-fatal` | Whether to fail if the queues declared by the container are not available on the broker. | `false` |
| `spring.rabbitmq.listener.direct.observation-enabled` | Whether to enable observation. | `false` |
| `spring.rabbitmq.listener.direct.prefetch` | Maximum number of unacknowledged messages that can be outstanding at each consumer. |  |
| `spring.rabbitmq.listener.direct.retry.enabled` | Whether publishing retries are enabled. | `false` |
| `spring.rabbitmq.listener.direct.retry.initial-interval` | Duration between the first and second attempt to deliver a message. | `1000ms` |
| `spring.rabbitmq.listener.direct.retry.max-interval` | Maximum duration between attempts. | `10000ms` |
| `spring.rabbitmq.listener.direct.retry.max-retries` | Maximum number of retry attempts to deliver a message. | `3` |
| `spring.rabbitmq.listener.direct.retry.multiplier` | Multiplier to apply to the previous retry interval. | `1` |
| `spring.rabbitmq.listener.direct.retry.stateless` | Whether retries are stateless or stateful. | `true` |
| `spring.rabbitmq.listener.simple.acknowledge-mode` | Acknowledge mode of container. |  |
| `spring.rabbitmq.listener.simple.auto-startup` | Whether to start the container automatically on startup. | `true` |
| `spring.rabbitmq.listener.simple.batch-size` | Batch size, expressed as the number of physical messages, to be used by the container. |  |
| `spring.rabbitmq.listener.simple.concurrency` | Minimum number of listener invoker threads. |  |
| `spring.rabbitmq.listener.simple.consumer-batch-enabled` | Whether the container creates a batch of messages based on the 'receive-timeout' and 'batch-size'. Coerces 'de-batching-enabled' to true to include the contents of a producer created batch in the batch as discrete records. | `false` |
| `spring.rabbitmq.listener.simple.de-batching-enabled` | Whether the container should present batched messages as discrete messages or call the listener with the batch. | `true` |
| `spring.rabbitmq.listener.simple.default-requeue-rejected` | Whether rejected deliveries are re-queued by default. |  |
| `spring.rabbitmq.listener.simple.force-stop` | Whether the container (when stopped) should stop immediately after processing the current message or stop after processing all pre-fetched messages. | `false` |
| `spring.rabbitmq.listener.simple.idle-event-interval` | How often idle container events should be published. |  |
| `spring.rabbitmq.listener.simple.max-concurrency` | Maximum number of listener invoker threads. |  |
| `spring.rabbitmq.listener.simple.missing-queues-fatal` | Whether to fail if the queues declared by the container are not available on the broker and/or whether to stop the container if one or more queues are deleted at runtime. | `true` |
| `spring.rabbitmq.listener.simple.observation-enabled` | Whether to enable observation. | `false` |
| `spring.rabbitmq.listener.simple.prefetch` | Maximum number of unacknowledged messages that can be outstanding at each consumer. |  |
| `spring.rabbitmq.listener.simple.retry.enabled` | Whether publishing retries are enabled. | `false` |
| `spring.rabbitmq.listener.simple.retry.initial-interval` | Duration between the first and second attempt to deliver a message. | `1000ms` |
| `spring.rabbitmq.listener.simple.retry.max-interval` | Maximum duration between attempts. | `10000ms` |
| `spring.rabbitmq.listener.simple.retry.max-retries` | Maximum number of retry attempts to deliver a message. | `3` |
| `spring.rabbitmq.listener.simple.retry.multiplier` | Multiplier to apply to the previous retry interval. | `1` |
| `spring.rabbitmq.listener.simple.retry.stateless` | Whether retries are stateless or stateful. | `true` |
| `spring.rabbitmq.listener.stream.native-listener` | Whether the container will support listeners that consume native stream messages instead of Spring AMQP messages. | `false` |
| `spring.rabbitmq.listener.stream.observation-enabled` | Whether to enable observation. | `false` |
| `spring.rabbitmq.listener.type` | Listener container type. | `simple` |
| `spring.rabbitmq.max-inbound-message-body-size` | Maximum size of the body of inbound (received) messages. | `64MB` |
| `spring.rabbitmq.password` | Login to authenticate against the broker. | `guest` |
| `spring.rabbitmq.port` | RabbitMQ port. Ignored if an address is set. Default to 5672, or 5671 if SSL is enabled. |  |
| `spring.rabbitmq.publisher-confirm-type` | Type of publisher confirms to use. |  |
| `spring.rabbitmq.publisher-returns` | Whether to enable publisher returns. | `false` |
| `spring.rabbitmq.requested-channel-max` | Number of channels per connection requested by the client. Use 0 for unlimited. | `2047` |
| `spring.rabbitmq.requested-heartbeat` | Requested heartbeat timeout; zero for none. If a duration suffix is not specified, seconds will be used. |  |
| `spring.rabbitmq.ssl.algorithm` | SSL algorithm to use. By default, configured by the Rabbit client library. |  |
| `spring.rabbitmq.ssl.bundle` | SSL bundle name. |  |
| `spring.rabbitmq.ssl.enabled` | Whether to enable SSL support. Determined automatically if an address is provided with the protocol (amqp:// vs. amqps://). |  |
| `spring.rabbitmq.ssl.key-store` | Path to the key store that holds the SSL certificate. |  |
| `spring.rabbitmq.ssl.key-store-algorithm` | Key store algorithm. | `SunX509` |
| `spring.rabbitmq.ssl.key-store-password` | Password used to access the key store. |  |
| `spring.rabbitmq.ssl.key-store-type` | Key store type. | `PKCS12` |
| `spring.rabbitmq.ssl.trust-store` | Trust store that holds SSL certificates. |  |
| `spring.rabbitmq.ssl.trust-store-algorithm` | Trust store algorithm. | `SunX509` |
| `spring.rabbitmq.ssl.trust-store-password` | Password used to access the trust store. |  |
| `spring.rabbitmq.ssl.trust-store-type` | Trust store type. | `JKS` |
| `spring.rabbitmq.ssl.validate-server-certificate` | Whether to enable server side certificate validation. | `true` |
| `spring.rabbitmq.ssl.verify-hostname` | Whether to enable hostname verification. | `true` |
| `spring.rabbitmq.stream.host` | Host of a RabbitMQ instance with the Stream plugin enabled. | `localhost` |
| `spring.rabbitmq.stream.name` | Name of the stream. |  |
| `spring.rabbitmq.stream.password` | Login password to authenticate to the broker. When not set spring.rabbitmq.password is used. |  |
| `spring.rabbitmq.stream.port` | Stream port of a RabbitMQ instance with the Stream plugin enabled. |  |
| `spring.rabbitmq.stream.username` | Login user to authenticate to the broker. When not set, spring.rabbitmq.username is used. |  |
| `spring.rabbitmq.stream.virtual-host` | Virtual host of a RabbitMQ instance with the Stream plugin enabled. When not set, spring.rabbitmq.virtual-host is used. |  |
| `spring.rabbitmq.template.allowed-list-patterns` | Simple patterns for allowable packages/classes for deserialization. |  |
| `spring.rabbitmq.template.default-receive-queue` | Name of the default queue to receive messages from when none is specified explicitly. |  |
| `spring.rabbitmq.template.exchange` | Name of the default exchange to use for send operations. |  |
| `spring.rabbitmq.template.mandatory` | Whether to enable mandatory messages. |  |
| `spring.rabbitmq.template.observation-enabled` | Whether to enable observation. | `false` |
| `spring.rabbitmq.template.receive-timeout` | Timeout for receive() operations. |  |
| `spring.rabbitmq.template.reply-timeout` | Timeout for sendAndReceive() operations. |  |
| `spring.rabbitmq.template.retry.enabled` | Whether publishing retries are enabled. | `false` |
| `spring.rabbitmq.template.retry.initial-interval` | Duration between the first and second attempt to deliver a message. | `1000ms` |
| `spring.rabbitmq.template.retry.max-interval` | Maximum duration between attempts. | `10000ms` |
| `spring.rabbitmq.template.retry.max-retries` | Maximum number of retry attempts to deliver a message. | `3` |
| `spring.rabbitmq.template.retry.multiplier` | Multiplier to apply to the previous retry interval. | `1` |
| `spring.rabbitmq.template.routing-key` | Value of a default routing key to use for send operations. |  |
| `spring.rabbitmq.username` | Login user to authenticate to the broker. | `guest` |
| `spring.rabbitmq.virtual-host` | Virtual host to use when connecting to the broker. |  |
| `spring.webservices.path` | Path that serves as the base URI for the services. | `/services` |
| `spring.webservices.servlet.init.*` | Servlet init parameters to pass to Spring Web Services. |  |
| `spring.webservices.servlet.load-on-startup` | Load on startup priority of the Spring Web Services servlet. | `-1` |
| `spring.webservices.wsdl-locations` | Comma-separated list of locations of WSDLs and accompanying XSDs to be exposed as beans. |  |

## JSON Properties (48 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `spring.gson.date-format` | Format to use when serializing Date objects. |  |
| `spring.gson.disable-html-escaping` | Whether to disable the escaping of HTML characters such as '<', '>', etc. |  |
| `spring.gson.disable-inner-class-serialization` | Whether to exclude inner classes during serialization. |  |
| `spring.gson.enable-complex-map-key-serialization` | Whether to enable serialization of complex map keys (i.e. non-primitives). |  |
| `spring.gson.exclude-fields-without-expose-annotation` | Whether to exclude all fields from consideration for serialization or deserialization that do not have the "Expose" annotation. |  |
| `spring.gson.field-naming-policy` | Naming policy that should be applied to an object's field during serialization and deserialization. |  |
| `spring.gson.generate-non-executable-json` | Whether to generate non-executable JSON by prefixing the output with some special text. |  |
| `spring.gson.long-serialization-policy` | Serialization policy for Long and long types. |  |
| `spring.gson.pretty-printing` | Whether to output serialized JSON that fits in a page for pretty printing. |  |
| `spring.gson.serialize-nulls` | Whether to serialize null fields. |  |
| `spring.gson.strictness` | Sets how strictly the RFC 8259 specification will be enforced when reading and writing JSON. |  |
| `spring.jackson.cbor.read.*` | Jackson on/off token reader features that are specific to CBOR. |  |
| `spring.jackson.cbor.write.*` | Jackson on/off token writer features that are specific to CBOR. |  |
| `spring.jackson.constructor-detector` | Strategy to use to auto-detect constructor, and in particular behavior with single-argument constructors. | `default` |
| `spring.jackson.datatype.datetime.*` | Jackson on/off features for DateTimes. |  |
| `spring.jackson.datatype.enum.*` | Jackson on/off features for enums. |  |
| `spring.jackson.datatype.json-node.*` | Jackson on/off features for JsonNodes. |  |
| `spring.jackson.date-format` | Date format string or a fully-qualified date format class name. For instance, 'yyyy-MM-dd HH:mm:ss'. |  |
| `spring.jackson.default-leniency` | Global default setting (if any) for leniency. |  |
| `spring.jackson.default-property-inclusion` | Controls the inclusion of properties during serialization. Configured with one of the values in Jackson's JsonInclude.Include enumeration. |  |
| `spring.jackson.deserialization.*` | Jackson on/off features that affect the way Java objects are deserialized. |  |
| `spring.jackson.find-and-add-modules` | Whether to find and add modules to the auto-configured JsonMapper.Builder using MapperBuilder.findAndAddModules(ClassLoader). | `true` |
| `spring.jackson.json.read.*` | Jackson on/off token reader features that are specific to JSON. |  |
| `spring.jackson.json.write.*` | Jackson on/off token writer features that are specific to JSON. |  |
| `spring.jackson.locale` | Locale used for formatting. |  |
| `spring.jackson.mapper.*` | Jackson general purpose on/off features. |  |
| `spring.jackson.property-naming-strategy` | One of the constants on Jackson's PropertyNamingStrategies. Can also be a fully-qualified class name of a PropertyNamingStrategy implementation. |  |
| `spring.jackson.serialization.*` | Jackson on/off features that affect the way Java objects are serialized. |  |
| `spring.jackson.time-zone` | Time zone used when formatting dates. For instance, "America/Los_Angeles" or "GMT+10". |  |
| `spring.jackson.use-jackson2-defaults` | Whether to configure Jackson 3 with the same defaults as Spring Boot previously used for Jackson 2. | `false` |
| `spring.jackson.visibility.*` | Jackson visibility thresholds that can be used to limit which methods (and fields) are auto-detected. |  |
| `spring.jackson.xml.read.*` | Jackson on/off token reader features that are specific to XML. |  |
| `spring.jackson.xml.write.*` | Jackson on/off token writer features that are specific to XML. |  |
| `spring.kotlinx.serialization.json.allow-comments` | Whether to allow parser to accept C/Java-style comments in JSON input. | `false` |
| `spring.kotlinx.serialization.json.allow-special-floating-point-values` | Whether to remove the JSON specification restriction on special floating-point values such as 'NaN' and 'Infinity' and allow their serialization and deserialization as float literals without quotes. | `false` |
| `spring.kotlinx.serialization.json.allow-structured-map-keys` | Whether to allow structured objects to be serialized as map keys by changing the serialized form of the map from JSON object (key-value pairs) to flat array like [k1, v1, k2, v2]. | `false` |
| `spring.kotlinx.serialization.json.allow-trailing-comma` | Whether to allow parser to accept trailing commas in JSON objects and arrays. | `false` |
| `spring.kotlinx.serialization.json.class-discriminator` | Name of the class descriptor property for polymorphic serialization. | `type` |
| `spring.kotlinx.serialization.json.class-discriminator-mode` | Defines which classes and objects should have class discriminator added to the output. | `polymorphic` |
| `spring.kotlinx.serialization.json.coerce-input-values` | Whether to coerce incorrect JSON values. | `false` |
| `spring.kotlinx.serialization.json.decode-enums-case-insensitive` | Whether enum values are decoded in a case-insensitive manner. | `false` |
| `spring.kotlinx.serialization.json.encode-defaults` | Whether default values of Kotlin properties should be encoded. | `false` |
| `spring.kotlinx.serialization.json.explicit-nulls` | Whether null values should be encoded for nullable properties and must be present in JSON object during decoding. | `true` |
| `spring.kotlinx.serialization.json.ignore-unknown-keys` | Whether encounters of unknown properties in the input JSON should be ignored instead of throwing SerializationException. | `false` |
| `spring.kotlinx.serialization.json.lenient` | Whether parser should operate in lenient mode, removing the JSON specification restriction (RFC-4627) and being more liberal to malformed input. | `false` |
| `spring.kotlinx.serialization.json.naming-strategy` | Specifies JsonNamingStrategy that should be used for all properties in classes for serialization and deserialization. |  |
| `spring.kotlinx.serialization.json.pretty-print` | Whether resulting JSON should be pretty-printed. | `false` |
| `spring.kotlinx.serialization.json.use-alternative-names` | Whether Json instance makes use of JsonNames annotation. | `true` |

## Mail Properties (14 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `spring.mail.default-encoding` | Default MimeMessage encoding. | `UTF-8` |
| `spring.mail.host` | SMTP server host. For instance, 'smtp.example.com'. |  |
| `spring.mail.jndi-name` | Session JNDI name. When set, takes precedence over other Session settings. |  |
| `spring.mail.password` | Login password of the SMTP server. |  |
| `spring.mail.port` | SMTP server port. |  |
| `spring.mail.properties.*` | Additional JavaMail Session properties. |  |
| `spring.mail.protocol` | Protocol used by the SMTP server. | `smtp` |
| `spring.mail.ssl.bundle` | SSL bundle name. If set, 'mail.(protocol).ssl.socketFactory' property is set to an SSLSocketFactory obtained from the corresponding SSL bundle. <p> Note that the STARTTLS command can use the corresponding SSLSocketFactory, even if the 'mail.(protocol).ssl.enable' property is not set. |  |
| `spring.mail.ssl.enabled` | Whether to enable SSL support. If enabled, 'mail.(protocol).ssl.enable' property is set to 'true'. | `false` |
| `spring.mail.test-connection` | Whether to test that the mail server is available on startup. | `false` |
| `spring.mail.username` | Login user of the SMTP server. |  |
| `spring.sendgrid.api-key` | SendGrid API key. |  |
| `spring.sendgrid.proxy.host` | SendGrid proxy host. |  |
| `spring.sendgrid.proxy.port` | SendGrid proxy port. |  |

## RSocket Properties (31 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `spring.rsocket.preferred-mapper` | Preferred JSON and CBOR mapper to use. By default, auto-detected according to the environment. Supported values are 'jackson' and 'jackson2' (deprecated). | `jackson` |
| `spring.rsocket.server.address` | Network address to which the server should bind. |  |
| `spring.rsocket.server.fragment-size` | Maximum transmission unit. Frames larger than the specified value are fragmented. |  |
| `spring.rsocket.server.mapping-path` | Path under which RSocket handles requests (only works with websocket transport). |  |
| `spring.rsocket.server.port` | Server port. |  |
| `spring.rsocket.server.spec.compress` | Whether the websocket compression extension is enabled. | `false` |
| `spring.rsocket.server.spec.handle-ping` | Whether to proxy websocket ping frames or respond to them. | `false` |
| `spring.rsocket.server.spec.max-frame-payload-length` | Maximum allowable frame payload length. | `65536B` |
| `spring.rsocket.server.spec.protocols` | Sub-protocols to use in websocket handshake signature. |  |
| `spring.rsocket.server.ssl.bundle` | Name of a configured SSL bundle. |  |
| `spring.rsocket.server.ssl.certificate` | Path to a PEM-encoded SSL certificate file. |  |
| `spring.rsocket.server.ssl.certificate-private-key` | Path to a PEM-encoded private key file for the SSL certificate. |  |
| `spring.rsocket.server.ssl.ciphers` | Supported SSL ciphers. |  |
| `spring.rsocket.server.ssl.client-auth` | Client authentication mode. Requires a trust store. |  |
| `spring.rsocket.server.ssl.enabled` | Whether to enable SSL support. | `true` |
| `spring.rsocket.server.ssl.enabled-protocols` | Enabled SSL protocols. |  |
| `spring.rsocket.server.ssl.key-alias` | Alias that identifies the key in the key store. |  |
| `spring.rsocket.server.ssl.key-password` | Password used to access the key in the key store. |  |
| `spring.rsocket.server.ssl.key-store` | Path to the key store that holds the SSL certificate (typically a jks file). |  |
| `spring.rsocket.server.ssl.key-store-password` | Password used to access the key store. |  |
| `spring.rsocket.server.ssl.key-store-provider` | Provider for the key store. |  |
| `spring.rsocket.server.ssl.key-store-type` | Type of the key store. |  |
| `spring.rsocket.server.ssl.protocol` | SSL protocol to use. | `TLS` |
| `spring.rsocket.server.ssl.server-name-bundles` | Mapping of host names to SSL bundles for SNI configuration. |  |
| `spring.rsocket.server.ssl.trust-certificate` | Path to a PEM-encoded SSL certificate authority file. |  |
| `spring.rsocket.server.ssl.trust-certificate-private-key` | Path to a PEM-encoded private key file for the SSL certificate authority. |  |
| `spring.rsocket.server.ssl.trust-store` | Trust store that holds SSL certificates. |  |
| `spring.rsocket.server.ssl.trust-store-password` | Password used to access the trust store. |  |
| `spring.rsocket.server.ssl.trust-store-provider` | Provider for the trust store. |  |
| `spring.rsocket.server.ssl.trust-store-type` | Type of the trust store. |  |
| `spring.rsocket.server.transport` | RSocket transport protocol. | `tcp` |

## Security Properties (34 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `spring.security.filter.dispatcher-types` | Security filter chain dispatcher types for Servlet-based web applications. | `[async, error, forward, include, request]` |
| `spring.security.filter.order` | Security filter chain order for Servlet-based web applications. | `-100` |
| `spring.security.oauth2.authorizationserver.client.*` | Registered clients of the Authorization Server. |  |
| `spring.security.oauth2.authorizationserver.endpoint.authorization-uri` | Authorization Server's OAuth 2.0 Authorization Endpoint. | `/oauth2/authorize` |
| `spring.security.oauth2.authorizationserver.endpoint.device-authorization-uri` | Authorization Server's OAuth 2.0 Device Authorization Endpoint. | `/oauth2/device_authorization` |
| `spring.security.oauth2.authorizationserver.endpoint.device-verification-uri` | Authorization Server's OAuth 2.0 Device Verification Endpoint. | `/oauth2/device_verification` |
| `spring.security.oauth2.authorizationserver.endpoint.jwk-set-uri` | Authorization Server's JWK Set Endpoint. | `/oauth2/jwks` |
| `spring.security.oauth2.authorizationserver.endpoint.oidc.client-registration-uri` | Authorization Server's OpenID Connect 1.0 Client Registration Endpoint. | `/connect/register` |
| `spring.security.oauth2.authorizationserver.endpoint.oidc.logout-uri` | Authorization Server's OpenID Connect 1.0 Logout Endpoint. | `/connect/logout` |
| `spring.security.oauth2.authorizationserver.endpoint.oidc.user-info-uri` | Authorization Server's OpenID Connect 1.0 UserInfo Endpoint. | `/userinfo` |
| `spring.security.oauth2.authorizationserver.endpoint.pushed-authorization-request-uri` | Authorization Server's OAuth 2.0 Pushed Authorization Request Endpoint. | `/oauth2/par` |
| `spring.security.oauth2.authorizationserver.endpoint.token-introspection-uri` | Authorization Server's OAuth 2.0 Token Introspection Endpoint. | `/oauth2/introspect` |
| `spring.security.oauth2.authorizationserver.endpoint.token-revocation-uri` | Authorization Server's OAuth 2.0 Token Revocation Endpoint. | `/oauth2/revoke` |
| `spring.security.oauth2.authorizationserver.endpoint.token-uri` | Authorization Server's OAuth 2.0 Token Endpoint. | `/oauth2/token` |
| `spring.security.oauth2.authorizationserver.issuer` | URL of the Authorization Server's Issuer Identifier. |  |
| `spring.security.oauth2.authorizationserver.multiple-issuers-allowed` | Whether multiple issuers are allowed per host. Using path components in the URL of the issuer identifier enables supporting multiple issuers per host in a multi-tenant hosting configuration. | `false` |
| `spring.security.oauth2.client.provider.*` | OAuth provider details. |  |
| `spring.security.oauth2.client.registration.*` | OAuth client registrations. |  |
| `spring.security.oauth2.resourceserver.jwt.audiences` | Identifies the recipients that the JWT is intended for. |  |
| `spring.security.oauth2.resourceserver.jwt.authorities-claim-delimiter` | Regex to use for splitting the value of the authorities claim into authorities. |  |
| `spring.security.oauth2.resourceserver.jwt.authorities-claim-name` | Name of token claim to use for mapping authorities from JWT. |  |
| `spring.security.oauth2.resourceserver.jwt.authority-prefix` | Prefix to use for authorities mapped from JWT. |  |
| `spring.security.oauth2.resourceserver.jwt.issuer-uri` | URI that can either be an OpenID Connect discovery endpoint or an OAuth 2.0 Authorization Server Metadata endpoint defined by RFC 8414. |  |
| `spring.security.oauth2.resourceserver.jwt.jwk-set-uri` | JSON Web Key URI to use to verify the JWT token. |  |
| `spring.security.oauth2.resourceserver.jwt.jws-algorithms` | JSON Web Algorithms used for verifying the digital signatures. | `RS256` |
| `spring.security.oauth2.resourceserver.jwt.principal-claim-name` | JWT principal claim name. |  |
| `spring.security.oauth2.resourceserver.jwt.public-key-location` | Location of the file containing the public key used to verify a JWT. |  |
| `spring.security.oauth2.resourceserver.opaquetoken.client-id` | Client id used to authenticate with the token introspection endpoint. |  |
| `spring.security.oauth2.resourceserver.opaquetoken.client-secret` | Client secret used to authenticate with the token introspection endpoint. |  |
| `spring.security.oauth2.resourceserver.opaquetoken.introspection-uri` | OAuth 2.0 endpoint through which token introspection is accomplished. |  |
| `spring.security.saml2.relyingparty.registration.*` | SAML2 relying party registrations. |  |
| `spring.security.user.name` | Default user name. | `user` |
| `spring.security.user.password` | Password for the default user name. |  |
| `spring.security.user.roles` | Granted roles for the default user name. |  |

## Server Properties (140 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `server.address` | Network address to which the server should bind. |  |
| `server.compression.enabled` | Whether response compression is enabled. | `false` |
| `server.compression.excluded-user-agents` | Comma-separated list of user agents for which responses should not be compressed. |  |
| `server.compression.mime-types` | Comma-separated list of MIME types that should be compressed. | `[text/html, text/xml, text/plain, text/css, text/javascript, application/javascript, application/json, application/xml]` |
| `server.compression.min-response-size` | Minimum "Content-Length" value that is required for compression to be performed. | `2KB` |
| `server.forward-headers-strategy` | Strategy for handling X-Forwarded-* headers. |  |
| `server.http2.enabled` | Whether to enable HTTP/2 support, if the current environment supports it. | `false` |
| `server.jetty.accesslog.append` | Append to log. | `false` |
| `server.jetty.accesslog.custom-format` | Custom log format, see org.eclipse.jetty.server.CustomRequestLog. If defined, overrides the "format" configuration key. |  |
| `server.jetty.accesslog.enabled` | Enable access log. | `false` |
| `server.jetty.accesslog.file-date-format` | Date format to place in log file name. |  |
| `server.jetty.accesslog.filename` | Log filename. If not specified, logs redirect to "System.err". |  |
| `server.jetty.accesslog.format` | Log format. |  |
| `server.jetty.accesslog.ignore-paths` | Request paths that should not be logged. |  |
| `server.jetty.accesslog.retention-period` | Number of days before rotated log files are deleted. | `31` |
| `server.jetty.connection-idle-timeout` | Time that the connection can be idle before it is closed. |  |
| `server.jetty.max-connections` | Maximum number of connections that the server accepts and processes at any given time. | `-1` |
| `server.jetty.max-form-keys` | Maximum number of form keys. | `1000` |
| `server.jetty.max-http-form-post-size` | Maximum size of the form content in any HTTP post request. | `200000B` |
| `server.jetty.max-http-response-header-size` | Maximum size of the HTTP response header. | `16KB` |
| `server.jetty.threads.acceptors` | Number of acceptor threads to use. When the value is -1, the default, the number of acceptors is derived from the operating environment. | `-1` |
| `server.jetty.threads.idle-timeout` | Maximum thread idle time. | `60000ms` |
| `server.jetty.threads.max` | Maximum number of threads. | `200` |
| `server.jetty.threads.max-queue-capacity` | Maximum capacity of the thread pool's backing queue. A default is computed based on the threading configuration. |  |
| `server.jetty.threads.min` | Minimum number of threads. Doesn't have an effect if virtual threads are enabled. | `8` |
| `server.jetty.threads.selectors` | Number of selector threads to use. When the value is -1, the default, the number of selectors is derived from the operating environment. | `-1` |
| `server.max-http-request-header-size` | Maximum size of the HTTP request header. Refer to the documentation for your chosen embedded server for details of exactly how this limit is applied. For example, Netty applies the limit separately to each individual header in the request whereas Tomcat applies the limit to the combined size of the request line and all of the header names and values in the request. | `8KB` |
| `server.netty.connection-timeout` | Connection timeout of the Netty channel. |  |
| `server.netty.h2c-max-content-length` | Maximum content length of an H2C upgrade request. | `0B` |
| `server.netty.idle-timeout` | Idle timeout of the Netty channel. When not specified, an infinite timeout is used. |  |
| `server.netty.initial-buffer-size` | Initial buffer size for HTTP request decoding. | `128B` |
| `server.netty.max-initial-line-length` | Maximum length that can be decoded for an HTTP request's initial line. | `4KB` |
| `server.netty.max-keep-alive-requests` | Maximum number of requests that can be made per connection. By default, a connection serves unlimited number of requests. |  |
| `server.netty.validate-headers` | Whether to validate headers when decoding requests. | `true` |
| `server.port` | Server HTTP port. | `8080` |
| `server.reactive.session.cookie.domain` | Domain for the cookie. |  |
| `server.reactive.session.cookie.http-only` | Whether to use "HttpOnly" cookies for the cookie. |  |
| `server.reactive.session.cookie.max-age` | Maximum age of the cookie. If a duration suffix is not specified, seconds will be used. A positive value indicates when the cookie expires relative to the current time. A value of 0 means the cookie should expire immediately. A negative value means no "Max-Age". |  |
| `server.reactive.session.cookie.name` | Name for the cookie. |  |
| `server.reactive.session.cookie.partitioned` | Whether the generated cookie carries the Partitioned attribute. |  |
| `server.reactive.session.cookie.path` | Path of the cookie. |  |
| `server.reactive.session.cookie.same-site` | SameSite setting for the cookie. |  |
| `server.reactive.session.cookie.secure` | Whether to always mark the cookie as secure. |  |
| `server.reactive.session.max-sessions` | Maximum number of sessions that can be stored. | `10000` |
| `server.reactive.session.timeout` | Session timeout. If a duration suffix is not specified, seconds will be used. | `30m` |
| `server.server-header` | Value to use for the Server response header (if empty, no header is sent). |  |
| `server.servlet.application-display-name` | Display name of the application. | `application` |
| `server.servlet.context-parameters.*` | Servlet context init parameters. |  |
| `server.servlet.context-path` | Context path of the application. |  |
| `server.servlet.encoding.mapping.*` | Mapping of locale to charset for response encoding. |  |
| `server.servlet.jsp.class-name` | Class name of the servlet to use for JSPs. If registered is true and this class
	 * is on the classpath then it will be registered. | `org.apache.jasper.servlet.JspServlet` |
| `server.servlet.jsp.init-parameters.*` | Init parameters used to configure the JSP servlet. |  |
| `server.servlet.jsp.registered` | Whether the JSP servlet is registered. | `true` |
| `server.servlet.register-default-servlet` | Whether to register the default Servlet with the container. | `false` |
| `server.servlet.session.cookie.domain` | Domain for the cookie. |  |
| `server.servlet.session.cookie.http-only` | Whether to use "HttpOnly" cookies for the cookie. |  |
| `server.servlet.session.cookie.max-age` | Maximum age of the cookie. If a duration suffix is not specified, seconds will be used. A positive value indicates when the cookie expires relative to the current time. A value of 0 means the cookie should expire immediately. A negative value means no "Max-Age". |  |
| `server.servlet.session.cookie.name` | Name for the cookie. |  |
| `server.servlet.session.cookie.partitioned` | Whether the generated cookie carries the Partitioned attribute. |  |
| `server.servlet.session.cookie.path` | Path of the cookie. |  |
| `server.servlet.session.cookie.same-site` | SameSite setting for the cookie. |  |
| `server.servlet.session.cookie.secure` | Whether to always mark the cookie as secure. |  |
| `server.servlet.session.persistent` | Whether to persist session data between restarts. | `false` |
| `server.servlet.session.store-dir` | Directory used to store session data. |  |
| `server.servlet.session.timeout` | Session timeout. If a duration suffix is not specified, seconds will be used. | `30m` |
| `server.servlet.session.tracking-modes` | Session tracking modes. |  |
| `server.shutdown` | Type of shutdown that the server will support. | `graceful` |
| `server.ssl.bundle` | Name of a configured SSL bundle. |  |
| `server.ssl.certificate` | Path to a PEM-encoded SSL certificate file. |  |
| `server.ssl.certificate-private-key` | Path to a PEM-encoded private key file for the SSL certificate. |  |
| `server.ssl.ciphers` | Supported SSL ciphers. |  |
| `server.ssl.client-auth` | Client authentication mode. Requires a trust store. |  |
| `server.ssl.enabled` | Whether to enable SSL support. | `true` |
| `server.ssl.enabled-protocols` | Enabled SSL protocols. |  |
| `server.ssl.key-alias` | Alias that identifies the key in the key store. |  |
| `server.ssl.key-password` | Password used to access the key in the key store. |  |
| `server.ssl.key-store` | Path to the key store that holds the SSL certificate (typically a jks file). |  |
| `server.ssl.key-store-password` | Password used to access the key store. |  |
| `server.ssl.key-store-provider` | Provider for the key store. |  |
| `server.ssl.key-store-type` | Type of the key store. |  |
| `server.ssl.protocol` | SSL protocol to use. | `TLS` |
| `server.ssl.server-name-bundles` | Mapping of host names to SSL bundles for SNI configuration. |  |
| `server.ssl.trust-certificate` | Path to a PEM-encoded SSL certificate authority file. |  |
| `server.ssl.trust-certificate-private-key` | Path to a PEM-encoded private key file for the SSL certificate authority. |  |
| `server.ssl.trust-store` | Trust store that holds SSL certificates. |  |
| `server.ssl.trust-store-password` | Password used to access the trust store. |  |
| `server.ssl.trust-store-provider` | Provider for the trust store. |  |
| `server.ssl.trust-store-type` | Type of the trust store. |  |
| `server.tomcat.accept-count` | Maximum queue length for incoming connection requests when all possible request processing threads are in use. | `100` |
| `server.tomcat.accesslog.buffered` | Whether to buffer output such that it is flushed only periodically. | `true` |
| `server.tomcat.accesslog.check-exists` | Whether to check for log file existence so it can be recreated if an external process has renamed it. | `false` |
| `server.tomcat.accesslog.condition-if` | Whether logging of the request will only be enabled if "ServletRequest.getAttribute(conditionIf)" does not yield null. |  |
| `server.tomcat.accesslog.condition-unless` | Whether logging of the request will only be enabled if "ServletRequest.getAttribute(conditionUnless)" yield null. |  |
| `server.tomcat.accesslog.directory` | Directory in which log files are created. Can be absolute or relative to the Tomcat base dir. | `logs` |
| `server.tomcat.accesslog.enabled` | Enable access log. | `false` |
| `server.tomcat.accesslog.encoding` | Character set used by the log file. Default to the system default character set. |  |
| `server.tomcat.accesslog.file-date-format` | Date format to place in the log file name. | `.yyyy-MM-dd` |
| `server.tomcat.accesslog.ipv6-canonical` | Whether to use IPv6 canonical representation format as defined by RFC 5952. | `false` |
| `server.tomcat.accesslog.locale` | Locale used to format timestamps in log entries and in log file name suffix. Default to the default locale of the Java process. |  |
| `server.tomcat.accesslog.max-days` | Number of days to retain the access log files before they are removed. | `-1` |
| `server.tomcat.accesslog.pattern` | Format pattern for access logs. | `common` |
| `server.tomcat.accesslog.prefix` | Log file name prefix. | `access_log` |
| `server.tomcat.accesslog.rename-on-rotate` | Whether to defer inclusion of the date stamp in the file name until rotate time. | `false` |
| `server.tomcat.accesslog.request-attributes-enabled` | Set request attributes for the IP address, Hostname, protocol, and port used for the request. | `false` |
| `server.tomcat.accesslog.rotate` | Whether to enable access log rotation. | `true` |
| `server.tomcat.accesslog.suffix` | Log file name suffix. | `.log` |
| `server.tomcat.additional-tld-skip-patterns` | List of additional patterns that match jars to ignore for TLD scanning. The special '?' and '*' characters can be used in the pattern to match one and only one character and zero or more characters respectively. |  |
| `server.tomcat.background-processor-delay` | Delay between the invocation of backgroundProcess methods. If a duration suffix is not specified, seconds will be used. | `10s` |
| `server.tomcat.basedir` | Tomcat base directory. If not specified, a temporary directory is used. |  |
| `server.tomcat.connection-timeout` | Amount of time the connector will wait, after accepting a connection, for the request URI line to be presented. |  |
| `server.tomcat.keep-alive-timeout` | Time to wait for another HTTP request before the connection is closed. When not set the connectionTimeout is used. When set to -1 there will be no timeout. |  |
| `server.tomcat.max-connections` | Maximum number of connections that the server accepts and processes at any given time. Once the limit has been reached, the operating system may still accept connections based on the "acceptCount" property. | `8192` |
| `server.tomcat.max-http-form-post-size` | Maximum size of the form content in any HTTP post request. | `2MB` |
| `server.tomcat.max-http-response-header-size` | Maximum size of the HTTP response header. | `8KB` |
| `server.tomcat.max-keep-alive-requests` | Maximum number of HTTP requests that can be pipelined before the connection is closed. When set to 0 or 1, keep-alive and pipelining are disabled. When set to -1, an unlimited number of pipelined or keep-alive requests are allowed. | `100` |
| `server.tomcat.max-parameter-count` | Maximum number of parameters (GET plus POST) that will be automatically parsed by the container. A value of less than 0 means no limit. | `1000` |
| `server.tomcat.max-part-count` | Maximum total number of parts permitted in a multipart/form-data request. Requests that exceed this limit will be rejected. A value of less than 0 means no limit. | `50` |
| `server.tomcat.max-part-header-size` | Maximum per-part header size permitted in a multipart/form-data request. Requests that exceed this limit will be rejected. A value of less than 0 means no limit. | `512B` |
| `server.tomcat.max-swallow-size` | Maximum amount of request body to swallow. | `2MB` |
| `server.tomcat.mbeanregistry.enabled` | Whether Tomcat's MBean Registry should be enabled. | `false` |
| `server.tomcat.processor-cache` | Maximum number of idle processors that will be retained in the cache and reused with a subsequent request. When set to -1 the cache will be unlimited with a theoretical maximum size equal to the maximum number of connections. | `200` |
| `server.tomcat.redirect-context-root` | Whether requests to the context root should be redirected by appending a / to the path. When using SSL terminated at a proxy, this property should be set to false. | `true` |
| `server.tomcat.relaxed-path-chars` | List of additional unencoded characters that should be allowed in URI paths. Only "< > [ \ ] ^ ` { \| }" are allowed. |  |
| `server.tomcat.relaxed-query-chars` | List of additional unencoded characters that should be allowed in URI query strings. Only "< > [ \ ] ^ ` { \| }" are allowed. |  |
| `server.tomcat.remoteip.host-header` | Name of the HTTP header from which the remote host is extracted. | `X-Forwarded-Host` |
| `server.tomcat.remoteip.internal-proxies` | Internal proxies that are to be trusted. Can be set as a comma separate list of CIDR or as a regular expression. | `192.168.0.0/16, 172.16.0.0/12, 169.254.0.0/16, fc00::/7, 10.0.0.0/8, 100.64.0.0/10, 127.0.0.0/8, fe80::/10, ::1/128` |
| `server.tomcat.remoteip.port-header` | Name of the HTTP header used to override the original port value. | `X-Forwarded-Port` |
| `server.tomcat.remoteip.protocol-header` | Header that holds the incoming protocol, usually named "X-Forwarded-Proto". |  |
| `server.tomcat.remoteip.protocol-header-https-value` | Value of the protocol header indicating whether the incoming request uses SSL. | `https` |
| `server.tomcat.remoteip.remote-ip-header` | Name of the HTTP header from which the remote IP is extracted. For instance, 'X-FORWARDED-FOR'. |  |
| `server.tomcat.remoteip.trusted-proxies` | Regular expression defining proxies that are trusted when they appear in the "remote-ip-header" header. |  |
| `server.tomcat.resource.allow-caching` | Whether static resource caching is permitted for this web application. | `true` |
| `server.tomcat.resource.cache-max-size` | Maximum size of the static resource cache. | `10MB` |
| `server.tomcat.resource.cache-ttl` | Time-to-live of the static resource cache. | `5s` |
| `server.tomcat.threads.max` | Maximum amount of worker threads. Doesn't have an effect if virtual threads are enabled. | `200` |
| `server.tomcat.threads.max-queue-capacity` | Maximum capacity of the thread pool's backing queue. This setting only has an effect if the value is greater than 0. | `2147483647` |
| `server.tomcat.threads.min-spare` | Minimum amount of worker threads. Doesn't have an effect if virtual threads are enabled. | `10` |
| `server.tomcat.uri-encoding` | Character encoding to use to decode the URI. | `UTF-8` |
| `server.tomcat.use-apr` | Whether to use APR. | `never` |
| `server.tomcat.use-relative-redirects` | Whether HTTP 1.1 and later location headers generated by a call to sendRedirect will use relative or absolute redirects. | `false` |

## Templating Properties (72 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `spring.freemarker.allow-request-override` | Whether HttpServletRequest attributes are allowed to override (hide) controller generated model attributes of the same name. Only supported with Spring MVC. | `false` |
| `spring.freemarker.allow-session-override` | Whether HttpSession attributes are allowed to override (hide) controller generated model attributes of the same name. Only supported with Spring MVC. | `false` |
| `spring.freemarker.cache` | Whether to enable template caching. Only supported with Spring MVC. | `false` |
| `spring.freemarker.charset` | Template encoding. | `UTF-8` |
| `spring.freemarker.check-template-location` | Whether to check that the templates location exists. | `true` |
| `spring.freemarker.content-type` | Content-Type value. Only supported with Spring MVC. | `text/html` |
| `spring.freemarker.expose-request-attributes` | Whether all request attributes should be added to the model prior to merging with the template. Only supported with Spring MVC. | `false` |
| `spring.freemarker.expose-session-attributes` | Whether all HttpSession attributes should be added to the model prior to merging with the template. Only supported with Spring MVC. | `false` |
| `spring.freemarker.expose-spring-macro-helpers` | Whether to expose a RequestContext for use by Spring's macro library, under the name "springMacroRequestContext". Only supported with Spring MVC. | `true` |
| `spring.freemarker.prefer-file-system-access` | Whether to prefer file system access for template loading to enable hot detection of template changes. When a template path is detected as a directory, templates are loaded from the directory only and other matching classpath locations will not be considered. | `false` |
| `spring.freemarker.prefix` | Prefix that gets prepended to view names when building a URL. |  |
| `spring.freemarker.request-context-attribute` | Name of the RequestContext attribute for all views. |  |
| `spring.freemarker.settings.*` | Well-known FreeMarker keys which are passed to FreeMarker's Configuration. |  |
| `spring.freemarker.suffix` | Suffix that gets appended to view names when building a URL. | `.ftlh` |
| `spring.freemarker.template-loader-path` | List of template paths. | `[classpath:/templates/]` |
| `spring.freemarker.view-names` | View names that can be resolved. |  |
| `spring.groovy.template.allow-request-override` | Whether HttpServletRequest attributes are allowed to override (hide) controller generated model attributes of the same name. | `false` |
| `spring.groovy.template.allow-session-override` | Whether HttpSession attributes are allowed to override (hide) controller generated model attributes of the same name. | `false` |
| `spring.groovy.template.auto-escape` | Whether models that are assignable to CharSequence are escaped automatically. | `false` |
| `spring.groovy.template.auto-indent` | Whether indents are rendered automatically. | `false` |
| `spring.groovy.template.auto-indent-string` | String used for auto-indents. |  |
| `spring.groovy.template.auto-new-line` | Whether new lines are rendered automatically. | `false` |
| `spring.groovy.template.base-template-class` | Template base class. |  |
| `spring.groovy.template.cache` | Whether to enable template caching. | `false` |
| `spring.groovy.template.charset` | Template encoding. | `UTF-8` |
| `spring.groovy.template.check-template-location` | Whether to check that the templates location exists. | `true` |
| `spring.groovy.template.content-type` | Content-Type value. | `text/html` |
| `spring.groovy.template.declaration-encoding` | Encoding used to write the declaration heading. |  |
| `spring.groovy.template.expand-empty-elements` | Whether elements without a body should be written expanded (<br></br>) or not (<br/>). | `false` |
| `spring.groovy.template.expose-request-attributes` | Whether all request attributes should be added to the model prior to merging with the template. | `false` |
| `spring.groovy.template.expose-session-attributes` | Whether all HttpSession attributes should be added to the model prior to merging with the template. | `false` |
| `spring.groovy.template.expose-spring-macro-helpers` | Whether to expose a RequestContext for use by Spring's macro library, under the name "springMacroRequestContext". | `true` |
| `spring.groovy.template.locale` | Default locale for template resolution. |  |
| `spring.groovy.template.new-line-string` | String used to write a new line. Defaults to the system's line separator. |  |
| `spring.groovy.template.prefix` | Prefix that gets prepended to view names when building a URL. |  |
| `spring.groovy.template.request-context-attribute` | Name of the RequestContext attribute for all views. | `spring` |
| `spring.groovy.template.resource-loader-path` | Template path. | `classpath:/templates/` |
| `spring.groovy.template.suffix` | Suffix that gets appended to view names when building a URL. | `.tpl` |
| `spring.groovy.template.use-double-quotes` | Whether attributes should use double quotes. | `false` |
| `spring.groovy.template.view-names` | View names that can be resolved. |  |
| `spring.mustache.charset` | Template encoding. | `UTF-8` |
| `spring.mustache.check-template-location` | Whether to check that the templates location exists. | `true` |
| `spring.mustache.prefix` | Prefix to apply to template names. | `classpath:/templates/` |
| `spring.mustache.reactive.media-types` | Media types supported by Mustache views. | `text/html;charset=UTF-8` |
| `spring.mustache.request-context-attribute` | Name of the RequestContext attribute for all views. |  |
| `spring.mustache.servlet.allow-request-override` | Whether HttpServletRequest attributes are allowed to override (hide) controller generated model attributes of the same name. | `false` |
| `spring.mustache.servlet.allow-session-override` | Whether HttpSession attributes are allowed to override (hide) controller generated model attributes of the same name. | `false` |
| `spring.mustache.servlet.cache` | Whether to enable template caching. | `false` |
| `spring.mustache.servlet.content-type` | Content-Type value. |  |
| `spring.mustache.servlet.expose-request-attributes` | Whether all request attributes should be added to the model prior to merging with the template. | `false` |
| `spring.mustache.servlet.expose-session-attributes` | Whether all HttpSession attributes should be added to the model prior to merging with the template. | `false` |
| `spring.mustache.servlet.expose-spring-macro-helpers` | Whether to expose a RequestContext for use by Spring's macro library, under the name "springMacroRequestContext". | `true` |
| `spring.mustache.suffix` | Suffix to apply to template names. | `.mustache` |
| `spring.mustache.view-names` | View names that can be resolved. |  |
| `spring.thymeleaf.cache` | Whether to enable template caching. | `true` |
| `spring.thymeleaf.check-template` | Whether to check that the template exists before rendering it. | `true` |
| `spring.thymeleaf.check-template-location` | Whether to check that the templates location exists. | `true` |
| `spring.thymeleaf.enable-spring-el-compiler` | Enable the SpringEL compiler in SpringEL expressions. | `false` |
| `spring.thymeleaf.encoding` | Template files encoding. | `UTF-8` |
| `spring.thymeleaf.excluded-view-names` | List of view names (patterns allowed) that should be excluded from resolution. |  |
| `spring.thymeleaf.mode` | Template mode to be applied to templates. See also Thymeleaf's TemplateMode enum. | `HTML` |
| `spring.thymeleaf.prefix` | Prefix that gets prepended to view names when building a URL. | `classpath:/templates/` |
| `spring.thymeleaf.reactive.chunked-mode-view-names` | Comma-separated list of view names (patterns allowed) that should be the only ones executed in CHUNKED mode when a max chunk size is set. |  |
| `spring.thymeleaf.reactive.full-mode-view-names` | Comma-separated list of view names (patterns allowed) that should be executed in FULL mode even if a max chunk size is set. |  |
| `spring.thymeleaf.reactive.max-chunk-size` | Maximum size of data buffers used for writing to the response. Templates will execute in CHUNKED mode by default if this is set. | `0B` |
| `spring.thymeleaf.reactive.media-types` | Media types supported by the view technology. | `[text/html, application/xhtml+xml, application/xml, text/xml, application/rss+xml, application/atom+xml, application/javascript, application/ecmascript, text/javascript, text/ecmascript, application/json, text/css, text/plain, text/event-stream]` |
| `spring.thymeleaf.render-hidden-markers-before-checkboxes` | Whether hidden form inputs acting as markers for checkboxes should be rendered before the checkbox element itself. | `false` |
| `spring.thymeleaf.servlet.content-type` | Content-Type value written to HTTP responses. | `text/html` |
| `spring.thymeleaf.servlet.produce-partial-output-while-processing` | Whether Thymeleaf should start writing partial output as soon as possible or buffer until template processing is finished. | `true` |
| `spring.thymeleaf.suffix` | Suffix that gets appended to view names when building a URL. | `.html` |
| `spring.thymeleaf.template-resolver-order` | Order of the template resolver in the chain. By default, the template resolver is first in the chain. Order start at 1 and should only be set if you have defined additional "TemplateResolver" beans. |  |
| `spring.thymeleaf.view-names` | List of view names (patterns allowed) that can be resolved. |  |

## Testcontainers Properties (2 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `spring.testcontainers.beans.startup` | Testcontainers startup modes. | `sequential` |
| `spring.testcontainers.dynamic-property-registry-injection` | How to treat injection of DynamicPropertyRegistry into a @Bean method. | `fail` |

## Testing Properties (18 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `spring.test.database.replace` | Type of existing DataSource to replace. | `any` |
| `spring.test.jsontesters.enabled` | Whether auto-configuration of JSON testers is enabled. | `true` |
| `spring.test.metrics.export` | Whether metrics export should be auto-configured in tests. | `false` |
| `spring.test.mockmvc.add-filters` | Whether to add servlet filters. | `true` |
| `spring.test.mockmvc.htmlunit.url` | URL to use when HtmlUnit expands relative paths. | `http://localhost` |
| `spring.test.mockmvc.htmlunit.webclient.enabled` | Whether HTMLUnit's WebClient should be auto-configured when it's on the classpath. | `true` |
| `spring.test.mockmvc.htmlunit.webdriver.enabled` | Whether Selenium's WebDriver should be auto-configured when it's on the classpath. | `true` |
| `spring.test.mockmvc.print` | MVC Print option. | `default` |
| `spring.test.mockmvc.print-only-on-failure` | Whether to only print failed exchanges. | `true` |
| `spring.test.print-condition-evaluation-report` | Whether the condition evaluation report should be printed when the ApplicationContext fails to start. | `true` |
| `spring.test.restclient.mockrestserviceserver.enabled` | Whether a MockRestServiceServer should be auto-configured. | `true` |
| `spring.test.restdocs.uri-host` | The URI host to use. |  |
| `spring.test.restdocs.uri-port` | The URI port to use. |  |
| `spring.test.restdocs.uri-scheme` | The URI scheme for to use (for example http). |  |
| `spring.test.tracing.export` | Whether tracing export should be auto-configured in tests. | `false` |
| `spring.test.webservice.client.mockserver.enabled` | Whether a MockWebServiceServer should be auto-configured. | `true` |
| `spring.test.webservice.client.register-web-service-template` | Whether a WebServiceTemplate bean should be registered. | `false` |
| `spring.test.webtestclient.timeout` | Maximum amount of time to wait for responses. | `5s` |

## Transaction Properties (3 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `spring.jta.enabled` | Whether to enable JTA support. | `true` |
| `spring.transaction.default-timeout` | Default transaction timeout. If a duration suffix is not specified, seconds will be used. |  |
| `spring.transaction.rollback-on-commit-failure` | Whether to roll back on commit failures. |  |

## Web Properties (158 properties)

| Property | Description | Default |
|----------|-------------|---------|
| `spring.graphql.cors.allow-credentials` | Whether credentials are supported. When not set, credentials are not supported. |  |
| `spring.graphql.cors.allowed-headers` | List of HTTP headers to allow in a request. '*' allows all headers. |  |
| `spring.graphql.cors.allowed-methods` | List of HTTP methods to allow. '*' allows all methods. When not set, defaults to GET. |  |
| `spring.graphql.cors.allowed-origin-patterns` | List of origin patterns to allow. Unlike allowed origins which only support '*', origin patterns are more flexible, e.g. 'https://*.example.com', and can be used with allow-credentials. When neither allowed origins nor allowed origin patterns are set, cross-origin requests are effectively disabled. |  |
| `spring.graphql.cors.allowed-origins` | List of origins to allow with '*' allowing all origins. When allow-credentials is enabled, '*' cannot be used, and setting origin patterns should be considered instead. When neither allowed origins nor allowed origin patterns are set, cross-origin requests are effectively disabled. |  |
| `spring.graphql.cors.exposed-headers` | List of headers to include in a response. |  |
| `spring.graphql.cors.max-age` | How long the response from a pre-flight request can be cached by clients. If a duration suffix is not specified, seconds will be used. | `1800s` |
| `spring.graphql.graphiql.enabled` | Whether the default GraphiQL UI is enabled. | `false` |
| `spring.graphql.graphiql.path` | Path to the GraphiQL UI endpoint. | `/graphiql` |
| `spring.graphql.http.path` | Path at which to expose a GraphQL request HTTP endpoint. | `/graphql` |
| `spring.graphql.http.sse.keep-alive` | How frequently keep-alive messages should be sent. |  |
| `spring.graphql.http.sse.timeout` | Time required for concurrent handling to complete. |  |
| `spring.graphql.rsocket.mapping` | Mapping of the RSocket message handler. |  |
| `spring.graphql.rsocket.preferred-json-mapper` | Preferred JSON mapper to use. By default, auto-detected according to the environment. Supported values are 'jackson' and 'jackson2' (deprecated). | `jackson` |
| `spring.graphql.schema.additional-files` | Locations of additional, individual schema files to parse. | `[]` |
| `spring.graphql.schema.file-extensions` | File extensions for GraphQL schema files. | `.graphqls,.gqls` |
| `spring.graphql.schema.inspection.enabled` | Whether schema should be compared to the application to detect missing mappings. | `true` |
| `spring.graphql.schema.introspection.enabled` | Whether field introspection should be enabled at the schema level. | `true` |
| `spring.graphql.schema.locations` | Locations of GraphQL schema files. | `classpath:graphql/**/` |
| `spring.graphql.schema.printer.enabled` | Whether the endpoint that prints the schema is enabled. Schema is available under spring.graphql.http.path + "/schema". | `false` |
| `spring.graphql.websocket.connection-init-timeout` | Time within which the initial {@code CONNECTION_INIT} type message must be received. | `60s` |
| `spring.graphql.websocket.keep-alive` | Maximum idle period before a server keep-alive ping is sent to client. |  |
| `spring.graphql.websocket.path` | Path of the GraphQL WebSocket subscription endpoint. |  |
| `spring.hateoas.use-hal-as-default-json-media-type` | Whether application/hal+json responses should be sent to requests that accept application/json. | `true` |
| `spring.http.clients.connect-timeout` | Default connect timeout for a client HTTP request. |  |
| `spring.http.clients.imperative.factory` | Default factory used for a client HTTP request. |  |
| `spring.http.clients.reactive.connector` | Default connector used for a client HTTP request. |  |
| `spring.http.clients.read-timeout` | Default read timeout for a client HTTP request. |  |
| `spring.http.clients.redirects` | Handling for HTTP redirects. |  |
| `spring.http.clients.ssl.bundle` | SSL bundle to use. |  |
| `spring.http.codecs.log-request-details` | Whether to log form data at DEBUG level, and headers at TRACE level. | `false` |
| `spring.http.codecs.max-in-memory-size` | Limit on the number of bytes that can be buffered whenever the input stream needs to be aggregated. This applies only to the auto-configured WebFlux server and WebClient instances. By default this is not set, in which case individual codec defaults apply. Most codecs are limited to 256K by default. |  |
| `spring.http.codecs.preferred-json-mapper` | Preferred JSON mapper to use for HTTP encoding and decoding. By default, auto-detected according to the environment. Supported values are 'jackson' and 'jackson2' (deprecated). | `jackson` |
| `spring.http.converters.preferred-json-mapper` | Preferred JSON mapper to use for HTTP message conversion. By default, auto-detected according to the environment. Supported values are 'jackson', 'jackson2' (deprecated), 'gson' and 'jsonb'. When other JSON mapping libraries are present, use a custom HttpMessageConverters bean to control the preferred mapper. | `jackson` |
| `spring.http.converters.string-encoding-charset` | Charset to use for String conversion. | `UTF-8` |
| `spring.http.serviceclient.*` | HTTP Service Client definitions |  |
| `spring.jersey.application-path` | Path that serves as the base URI for the application. If specified, overrides the value of "@ApplicationPath". |  |
| `spring.jersey.filter.order` | Jersey filter chain order. | `0` |
| `spring.jersey.init.*` | Init parameters to pass to Jersey through the servlet or filter. |  |
| `spring.jersey.servlet.load-on-startup` | Load on startup priority of the Jersey servlet. | `-1` |
| `spring.jersey.type` | Jersey integration type. | `servlet` |
| `spring.mvc.apiversion.default` | Default version that should be used for each request. |  |
| `spring.mvc.apiversion.detect-supported` | Whether supported versions should be detected from controllers. |  |
| `spring.mvc.apiversion.required` | Whether the API version is required with each request. |  |
| `spring.mvc.apiversion.supported` | Supported versions. |  |
| `spring.mvc.apiversion.use.header` | Use the HTTP header with the given name to obtain the version. |  |
| `spring.mvc.apiversion.use.media-type-parameter.*` | Use the media type parameter with the given name to obtain the version. |  |
| `spring.mvc.apiversion.use.path-segment` | Use the path segment at the given index to obtain the version. |  |
| `spring.mvc.apiversion.use.query-parameter` | Use the query parameter with the given name to obtain the version. |  |
| `spring.mvc.async.request-timeout` | Amount of time before asynchronous request handling times out. If this value is not set, the default timeout of the underlying implementation is used. |  |
| `spring.mvc.contentnegotiation.default-content-types` | List of default content types to be used when no specific content type is requested. |  |
| `spring.mvc.contentnegotiation.favor-parameter` | Whether a request parameter ("format" by default) should be used to determine the requested media type. | `false` |
| `spring.mvc.contentnegotiation.media-types.*` | Map file extensions to media types for content negotiation. For instance, yml to text/yaml. |  |
| `spring.mvc.contentnegotiation.parameter-name` | Query parameter name to use when "favor-parameter" is enabled. |  |
| `spring.mvc.dispatch-options-request` | Whether to dispatch OPTIONS requests to the FrameworkServlet doService method. | `true` |
| `spring.mvc.dispatch-trace-request` | Whether to dispatch TRACE requests to the FrameworkServlet doService method. | `false` |
| `spring.mvc.format.date` | Date format to use, for example 'dd/MM/yyyy'. Used for formatting of java.util.Date and java.time.LocalDate. |  |
| `spring.mvc.format.date-time` | Date-time format to use, for example 'yyyy-MM-dd HH:mm:ss'. Used for formatting of java.time's LocalDateTime, OffsetDateTime, and ZonedDateTime. |  |
| `spring.mvc.format.time` | Time format to use, for example 'HH:mm:ss'. Used for formatting of java.time's LocalTime and OffsetTime. |  |
| `spring.mvc.formcontent.filter.enabled` | Whether to enable Spring's FormContentFilter. | `true` |
| `spring.mvc.hiddenmethod.filter.enabled` | Whether to enable Spring's HiddenHttpMethodFilter. | `false` |
| `spring.mvc.log-request-details` | Whether logging of (potentially sensitive) request details at DEBUG and TRACE level is allowed. | `false` |
| `spring.mvc.log-resolved-exception` | Whether to enable warn logging of exceptions resolved by a "HandlerExceptionResolver", except for "DefaultHandlerExceptionResolver". | `false` |
| `spring.mvc.message-codes-resolver-format` | Formatting strategy for message codes. For instance, 'PREFIX_ERROR_CODE'. |  |
| `spring.mvc.pathmatch.matching-strategy` | Choice of strategy for matching request paths against registered mappings. | `path-pattern-parser` |
| `spring.mvc.problemdetails.enabled` | Whether RFC 9457 Problem Details support should be enabled. | `false` |
| `spring.mvc.publish-request-handled-events` | Whether to publish a ServletRequestHandledEvent at the end of each request. | `true` |
| `spring.mvc.servlet.load-on-startup` | Load on startup priority of the dispatcher servlet. | `-1` |
| `spring.mvc.servlet.path` | Path of the dispatcher servlet. Setting a custom value for this property is not compatible with the PathPatternParser matching strategy. | `/` |
| `spring.mvc.static-path-pattern` | Path pattern used for static resources. | `/**` |
| `spring.mvc.view.prefix` | Spring MVC view prefix. |  |
| `spring.mvc.view.suffix` | Spring MVC view suffix. |  |
| `spring.mvc.webjars-path-pattern` | Path pattern used for WebJar assets. | `/webjars/**` |
| `spring.netty.leak-detection` | Level of leak detection for reference-counted buffers. If not configured via 'ResourceLeakDetector.setLevel' or the 'io.netty.leakDetection.level' system property, default to 'simple'. |  |
| `spring.servlet.encoding.charset` | Charset of HTTP requests and responses. Added to the "Content-Type" header if not set explicitly. | `UTF-8` |
| `spring.servlet.encoding.enabled` | Whether to enable Servlet HTTP encoding support. | `true` |
| `spring.servlet.encoding.force` | Whether to force the encoding to the configured charset on HTTP requests and responses. |  |
| `spring.servlet.encoding.force-request` | Whether to force the encoding to the configured charset on HTTP requests. Defaults to true when "force" has not been specified. |  |
| `spring.servlet.encoding.force-response` | Whether to force the encoding to the configured charset on HTTP responses. |  |
| `spring.servlet.multipart.enabled` | Whether to enable support of multipart uploads. | `true` |
| `spring.servlet.multipart.file-size-threshold` | Threshold after which files are written to disk. | `0B` |
| `spring.servlet.multipart.location` | Intermediate location of uploaded files. |  |
| `spring.servlet.multipart.max-file-size` | Max file size. | `1MB` |
| `spring.servlet.multipart.max-request-size` | Max request size. | `10MB` |
| `spring.servlet.multipart.resolve-lazily` | Whether to resolve the multipart request lazily at the time of file or parameter access. | `false` |
| `spring.servlet.multipart.strict-servlet-compliance` | Whether to resolve the multipart request strictly complying with the Servlet specification, only to be used for "multipart/form-data" requests. | `false` |
| `spring.session.data.redis.cleanup-cron` | Cron expression for expired session cleanup job. Only supported when repository-type is set to indexed. Not supported with a reactive session repository. | `0 * * * * *` |
| `spring.session.data.redis.configure-action` | The configure action to apply when no user-defined ConfigureRedisAction or ConfigureReactiveRedisAction bean is present. | `notify-keyspace-events` |
| `spring.session.data.redis.flush-mode` | Sessions flush mode. Determines when session changes are written to the session store. Not supported with a reactive session repository. | `on-save` |
| `spring.session.data.redis.namespace` | Namespace for keys used to store sessions. | `spring:session` |
| `spring.session.data.redis.repository-type` | Type of Redis session repository to configure. | `default` |
| `spring.session.data.redis.save-mode` | Sessions save mode. Determines how session changes are tracked and saved to the session store. | `on-set-attribute` |
| `spring.session.jdbc.cleanup-cron` | Cron expression for expired session cleanup job. | `0 * * * * *` |
| `spring.session.jdbc.continue-on-error` | Whether initialization should continue when an error occurs when applying a schema script. | `true` |
| `spring.session.jdbc.flush-mode` | Sessions flush mode. Determines when session changes are written to the session store. | `on-save` |
| `spring.session.jdbc.initialize-schema` | Database schema initialization mode. | `embedded` |
| `spring.session.jdbc.platform` | Platform to use in initialization scripts if the @@platform@@ placeholder is used. Auto-detected by default. |  |
| `spring.session.jdbc.save-mode` | Sessions save mode. Determines how session changes are tracked and saved to the session store. | `on-set-attribute` |
| `spring.session.jdbc.schema` | Path to the SQL file to use to initialize the database schema. |  |
| `spring.session.jdbc.table-name` | Name of the database table used to store sessions. | `SPRING_SESSION` |
| `spring.session.servlet.filter-dispatcher-types` | Session repository filter dispatcher types. | `[async, error, request]` |
| `spring.session.servlet.filter-order` | Session repository filter order. |  |
| `spring.session.timeout` | Session timeout. If a duration suffix is not specified, seconds will be used. |  |
| `spring.web.error.include-binding-errors` | When to include "errors" attribute. | `never` |
| `spring.web.error.include-exception` | Include the "exception" attribute. | `false` |
| `spring.web.error.include-message` | When to include "message" attribute. | `never` |
| `spring.web.error.include-path` | When to include "path" attribute. | `always` |
| `spring.web.error.include-stacktrace` | When to include the "trace" attribute. | `never` |
| `spring.web.error.path` | Path of the error controller. | `/error` |
| `spring.web.error.whitelabel.enabled` | Whether to enable the default error page displayed in browsers in case of a server error. | `true` |
| `spring.web.locale` | Locale to use. By default, this locale is overridden by the "Accept-Language" header. |  |
| `spring.web.locale-resolver` | Define how the locale should be resolved. | `accept-header` |
| `spring.web.resources.add-mappings` | Whether to enable default resource handling. | `true` |
| `spring.web.resources.cache.cachecontrol.cache-private` | Indicate that the response message is intended for a single user and must not be stored by a shared cache. |  |
| `spring.web.resources.cache.cachecontrol.cache-public` | Indicate that any cache may store the response. |  |
| `spring.web.resources.cache.cachecontrol.max-age` | Maximum time the response should be cached, in seconds if no duration suffix is not specified. |  |
| `spring.web.resources.cache.cachecontrol.must-revalidate` | Indicate that once it has become stale, a cache must not use the response without re-validating it with the server. |  |
| `spring.web.resources.cache.cachecontrol.no-cache` | Indicate that the cached response can be reused only if re-validated with the server. |  |
| `spring.web.resources.cache.cachecontrol.no-store` | Indicate to not cache the response in any case. |  |
| `spring.web.resources.cache.cachecontrol.no-transform` | Indicate intermediaries (caches and others) that they should not transform the response content. |  |
| `spring.web.resources.cache.cachecontrol.proxy-revalidate` | Same meaning as the "must-revalidate" directive, except that it does not apply to private caches. |  |
| `spring.web.resources.cache.cachecontrol.s-max-age` | Maximum time the response should be cached by shared caches, in seconds if no duration suffix is not specified. |  |
| `spring.web.resources.cache.cachecontrol.stale-if-error` | Maximum time the response may be used when errors are encountered, in seconds if no duration suffix is not specified. |  |
| `spring.web.resources.cache.cachecontrol.stale-while-revalidate` | Maximum time the response can be served after it becomes stale, in seconds if no duration suffix is not specified. |  |
| `spring.web.resources.cache.period` | Cache period for the resources served by the resource handler. If a duration suffix is not specified, seconds will be used. Can be overridden by the 'spring.web.resources.cache.cachecontrol' properties. |  |
| `spring.web.resources.cache.use-last-modified` | Whether we should use the "lastModified" metadata of the files in HTTP caching headers. | `true` |
| `spring.web.resources.chain.cache` | Whether to enable caching in the Resource chain. | `true` |
| `spring.web.resources.chain.compressed` | Whether to enable resolution of already compressed resources (gzip, brotli). Checks for a resource name with the '.gz' or '.br' file extensions. | `false` |
| `spring.web.resources.chain.enabled` | Whether to enable the Spring Resource Handling chain. By default, disabled unless at least one strategy has been enabled. |  |
| `spring.web.resources.chain.strategy.content.enabled` | Whether to enable the content Version Strategy. | `false` |
| `spring.web.resources.chain.strategy.content.paths` | List of patterns to apply to the content Version Strategy. | `[/**]` |
| `spring.web.resources.chain.strategy.fixed.enabled` | Whether to enable the fixed Version Strategy. | `false` |
| `spring.web.resources.chain.strategy.fixed.paths` | List of patterns to apply to the fixed Version Strategy. | `[/**]` |
| `spring.web.resources.chain.strategy.fixed.version` | Version string to use for the fixed Version Strategy. |  |
| `spring.web.resources.static-locations` | Locations of static resources. Defaults to classpath:[/META-INF/resources/, /resources/, /static/, /public/]. | `[classpath:/META-INF/resources/, classpath:/resources/, classpath:/static/, classpath:/public/]` |
| `spring.webflux.apiversion.default` | Default version that should be used for each request. |  |
| `spring.webflux.apiversion.detect-supported` | Whether supported versions should be detected from controllers. |  |
| `spring.webflux.apiversion.required` | Whether the API version is required with each request. |  |
| `spring.webflux.apiversion.supported` | Supported versions. |  |
| `spring.webflux.apiversion.use.header` | Use the HTTP header with the given name to obtain the version. |  |
| `spring.webflux.apiversion.use.media-type-parameter.*` | Use the media type parameter with the given name to obtain the version. |  |
| `spring.webflux.apiversion.use.path-segment` | Use the path segment at the given index to obtain the version. |  |
| `spring.webflux.apiversion.use.query-parameter` | Use the query parameter with the given name to obtain the version. |  |
| `spring.webflux.base-path` | Base path for all web handlers. |  |
| `spring.webflux.format.date` | Date format to use, for example 'dd/MM/yyyy'. Used for formatting of java.util.Date and java.time.LocalDate. |  |
| `spring.webflux.format.date-time` | Date-time format to use, for example 'yyyy-MM-dd HH:mm:ss'. Used for formatting of java.time's LocalDateTime, OffsetDateTime, and ZonedDateTime. |  |
| `spring.webflux.format.time` | Time format to use, for example 'HH:mm:ss'. Used for formatting of java.time's LocalTime and OffsetTime. |  |
| `spring.webflux.hiddenmethod.filter.enabled` | Whether to enable Spring's HiddenHttpMethodFilter. | `false` |
| `spring.webflux.multipart.file-storage-directory` | Directory used to store file parts larger than 'maxInMemorySize'. Default is a directory named 'spring-multipart' created under the system temporary directory. Ignored when using the PartEvent streaming support. |  |
| `spring.webflux.multipart.headers-charset` | Character set used to decode headers. | `UTF-8` |
| `spring.webflux.multipart.max-disk-usage-per-part` | Maximum amount of disk space allowed per part. Default is -1 which enforces no limits. | `-1B` |
| `spring.webflux.multipart.max-headers-size` | Maximum amount of memory allowed per headers section of each part. Set to -1 to enforce no limits. | `10KB` |
| `spring.webflux.multipart.max-in-memory-size` | Maximum amount of memory allowed per part before it's written to disk. Set to -1 to store all contents in memory. | `256KB` |
| `spring.webflux.multipart.max-parts` | Maximum number of parts allowed in a given multipart request. Default is -1 which enforces no limits. | `-1` |
| `spring.webflux.problemdetails.enabled` | Whether RFC 9457 Problem Details support should be enabled. | `false` |
| `spring.webflux.static-path-pattern` | Path pattern used for static resources. | `/**` |
| `spring.webflux.webjars-path-pattern` | Path pattern used for WebJar assets. | `/webjars/**` |
| `spring.websocket.messaging.preferred-json-mapper` | Preferred JSON mapper to use for WebSocket messaging. By default, auto-detected according to the environment. Supported values are 'jackson' and 'jackson2' (deprecated). | `jackson` |
