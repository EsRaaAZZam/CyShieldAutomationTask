package com.Demo.tests;

import com.Demo.device.Device;
import com.Demo.server.appiumServer;

import java.util.Properties;

public class BaseTest {

    protected static Device device = new Device(35);
    public boolean androidPlatform = true;
    public appiumServer server = new appiumServer();
}
