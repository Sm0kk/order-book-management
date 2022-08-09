package order.book.management.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import order.book.management.service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(String data, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + filePath);
        }
    }
}
