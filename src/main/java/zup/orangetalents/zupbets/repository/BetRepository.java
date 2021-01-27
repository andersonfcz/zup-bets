package zup.orangetalents.zupbets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zup.orangetalents.zupbets.entity.Bet;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet, String> {

  List<Bet> findByEmail(String email);

}
