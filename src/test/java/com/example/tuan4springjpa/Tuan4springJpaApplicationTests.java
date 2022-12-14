package com.example.tuan4springjpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.google.gson.Gson;

import com.example.tuan4springjpa.entity.ChuyenBay;
import com.example.tuan4springjpa.entity.MayBay;
import com.example.tuan4springjpa.entity.NhanVien;
import com.example.tuan4springjpa.repository.ChungNhanRepository;
import com.example.tuan4springjpa.repository.ChuyenBayRepository;
import com.example.tuan4springjpa.repository.MayBayRepository;
import com.example.tuan4springjpa.repository.NhanVienRepository;

@SpringBootTest
class SpringJpaApplicationTests {
	Gson gson = new Gson();

	@Autowired
	ChuyenBayRepository chuyenBayRepository;

	@Autowired
	NhanVienRepository nhanVienRepository;

	@Autowired
	MayBayRepository mayBayRepository;

	@Autowired
	ChungNhanRepository chungNhanRepository;

//	@Test
//	void test_1() {
//		System.out.println("1. chuyen bay di dalat");
//		List<ChuyenBay> ls = chuyenBayRepository.timTatCa("DAD");
//		System.out.println(ls);
//
//	}
	@Test
	void test_2() {
		System.out.println("2. chuyen bay co ho 10.000 km");
		List<MayBay> ls = mayBayRepository.findMayBayLon(10000);
		System.out.println(ls);
	}

	@Test
	void test_3() {
		System.out.println("3. nhan vien co luong nho hon 10.000");
		List<MayBay> ls = mayBayRepository.findMayBayLon(10000);
		System.out.println(ls);
	}

	@Test
	void test_4() {
		System.out.println("4. chuyen bay co do dai >8.000km, <10.000km");
		List<ChuyenBay> ls = chuyenBayRepository.chuyenBayfrom10000to8000(10000, 8000);
		for (ChuyenBay cb : ls) {
			System.out.println(cb);
		}
	}

	@Test
	void test_5() {
		System.out.println("5. chuyen bay xuat phat tu sai gon den buon me thuot");
		List<ChuyenBay> ls = chuyenBayRepository.chuyenBaySGtoBMV("SGN", "BMV");
		for (ChuyenBay cb : ls) {
			System.out.println(cb);
		}
	}

	@Test
	void test_6() {
		System.out.println("6. co bao nhieu chuyen bay xuat phat tu sai gon");
		List<ChuyenBay> ls = chuyenBayRepository.soChuyenbaySG("SGN");
		for (ChuyenBay cb : ls) {
			System.out.println(cb);
		}
	}

	@Test
	void test_7() {
		System.out.println("7. co bao nhieu may bay boeing");
		List<MayBay> ls = mayBayRepository.chuyenBayBoeing("Boeing");
		for (MayBay mb : ls) {
			System.out.println(mb);
		}
	}

	@Test
	void test_8() {
		System.out.println("8.	Cho bi???t t???ng s??? l????ng ph???i tr??? cho c??c nh??n vi??n.");
		int total = nhanVienRepository.tongLuongNhanVien();
		System.out.println(total);

	}

	@Test
	void test_9() {
		System.out.println("9.	Cho bi???t m?? s??? c???a c??c phi c??ng l??i m??y b??y Boeing.");
		List<String> ls = nhanVienRepository.maNVMBBoeing("Boeing%");
		for (String ma : ls) {
			System.out.println(ma);
		}

	}

	@Test
	void test_10() {
		System.out.println("10.	Cho bi???t c??c nh??n vi??n c?? th??? l??i m??y bay c?? m?? s??? 747.");
		List<NhanVien> ls = nhanVienRepository.nhanVienMB747("747");
		for (NhanVien cn : ls) {
			System.out.println(cn);
		}

	}

	@Test
	void test_11() {
		System.out.println("11.	Cho bi???t m?? s??? c???a c??c lo???i m??y bay m?? nh??n vi??n c?? h??? Nguy???n c?? th??? l??i.");
		List<String> ls = chungNhanRepository.findMMBtenHo("Nguyen");
		System.out.println(ls);
	}

	@Test
	void test_12() {
		System.out.println("12.	Cho bi???t m?? s??? c???a c??c phi c??ng v???a l??i ???????c Boeing v???a l??i ???????c Airbus.");
		List<String> ls = nhanVienRepository.maNVBoeingAirbus("Airbus%", "Boeing%");
		System.out.println(ls);
	}

	@Test
	void test_13() {
		System.out.println("13.	Cho bi???t c??c lo???i m??y bay c?? th??? th???c hi???n chuy???n bay VN280.");
		List<MayBay> ls = mayBayRepository.chuyenBayVN280("VN280");
		for (MayBay mb : ls) {
			System.out.println(mb.getLoai());
		}
	}

	@Test
	void test_14() {
		
	}

	@Test
	void test_15() {
		System.out.println("15.	Cho bi???t t??n c???a c??c phi c??ng l??i m??y bay Boeing.");
		List<String> ls = nhanVienRepository.tenNVBoeing("Boeing%");
		for (String nv : ls) {
			System.out.println(nv);
		}

	}

	@Test
	void test_16() {
		System.out.println("16.	V???i m???i lo???i m??y bay c?? phi c??ng l??i cho bi???t m?? s???, lo???i m??y b??y v?? t???ng s??? phi c??ng c?? th??? l??i lo???i m??y bay ????.");
		List<Object> ls = mayBayRepository.thongTinMoiLoaiMayBay();
		for (Object o : ls) {
			System.out.println(gson.toJson(o).toString());
		}
	}

}