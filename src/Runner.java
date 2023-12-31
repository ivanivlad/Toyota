import assembly.AssemblyLine;
import car.Car;
import assembly.Fabric;
import car.Color;
import car.passenger.Camry;
import car.passenger.cabriolet.Solara;
import car.truck.Dyna;
import car.truck.Hiance;
import client.Client;
import client.NotEnoughMoneyException;
import java.io.IOException;
import personal.Cashier;
import personal.Manager;
import storage.Storage;
import storage.exception.FullStorageException;
import static car.Country.JAPAN;

public class Runner {
    public static void main(String[] args) {

        Client[] clients = {
                new Client("Vasya1", 10_000),
                new Client("Vasya2", 12_000),
                new Client("Vasya3", 15_000),
                new Client("Vasya4", 22_000),
                new Client("Vasya5", 11_000),
                new Client("Vasya6", 13_000),
                new Client("Vasya7", 8_000),
                new Client("Vasya8", 30_000),
        };

        Camry camry = new Camry(Color.BLACK, 10_000);
        Solara solara = new Solara(Color.WHITE, 12_000);
        Hiance hiance = new Hiance(Color.BLACK, 15_000);
        Dyna dyna = new Dyna(Color.BLACK, 22_000);

        AssemblyLine assemblyLineJapan = new AssemblyLine(JAPAN);
        assemblyLineJapan.useFabric(new Fabric(JAPAN));

        Storage storageJapan = new Storage();
        try {
            storageJapan.addCar(
                    assemblyLineJapan.createCar(camry)
            );
            storageJapan.addCar(
                    assemblyLineJapan.createCar(solara)
            );
            storageJapan.addCar(
                    assemblyLineJapan.createCar(hiance)
            );
            storageJapan.addCar(
                    assemblyLineJapan.createCar(dyna)
            );
        } catch (FullStorageException e) {
            throw new RuntimeException(e);
        }

        Cashier cashier = new Cashier();

        Manager manager = new Manager("Петя");
        manager.goToWork(storageJapan, assemblyLineJapan);
        for (var client : clients) {
            try {
                Car car = manager.sellMostExpensiveCar(client);
                manager.addCarToReport(car);
                cashier.addIncome(car);
            } catch (NotEnoughMoneyException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            manager.getReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}