package com.aarouf.bootingweb.repository;

import com.aarouf.bootingweb.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
