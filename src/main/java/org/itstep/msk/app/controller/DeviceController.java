package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Device;
import org.itstep.msk.app.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    // как вывести все устройства без архивированных?
    @GetMapping("/device")
    public List<Device> listDevices() {
        return deviceRepository.findAll();
    };

    @PostMapping("/device")
    public Integer addDevice(Device device) {
        device = deviceRepository.save(device);

        return device.getId();
    }

    @DeleteMapping("device/{deviceId}")
    public String deleteDevice(@PathVariable Integer deviceId, HttpServletResponse response) {

        Optional<Device> device = deviceRepository.findById(deviceId);

        if(device.isPresent()){
            deviceRepository.delete(device.get()); // device - объект класса Optional. Чтобы получить объект класса Device, его нужно извлечь из переменной device с помощью метода get()
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return "OK";
    }

    @PutMapping("/device/{deviceId}")
    public String editDevice(@RequestBody Device device, @PathVariable Integer deviceId, HttpServletResponse response) {

        Optional<Device> dbDevice = deviceRepository.findById(deviceId);

        if(dbDevice.isPresent()) {
            Device updatedDevice = dbDevice.get();
            updatedDevice.setDeviceSKU(device.getDeviceSKU());
            updatedDevice.setDeviceSN(device.getDeviceSN());
            updatedDevice.setDeviceDesc(device.getDeviceDesc());
            updatedDevice.setOwner(device.getOwner()); //КАК ВЫБРАТЬ ИЗ СПИСКА ВЛАДЕЛЬЦЕВ?
            updatedDevice.setArchivedDevice(device.getArchivedDevice());

            deviceRepository.save(updatedDevice);
            deviceRepository.flush();

        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        return "redirect:/device/" + deviceId; // ПРАВИЛЬНО ЛИ СДЕЛАЛ?
    }

}

/*
- добавить вывод одного устройства.
- добавить поиск:
    - вывод всех свободных устройств (loaned == false);
	- *вывод всех устройств по типу;
	- *вывод всех устройств по местонахождению (свободный поиск по словам);
	-
 */