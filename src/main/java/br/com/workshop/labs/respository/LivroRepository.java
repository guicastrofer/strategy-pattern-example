package br.com.workshop.labs.respository;

import br.com.workshop.labs.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
