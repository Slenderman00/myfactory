package com.myfactory.myfactory.Documentation;

import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.io.File;
import java.io.FileWriter;

public class DocumentationGenerator {
    public List<Endpoint> endpoints;

    public DocumentationGenerator() {
        this.endpoints = new ArrayList<Endpoint>();
    }
    
    public void appendEndpoint(Endpoint endpoint) {
        if(endpoint != null) {
            endpoints.add(endpoint);
        }
    }

    public void print() {
        for (Endpoint endpoint : endpoints) {
            endpoint.print();
        }
    }

    public void generateIndex(StringBuilder sb) {
        sb.append("# Index\n");
        for (Endpoint endpoint : endpoints) {
            endpoint.generateIndex(sb);
        }
    }

    public void generateMarkdown(String path) {
        StringBuilder sb = new StringBuilder();

        generateIndex(sb);

        sb.append("# Documentation\n");
        for (Endpoint endpoint : endpoints) {
            endpoint.generateMarkdown(sb);
        }

        FileWriter fw = null;   
        try {
            File file = new File(path);
            fw = new FileWriter(file);
            fw.write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }
    }
}
