package wood.mike

import grails.gorm.services.Service

@Service(Fish)
interface FishService {

    Fish get(Serializable id)

    List<Fish> list(Map args)

    Long count()

    void delete(Serializable id)

    Fish save(Fish fish)

    List<Fish> findAll()
}