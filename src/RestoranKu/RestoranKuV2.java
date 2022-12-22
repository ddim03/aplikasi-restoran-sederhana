
package RestoranKu;

import java.util.Scanner;

public class RestoranKuV2 {
    // mengambil input dari user
    static Scanner input = new Scanner(System.in);
    // data paket
    static String[] paketMakanan = {
        "Nasi + Ayam Geprek   ",
        "Nasi + Ayam Geprek               |\n|    + Es Teh             ",
        "Nasi + Ayam Geprek               |\n|    + Tahu Tempe + Es Teh"
    };
    static int[] hargaPaketMakanan = {20000,25000,27000};
    // pesan kesalahan
    static String errorMassage = "| Mohon isi data dengan benar...!";
    // variabel untuk transaksi
    static int bayarMakan = 0;
    static int bayarResTempat = 0;
    static int bayarResMeja = 0;
    static int totalBayarMakan;
    static int dpResTempat;
    static int dpResMeja;
    // variabel untuk batasan reservasi
    static boolean ReservasiTempat = true;
    static boolean ReservasiMeja = true;
    
    public static void main(String[] args) {        
        // deklarasi untuk registrasi
        String nama, ttl, email, noHP, password;
        // deklarasi untuk login
        String loginName, loginPass;
        // deklarasi untuk perulangan
        String kembali,keluar;
        // deklarasi untuk pilih
        int pilih;
        
        System.out.println("---------------------------------------");
        System.out.println("|             RestoranKu              |");
        System.out.println("---------------------------------------");
        System.out.println("| Selamat datang di RestoranKu...     |");
        System.out.println("| Sebelum pesan registrasi dulu ya... |");
        System.out.println("---------------------------------------");
      
        //REGISTRASI
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("|              Registrasi             |");
        System.out.println("---------------------------------------");
        do {            
            System.out.print("| Masukan nama     : ");
            nama = input.nextLine();
            if (nama.isEmpty()) {
                System.out.println(errorMassage);
            }
        } while (nama.isEmpty());
        
        do {            
            System.out.print("| Masukan TTL      : ");
            ttl = input.nextLine();
            if (ttl.isEmpty()) {
                System.out.println(errorMassage);
            }
        } while (ttl.isEmpty());
        
        do {            
            System.out.print("| Masukan Email    : ");
            email = input.nextLine();
            if (email.isEmpty()) {
                System.out.println(errorMassage);
            }
        } while (email.isEmpty());
        
        do {            
            System.out.print("| Masukan nomor HP : ");
            noHP = input.nextLine();
            if (noHP.isEmpty()) {
                System.out.println(errorMassage);
            }
        } while (noHP.isEmpty());
        
        do {            
            System.out.print("| Masukan password : ");
            password = input.nextLine();
            if (password.isEmpty()) {
                System.out.println(errorMassage);
            }
        } while (password.isEmpty());
        System.out.println("---------------------------------------");
        System.out.println("| Registrasi berhasil....             |");
        System.out.println("| Silahkan melakukan login            |");
        System.out.println("---------------------------------------");
 
        //LOGIN
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("|                Login                |");
        System.out.println("---------------------------------------");       
        System.out.print("| Masukan Nama     : ");
        loginName = input.nextLine();
        System.out.print("| Masukan Password : ");
        loginPass = input.nextLine();
        while (!loginName.equals(nama) || !loginPass.equals(password)) {            
            System.out.println("| Data yang anda masukan tidak sesuai |");
            System.out.print("| Masukan Nama     : ");
            loginName = input.nextLine();
            System.out.print("| Masukan Password : ");
            loginPass = input.nextLine();
        }
        System.out.println("---------------------------------------"); 
        System.out.println("| Login berhasil....                  |");
        System.out.println("---------------------------------------"); 
        
        //MENU
        do {
            do {            
                System.out.println();
                System.out.println("---------------------------------------");
                System.out.println("|                 Menu                |");
                System.out.println("---------------------------------------");
                System.out.println("| 1. Pesan Makanan                    |");
                System.out.println("| 2. Reservasi Tempat                 |");
                System.out.println("| 3. Reservasi Meja                   |");
                System.out.println("| 4. Pembatalan Pesanan               |");
                System.out.println("| 5. Cetak Pesanan                    |");
                System.out.println("| 6. Keluar                           |");
                System.out.println("---------------------------------------");
            //PILIH
                System.out.print("| Masukan pilihan anda (1-6): ");
                pilih = input.nextInt();
                while (pilih > 6 || pilih < 1) {                    
                    System.out.println(errorMassage);
                    System.out.print("| Masukan pilihan anda (1-6): ");
                    pilih = input.nextInt();
                }
                System.out.println("---------------------------------------");
                switch(pilih){
                    case 1 :
                        pesanMakan();
                        break;
                    case 2 :
                        reservasiTempat();
                        break;
                    case 3 :
                        reservasiMeja();
                        break;
                    case 4 : 
                        batalPesan();
                        break;
                    case 5 :
                        cetakPesanan();
                        break;
                    default:
                        break;
                }
                // untuk triger keluar
                if (pilih > 0 && pilih < 6) {
                  System.out.print("| Kembali ke menu utama ?(y/n) ");
                  kembali = input.next();
                } else {
                  kembali = "n";  
                }
            } while (kembali.equalsIgnoreCase("y"));
            System.out.print("| Apakah anda ingin keluar ?(y/n) ");
            keluar = input.next();   
        } while (keluar.equalsIgnoreCase("n"));
        System.out.println("---------------------------------------");
        System.out.println("|   Terima Kasih Sudah Berkunjung :)  |");
        System.out.println("---------------------------------------");        
    }
    
    static void pesanMakan(){
        // deklarasi untuk pilih makan dan minum
        int pilihMakan,pilihMinum;
        int porsiMakan = 0;
        int porsiMinum = 0;
        // data yang diperlukan
        String[] makanan = {
            "Nasi Ayam Geprek", 
            "Nasi Ayam Goreng", 
            "Nasi Ayam Krispy"
        };
        int[] hargaMakanan = {12000, 13000, 15000};
        String[] minuman = {
            "Es Teh  ", 
            "Es Jeruk", 
            "Es Soda "
        };
        int[] hargaMinuman = {3000,4000,5000};
        //program utama
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("|               Makanan               |");
        System.out.println("---------------------------------------");
        for(int i = 0; i < makanan.length; i++){
            System.out.println("|   " + (i+1) + ". " + makanan[i] + 
                    "      Rp"+hargaMakanan[i] + "  |");
        }
        System.out.println("---------------------------------------");
        System.out.println("|               Minuman               |");
        System.out.println("---------------------------------------");
        for(int i = 0; i < minuman.length; i++){
            System.out.println("|   " + (i+1) + ". " + minuman[i] + 
                    "              Rp"+hargaMinuman[i] + "   |");
        }
        System.out.println("---------------------------------------");
        System.out.println("|   0. Tidak memesan                  |");
        System.out.println("---------------------------------------");
        System.out.print("| Pilihan makanan anda : ");
        pilihMakan = input.nextInt();
        while (pilihMakan > 3 || pilihMakan < 0) {            
            System.out.println(errorMassage);
            System.out.print("| Pilihan makanan anda : ");
            pilihMakan = input.nextInt();
        }
        if (pilihMakan != 0) {
            System.out.print("| Masukan jumlah porsi : ");
            porsiMakan = input.nextInt();           
        }
        switch(pilihMakan) {
            case 1:
                bayarMakan += hargaMakanan[0]*porsiMakan;
                break;
            case 2:
                bayarMakan += hargaMakanan[1]*porsiMakan;
                break;
            case 3:
                bayarMakan += hargaMakanan[2]*porsiMakan;
                break;
            default :
                System.out.println("| Anda tidak memesan makanan");
                break;
        }
        System.out.print("| Pilihan minuman anda : ");
        pilihMinum = input.nextInt();
        while (pilihMinum > 3 || pilihMinum < 0) {            
            System.out.println(errorMassage);
            System.out.print("| Pilihan minuman anda : ");
            pilihMinum = input.nextInt();
        }
        if (pilihMinum != 0) {
            System.out.print("| Masukan jumlah porsi : ");
            porsiMinum = input.nextInt();
        }
        switch(pilihMinum){
            case 1:
                bayarMakan += hargaMinuman[0]*porsiMinum;
                break;
            case 2:
                bayarMakan += hargaMinuman[1]*porsiMinum;
                break;
            case 3:
                bayarMakan += hargaMinuman[2]*porsiMinum;
                break;
            default :
                System.out.println("| Anda tidak memesan minuman");
                break;
        }
        totalBayarMakan = diskon(0,bayarMakan);
        System.out.println(infoDiskonPromo(0, bayarMakan));
        successMassage();
    }
    
    static void reservasiTempat(){
        if (ReservasiTempat) {
            //cek promo
            int tanggal;
            // variabel untuk pilih paket makanan
            int pilihPaket;
            // variabel untuk jumlah orang
            int jumlahOrg;
            // variabel untuk transaksi
            int paketMakan = 0;
            int sewaTempat = 100000;
            int totalResTempat;
            System.out.println();
            System.out.println("---------------------------------------");
            System.out.println("|          Reservasi Tempat           |");
            System.out.println("---------------------------------------");
            System.out.print("| Masukan tanggal (1-31) : ");
            tanggal = input.nextInt();
            while (tanggal < 1 || tanggal > 31) {            
                System.out.println(errorMassage);
                System.out.print("| Masukan tanggal (1-31) : ");
                tanggal = input.nextInt();
            }
            System.out.print("| Masukan jumlah orang : ");
            jumlahOrg = input.nextInt();
            System.out.println("---------------------------------------");
            System.out.println("|            Paket Makanan            |");
            System.out.println("---------------------------------------");
            for (int i = 0; i < paketMakanan.length; i++) {
                System.out.println("| " + (i+1) + ". " +paketMakanan[i]+
                        "   Rp." + hargaPaketMakanan[i] + " |");
            }
            System.out.println("| 0. Tidak memesan                    |");
            System.out.println("---------------------------------------");
            System.out.print("| Pilihan paket anda : ");
            pilihPaket = input.nextInt();
            while (pilihPaket > 3 || pilihPaket < 0) {            
                System.out.println(errorMassage);
                System.out.print("| Pilihan paket anda : ");
                pilihPaket = input.nextInt();
            }
            switch(pilihPaket){
                case 1 :
                    paketMakan = jumlahOrg*hargaPaketMakanan[0];
                    break;
                case 2 :
                    paketMakan = jumlahOrg*hargaPaketMakanan[1];
                    break;
                case 3 :
                    paketMakan = jumlahOrg*hargaPaketMakanan[2];
                    break;
                default :
                    System.out.println("| Anda tidak memesan paket makanan");
                    break;
            }
            bayarResTempat += sewaTempat + paketMakan;
            totalResTempat = diskon(tanggal,bayarResTempat);
            System.out.println(infoDiskonPromo(tanggal, bayarResTempat));
            dpResTempat = totalResTempat/2;
            ReservasiTempat = false;
            successMassage();
        } else {
            sudahReservasi();
        }
        
    }
    
    static void reservasiMeja(){
        if (ReservasiMeja == true) {
            // variabel untuk promo
            int tanggal;
            // variabel untuk pilih paket makanan
            int pilihPaket;
            // variabel untuk jumlah orang
            int jumlahOrg;
            // variabel untuk jumlah meja
            int jumlahMeja;
            // variabel untuk transaksi
            int makan = 0;
            int sewaMeja;
            int totalResMeja;
            //program utama
            System.out.println();
            System.out.println("---------------------------------------");
            System.out.println("|            Reservasi Meja           |");
            System.out.println("---------------------------------------");
            do {            
                System.out.print("| Masukan tanggal (1-31) : ");
                tanggal = input.nextInt(); 
            } while (tanggal < 1 || tanggal > 31);
            System.out.print("| Masukan jumlah orang : ");
            jumlahOrg = input.nextInt();
            System.out.print("| Masukan jumlah meja : ");
            jumlahMeja = input.nextInt();
            System.out.println("---------------------------------------");
            System.out.println("|            Paket Makanan            |");
            System.out.println("---------------------------------------");
            for (int i = 0; i < paketMakanan.length; i++) {
                System.out.println("| " + (i+1) + ". " +paketMakanan[i]+
                        "   Rp." + hargaPaketMakanan[i] + " |");
            }
            System.out.println("| 0. Tidak memesan                    |");
            System.out.println("---------------------------------------");
            System.out.print("| Pilihan paket anda : ");
            pilihPaket = input.nextInt();
            while (pilihPaket > 3 || pilihPaket < 0) {            
                System.out.println(errorMassage);
                System.out.print("| Pilihan paket anda : ");
                pilihPaket = input.nextInt();
            }
            switch(pilihPaket){
                case 1 :
                    makan = jumlahOrg*hargaPaketMakanan[0];
                    break;
                case 2 :
                    makan = jumlahOrg*hargaPaketMakanan[1];
                    break;
                case 3 :
                    makan = jumlahOrg*hargaPaketMakanan[2];
                    break;
                default :
                    System.out.println("| Anda tidak memesan paket makanan");
                    break;
            }
            sewaMeja = jumlahMeja*5000;
            bayarResMeja += sewaMeja + makan;
            totalResMeja = diskon(tanggal,bayarResMeja);
            dpResMeja = totalResMeja/2;
            System.out.println(infoDiskonPromo(tanggal, bayarResMeja));
            successMassage();
            ReservasiMeja = false;
        } else {
            sudahReservasi();
        }
        
    }
    
    static void batalPesan(){
        int pilihBatal;
        double uangSekarang,uangKembali;
        double penguranganUang;
        String warning = "| Anda belum melakukan reservasi      |";
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("|          Pembatalan Pesanan         |");
        System.out.println("---------------------------------------");
        System.out.println("| 1. Reservasi Tempat                 |");
        System.out.println("| 2. Reservasi Meja                   |");
        System.out.println("| 0. Kembali                          |");
        System.out.println("---------------------------------------");
        System.out.print("| Masukan pilihan anda : ");
        pilihBatal = input.nextInt();
        while (pilihBatal > 2 || pilihBatal < 0) {       
            System.out.println(errorMassage);
            System.out.print("| Masukan pilihan anda : ");
            pilihBatal = input.nextInt();
        }
        switch(pilihBatal){
            case 1 : 
                if (dpResTempat <= 0) {
                    System.out.println(warning);
                }else {
                    uangSekarang = dpResTempat;
                    penguranganUang = uangSekarang*0.25;
                    uangKembali = uangSekarang-penguranganUang;
                    System.out.println("| Uang anda    : Rp" + (int)uangSekarang +
                            "              |");
                    System.out.println("| Uang kembali : Rp" + (int)uangKembali +
                            "              |");
                    dpResTempat = 0;
                    bayarResTempat = 0;
                    ReservasiTempat = true;
                }
                break;
            case 2 :
                if (dpResMeja <= 0) {
                    System.out.println(warning);
                }else {
                    uangSekarang = dpResMeja;
                    penguranganUang = uangSekarang*0.20;
                    uangKembali = uangSekarang-penguranganUang;
                    System.out.println("| Uang anda    : Rp" + (int)uangSekarang);
                    System.out.println("| Uang kembali : Rp" + (int)uangKembali);
                    dpResMeja = 0;
                    bayarResMeja = 0;
                    ReservasiMeja = true;
                }
                break;
            default :
                System.out.println("| Anda tidak membatalkan reservasi |");
                break;
        }
        System.out.println("---------------------------------------");  
    }
    
    static void cetakPesanan(){
        // variabel untuk total pembayaran
        int totalBayar;
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("|           Nota Pembayaran           |");
        System.out.println("---------------------------------------");
        if (totalBayarMakan > 0) {
           System.out.println("| Pesanan Makanan        : Rp" + totalBayarMakan);
        }
        if (dpResTempat > 0) {           
           System.out.println("| DP Reservasi Tempat    : Rp" + dpResTempat);
        }
        if (dpResMeja > 0) {
           System.out.println("| DP Reservasi Meja      : Rp" + dpResMeja);
        }
        totalBayar = totalBayarMakan + dpResTempat + dpResMeja;
        if (totalBayar == 0) {
            System.out.println("| Anda belum memesan / reservasi      |");
        } else {
            System.out.println("| Total Pembayaran       : Rp" + totalBayar);
        }
        System.out.println("---------------------------------------");
    }
    
    static String infoDiskonPromo(int tanggal, int uang) {
        String info = "";
        if (tanggal==2||tanggal==10||tanggal==13 ) {
            if (uang >= 200000 && uang <= 400000) {
                info = "| Selamat anda mendapat diskon 3%";
            }else if (uang > 400000 && uang <= 600000) {
                info = "| Selamat anda mendapat diskon 4%";
            }else if (uang > 600000) {
                info = "| Selamat anda mendapat diskon 4,2%";
            }
        }else {
            if (uang >= 200000 && uang <= 400000) {
                info = "| Selamat anda mendapat diskon 1,5%";
            }else if (uang > 400000 && uang <= 600000) {
                info = "| Selamat anda mendapat diskon 2,5%";
            }else if (uang > 600000) {
                info = "| Selamat anda mendapat diskon 2,7%";
            }
        } 
        return info;
    }
    
    static int diskon(int tanggal,int uang){   
        if (tanggal==2||tanggal==10||tanggal==13){
            if (uang >= 200000 && uang <= 400000) {
                uang -= uang * 3 / 100; // uang = uang - (uang*3%)
            }else if (uang > 400000 && uang <= 600000) {
                uang -= uang * 4 / 100;
            }else if (uang > 600000) {
                uang -= uang * 42 / 1000;
            }
        } else {
            if (uang >= 200000 && uang <= 400000) {
                uang -= uang * 15 / 1000;
            }else if (uang > 400000 && uang <= 600000) {
                uang -= uang * 25 / 1000;
            }else if (uang > 600000) {
                uang -= uang * 27 / 1000;
            }
        }
        return uang;
    }
    
    static void sudahReservasi(){
        System.out.println("| Anda sudah melakukan reservasi");
        System.out.println("| Silahkan cek dicetak pesanan");
        System.out.println("| Atau batalkan reservasi lebih dulu");
        System.out.println("---------------------------------------");
    }
    
    static void successMassage(){
        System.out.println("---------------------------------------");
        System.out.println("|          Proses berhasil...!        |");
        System.out.println("---------------------------------------");
    }
}
