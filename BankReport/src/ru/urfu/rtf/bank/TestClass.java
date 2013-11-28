package ru.urfu.rtf.bank;

import java.util.ArrayList;
import java.util.List;

import ru.urfu.rtf.bank.models.Payment;

public class TestClass {

	public static void main(String[] args) {
		
		String inputFilePath = (args.length > 0 ? args[0] : "input.txt");
		String outputFilePath = (args.length > 1 ? args[1] : "output.txt");
		
		IPaymentStringReader reader = new FileStringReader(inputFilePath);
		IReportWriter writer = new FileReportWriter(outputFilePath);
		List<Payment> payments = new ArrayList<>();
		
		while (reader.hasNextString()) {
			payments.add(PaymentStringParser.getPayment(reader.readString()));
		}
		reader.finish();
		
		if (payments.size() > 0) {
			writer.printReport(payments);
		}
		
		System.out.println("Done.");
	}

}
