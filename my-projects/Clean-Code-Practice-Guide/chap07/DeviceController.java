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

// Usando o try catch fica muito melhor, pois, alem da estetica, duas preocupacoes que estavam intricadas foram sanadas:
// - Algoritmo para o desligamento do dispositivo
// - O tratamento de erro

// A condicao abaixo te permite pegar os dois casos acima e estuda-las de forma independente
public class DeviceControllerTryAndCatch {
    public void sendShutDown() {
        try {
            tryToShutDown();
        } catch (DeviceShutDownError e) {
            logger.log(e);
        }
    }

    private void tryToShutDown() throws DeviceShutDownError {
        DeviceHandle handle = getHandle(DEV1);
        DeviceRecord record = retrieveDeviceRecord(handle);

        pauseDevice(handle);
        clearDeviceWordQueue(handle);
        closeDevice(handle);
    }

    private DeviceHandle getHandle(DeviceID id) {
        throw new DeviceShutDownError("Invalid handle for: " + id.toString());
    }
}
