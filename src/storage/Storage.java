package storage;

import car.passenger.Camry;
import car.passenger.cabriolet.Solara;
import car.truck.Dyna;
import car.truck.Hiance;
import storage.exception.EmptyStorageException;
import storage.exception.FullStorageException;

public class Storage {
    private static final int MAX_STORAGE_CAPACITY = 1000;
    private int totalAmount = 0;
    private final Camry[] storageOfCamry;
    private int amountOfCamry;
    private final Solara[] storageOfSolara;
    private int amountOfSolara;
    private final Hiance[] storageOfHiance;
    private int amountOfHiance;
    private final Dyna[] storageOfDyna;
    private int amountOfDyna;

    public Storage() {
        storageOfCamry = new Camry[MAX_STORAGE_CAPACITY];
        storageOfSolara = new Solara[MAX_STORAGE_CAPACITY];
        storageOfHiance = new Hiance[MAX_STORAGE_CAPACITY];
        storageOfDyna = new Dyna[MAX_STORAGE_CAPACITY];
    }

    public void addCar(Solara car) throws FullStorageException {
        if (totalAmount == MAX_STORAGE_CAPACITY) {
            throw new FullStorageException();
        }
        storageOfSolara[amountOfSolara] = car;
        amountOfSolara++;
        totalAmount++;
    }

    public void addCar(Camry car) throws FullStorageException {
        if (totalAmount == MAX_STORAGE_CAPACITY) {
            throw new FullStorageException();
        }
        storageOfCamry[amountOfCamry] = car;
        amountOfCamry++;
        totalAmount++;
    }

    public void addCar(Hiance car) throws FullStorageException {
        if (totalAmount == MAX_STORAGE_CAPACITY) {
            throw new FullStorageException();
        }
        storageOfHiance[amountOfHiance] = car;
        amountOfHiance++;
        totalAmount++;
    }

    public void addCar(Dyna car) throws FullStorageException {
        if (totalAmount == MAX_STORAGE_CAPACITY) {
            throw new FullStorageException();
        }
        storageOfDyna[amountOfDyna] = car;
        amountOfDyna++;
        totalAmount++;
    }

    public Camry pullCarCamry() throws EmptyStorageException {
        if (amountOfCamry == 0) {
            throw new EmptyStorageException();
        }
        Camry car = storageOfCamry[--amountOfCamry];
        totalAmount--;
        return car;
    }

    public Solara pullCarSolara() throws EmptyStorageException {
        if (amountOfSolara == 0) {
            throw new EmptyStorageException();
        }
        Solara car = storageOfSolara[--amountOfSolara];
        totalAmount--;
        return car;
    }

    public Hiance pullCarHiance() throws EmptyStorageException {
        if (amountOfHiance == 0) {
            throw new EmptyStorageException();
        }
        Hiance car = storageOfHiance[--amountOfHiance];
        totalAmount--;
        return car;
    }

    public Dyna pullCarDyna() throws EmptyStorageException {
        if (amountOfHiance == 0) {
            throw new EmptyStorageException();
        }
        Dyna car = storageOfDyna[--amountOfDyna];
        totalAmount--;
        return car;
    }

}
