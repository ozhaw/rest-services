package org.nure.julia.web;

import org.nure.julia.HystrixFallbackController;
import org.nure.julia.web.dto.DeviceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static org.nure.julia.web.WebControllerDefinitions.*;

@FeignClient(name = "${spring.application.name}.DeviceController")
public interface DeviceController extends HystrixFallbackController {
    @PostMapping
    ResponseEntity addDevice(@RequestHeader(name = "userId") Long userId, @RequestBody final DeviceDto deviceDto);

    @GetMapping(EXTERNAL_DEVICE_ID_PARAMETER_URL)
    ResponseEntity getDeviceByDeviceId(@PathVariable(name = DEVICE_ID_PARAMETER) String deviceId);

    @GetMapping(DEVICE_ID_PARAMETER_URL)
    ResponseEntity getDeviceById(@PathVariable(name = DEVICE_ID_PARAMETER) Long deviceId);

    @GetMapping(DEVICE_INFO_DATA_URL)
    ResponseEntity getDeviceInfoForDevice(@PathVariable(name = DEVICE_ID_PARAMETER) Long deviceId);

    @GetMapping(USER_DEVICES_URL)
    ResponseEntity getDevicesForUser(@PathVariable(name = USER_ID_PARAMETER) Long userId);
}
