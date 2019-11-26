package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Device;
import org.itstep.msk.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {


    //???поиск множества устройств, уже архивированных (archived == true);
//    Iterable<Device> findByArchivedDevice(Integer archivedDevice);
}
