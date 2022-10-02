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
		System.out.println("8.	Cho biết tổng số lương phải trả cho các nhân viên.");
		int total = nhanVienRepository.tongLuongNhanVien();
		System.out.println(total);

	}

	@Test
	void test_9() {
		System.out.println("9.	Cho biết mã số của các phi công lái máy báy Boeing.");
		List<String> ls = nhanVienRepository.maNVMBBoeing("Boeing%");
		for (String ma : ls) {
			System.out.println(ma);
		}

	}

	@Test
	void test_10() {
		System.out.println("10.	Cho biết các nhân viên có thể lái máy bay có mã số 747.");
		List<NhanVien> ls = nhanVienRepository.nhanVienMB747("747");
		for (NhanVien cn : ls) {
			System.out.println(cn);
		}

	}

	@Test
	void test_11() {
		System.out.println("11.	Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.");
		List<String> ls = chungNhanRepository.findMMBtenHo("Nguyen");
		System.out.println(ls);
	}

	@Test
	void test_12() {
		System.out.println("12.	Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.");
		List<String> ls = nhanVienRepository.maNVBoeingAirbus("Airbus%", "Boeing%");
		System.out.println(ls);
	}

	@Test
	void test_13() {
		System.out.println("13.	Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.");
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
		System.out.println("15.	Cho biết tên của các phi công lái máy bay Boeing.");
		List<String> ls = nhanVienRepository.tenNVBoeing("Boeing%");
		for (String nv : ls) {
			System.out.println(nv);
		}

	}

	@Test
	void test_16() {
		System.out.println("16.	Với mỗi loại máy bay có phi công lái cho biết mã số, loại máy báy và tổng số phi công có thể lái loại máy bay đó.");
		List<Object> ls = mayBayRepository.thongTinMoiLoaiMayBay();
		for (Object o : ls) {
			System.out.println(gson.toJson(o).toString());
		}
	}

}