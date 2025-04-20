package com.helix.demo.participant;

import org.apache.helix.HelixManager;
import org.apache.helix.HelixManagerFactory;
import org.apache.helix.InstanceType;

public class HelixParticipant {
    public static void main(String[] args) throws Exception {
        String instance = args.length > 0 ? args[0] : "nodeA";

        HelixManager manager = HelixManagerFactory.getZKHelixManager(
                "MyDBCluster", instance, InstanceType.PARTICIPANT, "localhost:2181");

        manager.connect();
        System.out.printf("Participant %s running (no state logic). Press Enter to exit.%n", instance);
        System.in.read();
        manager.disconnect();
    }
}
