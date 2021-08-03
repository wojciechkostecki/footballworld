package com.example.footballworld.mapper;

import com.example.footballworld.model.Club;
import com.example.footballworld.model.dto.ClubDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClubMapper extends EntityMapper<ClubDTO, Club>{
}
