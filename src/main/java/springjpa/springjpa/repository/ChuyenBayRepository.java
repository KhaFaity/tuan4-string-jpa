package springjpa.springjpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import springjpa.springjpa.entity.ChuyenBay;



@Repository
@Transactional
public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String>{
//	1
	List<ChuyenBay> timTatCa(String gaDen);
//	4
	@Query(nativeQuery = true, value = "select * from chuyenbay where do_dai < ?1 and do_dai > ?2")
	List<ChuyenBay> chuyenBayfrom10000to8000(int cond1, int cond2);
//	5
	@Query(nativeQuery = true, value = "select * from chuyenbay where ga_di = ?1 and ga_den = ?2")
	List<ChuyenBay> chuyenBaySGtoBMV(String from, String to);
//	6
	@Query(nativeQuery = true, value = "select * from chuyenbay where ga_di = ?1 ")
	List<ChuyenBay> soChuyenbaySG(String from);
	

}
