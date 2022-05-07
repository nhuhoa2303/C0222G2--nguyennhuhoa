package case_study2.common.validate;


import java.util.Scanner;

public class RegexService {
    private static Scanner scanner = new Scanner(System.in);
    private static Validate validate = new Validate();

    public static String regexTieuChuanPhong(String tieuChuanPhong) {
        while (!validate.isMatchesTen(tieuChuanPhong)) {
            System.out.println("nhập sai, kiểu thuê phải viết hoa ký tự đầu, các ký tự sau là ký tự bình thường: ");
            tieuChuanPhong = scanner.nextLine();
        }
        return tieuChuanPhong;
    }

    public static String regexKieuThue(String kieuThue) {
        while (!validate.isMatchesTen(kieuThue)) {
            System.out.println("nhập sai, kiểu thuê phải viết hoa ký tự đầu, các ký tự sau là ký tự bình thường: ");
            kieuThue = scanner.nextLine();
        }
        return kieuThue;
    }

    //-	Số tầng phải là số nguyên dương.
    public static String regexSoTang(String soTang) {
        while (!validate.isMatchesSoTang(soTang)) {
            System.out.println("nhập sai định dạng số tầng phải là số nguyên dương: ");
            soTang = scanner.nextLine();
        }
        return soTang;
    }

    //-	Chi phí thuê phải là số dương
    public static String regexChiPhi(String chiPhiThue) {
        while (!validate.isMatchesChiPhiThue(chiPhiThue)) {
            System.out.println("nhập sai định dạng chi phí thuê phải là số dương: ");
            chiPhiThue = scanner.nextLine();
        }
        return chiPhiThue;
    }

    //-	Mã dịch vụ phải đúng định dạng: SVXX-YYYY, với YYYY là các số từ 0-9, XX là:
    //-	Nếu là Villa thì XX sẽ là VL


    public static String regexMaDichVuVilla(String maDichVu) {
        while (!validate.isMatchesVilla(maDichVu)) {
            System.out.println("định dạng sai, định dạng đúng: SVXX-YYYY(Villa thì XX sẽ là VL): ");
            maDichVu = scanner.nextLine();
        }
        return maDichVu;
    }

    public static String regexMaDichVuHouse(String maDichVu) {
        while (!validate.isMatchesHouse(maDichVu)) {
            System.out.println("định dạng sai, định dạng đúng: SVXX-YYYY(Villa thì XX sẽ là HO): ");
            maDichVu = scanner.nextLine();
        }
        return maDichVu;
    }

    public static String regexMaDichVuRoom(String maDichVu) {
        while (!validate.isMatchesRoom(maDichVu)) {
            System.out.println("định dạng sai, định dạng đúng: SVXX-YYYY(Villa thì XX sẽ là RO): ");
            maDichVu = scanner.nextLine();
        }
        return maDichVu;
    }

    //-	Tên dịch vụ phải viết hoa ký tự đầu, các ký tự sau là ký tự bình thường
    public static String regexTenDichVu(String tenDichVu) {
        while (!validate.isMatchesTen(tenDichVu)) {
            System.out.println("nhap sai, tên dịch vụ phải viết hoa ký tự đầu, các ký tự sau là ký tự bình thường: ");
            tenDichVu = scanner.nextLine();
        }
        return tenDichVu;
    }

    //-	Số lượng người tối đa phải >0 và nhỏ hơn <20
    public static String regexSoLuongNguoi(String soLuongNguoi) {
        while (!validate.isMatchesSoLuongNguoi(soLuongNguoi)) {
            System.out.println("nhập sai,số lượng người tối đa phải >0 và nhỏ hơn <20: ");
            soLuongNguoi = scanner.nextLine();
        }
        return soLuongNguoi;
    }


    //-	Diện tích sử dụng và diện tích hồ bơi phải là số thực lớn hơn 30m2
    public static String regexDienTichHoBoi(String dienTichHoBoi) {
        while (!validate.isMatchesDienTich(dienTichHoBoi)) {
            System.out.println("nhập sai, diện tích hồ bơi phải là số thực lớn hơn 30m2: ");
            dienTichHoBoi = scanner.nextLine();
        }
        return dienTichHoBoi;
    }

    public static String regexDienTichSD(String dienTichSD) {
        while (!validate.isMatchesDienTich(dienTichSD)) {
            System.out.println("nhập sai, diện tích sử dụng phải >30m2: ");
            dienTichSD = scanner.nextLine();
        }
        return dienTichSD;
    }


}
