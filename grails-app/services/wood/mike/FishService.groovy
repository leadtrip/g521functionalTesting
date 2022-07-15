package wood.mike

import grails.gorm.services.Service

@Service(Fish)
interface FishService {
    List<Fish> findAll()
}
