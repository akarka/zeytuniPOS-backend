package com.kadir.zeytuniPOS.core;

import com.kadir.zeytuniPOS.data.IslemLog;
import com.kadir.zeytuniPOS.data.IslemLogRepository;
import com.kadir.zeytuniPOS.dto.IslemLogCreateDTO;
import com.kadir.zeytuniPOS.dto.IslemLogDTO;
import com.kadir.zeytuniPOS.dto.IslemLogUpdateDTO;
import com.kadir.zeytuniPOS.mapper.IslemLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        if (createDTO.getTarih() == null) {
            createDTO.setTarih(LocalDateTime.now());
        }
        IslemLog entity = islemLogMapper.toEntity(createDTO);
        IslemLog saved = islemLogRepository.save(entity);
        return islemLogMapper.toDTO(saved);
    }

    public List<IslemLogDTO> getAllIslemLogs() {
        return islemLogMapper.toDTOList(islemLogRepository.findAll());
    }

    public IslemLogDTO getIslemLogById(Integer id) {
        IslemLog entity = getById(id);
        return islemLogMapper.toDTO(entity);
    }

    public IslemLogDTO updateIslemLog(Integer id, IslemLogUpdateDTO updateDTO) {
        IslemLog existing = getById(id);
        IslemLog updated = islemLogMapper.toEntity(updateDTO);
        updated.setLogId(existing.getLogId());
        return islemLogMapper.toDTO(islemLogRepository.save(updated));
    }

}
