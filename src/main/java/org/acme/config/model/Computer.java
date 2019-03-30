package org.acme.config.model;

public class Computer {
    private String ip;
    private String os;
    private String location;

    public Computer() {
    }

    public Computer(String ... args) {
        ip=args[0];
        os=args[1];
        location=args[2];
    }

    public Computer(String ip, String os, String location) {
        this.ip = ip;
        this.os = os;
        this.location = location;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ip='" + ip + '\'' +
                ", os='" + os + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
