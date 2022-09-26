package springjpa.springjpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import springjpa.springjpa.entity.NhanVien;

@Repository
@Transactional
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
//	3
	@Query(value = "select * from nhanvien where luong < ?1", nativeQuery = true)
	List<NhanVien> nhanVienLuongnho10000(int luong);

//	8
	@Query(value = "select SUM(luong) from nhanvien ", nativeQuery = true)
	int tongLuongNhanVien();

//	9
	@Query(nativeQuery = true, value = "select manv  from chungnhan where mamb IN (select mamb from maybay where loai like ?1)")
	List<String> maNVMBBoeing(String loai);

//	10
	@Query(value = "select * from nhanvien nv JOIN chungnhan cn on nv.manv = cn.manv Join maybay mb on mb.mamb = cn.mamb where mb.mamb=?1", nativeQuery = true)
	List<NhanVien> nhanVienMB747(String mb);

//	12
	@Query(nativeQuery = true, value = "SELECT nhanvien.manv FROM nhanvien WHERE nhanvien.manv IN (SELECT DISTINCT manv FROM chungnhan WHERE mamb IN (SELECT mamb FROM maybay WHERE loai LIKE ?1)) AND nhanvien.manv IN ( SELECT DISTINCT manv FROM chungnhan WHERE mamb IN (SELECT mamb FROM maybay WHERE loai LIKE ?2) )")
	List<String> maNVBoeingAirbus(String mb1, String mb2);

//	15
//	vidu: loai Boeing => loai = "Boeing%" theo de bai
	@Query(value = "select DISTINCT nv.ten from chungnhan c join maybay mb on c.mamb = mb.mamb join nhanvien nv on nv.manv = c.manv where loai like ?1 ", nativeQuery = true)
	List<String> tenNVBoeing(String loai);
}
