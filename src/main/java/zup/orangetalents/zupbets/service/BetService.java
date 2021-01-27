package zup.orangetalents.zupbets.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zup.orangetalents.zupbets.DTO.BetDTO;
import zup.orangetalents.zupbets.entity.Bet;
import zup.orangetalents.zupbets.mapper.BetMapper;
import zup.orangetalents.zupbets.repository.BetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BetService {

  private final BetRepository repository;
  private final BetMapper betMapper = BetMapper.INSTANCE;


  public List<BetDTO> getAllBetsByEmail(String email) {

    return repository
        .findByEmail(email)
        .stream()
        .map(betMapper::toDTO)
        .collect(Collectors.toList());
  }

  public BetDTO createBet(String email) {
    Bet bet = generateBet(email);
    repository.save(bet);
    return betMapper.toDTO(bet);
  }

  private Bet generateBet(String email) {
    List<Integer> numbersGenerated = generateNumbers();

    String numbersToBet = numbersGenerated.stream()
        .sorted()
        .map(String::valueOf)
        .collect(Collectors.joining("-"));

    Bet bet = new Bet();
    bet.setEmail(email);
    bet.setNumbers(numbersToBet);
    return bet;
  }

  private List<Integer> generateNumbers() {
    List<Integer> numbers = new ArrayList<>();

    while(numbers.size() < 6) {
      int n = (int) (Math.random() * 60) + 1;
      if(!numbers.contains(n)) {
        numbers.add(n);
      }
    }
    return numbers;
  }

}
