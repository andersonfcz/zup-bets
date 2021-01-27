package zup.orangetalents.zupbets.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import zup.orangetalents.zupbets.DTO.BetDTO;
import zup.orangetalents.zupbets.entity.Bet;

@Mapper
public interface BetMapper {

  BetMapper INSTANCE = Mappers.getMapper(BetMapper.class);


  BetDTO toDTO(Bet bet);
}
