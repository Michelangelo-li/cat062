/**
 * Copyright 2020 bejson.com
 */
package cat062.decoder;

import lombok.AllArgsConstructor;


@lombok.Data
@AllArgsConstructor
public class CAT062KafkaMsgNew {

    private Data data;

    private int dataLength;

    private String dataType;

    private String encode;

    private String hashCode;

    private long receiveTime;

    private int sendTime;

    private long seqNo;

    private String serviceId;

    private String serviceIp;

    private String serviceVersion;

    private int sourcePort;
}