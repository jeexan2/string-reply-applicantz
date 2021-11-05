package com.beta.replyservice;

import com.beta.replyservice.commandfactory.ParamOneCommand;
import com.beta.replyservice.commandfactory.ParamTwoCommand;
import com.beta.replyservice.pojo.CommandRequest;
import com.beta.replyservice.service.CommandExecutorService;
import com.beta.replyservice.service.CommandService;
import com.beta.replyservice.service.InputSegregatorService;
import com.beta.replyservice.service.ValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class RestServiceApplicationTest {




	@Test
	public void contextLoads() {
	}

	@Autowired
	ValidationService validationService;

	@Test
	public void textValidationService(){
		//Positive case
		String test_text = "1221aass";
		Boolean test = validationService.textValidated(test_text);
		Assertions.assertEquals(true,test);

		//Negative case
		test_text = "1221(00_+";
		test = validationService.textValidated(test_text);
		Assertions.assertEquals(false,test);
	}

	@Test
	public void testStringCommands(){
		//String command test
		String test_case = "1";
		Boolean test = validationService.commandValidated(test_case);
		Assertions.assertEquals(true,test);

		test_case = "3";
		test = validationService.commandValidated(test_case);
		Assertions.assertEquals(false,test);

	}

	@Test
	public void testCharCommands(){
		//String command test
		Character test_case = '1';
		Boolean test = validationService.commandValidated(test_case);
		Assertions.assertEquals(true,test);

		test_case = '3';
		test = validationService.commandValidated(test_case);
		Assertions.assertEquals(false,test);
	}

	@Test
	public void testListCommands(){
		List<String> test_cases = new ArrayList<>();
		List<String> test_cases_2 = new ArrayList<>();
		String input_ar[] = {"1","2"};
		test_cases = Arrays.asList(input_ar);

		Boolean test = validationService.commandValidated(test_cases);
		Assertions.assertEquals(true,test);

		String input_cor_ar[] = {"1","2","3"};
		test_cases_2 = Arrays.asList(input_cor_ar);

		test = validationService.commandValidated(test_cases_2);
		Assertions.assertEquals(false,test);

	}

	@Autowired
	InputSegregatorService inputSegregatorService;

	@Test
	public void testProcessingStringFetch(){
		String testcase = "12-hello";
		String test = inputSegregatorService.getProcessingStringFromInput(testcase);
		Assertions.assertEquals("hello",test);
	}

	@Test
	public void getCommandStringFromInput(){
		String testcase = "12-hello";
		String test = inputSegregatorService.getCommandStringFromInput(testcase);
		Assertions.assertEquals("12",test);
	}

	@Test
	public void getListCommandFromCommand(){
		String testcase = "1211";
		List<String> test = inputSegregatorService.segregateCommandFromCommandString(testcase);

		List<String> res = new ArrayList<>();
		String res_a[] = {"1","2","1","1"};
		res = Arrays.asList(res_a);

		Assertions.assertEquals(res,test);
	}

	@Autowired
	CommandService commandService;

//	String reverseString(String string);
//	String hashMd5String(String string)
	@Test
	public void reverseStringTest(){
		String test = "hello";

		String res = commandService.reverseString(test);

		Assertions.assertEquals("olleh",res);
	}

	@Test
	public void hashStringTest() throws NoSuchAlgorithmException {
		String test = "hello";

		String res = commandService.hashMd5String(test);

		Assertions.assertEquals("5d41402abc4b2a76b9719d911017c592",res);
	}

	@Autowired
	ParamOneCommand paramOneCommand;

	@Test
	public void paramOneTest(){
		String test = "hello";
		CommandRequest commandRequest = new CommandRequest();
		commandRequest.setInput_message(test);
		String res = paramOneCommand.processMessageAccordingToCommand(commandRequest);
		Assertions.assertEquals("olleh",res);
	}

	@Autowired
	ParamTwoCommand paramTwoCommand;

	@Test
	public void paramTwoTest() throws NoSuchAlgorithmException {
		String test = "hello";
		CommandRequest commandRequest = new CommandRequest();
		commandRequest.setInput_message(test);
		String res = paramTwoCommand.processMessageAccordingToCommand(commandRequest);

		Assertions.assertEquals("5d41402abc4b2a76b9719d911017c592",res);
	}

	@Autowired
	CommandExecutorService commandExecutorService;

	@Test
	public void commandListExecuteTest() throws NoSuchAlgorithmException {
		String test = "12-hello";
		String command = inputSegregatorService.getCommandStringFromInput(test);
		String msg = inputSegregatorService.getProcessingStringFromInput(test);
		List<String> commands = inputSegregatorService.segregateCommandFromCommandString(command);
		String res = commandExecutorService.applyListOfCommand(commands,msg);

		Assertions.assertEquals("10e099145e3c91cd94ccb9bdc50d0495",res);
	}

}
