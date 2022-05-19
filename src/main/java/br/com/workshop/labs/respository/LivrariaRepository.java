package br.com.workshop.labs.respository;

import br.com.workshop.labs.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivrariaRepository extends JpaRepository<Livro, Integer> {

    @Query(nativeQuery = true, value = "select * from Livro")
    List<Livro> listaTodosLivros();

    @Query(nativeQuery = true, value = "select * from Consumer where FOOD_CARD_NUMBER = ? ")
    Livro findByFoodCardNumber(int cardNumber);

    @Query(nativeQuery = true, value = "select * from Consumer where FUEL_CARD_NUMBER = ? ")
    Livro findByFuelCardNumber(int cardNumber);

    @Query(nativeQuery = true, value = "select * from Consumer where DRUGSTORE_NUMBER = ? ")
    Livro findByDrugstoreNumber(int cardNumber);
}
