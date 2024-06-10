package service;

import dto.EmployeeDto;
import dto.PassportDto;

import java.util.List;

public interface PassportService {
    PassportDto getPassportById(int id);
    List<PassportDto> getAllPassports();
    boolean deletePassportById(int id);
    boolean createPassport(PassportDto passportDto);
    boolean updatePassport(PassportDto employeeDto, int id);
}
