package by.alex.certws.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import by.alex.certws.domain.Certificate;

public interface CertificatesRepository extends PagingAndSortingRepository<Certificate, Long> {

}
