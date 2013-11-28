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
				
				print("����� � ����� ������ " + department.getId() + "/" + point.getId() + " �� ������ " + PaymentHelper.getPeriod(currentPayments));

				printForDates(currentPayments);
				print("����� �� ������ - " + PaymentHelper.getAmountForPrint(
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

			print("���� " + date.toString());

			printForBics(payments);			
			print("����� �� ���� - " + PaymentHelper.getAmountForPrint(
					PaymentHelper.getTotalAmount(payments)));
		}
	}

	private void printForBics(List<Payment> currentPayments) {
		for (String bic : PaymentHelper.getBics(currentPayments)) {
			List<Payment> payments = PaymentHelper.getPayments(bic, currentPayments);
			if (payments.size() == 0) {
				continue;
			}

			print("���� " + bic.toString());

			printForAccounts(payments);
			print("����� �� ����� - " + PaymentHelper.getAmountForPrint(
					PaymentHelper.getTotalAmount(payments)));
		}
	}

	private void printForAccounts(List<Payment> currentPayments) {
		for (Account account : PaymentHelper.getAccounts(currentPayments)) {
			List<Payment> payments = PaymentHelper.getPayments(account, currentPayments);
			
			if (payments.size() == 0) {
				continue;
			}

			print("���� " + account.getId());
			
			printPayments(payments);
			print("����� �� ����� - " + PaymentHelper.getAmountForPrint(
					PaymentHelper.getTotalAmount(payments)));
		}
		
	}

	private void printPayments(List<Payment> payments) {
		for (Payment currentPayment : payments) {
			print(PaymentHelper.getAmountForPrint(currentPayment.getPaymentAmount()));
		}
	}

}
