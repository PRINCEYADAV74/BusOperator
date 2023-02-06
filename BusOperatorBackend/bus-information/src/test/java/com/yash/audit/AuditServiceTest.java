package com.yash.audit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.model.Audit;
import com.yash.repository.AuditRepositoryImpl;
import com.yash.service.AuditService;

@SpringBootTest
class AuditServiceTest {

	@Autowired
	private AuditService service;

	@MockBean
	private AuditRepositoryImpl repository;

	@Test
	void getAuditTest() {

		try {
			String sDate1 = "01/01/2022";
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			when(repository.findAll()).thenReturn(Stream.of(new Audit(1, 1, date, 22)).collect(Collectors.toList()));
			assertEquals(1, service.findAll().size());

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	void findAuditById() {

		try {
			String sDate1 = "01/01/2022";
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Audit audit = new Audit(1, 1, date, 22);

			when(repository.findById(1)).thenReturn(audit);
			assertEquals(audit, service.findById(1));
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	void saveAuditTest() {

		try {
			String sDate1 = "01/01/2022";
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Audit audit = new Audit(1, 1, date, 22);
			repository.save(audit);
			java.util.List<Audit> auditList = repository.findAll();
			Assertions.assertThat(service.findAll()).isEqualTo(auditList);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	void deleteAuditTest() {
		try {
			String sDate1 = "01/01/2022";
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			Audit audit = new Audit(1, 1, date, 22);

			repository.deleteById(1);
			Assertions.assertThat(service.findAll()).isEmpty();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	void updateAuditTest() {
		try {
			String sDate1 = "01/01/2022";
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			Audit audit = new Audit(1, 1, date, 22);

			System.out.println("Old Audit Schedule Id :- " + audit.getScheduleId());
			repository.update(audit, 1);
			audit.setScheduleId(2);
			verify(repository, times(1)).update(audit, 1);
			System.out.println("Old Audit Schedule Id :- " + audit.getScheduleId());

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
