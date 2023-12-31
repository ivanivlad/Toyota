package personal;

import java.io.FileWriter;
import java.io.IOException;
import assembly.AssemblyLine;
import car.Car;
import car.Color;
import car.passenger.Camry;
import car.passenger.cabriolet.Solara;
import car.truck.Dyna;
import car.truck.Hiance;
import client.Client;
import client.NotEnoughMoneyException;
import report.Report;
import storage.Storage;
import storage.exception.EmptyStorageException;

public class Manager {
    private final String name;
    private Report[] reports;
    private int countReportRecord;
    private Storage store;
    private AssemblyLine assemblyLine;

    public Manager(String name) {
        this.name = name;
    }

    public void goToWork(Storage store, AssemblyLine assemblyLine) {
        this.store = store;
        this.assemblyLine = assemblyLine;
        this.reports = new Report[100];
    }

    public Car sellMostExpensiveCar(Client client) throws NotEnoughMoneyException {
        if (store == null) {
            throw new RuntimeException("У менеджера нет склада для продажи");
        }
        if (assemblyLine == null) {
            throw new RuntimeException("У менеджера нет сборочной линии для производства");
        }

        double moneyOfClient = client.shutUpAndTakeMyMoney();

        if (moneyOfClient >= 22_000) {
            try {
                return store.pullCarDyna();
            } catch (EmptyStorageException e) {
                return assemblyLine.createCar(new Dyna(Color.BLACK, 22_000));
            }
        } else if (moneyOfClient >= 15_000) {
            try {
                return store.pullCarHiance();
            } catch (EmptyStorageException e) {
                return assemblyLine.createCar(new Hiance(Color.BLACK, 15_000));
            }
        } else if (moneyOfClient >= 12_000) {
            try {
                return store.pullCarSolara();
            } catch (EmptyStorageException e) {
                return assemblyLine.createCar(new Solara(Color.WHITE, 12_000));
            }
        } else if (moneyOfClient >= 10_000) {
            try {
                return store.pullCarCamry();
            } catch (EmptyStorageException e) {
                return assemblyLine.createCar(new Camry(Color.BLACK, 10_000));
            }
        }

        throw new NotEnoughMoneyException();

    }

    public void addCarToReport(Car car) {
        reports[countReportRecord] = new Report(car);
        countReportRecord++;
    }

    public void getReport() throws IOException {
        String reportName = name.toLowerCase() + ".txt";
        try (FileWriter fileWriter = new FileWriter(reportName)) {
            fileWriter.write(name + '\n');
            double incomeTotal = 0;
            double costTotal = 0;
            for (int i = 0; i < countReportRecord; i++) {
                incomeTotal += reports[i].getIncome();
                costTotal += reports[i].getCostPrice();
                String data = String.format("Модель - %s - %.2f - %.2f %n",
                        reports[i].getModel(),
                        reports[i].getIncome(),
                        reports[i].getCostPrice());
                fileWriter.write(data);
            }
            String data = String.format("Итого: доходы - %.2f, расходы - %.2f, прибыль - %.2f %n",
                    incomeTotal,
                    costTotal,
                    incomeTotal - costTotal);
            fileWriter.write(data);
        }

    }
}
