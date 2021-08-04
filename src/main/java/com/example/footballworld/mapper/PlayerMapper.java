package com.example.footballworld.mapper;

import org.mapstruct.Mapper;
import com.example.footballworld.model.Player;
import com.example.footballworld.model.dto.PlayerDTO;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper extends EntityMapper<PlayerDTO, Player> {

    @Mapping(target = "club.id",source = "clubId")
    Player toEntity(PlayerDTO playerDTO);
}
