package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	 public static int calculateTax(TaxPayerInfo info) {
		int tax = 0;
	
		if (info.numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
	
		if (info.numberOfChildren > 3) {
			info.numberOfChildren = 3;
		}
	
		if (info.isMarried) {
			tax = (int) Math.round(0.05 * (((info.monthlySalary + info.otherMonthlyIncome) * info.numberOfMonthWorking)
					- info.deductible - (54000000 + 4500000 + (info.numberOfChildren * 1500000))));
		} else {
			tax = (int) Math.round(0.05 * (((info.monthlySalary + info.otherMonthlyIncome) * info.numberOfMonthWorking)
					- info.deductible - 54000000));
		}
	
		return Math.max(tax, 0);
	}
	
	
}
