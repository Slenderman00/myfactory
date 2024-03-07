package com.myfactory.myfactory.Documentation;

import java.util.List;
import java.lang.StringBuilder;

public class Endpoint {
    String path;
    String description;
    List<SubEndpoint> subEndpoints;

    public void print() {
        System.out.println("Endpoint: " + path + " " + description);
        for (SubEndpoint subEndpoint : subEndpoints) {
            subEndpoint.print();
        }
    }

    public StringBuilder generateIndex(StringBuilder sb) {
        sb.append("- [" + path + "](#" + path + ")\n");
        for (SubEndpoint subEndpoint : subEndpoints) {
            subEndpoint.generateIndex(sb);
        }
        return sb;
    }
    

    public StringBuilder generateMarkdown(StringBuilder sb) {
        sb.append("## " + path + "\n");
        sb.append(description + "\n");
        for (SubEndpoint subEndpoint : subEndpoints) {
            subEndpoint.generateMarkdown(sb);
        }
        return sb;
    }
}
