package com.disney.studios;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.*;

@Component
public class VoterWatcher {

    private static Map<Long, Set<String>> clientReferences = Collections.synchronizedMap(new HashMap<Long, Set<String>>());

    public boolean addClient(long dogId, String client) {
        Long dogLong = new Long(dogId);

        synchronized(clientReferences) {
            Set<String> clients = clientReferences.get(dogLong);
            if (clients == null) {
                clients = new HashSet<String>();
                clientReferences.put(dogLong, clients);
            }
            // check if its ok to add
            if (clients.add(client)) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}