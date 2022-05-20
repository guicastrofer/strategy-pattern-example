package br.com.workshop.labs.respository;

import br.com.workshop.labs.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
}
