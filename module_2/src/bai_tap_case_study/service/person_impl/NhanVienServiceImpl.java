package bai_tap_case_study.service.person_impl;

import bai_tap_case_study.model.person.Employee;
import bai_tap_case_study.service.interf.i_preson.INhanVienService;

import java.util.ArrayList;
import java.util.Scanner;

public class NhanVienServiceImpl implements INhanVienService {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Employee> employeeArrayList = new ArrayList<>();

    static {
        //id, name, birth, gender, soCMND, soDienThoai, email, level, viTri, luong
        employeeArrayList.add(new Employee(1,"hoa1","23/3","nam",123,0122,"hoa123","cao đẳng","nhan vien","100"));
        employeeArrayList.add(new Employee(2,"hoa1","23/3","nam",123,0122,"hoa123","đại học","quản lí","200"));
        employeeArrayList.add(new Employee(3,"hoa1","23/3","nam",123,0122,"hoa123","sau đại học","giám đốc","500"));
//        employeeArrayList = ReadAll.readNhanVien();
    }



    @Override
    public void add() {
        methodAdd();
    }

    private void methodAdd() {
        System.out.print("them id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("them ho ten: ");
        String name = scanner.nextLine();
        System.out.print("them ngay sinh: ");
        String birth = scanner.nextLine();
        System.out.print("them gioi tinh: ");
        String gender = scanner.nextLine();
        System.out.print("them so CMND: ");
        int soCMND = Integer.parseInt(scanner.nextLine());
        System.out.print("them so dien thoai: ");
        int soDienThoai = Integer.parseInt(scanner.nextLine());
        System.out.print("them email: ");
        String email = scanner.nextLine();
        System.out.print("trinh do: ");
        String level = scanner.nextLine();
        System.out.print("them vi tri: ");
        String viTri = scanner.nextLine();
        System.out.print("them luong: ");
        String luong = scanner.nextLine();
        Employee employee = new Employee(id, name, birth, gender, soCMND, soDienThoai, email, level, viTri, luong);
        System.out.print(employee);
        employeeArrayList.add(employee);
//        WriteAll.writeNhanVien(employeeArrayList,true);
    }

    @Override
    public void display(){
//        employeeArrayList= ReadAll.readNhanVien();
        for (Employee employee : employeeArrayList) {
            System.out.println(employee);
        }
    }

    @Override
    public void edit() {
        suaNhanVien();
    }

    private void suaNhanVien() {
        System.out.print("nhap id: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        for (int i = 0; i < employeeArrayList.size(); i++) {
            if (id == (employeeArrayList.get(i ).getId())) {
                flag = true;
                System.out.print("them ho ten: ");
                String name = scanner.nextLine();
                System.out.print("them ngay sinh: ");
                String birth = scanner.nextLine();
                System.out.print("them gioi tinh: ");
                String gender = scanner.nextLine();
                System.out.print("them so CMND: ");
                int soCMND = Integer.parseInt(scanner.nextLine());
                System.out.print("them so dien thoai: ");
                int soDienThoai = Integer.parseInt(scanner.nextLine());
                System.out.print("them email: ");
                String email = scanner.nextLine();
                System.out.print("trinh do: ");
                String level = scanner.nextLine();
                System.out.print("them vi tri: ");
                String viTri = scanner.nextLine();
                System.out.print("them luong: ");
                String luong = scanner.nextLine();
                Employee employee = new Employee(id, name, birth, gender, soCMND, soDienThoai, email, level, viTri, luong);
                System.out.print(employee);
                employeeArrayList.set(i, employee);
                break;
            }
        }
        if (flag == false) {
            System.out.println("ko ton tại ");
        }
    }
}
