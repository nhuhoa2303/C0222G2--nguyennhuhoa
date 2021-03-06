create database quan_ly_diem_thi;
drop database  quan_ly_diem_thi;
use quan_ly_diem_thi;

create table hoc_sinh(
ma_hoc_sinh int primary key,
ten_hoc_sinh varchar(50) ,
ngay_sinh datetime,
lop varchar(20),
gt varchar(20));
select*from hoc_sinh;
insert into hoc_sinh value 
(1,'hoa',23/03/2022,'1a','hocyeu'),
(2,'hoa2',23/03/2022,'1a','hoctb');
truncate table hoc_sinh;

create table mon_hoc(
ma_mon_hoc int primary key,
ten_mon_hoc varchar(50) );
select*from mon_hoc;
insert into mon_hoc value
(1,'toan'),
(2,'anh');

create table bang_diem(
ma_hoc_sinh int,
ma_mon_hoc int,
diem_thi int,
ngay_kt datetime,
 primary key (ma_hoc_sinh, ma_mon_hoc),
constraint fk_bang_diem_hoc_sinh foreign key (ma_hoc_sinh) references hoc_sinh(ma_hoc_sinh),
constraint fk_bang_diem_mon_hoc foreign key (ma_mon_hoc) references mon_hoc(ma_mon_hoc)
);
select*from bang_diem;
insert into bang_diem value
(1,2,10,2/2/2022),
(2,1,3,2/2/2022);

create table giao_vien(
ma_giao_vien  varchar(20) primary key,
ten_gv varchar(20),
sdt varchar(10)
);
select*from giao_vien;
alter table mon_hoc add ma_giao_vien varchar(20);
alter table mon_hoc add constraint fk_ma_giao_vien foreign key(ma_giao_vien) references giao_vien(ma_giao_vien);