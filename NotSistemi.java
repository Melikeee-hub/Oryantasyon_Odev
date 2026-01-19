import java.util.Scanner;

public class NotSistemi {
	//Ortalama hesaplama metodu
	public static double calculateAverage(double vize, double finalNotu, double odev) {
        return (vize * 0.30) + (finalNotu * 0.40) + (odev * 0.30);
    }
	
	public static boolean isPassingGrade(double ortalama) {
        return ortalama >= 50;
    }
	
	//Harf notu belirleme metodu
	public static String getLetterGrade(double ortalama) {
        if (ortalama >= 90.0) {return "A";
        }
       
        else if (ortalama>=80.0) {return "B";
        
        }else if (ortalama>=70.0) {
        	return "C";
        }else if(ortalama>=60.0) {
        	return "D";
        
        }else {return"F";
        
        }
	}
	//Onur listesi kontrolü
	public static boolean isOnHonorRoll(double ortalama, double vizeNotu, double finalNotu, double odevNotu) {
		return ortalama>85.0
				&&vizeNotu>=70.0
				&&finalNotu>=70.0
				&&odevNotu>=70.0;
	}
	
	
	// Bütünleme hakkı kontrolü
	public static boolean hasRetakeRight(double ortalama) {
       
        return (ortalama >= 40.0) && (ortalama < 50.0);
    }
	
	
	
    public static void main(String[] args) {
        Scanner melike = new Scanner(System.in);
        
        System.out.println("============== Öğrenci Not Girişi ==============");
        System.out.print("Vize notu: ");
        double vize = melike.nextDouble();
        System.out.print("Final notu: ");
        double finall = melike.nextDouble();
        System.out.print("Ödev notu: ");
        double odev = melike.nextDouble();

        double ortalama = calculateAverage(vize, finall, odev);
        String harfNotu = getLetterGrade(ortalama);
        
        
        // Geçme durumu: Ortalama 50 ve üzeri ise GEÇTİ, değilse KALDI.
        String durum = (ortalama >= 50.0) ? "GEÇTİ" : "KALDI";
        
        // Onur listesi
        String onurListesi = isOnHonorRoll(ortalama, vize, finall, odev) ? "VAR" : "YOK";
        
        // Bütünleme hakkı: Sadece KALANLAR (ortalama < 50) ve 40-50 arası olanlar için.
        String butunleme = (ortalama < 50.0 && hasRetakeRight(ortalama)) ? "VAR" : "YOK";
        
        System.out.println("\n========= Öğrenci Not Raporu ==========");
        System.out.printf("Vize notu    : %.1f\n", vize);
        System.out.printf("Final notu   : %.1f\n", finall);
        System.out.printf("Ödev notu    : %.1f\n", odev);
        System.out.printf("Ortalama     : %.1f\n", ortalama);
        System.out.printf("Harf Notu    : %s\n", harfNotu);
        System.out.printf("Durum        : %s\n", durum);
        System.out.printf("Onur Listesi : %s\n", onurListesi);
        System.out.printf("Bütünleme    : %s\n", butunleme);
        
        melike.close();
    }
}

