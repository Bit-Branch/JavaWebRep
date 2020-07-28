package by.epam.committiee.service;

import by.epam.committiee.entity.Specialty;
import by.epam.committiee.exception.ServiceException;

import javax.servlet.ServletContext;
import java.util.List;

public interface SpecialtyService extends Service<Specialty> {
    List<Specialty> findUserSpecialties(long userId) throws ServiceException;
    List<Specialty> findFacultySpecialties(long facultyId) throws ServiceException;
}
