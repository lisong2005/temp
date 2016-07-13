/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.plugin;

import java.util.logging.Level;

import javax.ws.rs.core.Feature;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.logging.LoggingFeature.Verbosity;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.biz.srv.rest.plugin.inter.GZIPWriterInterceptor;
import com.witon.ehealth.biz.srv.rest.plugin.inter.MessageReaderInterceptor;
import com.witon.ehealth.biz.srv.rest.plugin.listener.MyApplicationEventListener;
import com.witon.ehealth.biz.srv.rest.plugin.listener.MyRequestEventListener;
import com.witon.ehealth.biz.srv.rest.plugin.sfilter.PostMatchRequestFilter;
import com.witon.ehealth.biz.srv.rest.plugin.sfilter.PreMatchRequestFilter;
import com.witon.ehealth.biz.srv.rest.plugin.sfilter.ZPoweredResponseFilter;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: MyApplication.java, v 0.1 2016年6月22日 上午9:09:13 song.li@witontek.com Exp $
 */
public class MyApplication extends ResourceConfig {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(MyApplication.class);

    public MyApplication() {
        // Register resources and providers using package-scanning.
        packages("com.witon.ehealth.biz.srv.rest");

        register(MyApplicationEventListener.class);
        register(MyRequestEventListener.class);

        // Register my custom provider - not needed if it's in my.package.
        //        register(SecurityRequestFilter.class);
        // Register an instance of LoggingFilter.
        //        register(LoggingFeature.class);

        register(ZPoweredResponseFilter.class);
        register(PostMatchRequestFilter.class);
        register(PreMatchRequestFilter.class);

        register(GZIPWriterInterceptor.class);
        register(MessageReaderInterceptor.class);

        Level logLevel = Level.FINE;
        if (logger.isTraceEnabled() || logger.isDebugEnabled()) {
            logLevel = Level.INFO;
        }
        logger.warn("调试日志级别 {}", logLevel);
        // 1 
        java.util.logging.Logger log = java.util.logging.Logger.getLogger(getClass().getName());
        Feature feature = new LoggingFeature(log, logLevel, Verbosity.PAYLOAD_ANY, null);
        register(feature);

        // 2 java.util.logging
        //        register(new LoggingFeature(java.util.logging.Logger.getLogger(getClass().getName()),
        //            LoggingFeature.Verbosity.PAYLOAD_ANY));

        // 3 java.util.logging
        //        register(LoggingFeature.class);

        // Enable Tracing support.

        if (logLevel == Level.INFO) {
            property(ServerProperties.TRACING, "ALL");
            property(ServerProperties.MONITORING_STATISTICS_ENABLED, true);
        }
    }

    /*
    Client request invoked: The POST request with attached entity is built on the client and invoked.
    ClientRequestFilters: client request filters are executed on the client and they manipulate the request headers.
    Client WriterInterceptor: As the request contains an entity, writer interceptor registered on the client is executed before a MessageBodyWriter is executed. It wraps the entity output stream with the GZipOutputStream.
    Client MessageBodyWriter: message body writer is executed on the client which serializes the entity into the new GZipOutput stream. This stream zips the data and sends it to the "wire".
    Server: server receives a request. Data of entity is compressed which means that pure read from the entity input stream would return compressed data.
    Server pre-matching ContainerRequestFilters: ContainerRequestFilters are executed that can manipulate resource method matching process.
    Server: matching: resource method matching is done.
    Server: post-matching ContainerRequestFilters: ContainerRequestFilters post matching filters are executed. This include execution of all global filters (without name binding) and filters name-bound to the matched method.
    Server ReaderInterceptor: reader interceptors are executed on the server. The GZIPReaderInterceptor wraps the input stream (the stream from the "wire") into the GZipInputStream and set it to context.
    Server MessageBodyReader: server message body reader is executed and it deserializes the entity from new GZipInputStream (get from the context). This means the reader will read unzipped data and not the compressed data from the "wire".
    Server resource method is executed: the deserialized entity object is passed to the matched resource method as a parameter. The method returns this entity as a response entity.
    Server ContainerResponseFilters are executed: response filters are executed on the server and they manipulate the response headers. This include all global bound filters (without name binding) and all filters name-bound to the resource method.
    Server WriterInterceptor: is executed on the server. It wraps the original output stream with a new GZIPOuptutStream. The original stream is the stream that "goes to the wire" (output stream for response from the underlying server container).
    Server MessageBodyWriter: message body writer is executed on the server which serializes the entity into the GZIPOutputStream. This stream compresses the data and writes it to the original stream which sends this compressed data back to the client.
    Client receives the response: the response contains compressed entity data.
    Client ClientResponseFilters: client response filters are executed and they manipulate the response headers.
    Client response is returned: the javax.ws.rs.core.Response is returned from the request invocation.
    Client code calls response.readEntity(): read entity is executed on the client to extract the entity from the response.
    Client ReaderInterceptor: the client reader interceptor is executed when readEntity(Class) is called. The interceptor wraps the entity input stream with GZIPInputStream. This will decompress the data from the original input stream.
    Client MessageBodyReaders: client message body reader is invoked which reads decompressed data from GZIPInputStream and deserializes the entity.
    Client: The entity is returned from the readEntity().
     */

}
