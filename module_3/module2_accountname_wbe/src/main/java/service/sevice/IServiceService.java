package service.sevice;

import model.service.Service;

import java.util.List;

public interface IServiceService {
    List<Service> getAllService();

    void save(Service service);

    void delete(Integer id);

    Service findById(Integer id);

    void update(Service service);

    List<Service> searchName(String nameSearchService);
}
