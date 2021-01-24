package by.alex.certws.controller;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.alex.certws.domain.Certificate;

@RestController
public class CertificcatesRouter {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/certificates")
	public Iterable<Certificate> listCertificates() {
		ArrayList<Certificate> list = new ArrayList<Certificate>();
		list.add(new Certificate(counter.incrementAndGet(), "Hello World"));
		list.add(new Certificate(counter.incrementAndGet(), "Hello World with content", "A hello world certificate"));
		list.add(new Certificate(counter.incrementAndGet(), "Hello World with content and tags",
				"A hello world certificate", new String[] { "Java", "2021", "App of the year" }));
		return list;
	}

	@GetMapping("/certificate")
	public Certificate getCertificate(@RequestParam(name = "certId") long CertId) {
		return new Certificate(CertId, String.format("Hello World #%d with content and tags", CertId),
				"A hello world certificate", new String[] { "Java", "2021", "App of the year" });
	}

}
