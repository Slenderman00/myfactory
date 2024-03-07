package com.myfactory.myfactory.Documentation;
import java.lang.StringBuilder;

import java.util.List;

public class SubEndpoint {
    public String path;
    public String description;
    public String method;
    public String example;
    public String error;
    public List<Field> fields;  

    public void print() {
        System.out.println("SubEndpoint: " + path + " " + description);
        System.out.println("Method: " + method);
        System.out.println("Fields:");
        for (Field field : fields) {
            field.print();
        }
    }

    public StringBuilder generateIndex(StringBuilder sb) {
        sb.append("    - [" + path + "](#" + path + ")\n");
        return sb;
    }

    public StringBuilder generateMarkdown(StringBuilder sb) {
        sb.append("### " + path + "\n");
        sb.append(description + "\n");
        sb.append("- Method: " + method + "\n");
        if(fields.size() == 0) {
            sb.append("- Fields: None\n");
        } else {
            sb.append("- Fields:\n");
            for (Field field : fields) {
                field.generateMarkdown(sb);
            }
        }

        if(error != null && error.length() > 0) {
            sb.append("- Error: " + error + "\n");
        }

        if (example != null && example.length() > 0) {
            sb.append("- Example:\n");
            sb.append("```curl\n");
            sb.append(example + "\n");
            sb.append("```\n");
        }

        return sb;
    }
}
