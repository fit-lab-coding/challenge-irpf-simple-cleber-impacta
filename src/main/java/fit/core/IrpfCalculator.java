package fit.core;

public class IrpfCalculator {

	private static Double SALARIO_BASE = 1903.98;
	
	public static Double calculateBaseSalary(double totalSalary) {
		return totalSalary - (totalSalary * 11 / 100);
	}

	public static Double calculateExemption() {
		return SALARIO_BASE;
	}

	public static Double calculateDiscount(double baseSalary) {
		return baseSalary - calculateExemption();
	}

	public static Double calculateTaxLayer(double baseSalary) {
		if (baseSalary < 1903.98)
			return 0.0;
		if (baseSalary >= 1903.99 && baseSalary <= 2826.65)
			return 0.075;
		if (baseSalary >= 2826.66 && baseSalary <= 3751.05)
			return 0.15;
		if (baseSalary >= 3751.06 && baseSalary <= 4664.68)
			return 0.0225;
		if (baseSalary > 4664.68)
			return 0.275;
		return baseSalary;
	}

	public static Double calculateIrpf(double totalSalary) {
		var baseSalary = calculateBaseSalary(totalSalary);
		var discount = calculateDiscount(baseSalary);
		var taxa = calculateTaxLayer(baseSalary);
		var irpf = discount * taxa;
		
		return irpf;
	}
}
