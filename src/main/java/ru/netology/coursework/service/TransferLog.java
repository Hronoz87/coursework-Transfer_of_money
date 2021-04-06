package ru.netology.coursework.service;


import ru.netology.coursework.repository.Card;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class TransferLog {

    public String cardFromNumber;
    public String cardToNumber;
    public Card.Amount amount;
    public Date date;

    public TransferLog(String cardFromNumber, String cardToNumber, Card.Amount amount, Date date) {
        this.cardFromNumber = cardFromNumber;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "cardFromNumber = '" + cardFromNumber + '\'' +
                ", cardToNumber = '" + cardToNumber + '\'' +
                ", amount = " + amount +
                ", date = " + date
                ;
    }

    public  String nameLog = "fileOperatiosLogs.log";

    public boolean writeLog(TransferLog transferLog, String operationId) {
        String msgLog = "Файл fileOperatiosLogs.log успешно создан";
        File logFile = new File(nameLog);
        if (transferLog != null) {
            if (!logFile.exists()) {
                try {
                    if (logFile.createNewFile())
                        System.out.println(msgLog);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (FileWriter writerLogs = new FileWriter(nameLog, true)) {
                    writerLogs.write("Время транзакции:" + new Date() + ": " + msgLog + "\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try (FileWriter writerLogs = new FileWriter(nameLog, true)) {
                String text = "Operation id = " + operationId + ", " + transferLog.toString();
                writerLogs.write(text);
                writerLogs.append('\n');
                writerLogs.flush();
                System.out.println("Транзакция осуществлена, данные о транзакции занесены в файл");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

}
