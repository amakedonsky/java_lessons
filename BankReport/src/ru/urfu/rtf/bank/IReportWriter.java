package ru.urfu.rtf.bank;

import java.util.List;

import ru.urfu.rtf.bank.models.Payment;

public interface IReportWriter {

	public void printReport(List<Payment> payments);
}
