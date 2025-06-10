# 🚗 Turbo.Az Scraper: 

Are you tired of manually sifting through car listings on `turbo.az` to gather data? Do you wish there was an automated way to compile detailed information about vehicles for sale in Azerbaijan? Look no further!

**TurboScraper** is a powerful Java-based web scraping tool designed to effortlessly extract comprehensive car listing data from `turbo.az` and organize it into a clean, accessible Excel spreadsheet.

---

## ✨ Features

* **Effortless Data Extraction**: Scrapes key information like title, price, location, mileage, year, ban type, transmission, engine volume, and color directly from `turbo.az` listings.
* **Deep Dive Details**: Goes beyond summary information by navigating to individual product pages to fetch granular details for each car.
* **Structured Output**: Organizes all extracted data neatly into an **Excel file (`.xlsx`)**, ready for analysis, reporting, or further processing.
* **Robust & Reliable**: Built with `Jsoup` for efficient HTML parsing and `Apache POI` for seamless Excel file generation.

---

## 🛠️ How It Works

TurboScraper operates in a few simple steps:

1.  It connects to the main car listings page on `turbo.az`.
2.  It identifies individual car listings on the page.
3.  For each listing, it extracts basic details and then navigates to the car's dedicated product page.
4.  On the product page, it extracts a wealth of detailed specifications.
5.  Finally, all collected data is compiled row-by-row into a new Excel spreadsheet named `product_data.xlsx`.

---

## 🚀 Getting Started

To get this project up and running on your local machine, follow these steps:

### Prerequisites

* **Java Development Kit (JDK)**: Make sure you have JDK 8 or higher installed.
* **Maven** (recommended) or **Gradle** for dependency management.

### Installation

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/YourUsername/TurboScraper.git](https://github.com/YourUsername/TurboScraper.git)
    cd TurboScraper
    ```

2.  **Add Dependencies:**

    If using **Maven**, add the following to your `pom.xml`:

    ```xml
    <dependencies>
        <dependency>
            <groupId>org.jsoup</groupId>
            <artifactId>jsoup</artifactId>
            <version>1.17.2</version> </dependency>
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>5.2.5</version> </dependency>
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>5.2.5</version> </dependency>
    </dependencies>
    ```

    (Alternatively, you can manually download the Jsoup and Apache POI JARs and add them to your project's build path.)

### Running the Scraper

1.  **Compile the project:**
    ```bash
    javac -cp "path/to/jsoup.jar:path/to/poi.jar:path/to/poi-ooxml.jar" Main.java # Adjust paths as needed
    ```
    Or, if using Maven:
    ```bash
    mvn clean install
    ```

2.  **Run the `Main` class:**
    ```bash
    java -cp ".;path/to/jsoup.jar;path/to/poi.jar;path/to/poi-ooxml.jar" org.example.Main # Windows
    java -cp ".:path/to/jsoup.jar:path/to/poi.jar:path/to/poi-ooxml.jar" org.example.Main # macOS/Linux
    ```
    Or, if using Maven:
    ```bash
    mvn exec:java -Dexec.mainClass="org.example.Main"
    ```

After successful execution, an Excel file named `product_data.xlsx` will be generated in your project's root directory, containing all the scraped car data.

---

## ⚠️ Disclaimer

This tool is intended for educational purposes and personal data analysis. Please be mindful of `turbo.az`'s terms of service and robots.txt file. Excessive or rapid scraping can lead to your IP being blocked. Use responsibly.

---

## 🤝 Contributing

Contributions are welcome! If you have ideas for improvements, new features, or bug fixes, feel free to open an issue or submit a pull request.

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

**Happy Scraping!**
