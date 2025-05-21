package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.IslemLog;
import com.kadir.zeytuniPOS.data.IslemLogRepository;
import com.kadir.zeytuniPOS.dto.IslemLogCreateDTO;
import com.kadir.zeytuniPOS.dto.IslemLogDTO;
import com.kadir.zeytuniPOS.dto.IslemLogUpdateDTO;
import com.kadir.zeytuniPOS.mapper.IslemLogMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslemLogService extends AbstractService<IslemLog, Integer> {

    private final IslemLogRepository islemLogRepository;
    private final IslemLogMapper islemLogMapper;

    @Autowired
    public IslemLogService(IslemLogRepository islemLogRepository,
            IslemLogMapper islemLogMapper) {
        super(islemLogRepository);
        this.islemLogRepository = islemLogRepository;
        this.islemLogMapper = islemLogMapper;
    }

    public IslemLogDTO createIslemLog(IslemLogCreateDTO createDTO) {
        IslemLog entity = islemLogMapper.toEntity(createDTO);
        IslemLog savedEntity = islemLogRepository.save(entity);
        return islemLogMapper.toDTO(savedEntity);
    }

    public List<IslemLogDTO> getAllIslemLogs() {
        List<IslemLog> entities = islemLogRepository.findAll();
        return islemLogMapper.toDTOList(entities);
    }

    public IslemLogDTO getIslemLogById(Integer id) {
        IslemLog entity = getById(id);
        return islemLogMapper.toDTO(entity);
    }

    public IslemLogDTO updateIslemLog(Integer id, IslemLogUpdateDTO updateDTO) {

        getById(id);

        IslemLog entity = islemLogMapper.toEntity(updateDTO);
        IslemLog updatedEntity = islemLogRepository.save(entity);
        return islemLogMapper.toDTO(updatedEntity);
    }

    public void deleteIslemLog(Integer id) {
        islemLogRepository.deleteById(id);
    }
}
