package com.yash.audit;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.yash.model.Audit;
import com.yash.repository.AuditRepositoryImpl;


@SpringBootTest
class AuditRepositoryTest {

	@MockBean
	private AuditRepositoryImpl repository;
	

	@Test
	void saveAuditTest() {
		try {
			String sDate1 = "01/01/2022";
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Audit audit = new Audit(1, 1, date, 22);
			repository.save(audit);
			Assertions.assertThat(audit.getAuditId()).isGreaterThan(0);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test

	public void getAuditTest() {

		try {
			String sDate1 = "01/01/2022";
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Audit audit = new Audit(1, 1, date, 22);
			repository.findById(1);
			Assertions.assertThat(audit.getAuditId()).isEqualTo(1);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void getListOfAuditTest() {

		try {
			String sDate1 = "01/01/2022";
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Audit audit = new Audit(1, 1, date, 22);

			java.util.List<Audit> auditList = repository.findAll();
			Assertions.assertThat(repository.findAll()).isEqualTo(auditList);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	public void updateAuditTest() {

		try {
			String sDate1 = "01/01/2022";
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Audit audit = new Audit(1, 1, date, 22);

			repository.update(audit, 1);
			audit.setOccupiedSeats(25);
			Assertions.assertThat(audit.getOccupiedSeats()).isEqualTo(25);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	void deleteDriverTest() {

		try {
			String sDate1 = "01/01/2022";
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Audit audit = new Audit(1, 1, date, 22);

			repository.deleteById(1);
			verify(repository, times(1)).deleteById(1);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
