package com.ept.eptmanagement.Mapper;

import com.ept.eptmanagement.dto.OffreDto;
import com.ept.eptmanagement.model.Offre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OfferMapper {

    OfferMapper INSTANCE = Mappers.getMapper(OfferMapper.class);


    /**
     * Method to map from Dto object to offre object.
     *
     * @param offreDto Dto object to map
     */
    @Mapping(source = "exstudentId", target = "exstudent.id")
    Offre toEntity(OffreDto offreDto);

    /**
     * Method to map from offre object to Dto object.
     *
     * @param offre offre object to map
     */
    OffreDto toDto(Offre offre);
}
