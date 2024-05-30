// Use excecoes em vez de retornar codigos

// A forma como foi codado abaixo pode ofuscar muito a logica conforme vai aumentando o numero de erros que precisam ser tratados.

public class DeviceController {
    public void sendShutDown() {
        DeviceHandle handle = getHandle(DEV1);
        // Check the state of the device
        if (handle != DeviceHandle.INVALID) {
            // Save the device status to the record field
            retrieveDeviceRecord(handle);
            // If not suspended, shut down
            if (record.getStatus() != DEVICE_SUSPENDED) {
                pauseDevice(handle);
                clearDeviceWorkQueue(handle);
                closeDevice(handle);
            } else {
                logger.log("Device suspended. Unable to shut down!");
            }
        } else {
            logger.log("Invalid handle for: " + DEV1.toString());
        }
    }
}