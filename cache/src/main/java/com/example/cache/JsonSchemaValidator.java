package com.example.cache;

import static java.util.stream.Collectors.joining;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaException;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class JsonSchemaValidator {

  private final ObjectMapper objectMapper = new ObjectMapper();

  public void validate(String jsonString,String resource) {

    JsonNode jsonNode;
  InputStream inputStream=null;
	try {
		inputStream = new FileInputStream(resource);
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
  
    JsonSchema jsonSchema;
    // schema
    try {
    	System.out.println(jsonString.toString());
      jsonNode = objectMapper.readTree(jsonString);
      jsonSchema = JsonSchemaFactory.getInstance().getSchema(inputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    // validation
    Set<ValidationMessage> validationResult = jsonSchema.validate(jsonNode);

    if (!validationResult.isEmpty()) {
      String errorMessages = validationResult.stream()
          .map(ValidationMessage::getMessage)
          .collect(joining(" # "));
      throw new JsonSchemaException(errorMessages);
    }
  }

}