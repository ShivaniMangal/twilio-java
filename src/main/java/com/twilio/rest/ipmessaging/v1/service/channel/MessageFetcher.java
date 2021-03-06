/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.ipmessaging.v1.service.channel;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class MessageFetcher extends Fetcher<Message> {
    private final String serviceSid;
    private final String channelSid;
    private final String sid;

    /**
     * Construct a new MessageFetcher.
     * 
     * @param serviceSid The service_sid
     * @param channelSid The channel_sid
     * @param sid The sid
     */
    public MessageFetcher(final String serviceSid, 
                          final String channelSid, 
                          final String sid) {
        this.serviceSid = serviceSid;
        this.channelSid = channelSid;
        this.sid = sid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched Message
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Message fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.IPMESSAGING.toString(),
            "/v1/Services/" + this.serviceSid + "/Channels/" + this.channelSid + "/Messages/" + this.sid + "",
            client.getRegion()
        );
        
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Message fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
        
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return Message.fromJson(response.getStream(), client.getObjectMapper());
    }
}