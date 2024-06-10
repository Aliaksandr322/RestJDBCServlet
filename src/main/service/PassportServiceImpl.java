package service;

import dao.abs.PassportDao;
import dto.EmployeeDto;
import dto.PassportDto;
import model.Employee;
import model.Office;
import model.Passport;
import model.Role;

import java.util.ArrayList;
import java.util.List;

public class PassportServiceImpl implements PassportService{
    private static PassportDao passportDao;

    public PassportServiceImpl (PassportDao passportDao){
        this.passportDao = passportDao;
    }


    @Override
    public PassportDto getPassportById(int id) {
        if(id <= 0){
            throw new IllegalArgumentException("id is less or equal 0");
        }
        Passport passport = passportDao.findById(id);
        return toPassportDto(passport);
    }

    @Override
    public List<PassportDto> getAllPassports() {
        List<PassportDto> passportDtos = new ArrayList<>();
        List<Passport> passports = passportDao.all();
        for(Passport p : passports){
            passportDtos.add(toPassportDto(p));
        }
        return passportDtos;
    }

    @Override
    public boolean deletePassportById(int id) {
        if(id <= 0){
            throw new IllegalArgumentException("id is less or equal 0");
        }
        return passportDao.deleteById(id);
    }

    @Override
    public boolean createPassport(PassportDto passportDto) {
        if(passportDto == null){
            throw new NullPointerException("object is null");
        }
        Passport passport = toPassport(passportDto);
        return passportDao.create(passport);
    }

    @Override
    public boolean updatePassport(PassportDto passportDto, int id) {
        if(passportDto == null){
            throw new NullPointerException("object is null");
        }
        if(id <= 0) throw new IllegalArgumentException("id is less or equals 0");
        Passport passport = toPassport(passportDto);
        return passportDao.update(passport, id);
    }

    private static PassportDto toPassportDto(Passport passport){
        String firstName = passport.getFirstName();
        String lastName = passport.getLastName();
        int initId = passport.getInitId();
        String personalId = passport.getPersonalId();

        return new PassportDto(firstName, lastName, initId, personalId);
    }

    private static Passport toPassport(PassportDto passportDto){
        Passport passport = new Passport();
        passport.setFirstName(passportDto.getFirstName());
        passport.setLastName(passportDto.getLastName());
        passport.setPersonalId(passportDto.getPersonalId());
        passport.setInitId(passportDto.getInitId());
        return passport;
    }
}
