package service;

import dao.abs.OfficeDao;
import dao.abs.PassportDao;
import dto.OfficeDto;
import dto.RoleDto;
import model.Employee;
import model.Office;
import model.Role;

import java.util.ArrayList;
import java.util.List;

public class OfficeServiceImpl implements OfficeService{

    private static OfficeDao officeDao;

    public OfficeServiceImpl (OfficeDao officeDao){
        this.officeDao = officeDao;
    }
    @Override
    public OfficeDto getOfficeById(int id) {
        if(id <= 0){
            throw new IllegalArgumentException("id is less or equal 0");
        }
        Office office = officeDao.findById(id);
        return toOfficeDto(office);
    }

    @Override
    public List<OfficeDto> getAllOffices() {
        List<OfficeDto> officeDtos = new ArrayList<>();
        List<Office> offices = officeDao.all();
        for(Office o : offices){
            officeDtos.add(toOfficeDto(o));
        }
        return officeDtos;
    }

    @Override
    public boolean deleteOfficeById(int id) {
        if(id <= 0){
            throw new IllegalArgumentException("id is less or equal 0");
        }
        return officeDao.deleteById(id);
    }

    @Override
    public boolean createOffice(OfficeDto officeDto) {
        if(officeDto == null){
            throw new NullPointerException("object is null");
        }
        Office office = toOffice(officeDto);
        return officeDao.create(office);
    }

    @Override
    public boolean updateOffice(OfficeDto officeDto, int id) {
        if(officeDto == null){
            throw new NullPointerException("object is null");
        }
        if(id <= 0) throw new IllegalArgumentException("id is less or equals 0");
        Office office = toOffice(officeDto);
        return officeDao.update(office,id);
    }

    private static OfficeDto toOfficeDto(Office office){
        String address = office.getAddress();
        List<Employee> emplName = new ArrayList<>();
        for(Employee employee : office.getEmployeeList()){
            emplName.add(employee);
        }
        return new OfficeDto(address,emplName);
    }

    private static Office toOffice(OfficeDto officeDto){
        Office office = new Office();
        office.setAddress(office.getAddress());
        office.setEmployeeList(new ArrayList<>());
        return office;
    }
}
