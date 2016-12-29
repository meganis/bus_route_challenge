package com.goeuro.direct.impl;

import com.goeuro.direct.api.DirectConnectionRequest;
import com.goeuro.direct.api.DirectConnectionResult;
import com.goeuro.direct.api.DirectService;
import com.google.common.base.Splitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.Iterator;

/**
 * Created by segr on 21.12.16.
 */
public class DirectServiceImpl implements DirectService {

    private BitSet[] buses;

    @Override
    public DirectConnectionResult checkDirectConnection(DirectConnectionRequest request) {
        DirectConnectionResult result = new DirectConnectionResult();
        result.setArrSid(request.getArrSid());
        result.setDepSid(request.getDepSid());
        boolean directBusRoute;
        try {
            BitSet arr = buses[request.getArrSid()];
            BitSet dep = buses[request.getDepSid()];
            directBusRoute = dep != null && arr != null && dep.intersects(arr);
        } catch (IndexOutOfBoundsException e) {
            // at least one of stations is not reachable by any bus
            directBusRoute = false;
        }
        result.setDirectBusRoute(directBusRoute);
        return result;
    }

    public void readData(String fileName) throws IOException {
        // allocate maximum size array
        buses = new BitSet[1000000];
        // NOTE for performance, one could provide custom parser
        // returning iterator of integers, parsing more efficiently than Integer.parseInt
        // and without splitting
        Splitter splitter = Splitter.on(' ');
        Integer n;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            n = Integer.parseInt(splitter.split(reader.readLine()).iterator().next());
            for (int i = 0; i < n; ++i) {
                Iterator<String> split = splitter.split(reader.readLine()).iterator();
                Integer routeId = Integer.parseInt(split.next());
                while (split.hasNext()) {
                    Integer stationId = Integer.parseInt(split.next());
                    if (buses[stationId] == null) {
                        buses[stationId] = new BitSet(n);
                    }
                    buses[stationId].set(routeId);
                }
            }
        }
    }
}
