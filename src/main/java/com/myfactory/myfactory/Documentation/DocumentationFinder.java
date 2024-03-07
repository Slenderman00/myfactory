package com.myfactory.myfactory.Documentation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import java.util.List;

import java.util.ArrayList;

public class DocumentationFinder {
    private List<Field> findFields(Class<?> clazz) {
        //create a list of fields
        List<Field> _fields = new ArrayList<Field>();

        //finds annotations on the class fields
        java.lang.reflect.Field[] fields = clazz.getFields();

        for (java.lang.reflect.Field f : fields) {
            Annotation[] annotations = f.getAnnotations();
            for (Annotation a : annotations) {
                if (a.annotationType().equals(Documentation.class)) {
                    Field field = new Field();
                    field.name = f.getName();
                    field.type = f.getType().getName();
                    field.description = f.getAnnotation(Documentation.class).description();

                    _fields.add(field);
                }
            }
        }

        return _fields;
    }

    private List<SubEndpoint> findMethodDocumentation(Class<?> clazz) {
        //create a list of subendpoints
        List<SubEndpoint> _subEndpoints = new ArrayList<SubEndpoint>();

        //finds annotations on the class methods
        Method[] methods = clazz.getMethods();

        for (Method m : methods) {
            Annotation[] annotations = m.getAnnotations();

            for (Annotation a : annotations) {
                if (a.annotationType().equals(Documentation.class)) {
                    SubEndpoint subEndpoint = new SubEndpoint();
                    subEndpoint.path = m.getAnnotation(Documentation.class).path();
                    subEndpoint.description = m.getAnnotation(Documentation.class).description();
                    subEndpoint.method = m.getAnnotation(Documentation.class).method();
                    subEndpoint.example = m.getAnnotation(Documentation.class).example();

                    //check if m returns an interface
                    if (m.getReturnType().isInterface()) {
                        subEndpoint.error = "🔥 Unable to resolve fields for interface: " + m.getReturnType().getName();
                    }
                    subEndpoint.fields = findFields(m.getReturnType());
                    
                    _subEndpoints.add(subEndpoint);
                }
                if (a.annotationType().equals(AppendFields.class)) {
                    //loop through all append fields
                    for (AppendField af : m.getAnnotation(AppendFields.class).value()) {
                        //append the field
                        Field field = new Field();
                        field.name = af.name();
                        field.type = af.type().getName();
                        field.description = af.description();

                        //add field to the latest subendpoint
                        _subEndpoints.get(_subEndpoints.size() - 1).fields.add(field);
                    }
                }
            }

            Class<?> returnType = m.getReturnType();
            
            findFields(returnType);
        }

        return _subEndpoints;
    }

    public void findDocumentation(Class<?> clazz) {
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a : annotations) {
            if (a.annotationType().equals(Documentation.class)) {
                System.out.println("Found annotation: " + a.toString());
            }
        }

        findMethodDocumentation(clazz);
    }

    public Endpoint findEndpointDocumentation(Class<?> clazz) {
        
        List<SubEndpoint> _subEndpoints = new ArrayList<SubEndpoint>();

        Annotation[] annotations = clazz.getAnnotations();

        for (Annotation a : annotations) {
            if (a.annotationType().equals(Documentation.class)) {                
                _subEndpoints.addAll(findMethodDocumentation(clazz));
            }
        }

        Endpoint endpoint = new Endpoint();

        try {
            endpoint.path = clazz.getAnnotation(Documentation.class).path();
        } catch (NullPointerException e) {
            System.out.println("No path annotation found");
        }

        try {
            endpoint.description = clazz.getAnnotation(Documentation.class).description();
        } catch (NullPointerException e) {
            System.out.println("No description annotation found");
        }

        endpoint.subEndpoints = _subEndpoints;

        //endpoint.print();

        return endpoint;
    }

}
