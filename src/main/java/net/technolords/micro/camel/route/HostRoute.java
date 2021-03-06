package net.technolords.micro.camel.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.technolords.micro.camel.JolokiaMain;
import net.technolords.micro.camel.expression.QuerySplitter;

/**
 * The responsibility of this route is to split by Jolokia queries. This opens the door
 * for parallelism.
 */
public class HostRoute extends RouteBuilder {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    public static final String ROUTE_ID = "routeHost";
    public static final String ROUTE_ENDPOINT = "direct:host";
    public static final String MARKER_FOR_QUERY_ROUTE = "markerForQueryRoute";
    private QuerySplitter querySplitter = new QuerySplitter();

    @Override
    public void configure() throws Exception {
        from(ROUTE_ENDPOINT)
                .routeId(ROUTE_ID)
                .id(ROUTE_ID)
                .log(LoggingLevel.DEBUG, LOGGER, "Executing host (splitting by query)...")
                .split()
                    .method(this.querySplitter)
                    .removeHeader(JolokiaMain.HEADER_QUERY_CONTEXT)
                    .to(QueryRoute.ROUTE_ENDPOINT)
                    .id(MARKER_FOR_QUERY_ROUTE);
    }
}
