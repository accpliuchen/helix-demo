package com.helix.demo.setup;

import org.apache.helix.tools.ClusterSetup;

public class HelixClusterSetup {
    public static void main(String[] args) {
        String zkAddress = "localhost:2181";
        String cluster = "MyDBCluster";

        ClusterSetup setup = new ClusterSetup(zkAddress);
        setup.addCluster(cluster, true);
        setup.addInstanceToCluster(cluster, "nodeA");
        setup.addInstanceToCluster(cluster, "nodeB");
        setup.addResourceToCluster(cluster, "TestResource", 4, "OnlineOffline");
        setup.rebalanceStorageCluster(cluster, "TestResource", 2);
        System.out.println("Cluster initialized.");
    }
}
