package ru.urfu.rtf.bank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;

import ru.urfu.rtf.bank.models.Account;
import ru.urfu.rtf.bank.models.Department;
import ru.urfu.rtf.bank.models.Payment;
import ru.urfu.rtf.bank.models.PaymentRecivingPoint;

public class FileReportWriter implements IReportWriter {
	
	private BufferedWriter writer;
	
	public FileReportWriter(String outputFilePath) {
		File file = getFile(outputFilePath);
		try {
			writer = new BufferedWriter(new FileWriter(file));
		} catch (Exception e) {
			writer = null;
		}
	}

	private File getFile(String outputFilePath) {
		return new File(outputFilePath);
	}
	
	private void print(String string) {
		try {
			writer.write(string);
			writer.newLine();
		} catch (Exception e) {
		}
	}

	@Override
	public void printReport(List<Payment> payments) {
		
		List<Department> departments = PaymentHelper.getDepartments(payments);
		List<PaymentRecivingPoint> points = PaymentHelper.getPoints(payments);
		
		for (Department department : departments) {
			for (PaymentRecivingPoint point : points) {
				List<Payment> currentPayments = PaymentHelper.getPayments(department, payments);
				currentPayments = PaymentHelper.getPayments(point, currentPayments);
				
				if (currentPayments.size() == 0) {
					continue;
				}
				
				print("Отчет о точке приема " + department.getId() + "/" + point.getId() + " за период " + PaymentHelper.getPeriod(currentPayments));

				printForDates(currentPayments);
				print("Итого за период - " + PaymentHelper.getAmountForPrint(
						PaymentHelper.getTotalAmount(currentPayments)));
			}
		}
		try {
			writer.close();
		} catch (Exception e) {
		}
	}

	private void printForDates(List<Payment> currentPayments) {
		for (Date date : PaymentHelper.getDates(currentPayments)) {
			List<Payment> payments = PaymentHelper.getPayments(date, currentPayments);
			if (payments.size() == 0) {
				continue;
			}

			print("Дата " + date.toString());

			printForBics(payments);			
			print("Итого за дату - " + PaymentHelper.getAmountForPrint(
					PaymentHelper.getTotalAmount(payments)));
		}
	}

	private void printForBics(List<Payment> currentPayments) {
		for (String bic : PaymentHelper.getBics(currentPayments)) {
			List<Payment> payments = PaymentHelper.getPayments(bic, currentPayments);
			if (payments.size() == 0) {
				continue;
			}

			print("Банк " + bic.toString());

			printForAccounts(payments);
			print("Итого по банку - " + PaymentHelper.getAmountForPrint(
					PaymentHelper.getTotalAmount(payments)));
		}
	}

	private void printForAccounts(List<Payment> currentPayments) {
		for (Account account : PaymentHelper.getAccounts(currentPayments)) {
			List<Payment> payments = PaymentHelper.getPayments(account, currentPayments);
			
			if (payments.size() == 0) {
				continue;
			}

			print("Счет " + account.getId());
			
			printPayments(payments);
			print("Итого по счету - " + PaymentHelper.getAmountForPrint(
					PaymentHelper.getTotalAmount(payments)));
		}
		
	}

	private void printPayments(List<Payment> payments) {
		for (Payment currentPayment : payments) {
			print(PaymentHelper.getAmountForPrint(currentPayment.getPaymentAmount()));
		}
	}

}
