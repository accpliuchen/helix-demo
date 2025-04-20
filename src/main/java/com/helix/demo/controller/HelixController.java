package com.helix.demo.controller;

import org.apache.helix.HelixManager;
import org.apache.helix.HelixManagerFactory;
import org.apache.helix.InstanceType;

public class HelixController {
    public static void main(String[] args) throws Exception {
        HelixManager controller = HelixManagerFactory.getZKHelixManager(
                "MyDBCluster", "controller", InstanceType.CONTROLLER, "localhost:2181");
        controller.connect();
        System.out.println("Controller started. Press Enter to quit.");
        System.in.read();
        controller.disconnect();
    }
}
