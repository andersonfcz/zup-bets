package zup.orangetalents.zupbets.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zup.orangetalents.zupbets.DTO.BetDTO;
import zup.orangetalents.zupbets.service.BetService;

import java.util.List;

@RestController
@RequestMapping("/api/bets")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BetsController {

  private final BetService service;

  @GetMapping("/{email}")
  public List<BetDTO> getAllBetsByEmail(@PathVariable String email) {
      return service.getAllBetsByEmail(email);
  }

  @PostMapping("/{email}")
  public BetDTO createBet(@PathVariable String email) {
    return service.createBet(email);
  }
}
