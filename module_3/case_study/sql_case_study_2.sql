create database csdl_case_study;
use csdl_case_study;


-- vi trí - trinh do - bo_phan -> nhan viên
create table vi_tri
(ma_vi_tri int primary key not null auto_increment,
ten_vi_tri varchar(50));

create table trinh_do
(ma_trinh_do int primary key not null auto_increment,
ten_trinh_do varchar(50));

create table bo_phan
(ma_bo_phan int primary key not null auto_increment,
ten_bo_phan varchar(50));

create table nhan_vien
(ma_nhan_vien int primary key not null auto_increment,
ho_ten varchar(50),
ngay_sinh date,
so_cmnd varchar(50),
luong double,
so_dt varchar(50),
email varchar(50),
dia_chi varchar(50),
ma_vi_tri int,
ma_trinh_do int,
ma_bo_phan int,
foreign key (ma_vi_tri) references vi_tri(ma_vi_tri),
foreign key (ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key (ma_bo_phan) references bo_phan(ma_bo_phan)
 );
 
 -- loai khach -> khach hang
 create table loai_khach
 (ma_loai_khach int primary key not null ,
 ten_loai_khach varchar(50));
 create table khach_hang
 (ma_khach_hang int primary key not null,
 
 ho_ten varchar(50),
 ngay_sinh date,
 gioi_tinh bit(1),
 so_cmnd varchar(50),
 so_dt varchar(50),
 email varchar(50),
 dia_chi varchar(50),
 ma_loai_khach int,
 foreign key (ma_loai_khach) references loai_khach(ma_loai_khach));
 
 -- loai dich vu - kieu thue -> dich vu
 
 create table loai_dich_vu
 (ma_loai_dich_vu int primary key not null,
 ten_loai_dich_vu varchar(50));
 
 create table kieu_thue
 (ma_kieu_thue int primary key not null,
 ten_kieu_thue varchar (50));
 
 create table dich_vu
 (ma_dich_vu int primary key not null,
 ten_dich_vu varchar (50),
 dien_tich int,
 chi_phi_thue double,
 so_nguoi_toi_da double,
 tieu_chuan_phong varchar (50),
 mo_ta_tien_nghi_khac varchar (50),
 dien_tich_ho_boi double,
 so_tang int,
 ma_kieu_thue int ,
 ma_loai_dich_vu int,
 foreign key (ma_kieu_thue) references kieu_thue(ma_kieu_thue),
 foreign key (ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
 );
 
 
 -- dich vu di kem -> hop dong chi tiet
 create table dich_vu_di_kem
 (ma_dich_vu_di_kem int primary key not null,
 ten_dich_vu_di_kem varchar(50),
 gia double,
 don_vi varchar(50),
 trang_thai varchar(50));


 create table hop_dong
 (ma_hop_dong int primary key not null,
 ngay_lam_hop_dong datetime,
 ngay_ket_thuc datetime,
 tien_dat_coc double,
 ma_nhan_vien int,
 ma_khach_hang int,
 ma_dich_vu int,
 foreign key (ma_nhan_vien) references nhan_vien (ma_nhan_vien),
 foreign key (ma_khach_hang) references khach_hang (ma_khach_hang),
 foreign key (ma_dich_vu) references dich_vu (ma_dich_vu)
 );


 create table hop_dong_chi_tiet
 (ma_hop_dong_chi_tiet int primary key not null,
 so_luong int,
 ma_hop_dong int ,
 ma_dich_vu_di_kem int,
 
 foreign key (ma_hop_dong) references hop_dong(ma_hop_dong),
 foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
 );
 