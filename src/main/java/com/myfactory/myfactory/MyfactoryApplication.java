package com.myfactory.myfactory;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myfactory.myfactory.Documentation.DocumentationFinder;
import com.myfactory.myfactory.Documentation.DocumentationGenerator;
import com.myfactory.myfactory.Endpoints.AddressEndpoint;
import com.myfactory.myfactory.Endpoints.CustomerEndpoint;
import com.myfactory.myfactory.Endpoints.FactoryOrderEndpoint;
import com.myfactory.myfactory.Endpoints.MachineEndpoint;
import com.myfactory.myfactory.Endpoints.PartsEndpoint;
import com.myfactory.myfactory.Endpoints.SubassemblyEndpoint;

import org.springframework.boot.SpringApplication;


@SpringBootApplication
public class MyfactoryApplication {
public static void main(String[] args) {
	boolean generateDocumentation = false;
	for (String arg : args) {
		if (arg.equals("--documentation")) {
			generateDocumentation = true;
			break;
		}
	}

	if (generateDocumentation) {
		Class<?>[] endpointClasses = {
			AddressEndpoint.class,
			CustomerEndpoint.class,
			FactoryOrderEndpoint.class,
			MachineEndpoint.class,
			PartsEndpoint.class,
			SubassemblyEndpoint.class
		};

		DocumentationGenerator generator = new DocumentationGenerator();

		for (Class<?> endpointClass : endpointClasses) {
			DocumentationFinder finder = new DocumentationFinder();
			generator.appendEndpoint(finder.findEndpointDocumentation(endpointClass));
		}

		generator.generateMarkdown("documentation.md");
	}

	SpringApplication.run(MyfactoryApplication.class, args);
}
}

