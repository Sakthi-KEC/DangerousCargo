package net.microservices.unNumberAndGroup.appUtils;

import net.microservices.unNumberAndGroup.dto.UnGroupDto;
import net.microservices.unNumberAndGroup.dto.UnNumberDto;
import net.microservices.unNumberAndGroup.models.UnGroup;
import net.microservices.unNumberAndGroup.models.UnNumber;
import org.springframework.beans.BeanUtils;

public class AppUtils
{
    // To convert UnGroup dto to entity
    public static UnGroup groupDtoToEntity(UnGroupDto dto)
    {
        UnGroup ungroup=new UnGroup();
        BeanUtils.copyProperties(dto,ungroup);
        return ungroup;
    }

    // To convert UnGroup entity to dto
    public static UnGroupDto groupEntityToDto(UnGroup entity)
    {
        UnGroupDto dto=new UnGroupDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

    // To convert UnNumber dto to entity
    public static UnNumber numberDtoToEntity(UnNumberDto dto)
    {
        UnNumber entity=new UnNumber();
        BeanUtils.copyProperties(dto,entity);
        return entity;
    }

    // To convert UnNumber entity to dto
    public static UnNumberDto numberEntityToDto(UnNumber entity)
    {
        UnNumberDto dto=new UnNumberDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }
}
