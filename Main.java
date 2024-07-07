package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String url = "https://turbo.az/autos";

        try {
            Document doc = Jsoup.connect(url).get();

            Workbook workbook = new XSSFWorkbook();
            CreationHelper createHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet("Product Data");

            Row headerRow = sheet.createRow(0);

            String[] headers = {"Title", "Price", "Location", "Mileage", "Year", "Ban Type", "Transmission", "Engine Volume", "Color"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            Elements productContainers = doc.select("div.products-i");
            int rowNum = 1;
            for (Element container : productContainers) {

                String title = container.select(".products-i__name").text().trim();
                String price = container.select(".products-i__price").text().trim();

                Element productLink = container.select("a.products-i__link").first();
                String productPageUrl = productLink.attr("abs:href");
                Document productDoc = Jsoup.connect(productPageUrl).get();

                String location = productDoc.select("label[for=ad_region]").next().select("span").text().trim();
                String year = productDoc.select("label[for=ad_reg_year]").next().select("span").text().trim();
                String banType = productDoc.select("label[for=ad_category]").next().select("span").text().trim();
                String color = productDoc.select("label[for=ad_color]").next().select("span").text().trim();
                String engineVolume = productDoc.select("label[for=ad_engine_volume]").next().select("span").text().trim();
                String mileage = productDoc.select("label[for=ad_mileage]").next().select("span").text().trim();
                String transmission = productDoc.select("label[for=ad_transmission]").next().select("span").text().trim();
                String seatsCount = productDoc.select("label[for=ad_seats_count]").next().select("span").text().trim();


                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(title);
                row.createCell(1).setCellValue(price);
                row.createCell(2).setCellValue(location);
                row.createCell(3).setCellValue(mileage);
                row.createCell(4).setCellValue(year);
                row.createCell(5).setCellValue(banType);
                row.createCell(6).setCellValue(transmission);
                row.createCell(7).setCellValue(engineVolume);
                row.createCell(8).setCellValue(color);


            }
            String excelFileName = "product_data.xlsx";
            try (FileOutputStream fileOut = new FileOutputStream(excelFileName)) {
                workbook.write(fileOut);
                System.out.println("Excel file has been created successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

