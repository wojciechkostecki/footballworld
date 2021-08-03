package com.example.footballworld.mapper;

import com.example.footballworld.model.Player;
import com.example.footballworld.model.dto.PlayerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper extends EntityMapper<PlayerDTO, Player> {

    @Mapping(target = "id", source = "clubId")
    Player toEntity(PlayerDTO playerDTO);
}
