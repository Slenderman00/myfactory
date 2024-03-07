package com.myfactory.myfactory.Documentation;
import java.lang.StringBuilder;

public class Field {
    public String name;
    public String type;
    public String description;

    public void print() {
        System.out.println("Field: " + name + " " + type + " " + description);
    }

    public StringBuilder generateMarkdown(StringBuilder sb) {
        sb.append("    - **" + name + "**\n");
        sb.append("        - Type: " + type + "\n");
        sb.append("        - " + description + "\n");
        return sb;
    }
}
