package service;

import dto.OfficeDto;
import dto.PassportDto;

import java.util.List;

public interface OfficeService {
    OfficeDto getOfficeById(int id);
    List<OfficeDto> getAllOffices();
    boolean deleteOfficeById(int id);
    boolean createOffice(OfficeDto officeDto);
    boolean updateOffice(OfficeDto officeDto, int id);
}
